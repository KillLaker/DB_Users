package org.example.dto;

import org.example.models.Permission;

import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class PermissionDto {

    private Long id;

    @NotBlank
    private String type;

    private Set<UserDto> users = new HashSet<>();

    public PermissionDto(Permission p){
        this.id = p.getId();
        this.type = p.getType();
        this.users = Optional.of(p.getUsers())
                .orElse(Collections.emptySet())
                .stream()
                .map(UserDto::new)
                .collect(Collectors.toSet());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<UserDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDto> users) {
        this.users = users;
    }


}
