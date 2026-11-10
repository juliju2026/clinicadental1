package com.erp.clinicadental1.repository;

import com.erp.clinicadental1.entity.Paciente;
import com.erp.clinicadental1.entity.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
}
