package org.example.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user_id", fetch = FetchType.LAZY)
    private Set<User_Perm_Relations> permissions =new HashSet<>();

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

    public Set<User_Perm_Relations> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<User_Perm_Relations> permissions) {
        this.permissions = permissions;
    }


}

