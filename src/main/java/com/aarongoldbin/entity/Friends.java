package com.aarongoldbin.entity;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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

