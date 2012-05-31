/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.StringTokenizer;
/**
 *
 * @author Toshiba
 */
public class Transacciones {
    public static boolean cargarDatos(String tabla)
    {
        
        if(serviciosDB.ejecutarConsulta("SELECT * FROM "+tabla))
            return true;
        return false;
    }
   
    
}
