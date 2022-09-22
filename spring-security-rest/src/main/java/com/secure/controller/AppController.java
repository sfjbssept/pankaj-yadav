package com.secure.controller;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.header.Header;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.secure.entity.Employee;

@RestController
public class AppController {
	
	@GetMapping("/get")
	public String getDetails() {
		return "get employee";
	}
	
	@PostMapping("/post")
	public Employee addEmployee(@RequestBody Employee newEmployee) {
		return newEmployee;
	}
	
	@PutMapping("/put/{name}")
	public String updateEmployee(@RequestBody Employee newEmployee,@PathVariable String name) {
		return newEmployee.toString()+" updated with name "+name;
	}
	
	@DeleteMapping("/delete/{name}")
	public String deleteEmployee(@PathVariable String name) {
		return name;
	}
	
	@GetMapping("/path/{name}")
	public String getPathVar(@PathVariable String name) {
		return "Path Variable "+name;
	}
	
	@GetMapping("/request")
	public String getRequestParam(@RequestParam(name="name",required = true,defaultValue = "Pankaj") String name) {
		return "Request Param : "+name;
	}
	
	@GetMapping("/request/params")
	public String getRequestParam(@RequestParam List<String> id) {
		return "Request Param : "+id;
	}
	
	@GetMapping("/headers")
	public ResponseEntity<String> getHeaders(@RequestHeader HttpHeaders header) {
		if(isHeaderMissing(header,"name")){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.setExpires(ZonedDateTime.now().plusDays(1));
		String response = "Valid Header";
		return ResponseEntity.ok().headers(responseHeader).body(response);
	}

	private boolean isHeaderMissing(HttpHeaders header, String headerKey) {
		if(header.containsKey(headerKey)) {
			return true;
		}else
		return false;
	}

}
