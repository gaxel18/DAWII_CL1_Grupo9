package pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="cursos")
public class Curso {

    @Id
    private Integer idcurso;
    @Column(name="nombrecurso")
    private String nombrecurso;

    @ManyToOne
    @JoinColumn(name="idesp")
    private Especialidad especialidad;
    @ManyToOne
    @JoinColumn(name="idprofesor")
    private Profesor profesor;
}
