package org.example.repositories;

import org.example.dto.PermissionDto;
import org.example.dto.UserDto;
import org.example.models.Permission;
import org.example.models.User;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

public class TuesRepo {
    private final EntityManager entityManager;
    public TuesRepo(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    public User createUser(UserDto userDto){
        User newUser = new User();
        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());

        if(!userDto.getPermissions().isEmpty()){
            Set<Long> permissionIds = userDto.getPermissions().stream().map(PermissionDto::getId).collect(Collectors.toSet());
            TypedQuery<Permission> q = entityManager.createQuery("select p from Permission p where id in (:in)", Permission.class);
            q.setParameter("in", permissionIds);
            List<Permission> permissions = q.getResultList();

            if(permissions.isEmpty()){
                throw new RuntimeException("ERROR: No permissions were found");
            }

            for(Permission perm : permissions){
                newUser.addPermission(perm);
            }

        }

        entityManager.persist(newUser);
        return newUser;

    }

    @Transactional
    public Permission createPermission(PermissionDto permissionDto){
        Permission newPermission = new Permission();
        newPermission.setType(permissionDto.getType());

        return newPermission;
    }


}
