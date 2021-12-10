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
public class CourMaterial {

    @Id
    @SequenceGenerator(
            name = "cour_material_sequence",
            sequenceName = "cour_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cour_material_sequence"
    )
    private Long courMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "cour_id",
            referencedColumnName = "courId"
    )
    private Cour cour;
}
