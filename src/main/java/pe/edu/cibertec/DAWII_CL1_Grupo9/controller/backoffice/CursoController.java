package pe.edu.cibertec.DAWII_CL1_Grupo9.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Curso;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.request.CursoRequest;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_Grupo9.service.CursoService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/curso")
public class CursoController {

    private CursoService cursoService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listarCursos",
                cursoService.listarCursos());
        return "backoffice/curso/frmMantCurso";
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<Curso> listarCursos(){
        return cursoService.listarCursos();
    }

    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarCurso(
            @RequestBody CursoRequest cursoRequest){
        return cursoService.guardarCurso(cursoRequest);
    }
}
