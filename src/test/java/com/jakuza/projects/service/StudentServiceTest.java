package com.jakuza.projects.service;

import com.jakuza.projects.model.Student;
import com.jakuza.projects.repository.LocationRepository;
import com.jakuza.projects.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    @Mock
    private LocationRepository locationRepository;
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService(studentRepository, locationRepository);
    }


    @Test
    void canGetAllStudents() {
        studentService.getAll();
        verify(studentRepository).findAll();
    }

    @Test
    void canAddNewStudent() {
        Student student = new Student();
        student.setName("Jani");
        student.setEmail("jani@kukutyin.hu");
        studentService.add(student);
        ArgumentCaptor<Student> studentArgumentCaptor =
                ArgumentCaptor.forClass(Student.class);

        verify(studentRepository)
                .save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    void willThrowWhenEmailIsTaken() {

        Student student = new Student();
        student.setName("Jani");
        student.setEmail("jani@kukutyin.hu");

        given(studentRepository.selectExistsEmail(anyString()))
                .willReturn(true);

        assertThatThrownBy(() -> studentService.add(student))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Email " + student.getEmail() + " taken");

        verify(studentRepository, never()).save(any());

    }


    @Test
    void willDeleteStudent() {
        long id = 10;
        given(studentRepository.existsById(id))
                .willReturn(true);
        studentService.remove(id);
        verify(studentRepository).deleteById(id);
    }

    @Test
    void willThrowWhenDeleteStudentNotFound() {
        // given
        long id = 10;
        given(studentRepository.existsById(id))
                .willReturn(false);
        // when
        // then
        assertThatThrownBy(() -> studentService.remove(id))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Student with id " + id + " does not exists");

        verify(studentRepository, never()).deleteById(any());
    }


}
