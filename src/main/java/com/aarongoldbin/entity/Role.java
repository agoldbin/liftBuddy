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
@Table(name = "role") // case senstitive
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
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
     * @returns the users
     */
    public Set<User> getUsers(){
        return users;
    }

    /**
     * Sets users
     *
     * @param users the users
     */
    public void setUsers(Set<User> users){
        this.users = users;
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

//package com.aarongoldbin.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * A class to represent the role options for the site
// * 1 = admin
// * 2 = buddy
// *
// * @author agoldbin
// */
//@Entity(name = "Role")
//@Table(name = "role") // case senstitive
//@Getter
//@Setter
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
//    @GenericGenerator(name = "native", strategy = "native")
//    @Column(name = "role_id")
//    private int id;
//
//    @Column(name = "role_name")
//    private String roleName;
//
//    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
//    private Set<User> users = new HashSet<>();
//
//
//    /**
//     * Instantiates a new Role.
//     */
//    public Role() {
//    }
//
//    /**
//     * Instantiates a new Role.
//     *
//     * @param id the role id
//     */
//    public Role(int id) {
//        this.id = id;
//    }
//
//    /**
//     * Instantiates a new Role.
//     *
//     * @param id the role id
//     */
//    public Role(int id, String roleName) {
//        this.id = id;
//        this.roleName = roleName;
//    }
//
//    /**
//     * Gets id.
//     *
//     * @return the id
//     */
//    public int getId() {
//        return id;
//    }
//
//    /**
//     * Sets id.
//     *
//     * @param id the id
//     */
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    /**
//     * Gets role name.
//     *
//     * @return the role name
//     */
//    public String getRoleName() {
//        return roleName;
//    }
//
//    /**
//     * Sets role name.
//     *
//     * @param roleName the role name
//     */
//    public void setRoleName(String roleName) {
//        this.roleName = roleName;
//    }
//
//    /**
//     * Gets users
//     *
//     * @returns the users
//     */
//    public Set<User> getUsers(){
//        return users;
//    }
//
//    /**
//     * Sets users
//     *
//     * @param users the users
//     */
//    public void setUsers(Set<User> users){
//        this.users = users;
//    }
//
//    /**
//     * Add user.
//     *
//     * @param user the user
//     */
//    public void addUser(User user) {
//        users.add(user);
//        user.setRole(this);
//    }
//
//    /**
//     * Remove user.
//     *
//     * @param user the user
//     */
//    public void removeUser(User user) {
//        users.remove(user);
//        user.setGym(null);
//    }
//}
//
//
//
//
//
////
////    /**
////     * Instantiates a new Role.
////     */
////    public Role() {
////    }
////
////    /**
////     * Instantiates a new Role.
////     *
////     * @param roleName the role name
////     */
////    public Role(String roleName) {
////        this.roleName = roleName;
////    }
////
////    /**
////     * Instantiates a new Role.
////     *
////     * @param roleName  the role name
////     * @param users the user roles
////     */
////    public Role(String roleName, Set<User> users) {
////        this.roleName = roleName;
////        this.users = this.users;
////    }
////
////    /**
////     * Instantiates a new Role.
////     *
////     * @param roleId  the role id
////     * @param roleName the role name
////     */
////    public Role(int roleId, String roleName) {
////        this.roleName = roleName;
////        this.users = this.users;
////    }
////
////    /**
////     * Method to set a users role.
////     */
////    public void setRole(String roleName) {
////        this.roleName = roleName;
////    }
////
////    /**
////     * Method to set a users role.
////     */
////    public void setRole(int roleId) {
////        this.roleId = roleId;
////    }
////
////    /**
////     * Gets users
////     *
////     * @returns the users
////     */
////    public Set<User> getUsers(){
////        return users;
////    }
////
////    /**
////     * Sets users
////     *
////     * @param users the users
////     */
////    public void setUsers(Set<User> users){
////        this.users = users;
////    }
////
////    /**
////     * Add user.
////     *
////     * @param user the user
////     */
////    public void addUser(User user, Role role) {
////        users.add(user);
////        user.setRole(this);
////    }
////
////    /**
////     * Remove user.
////     *
////     * @param user the user
////     */
////    public void removeUser(User user) {
////        users.remove(user);
////        user.setRole(null);
////    }
////
////}