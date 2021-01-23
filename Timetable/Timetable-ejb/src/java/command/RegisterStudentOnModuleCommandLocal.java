/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import dto.ModuleDTO;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Nurul
 */
@Local
public interface RegisterStudentOnModuleCommandLocal extends Command{

    void setId(int id);

    void setModules(ArrayList<ModuleDTO> modules);

    @Override
    Object execute();

}
