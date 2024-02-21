package org.example.models;

import javax.persistence.*;

@Entity
public class User_Perm_Relations {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Permission permission_id;

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

    public Permission getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Permission permission_id) {
        this.permission_id = permission_id;
    }


}
