/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dto.ClassDTO;
import gateway.ClassGatewayLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Nurul
 */
@Stateless
public class ClassHandler implements ClassHandlerLocal {

    //Enterpise Java Bean for gateway
    @EJB
    ClassGatewayLocal classGateway;

    //Methods
    @Override
    public void addClass(ClassDTO classDTO) {
        ClassDTO c = classGateway.findClass(classDTO.getId());
        if (c == null) {
            classGateway.createClass(classDTO);
        }
    }

    @Override
    public void deleteClass(int id) {
            classGateway.deleteClass(id);
    }

    @Override
    public void updateClass(int id, ClassDTO classDTO) {
            classGateway.updateClass(id, classDTO);
    }
    
    @Override
    public ClassDTO findClass(int id){
        return classGateway.findClass(id);
    }
    
    @Override
    public ArrayList<ClassDTO> getAllClass(){
        return classGateway.getAllClass();
    }
    
    @Override
    public ArrayList<ClassDTO> getAllClassById(int id){
        return classGateway.getAllClassById(id);
    }
}
