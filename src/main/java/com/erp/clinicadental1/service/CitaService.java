package com.erp.clinicadental1.service;

import com.erp.clinicadental1.entity.Cita;
import com.erp.clinicadental1.entity.Paciente;
import com.erp.clinicadental1.repository.CitaRepository;
import com.erp.clinicadental1.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {

    private final CitaRepository repositorio;

    public CitaService(CitaRepository repositorio){this.repositorio = repositorio;}

    public List<Cita> listar() {
        return repositorio.findAll();
    }

    public Cita guardar(Cita cita) {
        return repositorio.save(cita);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }


}