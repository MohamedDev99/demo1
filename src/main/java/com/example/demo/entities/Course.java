package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @Builder
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "title_unique",
                columnNames = "title"
        )
)
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private String description;
}
