package com.dockerassigment.restapp.service;

import java.util.List;

import com.dockerassigment.restapp.dto.StudentDto;

public interface StudentService {

	// Get Request service Methods

	List<StudentDto> getAllStudent();

	List<StudentDto> getStudentByFirstName(String firstName);

	List<StudentDto> getStudentByLastName(String lastName);

	List<StudentDto> getStudentByEmail(String email);

	List<StudentDto> getStudentByContactNumber(String contactNumber);

	StudentDto getStudentById(Integer id);

	// Post Request Service Method

	StudentDto addStudentRecord(StudentDto studentDto);

	// Put Request Service Method

	StudentDto updateStudentRecord(Integer id, StudentDto studentDto);

	// Delete Request Service Method

	String deleteStudentRecord(Integer id);

}
