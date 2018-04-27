package com.aarongoldbin.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * A class to represent a role choices
 *
 * @author agoldbin
 */
@Entity(name = "Role")
@Table(name = "role")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "role_name")
    private String roleName;

    @ManyToOne
    private User user;

    @Column(name = "user_name")
    private String userName;


    /**
     * Instantiates a new Role.
     */
    public Role() {
    }

    /**
     * Instantiates a new Role
     *
     * @param user     the user
     * @param roleName the role name
     */
    public Role(User user, String roleName) {
        this.user = user;
        this.roleName = roleName;
        this.userName = user.getUserName();
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets role name.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets role name.
     *
     * @param roleName the role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Gets users
     *
     * @return the user
     * @returns the users
     */
    public User getUser(){
        return user;
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(userName, role.userName) &&
                Objects.equals(roleName, role.roleName);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id,  roleName, userName);
    }
}