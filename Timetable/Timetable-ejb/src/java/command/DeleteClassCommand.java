/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import ejb.ClassHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Nurul
 */
@Stateless
public class DeleteClassCommand implements DeleteClassCommandLocal {

    //Enterprise Java Bean
    @EJB
    private ClassHandlerLocal classHandler;

    //Attribute
    private int id;

    //Setter
    @Override
    public void setId(int id) {
        this.id = id;
    }

    //Method
    @Override
    public Object execute() {
        classHandler.deleteClass(id);
        return null;
    }
}
