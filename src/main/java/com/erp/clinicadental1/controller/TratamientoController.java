package com.erp.clinicadental1.controller;
import com.erp.clinicadental1.entity.Tratamiento;
import com.erp.clinicadental1.service.TratamientoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/tratamientos")
public class TratamientoController {

    private final TratamientoService servicio;

    public TratamientoController(TratamientoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute(
                "tratamientos", servicio.listar()
        );
        return "tratamientos";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("tratamiento", new Tratamiento());
        return "formulario-tratamiento";
    }

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Tratamiento tratamiento) {
        servicio.guardar(tratamiento);
        return "redirect:/tratamientos";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return "redirect:/tratamientos";
    }
}


