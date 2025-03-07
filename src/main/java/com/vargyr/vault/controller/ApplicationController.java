package com.vargyr.vault.controller;

import com.vargyr.vault.entities.Application;
import com.vargyr.vault.repository.ApplicationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApplicationController {

    private final ApplicationRepository repository;

    ApplicationController(ApplicationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/applications/{id}")
    Application getApplicationById(Long id) {
        return repository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
