package com.aarongoldbin.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// TODO work on this class, make sure all vars that are needed are included
// TODO clean up code, properly connect to UserRole
/**
 * A class to represent a role options
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

//    private Set<UserRole> userRoles = new HashSet<>();
//    @Column(name = "user_name")
//    private String userName;
//
//    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    private Set<User> users = new HashSet<>();

}
