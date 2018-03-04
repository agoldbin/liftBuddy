package com.aarongoldbin.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 *
 * @author agoldbin
 */
@Entity(name = "Weight")
@Table(name = "weight")
@Data
public class Weight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "weightId")
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
     * Constructor for Weight
     *
     * @param weight the user weight
     */
    public Weight(int weight) {
        this.weight = weight;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }
}
