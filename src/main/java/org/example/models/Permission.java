package org.example.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String type;

    @OneToMany(mappedBy = "permission_id", fetch = FetchType.LAZY)
    private Set<User_Perm_Relations> users = new HashSet<>();

    public Set<User_Perm_Relations> getUsers() {
        return users;
    }

    public void setUsers(Set<User_Perm_Relations> users) {
        this.users = users;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
