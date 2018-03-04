package com.aarongoldbin.entity;

import lombok.Data;
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
@Data
public class Friends {
    @Id
    @ManyToOne
    private User user;
}
