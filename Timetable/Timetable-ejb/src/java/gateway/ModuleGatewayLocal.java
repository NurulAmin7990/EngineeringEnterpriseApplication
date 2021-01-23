/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway;

import dto.ModuleDTO;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Nurul
 */
@Local
public interface ModuleGatewayLocal {

    boolean updateModule(int id, ModuleDTO moduleDTO);

    ArrayList<ModuleDTO> getAllModule();

    ArrayList<ModuleDTO> findUnregisteredModules(int id);

    ArrayList<ModuleDTO> findRegisteredModules(int id);

}
