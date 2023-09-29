package pe.edu.cibertec.DAWII_CL1_Grupo9.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Alumno;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.request.AlumnoRequest;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_Grupo9.repository.AlumnoRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class AlumnoService {

    private AlumnoRepository alumnoRepository;

    public List<Alumno> listarAlumnos(){
        return alumnoRepository.findAll();
    }

    public ResultadoResponse guardarAlumno(AlumnoRequest alumnoRequest){
        return null;
    }

}
