package pe.edu.cibertec.DAWII_CL1_Grupo9.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Curso;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Especialidad;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Profesor;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.request.CursoRequest;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_Grupo9.repository.CursoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CursoService {
    private CursoRepository cursoRepository;

    public List<Curso> listarCursos(){
        return cursoRepository.findAll();
    }

    public ResultadoResponse guardarCurso(CursoRequest curso){
        String mensaje = "Curso registrado correctamente";
        Boolean respuesta=true;
        try {
            Curso objCurso = new Curso();
            if (curso.getIdcurso() > 0) {
                objCurso.setIdcurso(curso.getIdcurso());
            }
            objCurso.setNombrecurso(curso.getNombrecurso());
            Especialidad especialidad = new Especialidad();
            especialidad.setIdesp(curso.getIdesp());
            Profesor profesor = new Profesor();
            profesor.setIdprofesor(curso.getIdprofesor());

            objCurso.setEspecialidad(especialidad);
            objCurso.setProfesor(profesor);
            cursoRepository.save(objCurso);
        } catch(Exception ex){
            mensaje="Curso no registrado";
            respuesta=false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
