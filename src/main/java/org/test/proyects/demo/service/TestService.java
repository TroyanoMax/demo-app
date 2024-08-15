package org.test.proyects.demo.service;

import org.test.proyects.demo.model.dto.TestDTO;

import java.util.Optional;

public interface TestService {
    void createTest(TestDTO testDTO);
    Optional<TestDTO> getTestById(Long id);
    // Puedes agregar otros métodos según sea necesario
}
