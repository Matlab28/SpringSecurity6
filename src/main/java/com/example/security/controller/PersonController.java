package com.example.security.controller;

import com.example.security.dto.response.PersonResponseDto;
import com.example.security.entity.PersonEntity;
import com.example.security.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService service;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<PersonResponseDto>> findAll() {
        final List<PersonEntity> persons = service.findAll();
        final List<PersonResponseDto> dtos = persons.stream().map(p -> new PersonResponseDto(p)).toList();
        return ResponseEntity.ok(dtos);
    }

    public ResponseEntity<PersonResponseDto> create(@RequestBody PersonResponseDto dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        return ResponseEntity.ok(service.create(dto));
    }

    public ResponseEntity<PersonResponseDto> update(@RequestBody PersonResponseDto dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        return ResponseEntity.ok(service.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
