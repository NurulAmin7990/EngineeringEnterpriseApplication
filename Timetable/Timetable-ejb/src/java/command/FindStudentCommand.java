/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import ejb.ClassHandlerLocal;
import ejb.StudentHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Nurul
 */
@Stateless
public class FindStudentCommand implements FindStudentCommandLocal {

    //Enterprise Java Bean
    @EJB
    private StudentHandlerLocal studentHandler;

    //Attributes
    private int id;

    //Setter
    @Override
    public void setId(int id) {
        this.id = id;
    }

    //Methods
    @Override
    public Object execute() {
        return studentHandler.findStudent(id);
    }
}
