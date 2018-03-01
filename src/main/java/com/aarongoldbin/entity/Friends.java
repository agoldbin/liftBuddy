package com.aarongoldbin.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * A class to represent a gym choices
 *
 * @author agoldbin
 */

@Entity(name = "Friends")
@Table(name = "friends") // case senstitive
public class Friends {
    @ManyToOne
    @Column(name="friendUserId")
    private Set<User> users = new HashSet<>();
}
