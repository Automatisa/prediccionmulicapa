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
                            <select name="cboEducacion" id="cboEducacion">
                                <option value="1/15">Bachelors</option>
                                <option value="2/15">Some-college</option>
                                <option value="3/15">11th</option>
                                <option value="4/15">HS-grad</option>
                                <option value="5/15">Prof-school</option>
                                <option value="6/15">Assoc-acdm</option>
                                <option value="7/15">Assoc-voc</option>
                                <option value="8/15">9th</option>
                                <option value="9/15">7th-8th</option>
                                <option value="10/15">12th</option>
                                <option value="11/15">Masters</option>
                                <option value="12/15">1st-4th</option>
                                <option value="13/15">10th</option>
                                <option value="14/15">Doctorate</option>
                                <option value="15/15">5th-6th</option>
                                <option value="15/15">Preschool</option>
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
                                <option value="1/7">Married-civ-spouse</option>
                                <option value="2/7">Divorced</option>
                                <option value="3/7">Never-married</option>
                                <option value="4/7">Separated</option>
                                <option value="5/7">Widowed</option>
                                <option value="6/7">Married-spouse-absent</option>
                                <option value="7/7">Married-AF-spouse</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Ocupacion: </label>
                        </td>
                        <td>
                            <select name="cboOcupacion" id="cboOcupacion">
                                <option value="1/14">Tech-support</option>
                                <option value="2/14">Craft-repair</option>
                                <option value="3/14">Other-service</option>
                                <option value="4/14">Sales</option>
                                <option value="5/14">Exec-managerial</option>
                                <option value="6/14">Prof-specialty</option>
                                <option value="7/14">Handlers-cleaners</option>
                                <option value="8/14">Machine-op-inspct</option>
                                <option value="9/14">Adm-clerical</option>
                                <option value="10/14">Farming-fishing</option>
                                <option value="11/14">Transport-moving</option>
                                <option value="12/14">Priv-house-serv</option>
                                <option value="13/14">Protective-serv</option>
                                <option value="14/14">Armed-Forces</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Relationship: </label>
                        </td>
                        <td>
                            <select name="cboRelationship" id="cboRelationship">
                                <option value="1/6">Wife</option>
                                <option value="2/6">Own-child</option>
                                <option value="3/6">Husband</option>
                                <option value="4/6">Not-in-family</option>
                                <option value="5/6">Other-relative</option>
                                <option value="6/6">Unmarried</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Raza: </label>
                        </td>
                        <td>
                            <select name="cboRaza" id="cboRaza">
                                <option value="1/5">White</option>
                                <option value="2/5">Asian-Pac-Islander</option>
                                <option value="3/5">Amer-Indian-Eskimo</option>
                                <option value="4/5">Other</option>
                                <option value="5/5">Black</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 150px">
                            <label>Sexo: </label>
                        </td>
                        <td>
                            <select name="cboSexo" id="cboSexo">
                                <option value="2/2">Female</option>
                                <option value="1/2">Male</option>
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
                                <option value="1/41">United-States</option>
                                <option value="2/41">Cambodia</option>
                                <option value="3/41">England</option>
                                <option value="4/41">Puerto-Rico</option>
                                <option value="5/41">Canada</option>
                                <option value="6/41">Germany</option>
                                <option value="7/41">Outlying-US(Guam-USVI-etc)</option>
                                <option value="8/41">India</option>
                                <option value="9/41">Japan</option>
                                <option value="10/41">Greece</option>
                                <option value="11/41">South</option>
                                <option value="12/41">China</option>
                                <option value="13/41">Cuba</option>
                                <option value="14/41">Iran</option>
                                <option value="15/41">Honduras</option>
                                <option value="16/41">Philippines</option>
                                <option value="17/41">Italy</option>
                                <option value="18/41">Poland</option>
                                <option value="19/41">Jamaica</option>
                                <option value="20/41">Vietnam</option>
                                <option value="21/41">Mexico</option>
                                <option value="22/41">Portugal</option>
                                <option value="23/41">Ireland</option>
                                <option value="24/41">France</option>
                                <option value="25/41">Dominican-Republic</option>
                                <option value="26/41">Laos</option>
                                <option value="27/41">Ecuador</option>
                                <option value="28/41">Taiwan</option>
                                <option value="29/41">Haiti</option>
                                <option value="30/41">Columbia</option>
                                <option value="31/41">Hungary</option>
                                <option value="32/41">Guatemala</option>
                                <option value="33/41">Nicaragua</option>
                                <option value="34/41">Scotland</option>
                                <option value="35/41">Thailand</option>
                                <option value="36/41">Yugoslavia</option>
                                <option value="37/41">El-Salvador</option>
                                <option value="38/41">Trinadad&Tobago</option>
                                <option value="39/41">Peru</option>
                                <option value="40/41">Hong</option>    
                                <option value="41/41">Holand-Netherlands</option> 
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
    </body>
</html>
