package pe.edu.cibertec.DAWII_CL1_Grupo9.model.request;

import lombok.Data;

@Data
public class CursoRequest {
    private Integer idcurso;
    private String nombrecurso;
    private Integer idesp;
    private Integer idprofesor;
}
