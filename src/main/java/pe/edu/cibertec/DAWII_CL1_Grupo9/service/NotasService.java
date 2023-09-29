package pe.edu.cibertec.DAWII_CL1_Grupo9.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Alumno;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Curso;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Notas;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.request.NotasRequest;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_Grupo9.repository.NotasRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class NotasService {

    private NotasRepository notasRepository;

    public List<Notas> listarnotas(){
        return notasRepository.findAll();
    }

    public ResultadoResponse guardarNotas(NotasRequest notas){
        String mensaje = "Notas registradas correctamente";
        Boolean respuesta = true;
        try {
            Notas objNotas = new Notas();
            if(notas.getIdnota()> 0){
                objNotas.setIdnota(notas.getIdnota());
            }
            objNotas.setCalificacion(notas.getCalificacion());
            objNotas.setFecha_examen(notas.getFecha_examen());
            Alumno alumno = new Alumno();
            alumno.setIdalumno(notas.getIdalumno());
            Curso curso = new Curso();
            curso.setIdCurso(notas.getIdcurso());
            objNotas.setAlumno(alumno);
            objNotas.setCurso(curso);
        }catch (Exception ex){
            mensaje = "Producto no registrado";
            respuesta = false;

        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }


}