package beans;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 16476
 */
public class Player{
    
    private int ID = -1;
    private String name = null;
    private String address = null;
    private int teamID = -1;
    private String role = null;
    private String active = null;

    public void setActive(String active) {
        this.active = active;
    }

    public String getActive() {
        return active;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getTeamID() {
        return teamID;
    }

    public String getRole() {
        return role;
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    
    
}
