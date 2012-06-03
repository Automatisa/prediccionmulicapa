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
        if(serviciosDB.ejecutarConsulta("SELECT * FROM "+tabla+" WHERE oid<5000"))
            return true;
        return false;
    }
    public static int cuentaRegistros(String tabla)
    {
        int nr=0;
        try
        {
        String q;    
        q="SELECT COUNT(*) FROM "+tabla;
        serviciosDB.ejecutarConsulta(q);
        if (serviciosDB.resultado.first())
        nr = serviciosDB.resultado.getInt(1);
        } catch (SQLException e) {
            System.err.println("Error");
        }
        return nr;
    }
}
