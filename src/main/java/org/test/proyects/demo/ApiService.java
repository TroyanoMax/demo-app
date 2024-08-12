package org.test.proyects.demo;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ApiService {

    @Value("${NAME}")
    private String name;

    @Value("${test}")
    private String test;

    private final RestTemplate restTemplate;

    @Autowired
    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getExampleData() {

        log.info("Esta es un mensaje de prueba: {}", name);
        log.info("Esta es una kv de testeo: {}", test);

        String url = "https://6659010ede346625136b17fc.mockapi.io/api/vi/quejas";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

    }
}
