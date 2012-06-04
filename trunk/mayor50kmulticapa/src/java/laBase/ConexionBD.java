/*    */ package laBase;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Statement;
         import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*    */ //import oracle.jdbc.driver.OracleDriver;
/*    */ 
/*    */ public class ConexionBD
/*    */ {
/*    */   private Statement cadSQL;
/*    */   public Connection conexion;
/*    */   private ResultSet rec;
/*    */   
            public void ConexionBD() throws IOException{

            }
/*    */   public void crearConexion(String paramString1, String paramString2) throws IOException
/*    */    {

/* 16 */     //DriverManager.registerDriver(new OracleDriver());
/*    */ 
/* 18 */     //this.conexion = DriverManager.getConnection("jdbc:oracle:thin:@fenix:1521:promas", paramString1, paramString2);
/*    */ 
/* 21 */     //this.cadSQL = this.conexion.createStatement(1004, 1008);
            try {
                Class.forName("com.mysql.jdbc.Driver"); //load the driver
            }
            catch (ClassNotFoundException e) {
                System.out.println("ClassNotFoundException: " + e.getMessage());
            }
            try {

                this.conexion= DriverManager.getConnection("jdbc:mysql://127.0.0.1/persona","root","jony1989");
                //this.conexion= DriverManager.getConnection("jdbc:postgresql://localhost:5432/biblioteca",paramString1,paramString2); //connect to the db
//connect to the db

                this.cadSQL = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            } catch (SQLException se) {

                while ( se != null) {
                    System.out.println("SQLState: "+ se.getSQLState());
                    System.out.println("Mensaje: "+ se.getMessage());
                    System.out.println("Codigo: "+ se.getErrorCode());
                    se = se.getNextException();
                    System.out.println("");
                }
            }

/*    */   }


/*    */ 
/*    */   public ResultSet ejecutaSQL(String paramString) throws SQLException, IOException
/*    */   {
             try {
                 crearConexion("", "");
/* 26 */     this.rec = this.cadSQL.executeQuery(paramString);
/* 27 */     return this.rec;
             } catch (SQLException e) {
                 return null;
             }

/*    */   }
/*    */ 
/*    */   public int ejecutaUpdate(String paramString)  {
            try {
                return this.cadSQL.executeUpdate(paramString);
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                return -1;
            }
           }
/*    */ 
/*    */   public void cerrarConexion()
/*    */     throws SQLException
/*    */   {
/* 37 */     this.rec.close();
/* 38 */     this.cadSQL.close();
/* 39 */     this.conexion.close();
/*    */   }

/*    */ }

/* Location:           D:\software promas\edahmi\decompilado\Prototipos\WEB-INF\classes\
 * Qualified Name:     laBase.ConexionBD
 * JD-Core Version:    0.5.4
 */