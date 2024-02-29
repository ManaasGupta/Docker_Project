package com.dockerassigment.restapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dockerassigment.restapp.dto.StudentDto;
import com.dockerassigment.restapp.entity.Student;
import com.dockerassigment.restapp.repo.StudentRepo;
import com.dockerassigment.restapp.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo repo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<StudentDto> getAllStudent() {
		List<Student> studentList = this.repo.findAll();
		List<StudentDto> dtos = studentList.stream().map(student -> modelMapper.map(student, StudentDto.class))
				.collect(Collectors.toList());
		return dtos;
	}

	@Override
	public StudentDto getStudentById(Integer id) {
		Student studentRecord = null;
		try {
			studentRecord = this.repo.findById(id).orElseThrow(() -> new Exception("Record not Found"));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return modelMapper.map(studentRecord, StudentDto.class);
	}

	@Override
	public List<StudentDto> getStudentByFirstName(String firstName) {
		List<Student> retrivedStudentRecords = this.repo.findByFirstName(firstName);
		List<StudentDto> dtos = retrivedStudentRecords.stream()
				.map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public List<StudentDto> getStudentByLastName(String lastName) {
		List<Student> retrivedStudentRecords = this.repo.findByFirstName(lastName);
		List<StudentDto> dtos = retrivedStudentRecords.stream()
				.map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public List<StudentDto> getStudentByEmail(String email) {
		List<Student> retrivedStudentRecords = this.repo.findByFirstName(email);
		List<StudentDto> dtos = retrivedStudentRecords.stream()
				.map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public List<StudentDto> getStudentByContactNumber(String contactNumber) {
		List<Student> retrivedStudentRecords = this.repo.findByFirstName(contactNumber);
		List<StudentDto> dtos = retrivedStudentRecords.stream()
				.map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public StudentDto addStudentRecord(StudentDto studentDto) {
		Student retrivedStudentRecord = modelMapper.map(studentDto, Student.class);
		this.repo.save(retrivedStudentRecord);
		return modelMapper.map(retrivedStudentRecord, StudentDto.class);
	}

	@Override
	public StudentDto updateStudentRecord(Integer id, StudentDto studentDto) {
		Student studentRecord = null;
		try {
			studentRecord = this.repo.findById(id).orElseThrow(() -> new Exception("Record not Found"));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		StudentDto updatedDto = modelMapper.map(studentRecord, StudentDto.class);
		updatedDto.setFirstName(studentDto.getFirstName());
		updatedDto.setLastName(studentDto.getLastName());
		updatedDto.setEmail(studentDto.getEmail());
		updatedDto.setContactNumber(studentDto.getContactNumber());
		Student updatedStudent = modelMapper.map(updatedDto, Student.class);
		this.repo.save(updatedStudent);
		return modelMapper.map(updatedStudent, StudentDto.class);
	}

	@Override
	public String deleteStudentRecord(Integer id) {
		Student studentRecord = null;
		try {
			studentRecord = this.repo.findById(id).orElseThrow(() -> new Exception("Record not Found"));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		this.repo.delete(studentRecord);
		return "Record Deleted for ID:" + id;
	}

}
