package com.aarongoldbin.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 *
 *
 * @author agoldbin
 */

@Entity(name = "Workout")
@Table(name = "workout") // case senstitive
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int workoutId;

    @ManyToOne
    private User user;

    @Setter @Getter
    private Date workoutDate;


    @OneToMany(mappedBy = "exerciseId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<ExerciseType> exercise = new HashSet<>();
}
