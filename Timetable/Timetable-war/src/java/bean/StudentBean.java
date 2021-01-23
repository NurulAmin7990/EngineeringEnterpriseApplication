/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dto.ModuleDTO;
import dto.StudentDTO;
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
@Named(value = "studentBean")
@SessionScoped
public class StudentBean implements Serializable {

    //Enterpise Java Bean for Timetabler_UI
    @EJB
    Timetabler_UIRemote timetabler_UI;
    //Enterpise Java Bean for Timetabler_UI
    @EJB
    Student_UIRemote student_UI;

    //Attributes
    private StudentDTO student;
    private ArrayList<ModuleDTO> modules;
    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;

    //Constructor
    public StudentBean() {

    }

    //Getters and setters
    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setModules(ArrayList<ModuleDTO> modules) {
        this.modules = modules;
    }

    public ArrayList<ModuleDTO> getModules() {
        return modules;
    }

    public String setRegisterStudentOnModules(int id) {
        this.id = id;
        return "student_register";
    }

    //Methods
    public String registerStudentOnModules() {
        timetabler_UI.registerStudentOnModules(id, modules);
        id = 0;
        modules = null;
        return "student_index";
    }

    public String setUnregisterStudentOnModules(int id) {
        this.id = id;
        return "student_unregister";
    }

    //Methods
    public String unregisterStudentOnModules() {
        timetabler_UI.unregisterStudentOnModules(id, modules);
        id = 0;
        modules = null;
        return "student_index";
    }

    public ArrayList<StudentDTO> getAllStudents() {
        return timetabler_UI.getAllStudents();
    }

    public ArrayList<ModuleDTO> findUnregisteredModules() {
        return timetabler_UI.findUnregisteredModules(id);
    }

    public ArrayList<ModuleDTO> findRegisteredModules() {
        return timetabler_UI.findRegisteredModules(id);
    }

    public StudentDTO viewStudent(int id) {
        return student_UI.viewStudent(id);
    }
    
    public String studentDashboard(){
        return "student_index";
    }

    public String logout() {
        this.id = 0;
        return "student_login";
    }
}
