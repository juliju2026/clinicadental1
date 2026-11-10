package com.erp.clinicadental1.entity;

public enum TipoGenero {
    HOMBRE("Masculino"),
    MUJER("Femenino"),
    OTRO("Otro");

    private final String nombreMostrado;

    // Constructor del Enum
    TipoGenero(String nombreMostrado) {
        this.nombreMostrado = nombreMostrado;
    }

    // Getter para que Thymeleaf pueda leer el texto amigable
    public String getNombreMostrado() {
        return nombreMostrado;
    }

}
