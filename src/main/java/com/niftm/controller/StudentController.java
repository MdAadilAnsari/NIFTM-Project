package com.niftm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niftm.dto.StudentRequest;
import com.niftm.entity.Student;
import com.niftm.service.IStudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private IStudentService studService;
	
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudentDtls(@RequestBody StudentRequest studReq) {
		Student saveStudentDtls = studService.saveStudentDtls(studReq);
		return new ResponseEntity<Student>(saveStudentDtls,new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@GetMapping("/getAll")
	public List<Student> getAll(){
		List<Student> allStudent = studService.getAllStudent();
		return allStudent;
	}

	@GetMapping("/getOne/{id}")
	public Student getOneStudent(@PathVariable("id") Long id) {
		Student studentById = studService.getStudentById(id);
		return studentById;
	}
	
	@DeleteMapping("/delete/{id}")
	public Boolean deleteStudent(@PathVariable("id")Long id) {
		Boolean isDeleted = studService.deleteStudentById(id);
		return isDeleted;
	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student stud) {
		return studService.updateStudentDtls(stud);
	}
}

