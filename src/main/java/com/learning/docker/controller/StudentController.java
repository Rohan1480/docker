package com.learning.docker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.docker.entity.Student;
import com.learning.docker.repo.StudentRepository;

@RestController
@RequestMapping(value = "student")
public class StudentController {

	@Autowired
	StudentRepository repository;

	@GetMapping("/get/studentlist")
	public ResponseEntity<List<Student>> getStudentName() {
		return new ResponseEntity<List<Student>>(repository.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = "/create/studeint", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> create(@RequestBody Student student) {
		Student student1 = repository.save(student);
		return new ResponseEntity<>(student1, HttpStatus.CREATED);
	}

}
