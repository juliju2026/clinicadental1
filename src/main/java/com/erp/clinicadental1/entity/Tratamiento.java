package com.erp.clinicadental1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tratamientos")

public class Tratamiento {

    @Id //Primary KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String nombreTratamiento;

    @NotBlank
    @Size(max = 250)
    @Column(nullable = false, length = 250)
    private String descripcion; //explicacion tratamiento

    @Min(0)
    @Max(999999)
    private Float precio;

    @Min(0)
    @Max(1440)
    private Integer duracionminutos;
}
