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
public class GetAllClassCommand implements GetAllClassCommandLocal {
    
    //Enterprise Java Bean
    @EJB
    private ClassHandlerLocal classHandler;
    
    @Override
    public Object execute(){
        return classHandler.getAllClass();
    }
}
