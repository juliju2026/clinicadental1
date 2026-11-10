package com.erp.clinicadental1.controller;
import com.erp.clinicadental1.entity.Cita;
import com.erp.clinicadental1.service.CitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/citas")
public class CitaController {

    private final CitaService servicio;

    public CitaController(CitaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute(
                "citas", servicio.listar()
        );
        return "citas";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("cita", new Cita());
        return "formulario-cita";
    }

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Cita cita) {
        servicio.guardar(cita);
        return "redirect:/citas";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return "redirect:/citas";
    }
}

