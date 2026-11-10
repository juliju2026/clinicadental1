package com.erp.clinicadental1.service;

import com.erp.clinicadental1.entity.Tratamiento;
import com.erp.clinicadental1.repository.TratamientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TratamientoService {
    private final TratamientoRepository repositorio;

    public TratamientoService(TratamientoRepository repositorio) { this.repositorio = repositorio; }
    public List<Tratamiento> listar() { return repositorio.findAll(); }

    public Tratamiento guardar(Tratamiento tratamiento) { return repositorio.save(tratamiento); }

    public void eliminar(Long id) {
            repositorio.deleteById(id);
        }
}
