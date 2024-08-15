package org.test.proyects.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.test.proyects.demo.service.ApiService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;

    @GetMapping("/data")
    public ResponseEntity<String> getData() {
        return apiService.getExampleData();
    }

}
