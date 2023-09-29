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
@Table(name = "especialidad")
public class Especialidad {
    @Id
    private String idesp;
    @Column(name = "nomesp")
    private String nomesp;
    @Column(name = "costo")
    private Double costo;

}
