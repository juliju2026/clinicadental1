package com.erp.clinicadental1.controller;
import com.erp.clinicadental1.entity.Paciente;
import com.erp.clinicadental1.entity.TipoGenero;
import com.erp.clinicadental1.entity.TipoPaciente;
import com.erp.clinicadental1.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService servicio;

    public PacienteController(PacienteService servicio) {
        this.servicio = servicio;
    }

    // 1. Esto expone la lista de géneros a todas las vistas de este controlador automáticamente
    @ModelAttribute("generos")
    public TipoGenero[] getGeneros() {
        return TipoGenero.values();
    }

    // 2. Esto expone la lista de tipos de paciente automáticamente
    @ModelAttribute("tiposPaciente")
    public TipoPaciente[] getTiposPaciente() {
        return TipoPaciente.values();
    }


    @GetMapping
    public String listar(Model model) {
        model.addAttribute(
                "pacientes", servicio.listar()
        );
        return "pacientes";
    }
    // Mét odo para mostrar el formulario de nuevo paciente
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        // Pasamos un objeto Paciente vacío para vincularlo con th:object
        model.addAttribute("paciente", new Paciente());

        // Ya no necesitas poner model.addAttribute para los Enums aquí,
        // los métodos con @ModelAttribute de arriba se encargan de ello.
        return "formulario-paciente";
    }

    // Mét odo para recibir y procesar el formulario
    @PostMapping("/guardar")
    public String guardar(
            @Valid @ModelAttribute("paciente") Paciente paciente, BindingResult result) {
        // Si el backend detecta algún error de tamaño, vacío, etc.
        if (result.hasErrors()) {
            // Retornamos directamente la vista del formulario para que el usuario corrija los datos.
            // Los Enums de género y tipoPaciente siguen disponibles gracias a los @ModelAttribute globales.
            return "formulario-paciente"; // Pon aquí el nombre exacto de tu archivo HTML del formulario
        }

        // Si to do está correcto, procedemos a guardar
        servicio.guardar(paciente);
        return "redirect:/pacientes";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return "redirect:/pacientes";
    }
}

