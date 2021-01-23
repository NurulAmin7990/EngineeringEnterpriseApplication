/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dto.ModuleDTO;
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
@Named(value = "moduleBean")
@SessionScoped
public class ModuleBean implements Serializable {

    //Enterpise Java Bean for Timetabler_UI
    @EJB
    Timetabler_UIRemote timetabler_UI;

    //Attributes
    private ModuleDTO moduleDTO;
    private ArrayList<ModuleDTO> modules;
    private int id;
    private String name;
    private int level;
    private int semester;

    //Constructor
    public ModuleBean() {

    }

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public ModuleDTO getModuleDTO() {
        return moduleDTO;
    }

    //Methods
    public String setUpdateModule(ModuleDTO moduleDTO) {
        this.moduleDTO = moduleDTO;
        setId(moduleDTO.getId());
        return "module_update";
    }

    public String updateModule() {
        timetabler_UI.updateModule(id, new ModuleDTO(name, level, semester));
        moduleDTO = null;
        id = 0;
        name = null;
        level = 0;
        semester = 0;
        return "module_index";
    }

    public ArrayList<ModuleDTO> getAllModule() {
        return timetabler_UI.getAllModule();
    }
}
