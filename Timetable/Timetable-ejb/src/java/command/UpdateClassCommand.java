/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import dto.ClassDTO;
import ejb.ClassHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Nurul
 */
@Stateful
public class UpdateClassCommand implements UpdateClassCommandLocal {

    //Enterprise Java Bean
    @EJB
    private ClassHandlerLocal classHandler;

    //Attribute
    private int id;
    private ClassDTO classDTO;

    //Setter
    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setClassDTO(ClassDTO classDTO) {
        this.classDTO = classDTO;
    }

    //Method
    @Override
    public Object execute() {
        classHandler.updateClass(id, classDTO);
        return null;
    }
}
