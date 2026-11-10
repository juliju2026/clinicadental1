package com.erp.clinicadental1.service;

import com.erp.clinicadental1.entity.Paciente;
import com.erp.clinicadental1.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repositorio;

    public PacienteService(PacienteRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Paciente> listar() {
        return repositorio.findAll();
    }

    public Paciente guardar(Paciente paciente) {
        return repositorio.save(paciente);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}