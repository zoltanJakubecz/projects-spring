package com.jakuza.projects.service;

import com.jakuza.projects.repository.LocationRepository;
import com.jakuza.projects.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    @Mock
    private LocationRepository locationRepository;
    private AutoCloseable autoCloseable;
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        studentService = new StudentService(studentRepository, locationRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllStudents() {
        studentService.getAll();
        verify(studentRepository).findAll();
    }

    @Test
    @Disabled
    void add() {
    }

    @Test
    @Disabled
    void getOne() {
    }

    @Test
    @Disabled
    void update() {
    }

    @Test
    @Disabled
    void remove() {
    }

    @Test
    @Disabled
    void assignLocationToStudent() {
    }

}
