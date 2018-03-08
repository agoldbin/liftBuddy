package com.aarongoldbin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * A class to represent a gym choices
 *
 * @author agoldbin
 */

@Entity(name = "Friends")
@Table(name = "friends") // case senstitive
@Getter
@Setter
public class Friends implements Serializable {
    @Id
    @ManyToOne
    private User user;
}

