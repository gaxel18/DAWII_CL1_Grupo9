$(document).on("click", "#btnagregar", function(){
    $("#txtapellidoalumno").val("");
    $("#txtnombrealumno").val("");
    $("#hddidalumno").val("0");
    $("#cboespecialidad").empty();
    $("#txtprocealumno").val("");
    listarCboEspecialidades(0);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtapellidoalumno").val($(this).attr("data-apealu"));
    $("#txtnombrealumno").val($(this).attr("data-nomalu"));
    $("#cboespecialidad").empty();
    $("#txtprocealumno").val($(this).attr("data-proalu"));
    listarCboEspecialidades($(this).attr("data-aluespecialidad"));
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/alumno/guardar",
        contentType: "application/json",
        data: JSON.stringify({
            idalumno: $("#hddidalumno").val(),
            apellidoalumno: $("#txtapellidoalumno").val(),
            nombrealumno: $("#txtnombrealumno").val(),
            idesp: $("#cboespecialidad").val(),
            procealumno: $("#txtprocealumno").val(),
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarAlumnos;
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

function listarCboEspecialidadesAlumnos(idesp,idalumno){
    $.ajax({
        type: "GET",
        url: "/alumno/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboespecialidad").append(
                    `<option value="${value.idesp}">${value.nomesp}</option>`
                )
            });
            if(idcategoria > 0){
                $("#cboespecialidad").val(idespecialidad);
            }
            $.ajax({
                    type: "GET",
                    url: "/especialidad/listar",
                    dataType: "json",
                    success: function(resultado){
                        $.each(resultado, function(index, value){
                            $("#cboalumno").append(
                                `<option value="${value.idalumno}">${value.nomalu}</option>`
                            )
                        });
                        if(idalumno > 0){
                            $("#cboalumno").val(idalumno);
                        }
                    }
                })
        }
    });
}

function listarAlumnos(){
    $.ajax({
        type: "GET",
        url: "/alumnos/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblalumno > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblalumno > tbody").append("<tr>"+
                    "<td>"+value.idalumno+"</td>"+
                    "<td>"+value.apellidoalumno+"</td>"+
                    "<td>"+value.nombrealumno+"</td>"+
                    "<td>"+value.especialidad.nomesp+"</td>"+
                    "<td>"+value.procealumno+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-idsala='"+value.idalumno+"'"+
                                     "data-descsala='"+value.apellidoalumno+"'"+
                                     "data-descsala='"+value.nombrealumno+"'"+
                                     "data-idestado='"+value.especialidad.idesp+"'"+
                                     "data-descsala='"+value.procealumno+"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}