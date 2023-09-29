package pe.edu.cibertec.DAWII_CL1_Grupo9.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Alumno;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Especialidad;
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

    public ResultadoResponse guardarAlumno(AlumnoRequest alumno) {

        String mensaje = "Alumno registrado correctamente";
        Boolean respuesta = true;

        try {
            Alumno objAlumno = new Alumno();
            if (alumno.getIdalumno() > 0) {
                objAlumno.setIdalumno(alumno.getIdalumno());
            }
            objAlumno.setNombreAlumno(alumno.getNombrealumno());
            Especialidad especialidad = new Especialidad();
            especialidad.setIdesp(alumno.getIdesp());

            objAlumno.setEspecialidad(especialidad);
            alumnoRepository.save(objAlumno)
        }catch(Exception ex) {
            mensaje = "Alumno no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
