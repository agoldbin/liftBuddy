package com.aarongoldbin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role_name")
    private String roleName;

    private Set<UserRole> userRoles = new HashSet<>();


    /**
     * Instantiates a new UserRole.
     */
    public UserRole() {
    }

    /**
     * Instantiates a new UserRole.
     *
     * @param roleName the role name
     */
    public UserRole(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Instantiates a new UserRole.
     *
     * @param roleId the UserRole id
     */
    public UserRole(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Instantiates a new UserRole.
     *
     * @param roleId   the role id
     * @param roleName the role name
     */
    public UserRole(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    /**
     * Instantiates a new UserRole.
     *
     * @param roleName  the role name
     * @param userRoles the user roles
     */
    public UserRole(String roleName, Set<UserRole> userRoles) {
        this.roleName = roleName;
        this.userRoles = userRoles;
    }

    /**
     * Instantiates a new UserRole.
     *
     * @param roleId    the role id
     * @param roleName  the role name
     * @param userRoles the user roles
     */
    public UserRole(int roleId, String roleName, Set<UserRole> userRoles) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.userRoles = userRoles;
    }
}
