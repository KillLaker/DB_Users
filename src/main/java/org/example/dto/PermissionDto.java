package org.example.dto;

import org.example.models.Permission;
import org.example.models.User_Perm_Relations;

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

    private Set<User_Perm_Relations_Dto> users = new HashSet<>();

    public PermissionDto(Permission p){
        this.id = p.getId();
        this.type = p.getType();
        this.users = Optional.of(p.getUsers())
                .orElse(Collections.emptySet())
                .stream()
                .map(User_Perm_Relations_Dto::new)
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

    public Set<User_Perm_Relations_Dto> getUsers() {
        return users;
    }

    public void setUsers(Set<User_Perm_Relations_Dto> users) {
        this.users = users;
    }
}
