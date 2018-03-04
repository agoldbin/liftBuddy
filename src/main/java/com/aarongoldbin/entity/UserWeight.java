package com.aarongoldbin.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 *
 * @author agoldbin
 */
@Entity(name = "UserWeight")
@Table(name = "user_weight")
@Data public class UserWeight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "weightId")
    private int id;

    @ManyToOne
    private User user;

    private int weight;

    /**
     * Constructor for UserWeight
     */
    public UserWeight() {
    }

    /**
     * Constructor for UserWeight
     *
     * @param weight
     */
    public UserWeight(User user) {
        this.user = user;
//        user.getWeight();
//        user.getId();
//        this.weight = weight;
    }
}
