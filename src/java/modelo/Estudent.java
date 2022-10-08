/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lglui
 */
public class Estudent extends Persona{
    private String key1;
    private int id_blood;
    
       Conexion cn;  //global-variable
       
    public Estudent() {
    }

    public Estudent(String key1, int id_blood, int id, String names1, String lastnames, String address, String phone, String dbo) {
        super(id, names1, lastnames, address, phone, dbo);
        this.key1 = key1;
        this.id_blood = id_blood;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public int getId_blood() {
        return id_blood;
    }

    public void setId_blood(int id_blood) {
        this.id_blood = id_blood;
    }
    
    //read data
      public DefaultTableModel read (){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            cn= new Conexion(); // esta variable es tambien minuscula porque de esa forma la declare
            cn.open_connection1();
           String query;
            query="SELECT e.id_student as id, e.key1, e.names1, e.lastnames, e.address, e.phone, b.blood ,e.id_blood, e.dbo FROM estudents as e inner join bloodt as b on e.id_blood = b.id_blood ;";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            // encabezado de la tabla
            
            String encabezado[]= {"id","key1","names1","lastnames","address","phone","blood","id_blood","dbo"};
            tabla.setColumnIdentifiers(encabezado);
            
            String datos [] = new String [9]; // se coloco 7 porque son las cantidad de datos que vamos a colocar en la tabla
            //recorer 
            while(consulta.next()){
            datos[0]= consulta.getString("id");
            datos[1]= consulta.getString("key1");
            datos[2]= consulta.getString("names1");
            datos[3]= consulta.getString("lastnames");
            datos[4]= consulta.getString("address");
            datos[5]= consulta.getString("phone");
            datos[6]= consulta.getString("blood");
            datos[7]= consulta.getString("id_blood");
            datos[8]= consulta.getString("dbo");

            tabla.addRow(datos);
            }
            cn.close_connection1();// siempre va despues del while
            
        }catch(SQLException ex){
            cn.close_connection1();
            System.out.println("Error: "+ ex.getMessage());
         
        }
        return tabla;
    }
    

    
    @Override
    public int create1(){
    int retorno = 0;
     try{
            PreparedStatement parametro;
            
            cn = new Conexion();
            cn.open_connection1();
            String query = "INSERT INTO estudents(key1,names1,lastnames,address,phone,id_blood,dbo) VALUES (?,?,?,?,?,?,?)";
            cn.open_connection1();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getKey1());
            parametro.setString(2,getNames1());
            parametro.setString(3,getLastnames());
            parametro.setString(4,getAddress());
            parametro.setString(5,getPhone());
            parametro.setInt(6, this.getId_blood());
            parametro.setString(7,getDbo());
            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_connection1();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
         
    return retorno;
    }
    
    @Override
     public int modify(){
         
         int retorno = 0;
     try{
            PreparedStatement parametro;
            
            cn = new Conexion();
            cn.open_connection1();
            String query = "update estudents set key1=?,names1=?,lastnames=?,address=?,phone=?,id_blood=?,dbo=? where id_student=?";
            cn.open_connection1();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getKey1());
            parametro.setString(2,getNames1());
            parametro.setString(3,getLastnames());
            parametro.setString(4,getAddress());
            parametro.setString(5,getPhone());
            parametro.setInt(6, this.getId_blood());
            parametro.setString(7,getDbo());
            parametro.setInt(8, this.getId());
            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_connection1();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
         return retorno;
     }
     
     
     
    @Override
    public int delete1(){
        
          
         int retorno = 0;
     try{
            PreparedStatement parametro;
            
            cn = new Conexion();
            cn.open_connection1();
            String query = "delete from estudents where id_student=?;";
            cn.open_connection1();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);

            parametro.setInt(1, this.getId());
            int executar = parametro.executeUpdate();
            retorno = executar;
            cn.close_connection1();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    
    }

}//llave final 
    
