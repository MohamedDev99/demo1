package com.example.demo.repository;

import com.example.demo.entities.Guardian;
import com.example.demo.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
     public void saveStudent(){

        Guardian guardian = Guardian.builder()
                .name("mohamed")
                .email("khalid_mohamed@gmail.com").
                mobile("9999999900")
                .build();

        Student student = Student.builder()
                .firstName("mohamed")
                .lastName("said")
                .emailId("said@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }


    @Test
    public void getStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("said@gmail.com");
        System.out.println(student);
    }


    @Test
    public void getStudentFirstNameByEmailAddress(){
        String studentFirstName = studentRepository.getStudentFirstNameByEmailAddress("said@gmail.com");
        System.out.println(studentFirstName);
    }


}