package org.example.dto;

import org.example.models.Permission;
import org.example.models.User;
import org.example.models.User_Perm_Relations;

public class User_Perm_Relations_Dto {

    private Long id;
    private User user_id;
    private Permission perm_id;
    public User_Perm_Relations_Dto(User_Perm_Relations perm) {
        this.id = perm.getId();
        this.user_id = perm.getUser_id();
        this.perm_id = perm.getPermission_id();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Permission getPerm_id() {
        return perm_id;
    }

    public void setPerm_id(Permission perm_id) {
        this.perm_id = perm_id;
    }
}
