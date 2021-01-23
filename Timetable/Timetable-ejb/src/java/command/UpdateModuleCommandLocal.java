/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import dto.ModuleDTO;
import javax.ejb.Local;

/**
 *
 * @author Nurul
 */
@Local
public interface UpdateModuleCommandLocal extends Command{

    public void setId(int id);

    public void setModuleDTO(ModuleDTO moduleDTO);
    
    Object execute();
}
