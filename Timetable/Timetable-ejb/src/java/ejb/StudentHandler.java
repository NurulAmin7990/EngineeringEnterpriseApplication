/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dto.ModuleDTO;
import dto.StudentDTO;
import gateway.StudentGatewayLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Nurul
 */
@Stateless
public class StudentHandler implements StudentHandlerLocal {

    //Enterpise Java Bean for gateway
    @EJB
    StudentGatewayLocal studentGateway;

    @Override
    public StudentDTO findStudent(int id) {
        return studentGateway.getStudent(id);
    }

    @Override
    public void registerStudentOnModule(int id, ArrayList<ModuleDTO> modules) {
        studentGateway.registerStudentOnModule(id, modules);
    }

    @Override
    public void unregisterStudentOnModule(int id, ArrayList<ModuleDTO> modules) {
        studentGateway.unregisterStudentOnModule(id, modules);
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent() {
        return studentGateway.getAllStudent();
    }
}
