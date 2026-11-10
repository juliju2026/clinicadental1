package com.erp.clinicadental1.repository;

import com.erp.clinicadental1.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    //findAll() -Obtener todos los pacientes.
    //findById(id) - Buscar por identificador.
    //save(paciente) - Guardar o actualizar una entidad.
    //deleteById(id) - Eliminar por identificador.
    //existsById(id) - Comprobar si existe un identificador.
}
