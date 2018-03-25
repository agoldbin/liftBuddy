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
@Getter
@Setter
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "workout_id")
    private int workoutId;

    @ManyToOne
    private User user;

    @Transient
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<ExerciseType> exercise = new HashSet<>();

    /**
     * Empty constructor for workout
     */
    public Workout() {
    }

    /**
     * Workout constructor taking user as param
     *
     * @param user
     */
    public Workout(User user) {
        this.user = user;
        user.addWorkout(this);
    }
}
