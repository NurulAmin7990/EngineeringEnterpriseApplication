/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import ejb.StudentHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Nurul
 */
@Stateless
public class GetAllStudentCommand implements GetAllStudentCommandLocal {

    //Enterprise Java Bean
    @EJB
    private StudentHandlerLocal studentHandler;

    @Override
    public Object execute() {
        return studentHandler.getAllStudent();
    }
}
