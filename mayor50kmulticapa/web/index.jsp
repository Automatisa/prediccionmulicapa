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
                                <option value="1">Private</option>
                                <option value="2">Self-emp-not-inc</option>
                                <option value="3">Self-emp-inc</option>
                                <option value="4">Federal-gov</option>
                                <option value="5">Local-gov</option>
                                <option value="6">State-gov</option>
                                <option value="7">Without-pay</option>
                                <option value="8">Never-worked</option>
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
                            <select name="cboEducacion" id="cboEducacion">
                                <option value="1">Bachelors</option>
                                <option value="2">Some-college</option>
                                <option value="3">11th</option>
                                <option value="4">HS-grad</option>
                                <option value="5">Assoc-acdm</option>
                                <option value="6">Assoc-voc</option>
                                <option value="7">9th</option>
                                <option value="8">7th-8th</option>
                                <option value="9">12th</option>
                                <option value="10">Masters</option>
                                <option value="11">1st-4th</option>
                                <option value="12">10th</option>
                                <option value="13">Doctorate</option>
                                <option value="14">5th-6th</option>
                                <option value="15">Preschool</option>
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
                                <option value="1">Married-civ-spouse</option>
                                <option value="2">Divorced</option>
                                <option value="3">Never-married</option>
                                <option value="4">Separated</option>
                                <option value="5">Widowed</option>
                                <option value="6">Married-spouse-absent</option>
                                <option value="7">Married-AF-spouse</option>
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
                                <option value="1">Wife</option>
                                <option value="2">Own-child</option>
                                <option value="3">Husband</option>
                                <option value="4">Not-in-family</option>
                                <option value="5">Other-relative</option>
                                <option value="6">Unmarried</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Raza: </label>
                        </td>
                        <td>
                            <select name="cboRaza" id="cboRaza">
                                <option value="1">White</option>
                                <option value="2">Asian-Pac-Islander</option>
                                <option value="3">Amer-Indian-Eskimo</option>
                                <option value="4">Other</option>
                                <option value="5">Black</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Sexo: </label>
                        </td>
                        <td>
                            <select name="cboSexo" id="cboSexo">
                                <option value="2">Female</option>
                                <option value="1">Male</option>
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
                                <option value="1">United-States</option>
                                <option value="2">Cambodia</option>
                                <option value="3">England</option>
                                <option value="4">Puerto-Rico</option>
                                <option value="5">Canada</option>
                                <option value="6">Germany</option>
                                <option value="7">Outlying-US(Guam-USVI-etc)</option>
                                <option value="8">India</option>
                                <option value="9">Japan</option>
                                <option value="10">Greece</option>
                                <option value="11">South</option>
                                <option value="12">China</option>
                                <option value="13">Cuba</option>
                                <option value="14">Iran</option>
                                <option value="15">Honduras</option>
                                <option value="16">Philippines</option>
                                <option value="17">Italy</option>
                                <option value="18">Poland</option>
                                <option value="19">Jamaica</option>
                                <option value="20">Vietnam</option>
                                <option value="21">Mexico</option>
                                <option value="22">Portugal</option>
                                <option value="23">Ireland</option>
                                <option value="24">France</option>
                                <option value="25">Dominican-Republic</option>
                                <option value="26">Laos</option>
                                <option value="27">Ecuador</option>
                                <option value="28">Taiwan</option>
                                <option value="29">Haiti</option>
                                <option value="30">Columbia</option>
                                <option value="31">Hungary</option>
                                <option value="32">Guatemala</option>
                                <option value="33">Nicaragua</option>
                                <option value="34">Scotland</option>
                                <option value="35">Thailand</option>
                                <option value="36">Yugoslavia</option>
                                <option value="37">El-Salvador</option>
                                <option value="38">Trinadad&Tobago</option>
                                <option value="39">Peru</option>
                                <option value="40">Hong</option>    
                                <option value="41">Holand-Netherlands</option> 
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
