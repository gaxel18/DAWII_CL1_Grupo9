package pe.edu.cibertec.DAWII_CL1_Grupo9.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Especialidad;
import pe.edu.cibertec.DAWII_CL1_Grupo9.repository.EspecialidadRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EspecialidadService {

    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> listarEspecialidades(){
        return especialidadRepository.findAll();
    }
}
