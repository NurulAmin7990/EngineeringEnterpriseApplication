/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Nurul
 */
public class ClassDTO implements Serializable {

    //Attributes
    private int id;
    private final int roomId;
    private final int moduleId;
    private final Date date;
    private final Date startTime;
    private final Date endTime;

    //Constructors
    public ClassDTO(int id, int roomId, int moduleId, Date date, Date startTime, Date endTime) {
        this.id = id;
        this.roomId = roomId;
        this.moduleId = moduleId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ClassDTO(int roomId, int moduleId, Date date, Date startTime, Date endTime) {
        this.roomId = roomId;
        this.moduleId = moduleId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //Getters
    public int getId() {
        return id;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public Date getDate() {
        return date;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "ClassDTO{" + "id=" + id + ", roomId=" + roomId + ", moduleId=" + moduleId + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime + '}';
    }

}
