package com.jakuza.projects.repository;

import com.jakuza.projects.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void itShouldCheckIfStudentEmailExist(){
        Student student = new Student();
        student.setName("Jani");
        student.setEmail("jani@kukutyin.hu");
        studentRepository.save(student);
        boolean expected = studentRepository.selectExistsEmail("jani@kukutyin.hu");
        assertThat(expected).isTrue();

    }

    @Test
    void itShouldCheckIfStudentEmailDoesNotExist(){
        boolean expected = studentRepository.selectExistsEmail("jani@kukutyin.hu");
        assertThat(expected).isFalse();

    }

}
