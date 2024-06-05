package com.example.security.dto.request;

import com.example.security.constant.Role;
import com.example.security.entity.PersonEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
public class PersonRequestDto {
    private String name;
    private String email;
    private String password;
    private Set<String> roles = new HashSet<>();

    public PersonRequestDto() {
        super();
    }

    public PersonRequestDto(Long id, String name, String email, Set<String> roles) {
        super();
        this.name = name;
        this.email = email;
        this.roles = roles;
    }

    public PersonRequestDto(PersonEntity person) {
        super();
        this.name = person.getName();
        this.email = person.getEmail();
        this.setRoles(person.getRoles());
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles.stream().map(r -> r.getDescription()).collect(Collectors.toSet());
    }
}
