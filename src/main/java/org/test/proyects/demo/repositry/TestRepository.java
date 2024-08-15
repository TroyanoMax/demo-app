package org.test.proyects.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.proyects.demo.model.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
