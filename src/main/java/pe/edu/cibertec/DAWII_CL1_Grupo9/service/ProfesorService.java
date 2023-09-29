package pe.edu.cibertec.DAWII_CL1_Grupo9.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Profesor;
import pe.edu.cibertec.DAWII_CL1_Grupo9.repository.ProfesorRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfesorService {
    private ProfesorRepository profesorRepository;

    public List<Profesor> listarProfesores(){
        return profesorRepository.findAll();
    }
}
