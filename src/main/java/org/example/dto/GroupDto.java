package org.example.dto;

import org.example.models.Group;

import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupDto {
    private Long id;
    @NotBlank
    private String name;
    private Set<PermissionDto> permissions = new HashSet<>();

    public GroupDto(Group group){
        this.id = group.getId();
        this.name = group.getName();
        this.permissions = Optional.of(group.getPermissions())
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PermissionDto> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionDto> permissions) {
        this.permissions = permissions;
    }
}
