package pe.edu.cibertec.DAWII_CL1_Grupo9.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Matriculas;
import pe.edu.cibertec.DAWII_CL1_Grupo9.repository.MatriculasRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MatriculasService {

    private MatriculasRepository matriculasRepository;

    public List<Matriculas> listarMatriculas(){
        return matriculasRepository.findAll();
    }
}
