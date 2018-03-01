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

@Entity(name = "ExerciseType")
@Table(name = "exercise_type") // case senstitive
public class ExerciseType {

    @ManyToOne
    private Workout workout;

    @Getter @Setter
    private String exerciseName;
}
