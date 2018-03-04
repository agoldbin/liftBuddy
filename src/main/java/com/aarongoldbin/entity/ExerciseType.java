package com.aarongoldbin.entity;

import lombok.Data;
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

@Entity(name = "ExerciseType")
@Table(name = "exercise_type") // case senstitive
@Data
public class ExerciseType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int exerciseId;

    @ManyToOne
    private Workout workout;

    @Transient
    @OneToMany(mappedBy = "exercise_type", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<ExerciseAmount> exerciseAmounts = new HashSet<>();

    @Getter @Setter
    private String exerciseName;
}
