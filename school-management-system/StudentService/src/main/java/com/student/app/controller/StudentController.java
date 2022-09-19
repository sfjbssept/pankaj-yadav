package com.student.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.entity.Student;

@RestController
public class StudentController {

	public static Map<String, List<Student>> schoolDB = new HashMap<String, List<Student>>();

	static {
		schoolDB = new HashMap<String, List<Student>>();
		List<Student> list1 = new ArrayList<Student>();
		Student std1= new Student("Pankaj", "Class12");
		Student std2 = new Student("soni", "class11");
		Student std3 = new Student("raj", "class12");
		Student std4 = new Student("rohan", "class11");

		list1.add(std1);
		list1.add(std2);
		list1.add(std3);
		list1.add(std4);
		
		List<Student> list2= new ArrayList<Student>();
		Student s1= new Student("Sara", "Class10");
		Student s2 = new Student("sreya", "class8");
		Student s3 = new Student("rose", "class6");
		Student s4 = new Student("reha", "class10");

		list2.add(s1);
		list2.add(s2);
		list2.add(s3);
		list2.add(s4);

		schoolDB.put("school1", list1);
		schoolDB.put("school2", list2);
	}
	
	@RequestMapping(value="/getStudentDetailsForSchool/{schoolname}", method = RequestMethod.GET)
	public List<Student> getStudents(@PathVariable String schoolname){
		System.out.println("getting student details for "+schoolname);
		List<Student> studentList = schoolDB.get(schoolname);
		if(studentList ==  null) {
			studentList = new ArrayList<Student>();
			Student std = new Student("nnot found 404", "N/A");
			studentList.add(std);
		}
		return studentList;
	}

}
