/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dto.ClassDTO;
import ejb.Student_UIRemote;
import ejb.Timetabler_UIRemote;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Nurul
 */
@Named(value = "classBean")
@SessionScoped
public class ClassBean implements Serializable {

    //Enterpise Java Bean for Timetabler_UI
    @EJB
    Timetabler_UIRemote timetabler_UI;
    //Enterpise Java Bean for Student_UI
    @EJB
    Student_UIRemote student_UI;

    //Attributes
    private ClassDTO classDTO;
    private ArrayList<ClassDTO> classDTOs;
    private int id;
    private int roomId;
    private int moduleId;
    private Date date;
    private Date startTime;
    private Date endTime;

    //Constructor
    public ClassBean() {
    }

    //Getters and setters
    public ClassDTO getClassDTO() {
        return classDTO;
    }

    public void setClassDTO(ClassDTO classDTO) {
        this.classDTO = classDTO;
    }

    public ArrayList<ClassDTO> getClassDTOs() {
        return classDTOs;
    }

    public void setClassDTOs(ArrayList<ClassDTO> classDTOs) {
        this.classDTOs = classDTOs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    //Methods
    public String addClass() {
        timetabler_UI.addClass(new ClassDTO(roomId, moduleId, date, startTime, endTime));
        return "class_index";
    }

    public String setUpdateClass(ClassDTO classDTO) {
        this.classDTO = classDTO;
        setId(classDTO.getId());
        return "class_update";
    }

    public String updateClass() {
        timetabler_UI.updateClass(id, new ClassDTO(roomId, moduleId, date, startTime, endTime));
        classDTO = null;
        id = 0;
        return "class_index";
    }

    public String deleteClass(int id) {
        timetabler_UI.deleteClass(id);
        return "class_index";
    }

    public ArrayList<ClassDTO> getAllClass() {
        return timetabler_UI.getAllClass();
    }

    public ArrayList<ClassDTO> getTimetable(int id) {
        return student_UI.findTimetable(id);
    }
}
