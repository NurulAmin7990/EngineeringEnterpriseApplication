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
public class FindUnregisteredModulesCommand implements FindUnregisteredModulesCommandLocal {

    //Enterprise Java Bean
    @EJB
    private ModuleHandlerLocal moduleHandler;

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
        return moduleHandler.findUnregisteredModules(id);
    }
}
