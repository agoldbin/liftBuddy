package com.aarongoldbin.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A class to represent the role options for the site
 * 1 = admin
 * 2 = lifter
 *
 * @author agoldbin
 */
@Entity(name = "Role")
@Table(name = "role") // case senstitive
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role_name")
    private String roleName;

    private Set<User> users = new HashSet<>();

    /**
     * Instantiates a new Role.
     */
    public Role() {
    }

    /**
     * Instantiates a new Role.
     *
     * @param roleName the role name
     */
    public Role(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Instantiates a new Role.
     *
     * @param roleId the role id
     */
    public Role(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Instantiates a new Role.
     *
     * @param roleId   the role id
     * @param roleName the role name
     */
    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    /**
     * Instantiates a new Role.
     *
     * @param roleName  the role name
     * @param users the user roles
     */
    public Role(String roleName, Set<User> users) {
        this.roleName = roleName;
        this.users = this.users;
    }

    /**
     * Instantiates a new Role.
     *
     * @param roleId    the role id
     * @param roleName  the role name
     * @param users the user roles
     */
    public Role(int roleId, String roleName, Set<User> users) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.users = users;
    }

    /**
     * Method to set a users role.
     */
    public void setRole(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Method to set a users role.
     */
    public void setRole(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Add user.
     *
     * @param user the user
     */
    public void addUser(User user) {
        users.add(user);
        user.setRole(this);
    }

    /**
     * Remove user.
     *
     * @param user the user
     */
    public void removeUser(User user) {
        users.remove(user);
        user.setRole(null);
    }

}
