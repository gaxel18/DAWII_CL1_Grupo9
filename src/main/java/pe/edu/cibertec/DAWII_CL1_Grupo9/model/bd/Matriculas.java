package pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "matriculas")
public class Matriculas {
    @Id
    private Integer idnota;
    @Column(name = "fecha_matricula")
    private Date fecha_matricula;

    @ManyToOne
    @JoinColumn(name = "idalumno")
    private Alumno alumno;
    @ManyToOne
    @JoinColumn(name = "idesp")
    private Especialidad especialidad;
}
