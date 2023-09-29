package pe.edu.cibertec.DAWII_CL1_Grupo9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Integer> {
}
