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
@Data public class Weight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "weightId")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "weight_user_user_id_fk")
    )
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
     * @param user the user
     */
    public Weight(User user) {
        this.user = user;
//        user.getWeight();
//        user.getId();
//        this.weight = weight;
    }
}
