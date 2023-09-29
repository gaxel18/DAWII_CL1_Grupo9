$(document).on("click", "#btnagregar", function(){
    $("#txtcalificacion").val("");
    $("#txtfecha_matricula").val("");
    $("#hddcodnota").val("0");
    $("#cboalumno").empty();
    $("#cbocurso").empty();
    listarCboAlumnosCursos(0,0);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtcalificacion").val($(this).attr("data-prodname"));
    $("#txtfecha_matricula").val($(this).attr("data-produnit"));
    $("#hddcodnota").val($(this).attr("data-notacod"));
    $("#cboalumno").empty();
    $("#cbocurso").empty();
    listarCboAlumnosCursos($(this).attr("data-notaalumno"), $(this).attr("data-notacurso"));
    $("#modalNuevo").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/notas/registrar",
        contentType: "application/json",
        data: JSON.stringify({
            idnota: $("#hddcodnota").val(),
            calificacion: $("#txtcalificacion").val(),
            fecha_matricula: $("#txtfecha_matricula").val(),
            idalumno: $("#cboalumno").val(),
            idcurso: $("#cbocurso").val().prop('checked')
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarNotas();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

function listarCboAlumnosCursos(idalumno, idcurso){
    $.ajax({
        type: "GET",
        url: "/alumno/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboalumno").append(
                    `<option value="${value.idalumno}">${value.nomalumno}</option>`
                )
            });
            if(idalumno > 0){
                $("#cboalumno").val(idalumno);
            }
            $.ajax({
                    type: "GET",
                    url: "/curso/listar",
                    dataType: "json",
                    success: function(resultado){
                        $.each(resultado, function(index, value){
                            $("#cbocurso").append(
                                `<option value="${value.idcurso}">${value.nombrecurso}</option>`
                            )
                        });
                        if(idcurso > 0){
                            $("#cbocurso").val(idcurso);
                        }
                    }
                })
        }
    });
}

function listarProductos(){
    $.ajax({
        type: "GET",
        url: "/notas/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblnotas > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblnotas > tbody").append("<tr>"+
                    "<td>"+value.idnota+"</td>"+
                    "<td>"+value.calificacion+"</td>"+
                    "<td>"+value.fecha_matricula+"</td>"+
                    "<td>"+value.alumno.nomalumno+"</td>"+
                    "<td>"+value.curso.nombrecurso+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-idnota='"+value.idnota+"'"+
                                     "data-calificacion='"+value.calificacion+"'"+
                                     "data-fecha_matricula='"+value.fecha_matricula+"'"+
                                     "data-idalumno='"+value.categories.idalumno+"'"+
                                     "data-idcurso='"+value.suppliers.idcurso+"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}