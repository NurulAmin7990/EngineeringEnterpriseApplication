/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author Nurul
 */
public class RoomDTO implements Serializable{
    
    //Attributes
    private int id;
    private final int roomNumber;
    private final int roomCapacity;
    private final String buildingName;
    private final String location;
    
    //Constructor
    public RoomDTO(int id, int roomNumber, int roomCapacity, String buildingName, String location) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
        this.buildingName = buildingName;
        this.location = location;
    }

    public RoomDTO(int roomNumber, int roomCapacity, String buildingName, String location) {
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
        this.buildingName = buildingName;
        this.location = location;
    }
    
    //Getters
    public int getId() {
        return id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public String getLocation() {
        return location;
    }
}
