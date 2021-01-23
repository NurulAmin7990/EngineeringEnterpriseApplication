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
import factory.Factory;
import factory.FactoryLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Nurul
 */
@Stateless
public class Timetabler_UI implements Timetabler_UIRemote {

//Enterprise Java Bean for Factory
    @EJB
    FactoryLocal factory;

    @Override
    public void addClass(ClassDTO classDTO) {
        factory
                .createCommand(Factory.ADD_CLASS, classDTO)
                .execute();
    }

    @Override
    public void deleteClass(int id) {
        factory
                .createCommand(Factory.DELETE_CLASS, id)
                .execute();
    }

    @Override
    public void updateClass(int id, ClassDTO classDTO) {
        factory
                .createCommand(Factory.UPDATE_CLASS, id, classDTO)
                .execute();
    }

    @Override
    public ClassDTO findClass(int id) {
        return (ClassDTO) factory
                .createCommand(Factory.FIND_CLASS, id)
                .execute();
    }

    @Override
    public ArrayList<ClassDTO> getAllClass() {
        return (ArrayList<ClassDTO>) factory
                .createCommand(Factory.GET_ALL_CLASS)
                .execute();
    }

    @Override
    public void updateModule(int id, ModuleDTO moduleDTO) {
        factory
                .createCommand(Factory.UPDATE_MODULE, id, moduleDTO)
                .execute();
    }

    @Override
    public ArrayList<ModuleDTO> getAllModule() {
        return (ArrayList<ModuleDTO>) factory
                .createCommand(Factory.GET_ALL_MODULE)
                .execute();
    }

    @Override
    public ArrayList<RoomDTO> getAllRoom() {
        return (ArrayList<RoomDTO>) factory
                .createCommand(Factory.GET_ALL_ROOM)
                .execute();
    }

    @Override
    public void registerStudentOnModules(int id, ArrayList<ModuleDTO> modules) {
        factory
                .createCommand(Factory.REGISTER_STUDENT_ON_MODULES, id, modules)
                .execute();
    }

    @Override
    public void unregisterStudentOnModules(int id, ArrayList<ModuleDTO> modules) {
        factory
                .createCommand(Factory.UNREGISTER_STUDENT_ON_MODULES, id, modules)
                .execute();
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() {
        return (ArrayList<StudentDTO>) factory
                .createCommand(Factory.GET_ALL_STUDENTS)
                .execute();
    }

    @Override
    public ArrayList<ModuleDTO> findUnregisteredModules(int id) {
        return (ArrayList<ModuleDTO>) factory
                .createCommand(Factory.FIND_UNREGISTERED_MODULES, id)
                .execute();
    }

    @Override
    public ArrayList<ModuleDTO> findRegisteredModules(int id) {
        return (ArrayList<ModuleDTO>) factory
                .createCommand(Factory.FIND_REGISTERED_MODULES, id)
                .execute();
    }
}
