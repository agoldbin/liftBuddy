package com.aarongoldbin.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 *
 * @author agoldbin
 */
@Entity(name = "Weight")
@Table(name = "weight")
@Getter
@Setter
public class Weight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "weight_id")
    private int id;

    @ManyToOne
    private User user;

    private int weight;

    /**
     * Constructor for Weight
     */
    public Weight() {
    }

    /**
     * Constructor for weight with user weight param
     *
     * @param weight
     */
    public Weight(int weight) {
        this.weight = weight;
    }

    /**
     * Constructor for Weight
     *
     * @param user the user object
     */
    public Weight(User user, int weight) {
        this.weight = weight;
        this.user = user;
        user.addWeight(this);
    }
}
