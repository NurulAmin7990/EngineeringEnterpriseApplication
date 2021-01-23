/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway;

import dto.ModuleDTO;
import dto.StudentDTO;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Nurul
 */
@Local
public interface StudentGatewayLocal {

    boolean registerStudentOnModule(int id, ArrayList<ModuleDTO> modules);

    boolean unregisterStudentOnModule(int id, ArrayList<ModuleDTO> modules);

    StudentDTO getStudent(int id);

    ArrayList<StudentDTO> getAllStudent();

}
