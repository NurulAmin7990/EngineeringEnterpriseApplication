/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dto.ModuleDTO;
import gateway.ModuleGatewayLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Nurul
 */
@Stateless
public class ModuleHandler implements ModuleHandlerLocal {

    //Enterpise Java Bean for gateway
    @EJB
    ModuleGatewayLocal moduleGateway;

    //Methods
    @Override
    public void updateModule(int id, ModuleDTO moduleDTO) {
        moduleGateway.updateModule(id, moduleDTO);
    }

    @Override
    public ArrayList<ModuleDTO> getAllModule() {
        return moduleGateway.getAllModule();
    }

    @Override
    public ArrayList<ModuleDTO> findUnregisteredModules(int id) {
        return moduleGateway.findUnregisteredModules(id);
    }

    @Override
    public ArrayList<ModuleDTO> findRegisteredModules(int id) {
        return moduleGateway.findRegisteredModules(id);
    }
}
