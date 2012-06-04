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
        <script type="text/javascript" languaje="javascript" src="jquery-1.7.js"></script>
        <script type="text/javascript" languaje="javascript" src="eventos.js"></script>
        <link type="text/css" rel="stylesheet" href="style.css">
    </head>
    <body>
        <div id="divCabForm">
            INGRESE LOS DATOS PARA VERIFICAR EL SUELDO ANUAL
        </div>
        <div id="divFormulario">
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
                                <option value="5">Private</option>
                                <option value="3">Self-emp-not-inc</option>
                                <option value="4">Self-emp-inc</option>
                                <option value="8">Federal-gov</option>
                                <option value="6">Local-gov</option>
                                <option value="7">State-gov</option>
                                <option value="2">Without-pay</option>
                                <option value="1">Never-worked</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Educaci&oacute;n: </label>
                        </td>
                        <td>
                            <select name="cboEducacion" id="cboEducacion">
                                <option value="11">Bachelors</option>
                                <option value="10">Some-college</option>
                                <option value="9">11th</option>
                                <option value="9">HS-grad</option>
                                <option value="13">Assoc-acdm</option>
                                <option value="12">Assoc-voc</option>
                                <option value="15">Prof-school</option>
                                <option value="5">9th</option>
                                <option value="4">7th-8th</option>
                                <option value="8">12th</option>
                                <option value="14">Masters</option>
                                <option value="2">1st-4th</option>
                                <option value="6">10th</option>
                                <option value="16">Doctorate</option>
                                <option value="3">5th-6th</option>
                                <option value="1">Preschool</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>education-num: </label>
                        </td>
                        <td>
                            <input type="text" name="education-num" id="txteducation-num"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>marital-status: </label>
                        </td>
                        <td>
                            <select name="cboMarital-status" id="cboMarital-status">
                                <option value="7">Married-civ-spouse</option>
                                <option value="3">Divorced</option>
                                <option value="4">Never-married</option>
                                <option value="1">Separated</option>
                                <option value="2">Widowed</option>
                                <option value="6">Married-spouse-absent</option>
                                <option value="5">Married-AF-spouse</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Ocupacion: </label>
                        </td>
                        <td>
                            <select name="cboOcupacion" id="cboOcupacion">
                                <option value="1">Tech-support</option>
                                <option value="2">Craft-repair</option>
                                <option value="3">Other-service</option>
                                <option value="4">Sales</option>
                                <option value="5">Exec-managerial</option>
                                <option value="6">Prof-specialty</option>
                                <option value="7">Handlers-cleaners</option>
                                <option value="8">Machine-op-inspct</option>
                                <option value="9">Adm-clerical</option>
                                <option value="10">Farming-fishing</option>
                                <option value="11">Transport-moving</option>
                                <option value="12">Priv-house-serv</option>
                                <option value="13">Protective-serv</option>
                                <option value="14">Armed-Forces</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Relationship: </label>
                        </td>
                        <td>
                            <select name="cboRelationship" id="cboRelationship">
                                <option value="5">Wife</option>
                                <option value="2">Own-child</option>
                                <option value="6">Husband</option>
                                <option value="4">Not-in-family</option>
                                <option value="3">Other-relative</option>
                                <option value="1">Unmarried</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Raza: </label>
                        </td>
                        <td>
                            <select name="cboRaza" id="cboRaza">
                                <option value="5">White</option>
                                <option value="3">Asian-Pac-Islander</option>
                                <option value="2">Amer-Indian-Eskimo</option>
                                <option value="1">Other</option>
                                <option value="4">Black</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Sexo: </label>
                        </td>
                        <td>
                            <select name="cboSexo" id="cboSexo">
                                <option value="1">Female</option>
                                <option value="2">Male</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Capital-gain: </label>
                        </td>
                        <td>
                            <input type="text" name="capital-gain" id="txtcapital-gain"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Capital-loss: </label>
                        </td>
                        <td>
                            <input type="text" name="capital-loss" id="txtcapital-loss"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Horas por semana: </label>
                        </td>
                        <td>
                            <input type="text" name="hours-per-week" id="hours-per-week"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Pais: </label>
                        </td>
                        <td>
                            <select name="cboPais" id="cboPais">
                                <option value="41">United-States</option>
                                <option value="11">Cambodia</option>
                                <option value="31">England</option>
                                <option value="11">Puerto-Rico</option>
                                <option value="31">Canada</option>
                                <option value="31">Germany</option>
                                <option value="11">Outlying-US(Guam-USVI-etc)</option>
                                <option value="1">India</option>
                                <option value="31">Japan</option>
                                <option value="31">Greece</option>
                                <option value="11">South</option>
                                <option value="21">China</option>
                                <option value="1">Cuba</option>
                                <option value="1">Iran</option>
                                <option value="1">Honduras</option>
                                <option value="1">Philippines</option>
                                <option value="31">Italy</option>
                                <option value="31">Poland</option>
                                <option value="11">Jamaica</option>
                                <option value="1">Vietnam</option>
                                <option value="21">Mexico</option>
                                <option value="31">Portugal</option>
                                <option value="31">Ireland</option>
                                <option value="31">France</option>
                                <option value="1">Dominican-Republic</option>
                                <option value="21">Laos</option>
                                <option value="31">Ecuador</option>
                                <option value="1">Taiwan</option>
                                <option value="1">Haiti</option>
                                <option value="21">Columbia</option>
                                <option value="31">Hungary</option>
                                <option value="1">Guatemala</option>
                                <option value="11">Nicaragua</option>
                                <option value="31">Scotland</option>
                                <option value="1">Thailand</option>
                                <option value="31">Yugoslavia</option>
                                <option value="1">El-Salvador</option>
                                <option value="1">Trinadad&Tobago</option>
                                <option value="21">Peru</option>
                                <option value="1">Hong</option>    
                                <option value="31">Holand-Netherlands</option> 
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <input type="button" name="entrenar" id="cmdEntrenar" value="ENTRENAR"/>
                        </td>
                        <td>
                            <input type="button" name="calcular" id="cmdCalcular" value="CALCULAR"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="divResEnt">
           
        </div>
        <div id="divFooter">
           Johnny Avila - Sebastian Roman | Universidad de Cuenca 
        </div>
    </body>
</html>
