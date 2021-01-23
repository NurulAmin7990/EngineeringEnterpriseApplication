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
public class ModuleDTO implements Serializable {

    //Attributes
    private int id;
    private final String name;
    private final int level;
    private final int semester;

    //Constructor
    public ModuleDTO(int id, String name, int level, int semester) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.semester = semester;
    }

    public ModuleDTO(String name, int level, int semester) {
        this.name = name;
        this.level = level;
        this.semester = semester;
    }

    //Overrides
    @Override
    public boolean equals(Object obj) {
        return obj != null
                && obj instanceof ModuleDTO
                && ((ModuleDTO) obj).getId() == this.id;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public String toString() {
        return id + ":" + name;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getSemester() {
        return semester;
    }
}
