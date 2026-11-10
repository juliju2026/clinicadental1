package com.erp.clinicadental1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pacientes")

public class Paciente {

    @Id //Primary KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement
    private Long id;

    @NotBlank(message="El nombre es obligatorio.")
    @Size(min=2, max = 50, message="El nombre debe tener entre 2 y 50 caracteres.")
    @Column(nullable = false, length = 50)
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min=2, max = 80, message="Los apellidos deben tener entre 2 y 80 caracteres.")
    @Column(nullable = false, length = 80)
    private String apellidos;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoGenero tipoGenero;

    @Min(0)
    @Max(100)
    private Integer edad;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    @Size(max=15, message="El teléfono no puede superar los 15 caracteres")
    @Column(length=15)
    private String telefono;

    @Size(max=150, message="La dirección no puede superar los 150 caracteres")
    @Column(nullable=false, length=150)
    private String direccion;

    @Email(message="el correo no está en el formato adecuado")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoPaciente tipoPaciente;



}
