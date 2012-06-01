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
        neurona.mlp objneu = new neurona.mlp();
        out.print("<h2>"+objneu.Entrenar()+"<h2>");
    }
    else if(op==2)
    {
        
    }
%>
