package pe.edu.cibertec.DAWII_CL1_Grupo9.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "notas")
public class Notas {
    @Id
    private Integer idnota;
    @Column(name = "calificacion")
    private Double calificacion;
    @Column(name = "fecha_examen")
    private Date fecha_examen;

    @ManyToOne
    @JoinColumn(name = "idalumno")
    private Alumno alumno;
    @ManyToOne
    @JoinColumn(name = "idcurso")
    private Curso curso;

    public Integer getIdnota() {
        return idnota;
    }

    public void setIdnota(Integer idnota) {
        this.idnota = idnota;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFecha_examen() {
        return fecha_examen;
    }

    public void setFecha_examen(Date fecha_examen) {
        this.fecha_examen = fecha_examen;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
