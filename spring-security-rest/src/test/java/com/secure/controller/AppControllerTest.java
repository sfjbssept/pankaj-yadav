package com.secure.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.Base64Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.secure.entity.Employee;

@RunWith(SpringRunner.class)
@WebMvcTest({AppController.class})
@ActiveProfiles(value="true")
public class AppControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Value("${employee.get.url}")
	String getUrl;
	
	@Value("${employee.post.url}")
	String postUrl;
	
	@Value("${employee.put.url}")
	String putUrl;
	
	@Value("${employee.delete.url}")
	String deleteUrl;
	
	@Value("${user.user1.username}")
	String username1;
	
	@Value("${user.user1.password}")
	String password1;
	
	@Value("${admin.user1.username}")
	String admin_name1;
	
	@Value("${admin.user1.password}")
	String admin_password1;
	
	@Test
	public void testEmployeeGet() throws Exception {
		ResultActions responseEntity = processApiRequest(getUrl, HttpMethod.GET, null, null, username1, password1);
		responseEntity.andExpect(status().isOk());
		String result = responseEntity.andReturn().getResponse().getContentAsString();
		assertEquals("get employee", result);
	}
	
	@Test
	public void testEmployeePost() throws Exception {
		Employee employee =createEmployee("test","dev");
		ResultActions responseEntity = processApiRequest(postUrl, HttpMethod.POST, null, employee, admin_name1, admin_password1);
		responseEntity.andExpect(status().isOk());
		ObjectMapper mapper = new ObjectMapper();
		Employee result = mapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(), new TypeReference<Employee>() {
		}) ;
		assertEquals("test", result.getName());
		assertEquals("dev", result.getName());
	}

	private Employee createEmployee(String name, String role) {
		Employee createdEmp = new Employee(name, role);
		return createdEmp;
	}

	private ResultActions processApiRequest(String api, HttpMethod methType, String name, Employee employee,
			String username, String password) {
		ResultActions response =null;
		String secret =  "Basic "+Base64Utils.encodeToString((username+":"+password).getBytes());
		try {
			switch (methType) {
			case GET:
					response = mockMvc.perform(get(api).header(HttpHeaders.AUTHORIZATION, secret));
//				response = mockMvc.perform(get(api).with(user(name).password(password).roles("USER")));
				break;
			case POST:
				response = mockMvc.perform(post(api).header(HttpHeaders.AUTHORIZATION, secret).contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(employee)).accept(MediaType.APPLICATION_JSON));
			break;

			default:
				break;
			}
		}catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		return response;
	}

	private String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(mapper);
			return jsonContent;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}
