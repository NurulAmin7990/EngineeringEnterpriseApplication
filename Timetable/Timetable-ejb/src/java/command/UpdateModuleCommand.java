/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import dto.ModuleDTO;
import ejb.ModuleHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Nurul
 */
@Stateful
public class UpdateModuleCommand implements UpdateModuleCommandLocal {

    //Enterprise Java Bean
    @EJB
    private ModuleHandlerLocal moduleHandler;

    //Attribute
    private int id;
    private ModuleDTO moduleDTO;
    
    //Setter
    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setModuleDTO(ModuleDTO moduleDTO) {
        this.moduleDTO = moduleDTO;
    }
    
    //Method
    @Override
        public Object execute() {
        moduleHandler.updateModule(id, moduleDTO);
        return null;
    }
    
}
