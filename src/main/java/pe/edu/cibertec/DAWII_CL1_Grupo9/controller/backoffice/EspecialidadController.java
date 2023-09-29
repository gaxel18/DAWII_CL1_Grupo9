package pe.edu.cibertec.DAWII_CL1_Grupo9.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Especialidad;
import pe.edu.cibertec.DAWII_CL1_Grupo9.service.EspecialidadService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/especialidad")
public class EspecialidadController {

    private EspecialidadService especialidadService;

    @GetMapping("/listar")
    @ResponseBody
    public List<Especialidad> listarEspecialidades() {
        return especialidadService.listarEspecialidades();
    }

}
