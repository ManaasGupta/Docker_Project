package com.dockerassigment.restapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dockerassigment.restapp.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	List<Student> findByFirstName(String firstName);
	List<Student> findByLastName(String lastName);
	List<Student> findByEmail(String email);
	List<Student> findByContactNumber(String contactNumber);
}
