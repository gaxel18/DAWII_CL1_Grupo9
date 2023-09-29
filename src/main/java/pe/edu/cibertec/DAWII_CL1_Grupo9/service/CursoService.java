package pe.edu.cibertec.DAWII_CL1_Grupo9.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Curso;
import pe.edu.cibertec.DAWII_CL1_Grupo9.repository.CursoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CursoService {
    private CursoRepository cursoRepository;

    public List<Curso> listarCursos(){
        return cursoRepository.findAll();
    }
}
