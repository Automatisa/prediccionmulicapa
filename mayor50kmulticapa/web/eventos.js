/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(e){
    $("#cmdEntrenar").click(function(e){
        $("#divResEnt").html("<img src='http://www.voki.com/images/processing.gif' alt='procesando'>");
        alert("cambio");
        $.ajax({
            type:"GET",
            data: "op=1",
            url: "acciones.jsp",
            async:false,
            success: function(respuesta){
                $("#divResEnt").html(respuesta);
            }
            
            
        });
    });
})


