/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dto.ClassDTO;
import dto.ModuleDTO;
import dto.RoomDTO;
import dto.StudentDTO;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author Nurul
 */
@Remote
public interface Timetabler_UIRemote {

    void addClass(ClassDTO classDTO);

    void deleteClass(int id);

    void updateClass(int id, ClassDTO classDTO);

    ClassDTO findClass(int id);

    ArrayList<ClassDTO> getAllClass();

    void updateModule(int id, ModuleDTO moduleDTO);

    ArrayList<ModuleDTO> getAllModule();

    ArrayList<RoomDTO> getAllRoom();

    void registerStudentOnModules(int id, ArrayList<ModuleDTO> modules);

    void unregisterStudentOnModules(int id, ArrayList<ModuleDTO> modules);

    ArrayList<StudentDTO> getAllStudents();

    ArrayList<ModuleDTO> findUnregisteredModules(int id);

    ArrayList<ModuleDTO> findRegisteredModules(int id);
}
