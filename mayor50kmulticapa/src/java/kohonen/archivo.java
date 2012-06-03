package kohonen;

import java.io.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import laBase.ConexionBD;

public class archivo { 
    
    java.sql.ResultSet rs;
    laBase.ConexionBD con = new ConexionBD(); 
    
    
    public void main(String[] args) throws IOException  { 
        
            con.crearConexion("", "");
            
            JFileChooser selectorArchivo = new JFileChooser();
	    selectorArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );             
            selectorArchivo.setCurrentDirectory(new File("C:/"));
            int resultado = selectorArchivo.showOpenDialog(null);
            if ( resultado == JFileChooser.CANCEL_OPTION )
             return;
            File nombreArchivoNuevo = selectorArchivo.getSelectedFile();
            if (!nombreArchivoNuevo.getPath().endsWith(".data")) 
              JOptionPane.showMessageDialog(null, "Solo Archivos DATA", "Nombre de archivo incorrecto", JOptionPane.ERROR_MESSAGE);
            else if(nombreArchivoNuevo == null || nombreArchivoNuevo.getName().equals(""))
                JOptionPane.showMessageDialog( null, "Nombre de archivo incorrecto","Nombre de archivo incorrecto", JOptionPane.ERROR_MESSAGE );
            else{   
                String elemento="";
                String elemento_a="";
                try {
                    FileReader fr = new FileReader (nombreArchivoNuevo);
                    LinkedList<String> aux=obtener_lineas(fr);                    
                    while(!aux.isEmpty())
                    {
                        elemento=aux.pop();
                        for (int cont=0;cont<=15;cont++)
                        {
                            elemento=elemento.substring(0, elemento.indexOf(", ")+1);
                            
                        }
                    }
                }catch (Exception ex) {
                    Logger.getLogger(archivo.class.getName()).log(Level.SEVERE, null, ex);
                }
          }	           
    }
    
    public static LinkedList<String> obtener_lineas(FileReader archivo)
    {
        LinkedList<String> retorno=new LinkedList<String>();
        BufferedReader br = new BufferedReader(archivo);
        String linea;
        try {
            while((linea=br.readLine())!=null)
                retorno.add(linea);
        } catch (IOException ex) {
            Logger.getLogger(archivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return retorno;
    }   
}
