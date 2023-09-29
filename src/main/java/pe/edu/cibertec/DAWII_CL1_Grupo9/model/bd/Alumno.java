package pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    private String idalumno;
    @Column(name = "apealumno")
    private String apealumno;
    @Column(name = "nomalumno")
    private String nomalumno;
    @Column(name = "proce")
    private String proce;

    @ManyToOne
    @JoinColumn(name = "idesp")
    private Especialidad especialidad;

}
