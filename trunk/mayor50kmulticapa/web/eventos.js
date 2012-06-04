/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(e){
    $("#cmdEntrenar").click(function(e){
        $("#divResEnt").html("<img src='http://www.voki.com/images/processing.gif' alt='procesando'>");
        $.ajax({
            type:"GET",
            data: "op=1",
            url: "acciones.jsp",
            async:true,
            success: function(respuesta){
                $("#divResEnt").html(respuesta);
            }
            
            
        });
    });
    $("#cmdCalcular").click(function(e){
        var edad=Number($('#txtEdad').attr("value"));
        if(edad>21 && edad <60)
            edad=1;
        else
            edad=0;
        var area=Number($('#cboArea option:selected').attr("value"))/8;
        var educacion=Number($('#cboEducacion option:selected').attr("value"))/16;
        var educacion_num=Number($('#txteducation-num').attr("value"))/16;
        var estadoCiv=Number($('#cboMarital-status option:selected').attr("value"))/7;
        var ocupacion=Number($('#cboOcupacion option:selected').attr("value"))/14;
        var rol=Number($('#cboRelationship option:selected').attr("value"))/6;
        var raza=Number($('#cboRaza option:selected').attr("value"))/5;
        var sexo=Number($('#cboSexo option:selected').attr("value"))/2;
        var capitalg=Number($('#txtcapital-gain').attr("value"));
        if(capitalg>7000)
            capitalg=1;
        else
            capitalg=capitalg/7000
        var capitalp=Number($('#txtcapital-loss').attr("value"))/1000000;
        var horasps=Number($('#hours-per-week').attr("value"))/100;
        var pais=Number($('#cboPais option:selected').attr("value"))/41;
        $.ajax({
            type:"GET",
            data: "op=2&edad="+edad+
                "&area="+area+
                "&educacion="+educacion+
                "&educacion_num="+educacion_num+
                "&estadoCiv="+estadoCiv+
                "&ocupacion="+ocupacion+
                "&rol="+rol+
                "&raza="+raza+
                "&sexo="+sexo+
                "&capitalg="+capitalg+
                "&capitalp="+capitalp+
                "&horasps="+horasps+
                "&pais="+pais,
            url: "acciones.jsp",
            async:true,
            success: function(respuesta){
                $("#divResEnt").html(respuesta);
            } 
        });
        
    });
})


