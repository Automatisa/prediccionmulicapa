/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Johnny
 */
public class serviciosDB {
public static  String url =""; //atributos para hacerlo generico
private static Statement stm;
public static ResultSet resultado;
static String query ="";
    public static boolean conectar(String bd,String login,String password) {
        Connection conn = null;
        url ="jdbc:mysql://localhost:3306/"+bd;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection(url, login, password); // el driver
            if (conn != null)
            {
                //System.out.println("Conexión a base de datos "+url+" ... Ok"); //dice si se inicio bien
                stm = conn.createStatement(); // la base de datos con la q va a usarse
                return true;
            }
        }
        catch(SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos "+url); //si da error
        }
        catch(ClassNotFoundException ex) {
            System.out.println("mal "+ex);
        }
        return false;
    }
public static boolean ejecutarConsulta(String q)
    {
        query=q;
        try {
            resultado=stm.executeQuery(query);
            return true;
            } catch (SQLException e) {
            System.err.println("No se realizo la consulta");
            e.printStackTrace();
            return false;
        }
    }    
    public static boolean ejecutarUpdate(String q)
    {
        query=q;
        try {
                stm.executeUpdate(query);
                return true;
            } catch (SQLException e) {
            System.err.println("No se realizo la consulta");
            e.printStackTrace();
            return false;
        }
    }
}
