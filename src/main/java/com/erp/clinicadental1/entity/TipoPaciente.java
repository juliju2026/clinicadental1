package com.erp.clinicadental1.entity;

public enum TipoPaciente {
    PARTICULAR("Paciente Particular"),
    ASEGURADO("Asegurado por Convenio"),
    EMERGENCIA("Ingreso por Emergencia"),
    AMBULATORIO("Control Ambulatorio");

    private final String nombreMostrado;

    // Constructor del Enum
    TipoPaciente(String nombreMostrado) {
        this.nombreMostrado = nombreMostrado;
    }

    // Getter para que Thymeleaf pueda leer el texto amigable
    public String getNombreMostrado() {
        return nombreMostrado;
    }
}
