package com.erp.clinicadental1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


@Table(name = "citas")

public class Cita {


    @Id //Primary KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private LocalDateTime fechaHora;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String motivo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EstadoCita estado;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;


    @ManyToOne
    @JoinColumn(name = "tratamiento_id", nullable = false)
    private Tratamiento tratamiento;



}
