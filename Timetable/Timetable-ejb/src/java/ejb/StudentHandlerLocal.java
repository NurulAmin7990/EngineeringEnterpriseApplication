/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dto.ModuleDTO;
import dto.StudentDTO;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Nurul
 */
@Local
public interface StudentHandlerLocal {

    StudentDTO findStudent(int id);

    void registerStudentOnModule(int id, ArrayList<ModuleDTO> modules);

    void unregisterStudentOnModule(int id, ArrayList<ModuleDTO> modules);

    ArrayList<StudentDTO> getAllStudent();

}
