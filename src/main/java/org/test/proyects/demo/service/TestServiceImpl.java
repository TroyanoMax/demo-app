package org.test.proyects.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.proyects.demo.model.dto.TestDTO;
import org.test.proyects.demo.model.entity.Test;
import org.test.proyects.demo.repositry.TestRepository;


@Service
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public void createTest(TestDTO testDTO) {
        Test test = new Test();
        test.setId(testDTO.getId());
        test.setNombre(testDTO.getNombre());
        test.setApellido(testDTO.getApellido());
        test.setDni(testDTO.getDni());
        test.setEmail(testDTO.getEmail());
        testRepository.save(test);
    }

    @Override
    public Optional<TestDTO> getTestById(Long id) {
        return testRepository.findById(id)
                .map(test -> {
                    TestDTO dto = new TestDTO();
                    dto.setId(test.getId());
                    dto.setNombre(test.getNombre());
                    dto.setApellido(test.getApellido());
                    dto.setDni(test.getDni());
                    dto.setEmail(test.getEmail());
                    return dto;
                });
    }

    // Puedes agregar otros métodos según sea necesario
}
