<%-- 
    Document   : index
    Created on : 31/05/2012, 04:49:46 PM
    Author     : johnny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Predecir Sueldo</title>
    </head>
    <body>
        <div>
            <form name="datos" id="datos">
                <table>
                    <tr>
                        <td style="width: 150px">
                            <label>Nombre Completo: </label>
                        </td>
                        <td>
                            <input type="text" name="txtNombre" id="txtNombre"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Edad: </label>
                        </td>
                        <td>
                            <input type="text" name="txtEdad" id="txtEdad"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Area de Trabajo: </label>
                        </td>
                        <td>
                            <select name="cboArea" id="cboArea">
                                <option value="1/8">Private</option>
                                <option value="2/8">Self-emp-not-inc</option>
                                <option value="3/8">Self-emp-inc</option>
                                <option value="4/8">Federal-gov</option>
                                <option value="5/8">Local-gov</option>
                                <option value="6/8">State-gov</option>
                                <option value="7/8">Without-pay</option>
                                <option value="8/8">Never-worked</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Fnlwgt: </label>
                        </td>
                        <td>
                            <input type="text" name="txtFnlwgt" id="txtFnlwgt"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Educaci&oacute;n: </label>
                        </td>
                        <td>
                            <select name="cboEducacion" id="cboEducacion"></select>
                        </td>
                    </tr>
                    
                </table>
            </form>
        </div>
    </body>
</html>
