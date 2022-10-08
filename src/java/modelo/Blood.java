/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author lglui
 */
public class Blood {
    private int id_blood;
    private String blood;

    Conexion cn; // This variable helps to connet the bd 
    
    public Blood(){}
    public Blood(int id_blood, String blood) {
        this.id_blood = id_blood;
        this.blood = blood;
    }

    public int getId_blood() {
        return id_blood;
    }

    public void setId_blood(int id_blood) {
        this.id_blood = id_blood;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
    
    //this gives error so we have to use HashMap and return drop
    public HashMap drop_sangre(){
    HashMap<String,String>drop  = new HashMap();
    
    try{
     String query="SELECT id_blood as id,blood FROM bloodt";
     cn = new Conexion();
     cn.open_connection1();
     
     ResultSet consult = cn.conexionBD.createStatement().executeQuery(query);
     
      while(consult.next()){
     drop.put(consult.getString("id"),consult.getString("blood"));
     }
     
     cn.close_connection1();
   
    }catch(SQLException ex){
        System.out.print(ex.getMessage());
      
    }
    return drop;
    }
    
}
