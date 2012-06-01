<%-- 
    Document   : acciones
    Created on : 31/05/2012, 06:52:43 PM
    Author     : johnny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    
    int op=Integer.parseInt(request.getParameter("op"));
    if(op==1)
    {
        out.print("<h3>"+neurona.mlp.Entrenar()+"<h3>");
    }
    else if(op==2)
    { 
        double [] datos={Double.parseDouble(request.getParameter("edad")),
        Double.parseDouble(request.getParameter("area")),
        Double.parseDouble(request.getParameter("fnlwgt")),
        Double.parseDouble(request.getParameter("educacion")),
        Double.parseDouble(request.getParameter("educacion_num")),
        Double.parseDouble(request.getParameter("estadoCiv")),
        Double.parseDouble(request.getParameter("ocupacion")),
        Double.parseDouble(request.getParameter("rol")),
        Double.parseDouble(request.getParameter("raza")),
        Double.parseDouble(request.getParameter("sexo")),
        Double.parseDouble(request.getParameter("capitalg")),
        Double.parseDouble(request.getParameter("edad")),
        Double.parseDouble(request.getParameter("horasps")),
        Double.parseDouble(request.getParameter("pais"))
        };
        
        out.print(neurona.mlp.provar(datos));
    }
%>
