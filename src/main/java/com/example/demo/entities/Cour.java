package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cour {

    @Id
    @SequenceGenerator(
            name = "cour_sequence",
            sequenceName = "cour_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cour_sequence"
    )
    private Long courId;
    private String title;
    private Integer credit;

}
