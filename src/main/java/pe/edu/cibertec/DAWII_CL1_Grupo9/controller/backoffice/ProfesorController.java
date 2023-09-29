package pe.edu.cibertec.DAWII_CL1_Grupo9.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Profesor;
import pe.edu.cibertec.DAWII_CL1_Grupo9.service.ProfesorService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/profesor")
public class ProfesorController {

    private ProfesorService profesorService;

    @GetMapping("/listar")
    @ResponseBody
    public List<Profesor> listarProfesores(){
        return profesorService.listarProfesores();
    }
}
