/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import ejb.ModuleHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Nurul
 */
@Stateless
public class GetAllModuleCommand implements GetAllModuleCommandLocal {

    //Enterprise Java Bean
    @EJB
    private ModuleHandlerLocal moduleHandler;

    @Override
    public Object execute() {
        return moduleHandler.getAllModule();
    }
}
