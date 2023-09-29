$(document).on("click", "#btnagregar", function(){
    $("#txtnombrecurso").val("");
    $("#hddidcurso").val("0");
    $("#cboespecialidad").empty();
    $("#cboprofesor").empty();
    listarCboEspecialidadesProfesores(0,0);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtnombrecurso").val($(this).attr("data-curname"));
    $("#cboespecialidad").empty();
    $("#cboprofesor").empty();
    listarCboEspecialidadesProfesores($(this).attr("data-curespecialidad"), $(this).attr("data-curprofesor"));
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/curso/registrar",
        contentType: "application/json",
        data: JSON.stringify({
            idcurso: $("#hddidcurso").val(),
            nombrecurso: $("#txtnombrecurso").val(),
            idesp: $("#cboespecialidad").val(),
            idprofesor: $("#cboprofesor").val(),
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarCursos;
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

function listarCboEspecialidadesProfesores(idesp,idprofesor){
    $.ajax({
        type: "GET",
        url: "/profesor/listar",
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
                            $("#cboprofesor").append(
                                `<option value="${value.idprofesor}">${value.nomprofesor}</option>`
                            )
                        });
                        if(idprofesor > 0){
                            $("#cboprofesor").val(idprofesor);
                        }
                    }
                })
        }
    });
}

function listarCursos(){
    $.ajax({
        type: "GET",
        url: "/cursos/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblcurso > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblcurso > tbody").append("<tr>"+
                    "<td>"+value.idcurso+"</td>"+
                    "<td>"+value.nombrecurso+"</td>"+
                    "<td>"+value.especialidad.nomesp+"</td>"+
                    "<td>"+value.profesor.nomprofesor+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-idsala='"+value.idcurso+"'"+
                                     "data-descsala='"+value.nombrecurso+"'"+
                                     "data-idestado='"+value.especialidad.idesp+"'"+
                                     "data-idestado='"+value.profesor.idprofesor+"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}