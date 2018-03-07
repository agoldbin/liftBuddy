package com.aarongoldbin.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;

/**
 *
 *
 * @author agoldbin
 */

@Entity(name = "ExerciseType")
@Table(name = "exercise_type") // case senstitive
@Getter
@Setter
public class ExerciseType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int exerciseId;

    @ManyToOne
    private Workout workout;

    @Column(name = "exercise_name")
    private String exerciseName;

    private int reps;
    private int sets;
    private int weight;
    private Time time;
}
