package com.aarongoldbin.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "ExerciseAmount")
@Table(name = "exercise_amount")
@Data
public class ExerciseAmount {

    @Id
    private int exerciseId;

    @Transient
    @ManyToOne
    private ExerciseType exerciseType;

    private int weight;
    private int sets;
    private int reps;
    private Date time;

}
