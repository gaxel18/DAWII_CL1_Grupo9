package pe.edu.cibertec.DAWII_CL1_Grupo9.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Notas;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.request.NotasRequest;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_Grupo9.service.NotasService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/nota")
public class NotasController {

    private NotasService notasService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaNotas",
                NotasService.listarnotas());
        return "backoffice/notas/frmMantNotas";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<Notas> listarnotas(){
        return notasService.listarnotas();
    }
    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarNotas(
            @RequestBody NotasRequest notasRequest
    ){
        return notasService.guardarNotas(notasRequest);
    }



}
