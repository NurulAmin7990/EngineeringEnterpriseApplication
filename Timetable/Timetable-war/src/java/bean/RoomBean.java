/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dto.RoomDTO;
import ejb.Timetabler_UIRemote;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Nurul
 */
@Named(value = "roomBean")
@SessionScoped
public class RoomBean implements Serializable {

    //Enterpise Java Bean for Timetabler_UI
    @EJB
    Timetabler_UIRemote timetabler_UI;

    //Attributes
    private ArrayList<RoomDTO> rooms;
    private int id;
    private int roomNumber;
    private int roomCapacity;
    private String buildingName;
    private String location;

    //Constructor
    public RoomBean() {
    }

    //Getters and setters
    public ArrayList<RoomDTO> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<RoomDTO> rooms) {
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //Methods
    public ArrayList<RoomDTO> getAllRoom() {
        return timetabler_UI.getAllRoom();
    }

}
