package org.example.dto;

import org.example.models.User;

import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDto {


    private Long id;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    private Set<PermissionDto> permissions = new HashSet<>();

    public UserDto(User u){
        this.id = u.getId();
        this.firstName = u.getFirstName();
        this.lastName = u.getLastName();
        this.permissions = Optional.of(u.getPermissions())
                        .orElse(Collections.emptySet())
                .stream()
                .map(PermissionDto::new)
                .collect(Collectors.toSet());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Set<PermissionDto> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionDto> permissions) {
        this.permissions = permissions;
    }
}
