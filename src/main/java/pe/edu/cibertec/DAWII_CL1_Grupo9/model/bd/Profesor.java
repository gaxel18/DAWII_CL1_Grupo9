package pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="profesor")
public class Profesor {
    @Id
    private Integer idprofesor;
    @Column(name="nomprofesor")
    private String nomprofesor;
    @Column(name="apeprofesor")
    private String apeprofesor;

}
