package com.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.repo.IStudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private IStudentRepository studentRepo;
	
	@PostMapping("/addstudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		Student save = this.studentRepo.save(student);
		return ResponseEntity.ok(save);
	}
	
	@GetMapping("/getstudents")
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> students = this.studentRepo.findAll();
		return ResponseEntity.ok(students);
	}
	
	@GetMapping("/getstudent/{id}")
	public ResponseEntity<Optional<Student>> getStudentById(@PathVariable("id") Integer id){
		Optional<Student> students = this.studentRepo.findById(id);
		return ResponseEntity.ok(students);
	}
	
	@PutMapping("/updatestudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws Exception{
		Student existingStudent = studentRepo.findById(student.getId()).orElseThrow(()-> new Exception("Resource not found"));
		existingStudent.setId(student.getId());
		existingStudent.setCity(student.getCity());
		existingStudent.setCollege(student.getCollege());
		existingStudent.setName(student.getName());
		Student save = this.studentRepo.save(existingStudent);
		return ResponseEntity.ok(save);
	}
	
	@DeleteMapping("/deletestudent/{id}")
	public ResponseEntity<Student> deleteStudents(@PathVariable("id") Integer id) throws Exception{
		Student existingStudent = studentRepo.findById(id).orElseThrow(()-> new Exception("Resource not found"));
		this.studentRepo.delete(existingStudent);
		return ResponseEntity.ok(existingStudent);
	}

}
