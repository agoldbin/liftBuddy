package com.aarongoldbin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// TODO work on this class, make sure all vars that are needed are included
// TODO clean up code, properly connect to UserRole and User
/**
 * A class to represent a User's role on the site
 *
 * @author agoldbin
 */
@Entity(name = "UserRole")
@Table(name = "user_role")
@Getter
@Setter
public class UserRole {
    @OneToOne(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Column(name = "role_id")
    private int roleId;

    @Id
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    @Transient
    private Role role;

// TODO fix constructors
    public UserRole(User user, String roleName) {
        this.userName = user.getUserName();
        this.setUser(user);
//        this.setRole(roleName);
        role.setRole(roleName);
    }

    public UserRole(String userName, User user, int roleId) {
        this.userName = userName;
        this.setUser(user);
        role.setRole(roleId);
    }

    public UserRole(String userName, User user, Role role) {
        this.userName = userName;
        this.setUser(user);
        this.setRole(role);
    }

}
