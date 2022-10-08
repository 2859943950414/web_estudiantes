/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author lglui
 */
//this class always goes with abstract //  get and set we always have to encapsulate them
abstract class Persona {
    private int id;
    private String names1, lastnames, address, phone, dbo;
    
    public Persona(){} 
    public Persona(int id, String names1, String lastnames, String address, String phone, String dbo) {
        this.id = id;
        this.names1 = names1;
        this.lastnames = lastnames;
        this.address = address;
        this.phone = phone;
        this.dbo = dbo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames1() {
        return names1;
    }

    public void setNames1(String names1) {
        this.names1 = names1;
    }

    public String getLastnames() {
        return lastnames;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDbo() {
        return dbo;
    }

    public void setDbo(String dbo) {
        this.dbo = dbo;
    }
    
    public int create1(){return 0;}
    public int modify(){return 0;}
    public int delete1(){return 0;}


}
