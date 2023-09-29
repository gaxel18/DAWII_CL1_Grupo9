package pe.edu.cibertec.DAWII_CL1_Grupo9.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Alumno;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.request.AlumnoRequest;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_Grupo9.service.AlumnoService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    private AlumnoService alumnoService;
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaAlumno", alumnoService.listarAlumnos());
        return "backoffice/alumno/frmMantAlumno";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<Alumno> listarAlumnos(){
        return alumnoService.listarAlumnos();
    }

    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarAlumno(
        @RequestBody AlumnoRequest alumnoRequest){
        return alumnoService.guardarAlumno(alumnoRequest);
    }

}
