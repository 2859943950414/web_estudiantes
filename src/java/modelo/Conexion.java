/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lglui
 */
public class Conexion {
    public Connection conexionBD;
    private final String puerto = "3306";
    private final String bd= "db_school";
    private final String urlConexion= String.format("jdbc:mysql://localhost:%s/%s?serverTimezone=UTC",puerto,bd);
    private final String usuario = "usr_school";
    private final String contra = "school@my123";
    private final String jdbc = "com.mysql.cj.jdbc.Driver";
    
    public void open_connection1(){
        
        try{
            Class.forName(jdbc);
            conexionBD=DriverManager.getConnection(urlConexion,usuario,contra);
            //JOptionPane.showMessageDialog(null, "Conexion Exitosa...","Exito",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error..."+ ex.getMessage());
            
        }
    }
    
     public void close_connection1(){
        
        try{
            Class.forName(jdbc);
            conexionBD.close();
           
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error..."+ ex.getMessage());
            
        }
    }
       
}


