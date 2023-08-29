package com.learning.docker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.docker.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
