package com.dockerassigment.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.dockerassigment.restapp.dto.StudentDto;
import com.dockerassigment.restapp.response.ApiResponse;
import com.dockerassigment.restapp.service.StudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public ResponseEntity<ApiResponse<List<StudentDto>>> getAllStudent() {
		List<StudentDto> dtoList = this.studentService.getAllStudent();
		ApiResponse<List<StudentDto>> response = new ApiResponse<List<StudentDto>>();
		response.setContent(dtoList);
		response.setStatus(true);
		response.setMessage("All Records Retrived");
		return new ResponseEntity<ApiResponse<List<StudentDto>>>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<StudentDto>> getStudentById(@PathVariable Integer id) {
		StudentDto studentDto = this.studentService.getStudentById(id);
		ApiResponse<StudentDto> response = new ApiResponse<StudentDto>();
		response.setContent(studentDto);
		response.setStatus(true);
		response.setMessage("Student Records Retrived for ID: " + id);
		return new ResponseEntity<ApiResponse<StudentDto>>(response, HttpStatus.OK);
	}

	@GetMapping("/firstname/{firstname}")
	public ResponseEntity<ApiResponse<List<StudentDto>>> getStudentByFirstName(@PathVariable String firstname) {
		List<StudentDto> studentDto = this.studentService.getStudentByFirstName(firstname);
		ApiResponse<List<StudentDto>> response = new ApiResponse<List<StudentDto>>();
		response.setContent(studentDto);
		response.setStatus(true);
		response.setMessage("Student Records Retrived for First Name: " + firstname);
		return new ResponseEntity<ApiResponse<List<StudentDto>>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/lastname/{lastname}")
	public ResponseEntity<ApiResponse<List<StudentDto>>> getStudentByLastName(@PathVariable String lastname) {
		List<StudentDto> studentDto = this.studentService.getStudentByLastName(lastname);
		ApiResponse<List<StudentDto>> response = new ApiResponse<List<StudentDto>>();
		response.setContent(studentDto);
		response.setStatus(true);
		response.setMessage("Student Records Retrived for Last Name: " + lastname);
		return new ResponseEntity<ApiResponse<List<StudentDto>>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<ApiResponse<List<StudentDto>>> getStudentByEmail(@PathVariable String email) {
		List<StudentDto> studentDto = this.studentService.getStudentByEmail(email);
		ApiResponse<List<StudentDto>> response = new ApiResponse<List<StudentDto>>();
		response.setContent(studentDto);
		response.setStatus(true);
		response.setMessage("Student Records Retrived for Email: " + email);
		return new ResponseEntity<ApiResponse<List<StudentDto>>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/contactnumber/{contactnumber}")
	public ResponseEntity<ApiResponse<List<StudentDto>>> getStudentByContactNumber(@PathVariable String contactnumber) {
		List<StudentDto> studentDto = this.studentService.getStudentByContactNumber(contactnumber);
		ApiResponse<List<StudentDto>> response = new ApiResponse<List<StudentDto>>();
		response.setContent(studentDto);
		response.setStatus(true);
		response.setMessage("Student Records Retrived for Contact Number: " + contactnumber);
		return new ResponseEntity<ApiResponse<List<StudentDto>>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<ApiResponse<StudentDto>> addStudentRecord(@RequestBody StudentDto studentDto){
		StudentDto addStudenteDto = this.studentService.addStudentRecord(studentDto);
		ApiResponse<StudentDto> response = new ApiResponse<StudentDto>();
		response.setContent(addStudenteDto);
		response.setStatus(true);
		response.setMessage("Student Records Added");
		return new ResponseEntity<ApiResponse<StudentDto>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<ApiResponse<StudentDto>> updateStudentRecord(@PathVariable Integer id,@RequestBody StudentDto studentDto){
		StudentDto updatdeDto = this.studentService.updateStudentRecord(id,studentDto);
		ApiResponse<StudentDto> response = new ApiResponse<StudentDto>();
		response.setContent(updatdeDto);
		response.setStatus(true);
		response.setMessage("Student Records Updated");
		return new ResponseEntity<ApiResponse<StudentDto>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<ApiResponse<String>> deleteStudentRecord(@PathVariable Integer id){
		String messageString = this.studentService.deleteStudentRecord(id);
		ApiResponse<String> response = new ApiResponse<String>();
		response.setContent(messageString);
		response.setStatus(true);
		response.setMessage("Student Records Deleted");
		return new ResponseEntity<ApiResponse<String>>(response,HttpStatus.OK);
	}
	
}
