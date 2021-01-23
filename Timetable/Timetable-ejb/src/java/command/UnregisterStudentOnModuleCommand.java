/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import dto.ModuleDTO;
import gateway.StudentGatewayLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Nurul
 */
@Stateless
public class UnregisterStudentOnModuleCommand implements UnregisterStudentOnModuleCommandLocal {

    //Enterprise Java Bean
    @EJB
    private StudentGatewayLocal studentHandler;

    //Attribute
    private int id;
    private ArrayList<ModuleDTO> modules;

    //Setter
    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setModules(ArrayList<ModuleDTO> modules) {
        this.modules = modules;
    }

    //Method
    @Override
    public Object execute() {
        studentHandler.unregisterStudentOnModule(id, modules);
        return null;
    }
}
