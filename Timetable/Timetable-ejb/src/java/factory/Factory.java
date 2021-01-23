/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import command.AddClassCommandLocal;
import command.Command;
import command.DeleteClassCommandLocal;
import command.FindClassCommandLocal;
import command.FindRegisteredModulesCommandLocal;
import command.FindStudentCommandLocal;
import command.FindTimetableCommandLocal;
import command.FindUnregisteredModulesCommandLocal;
import command.GetAllClassCommandLocal;
import command.GetAllModuleCommandLocal;
import command.GetAllRoomCommandLocal;
import command.GetAllStudentCommandLocal;
import command.RegisterStudentOnModuleCommandLocal;
import command.UnregisterStudentOnModuleCommandLocal;
import command.UpdateClassCommandLocal;
import command.UpdateModuleCommandLocal;
import dto.ClassDTO;
import dto.ModuleDTO;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Nurul
 */
@Stateless
public class Factory implements FactoryLocal {

    //Attributes
    public static final int ADD_CLASS = 1;
    public static final int DELETE_CLASS = 2;
    public static final int UPDATE_CLASS = 3;
    public static final int FIND_CLASS = 4;
    public static final int GET_ALL_CLASS = 5;
    public static final int FIND_STUDENT = 6;
    public static final int UPDATE_MODULE = 7;
    public static final int GET_ALL_MODULE = 8;
    public static final int REGISTER_STUDENT_ON_MODULES = 9;
    public static final int UNREGISTER_STUDENT_ON_MODULES = 10;
    public static final int GET_ALL_ROOM = 11;
    public static final int FIND_TIMETABLE = 12;
    public static final int GET_ALL_STUDENTS = 13;
    public static final int FIND_UNREGISTERED_MODULES = 14;
    public static final int FIND_REGISTERED_MODULES = 15;

    //Enterprise Java Beans for commands
    @EJB
    private GetAllClassCommandLocal getAllClassCommand;
    @EJB
    private AddClassCommandLocal addClassCommand;
    @EJB
    private DeleteClassCommandLocal deleteClassCommand;
    @EJB
    private FindClassCommandLocal findClassCommand;
    @EJB
    private UpdateClassCommandLocal updateClassCommand;
    @EJB
    private FindTimetableCommandLocal findTimetableCommand;
    @EJB
    private UpdateModuleCommandLocal updateModuleCommand;
    @EJB
    private GetAllModuleCommandLocal getAllModuleCommand;
    @EJB
    private GetAllRoomCommandLocal getAllRoomCommand;
    @EJB
    private FindStudentCommandLocal findStudentCommand;
    @EJB
    private RegisterStudentOnModuleCommandLocal registerStudentOnModuleCommand;
    @EJB
    private UnregisterStudentOnModuleCommandLocal unregisterStudentOnModuleCommand;
    @EJB
    private GetAllStudentCommandLocal getAllStudentCommand;
    @EJB
    private FindUnregisteredModulesCommandLocal findUnregisteredModulesCommand;
    @EJB
    private FindRegisteredModulesCommandLocal findRegisteredModulesCommand;

    //Methods
    @Override
    public Command createCommand(int code, ClassDTO classDTO) {
        switch (code) {
            case ADD_CLASS:
                addClassCommand.setClassDTO(classDTO);
                return addClassCommand;
            default:
                return null;
        }
    }

    @Override
    public Command createCommand(int code, int id) {
        switch (code) {
            case DELETE_CLASS:
                deleteClassCommand.setId(id);
                return deleteClassCommand;
            case FIND_CLASS:
                findClassCommand.setId(id);
                return findClassCommand;
            case FIND_TIMETABLE:
                findTimetableCommand.setId(id);
                return findTimetableCommand;
            case FIND_STUDENT:
                findStudentCommand.setId(id);
                return findStudentCommand;
            case FIND_UNREGISTERED_MODULES:
                findUnregisteredModulesCommand.setId(id);
                return findUnregisteredModulesCommand;
            case FIND_REGISTERED_MODULES:
                findRegisteredModulesCommand.setId(id);
                return findRegisteredModulesCommand;
            default:
                return null;
        }
    }

    @Override
    public Command createCommand(int code, int id, ClassDTO classDTO) {
        switch (code) {
            case UPDATE_CLASS:
                updateClassCommand.setId(id);
                updateClassCommand.setClassDTO(classDTO);
                return updateClassCommand;
            default:
                return null;
        }
    }

    @Override
    public Command createCommand(int code) {
        switch (code) {
            case GET_ALL_CLASS:
                return getAllClassCommand;
            case GET_ALL_MODULE:
                return getAllModuleCommand;
            case GET_ALL_ROOM:
                return getAllRoomCommand;
            case GET_ALL_STUDENTS:
                return getAllStudentCommand;
            default:
                return null;
        }
    }

    @Override
    public Command createCommand(int code, int id, ModuleDTO moduleDTO) {
        switch (code) {
            case UPDATE_MODULE:
                updateModuleCommand.setId(id);
                updateModuleCommand.setModuleDTO(moduleDTO);
                return updateModuleCommand;
            default:
                return null;
        }
    }

    @Override
    public Command createCommand(int code, int id, ArrayList<ModuleDTO> modules) {
        switch (code) {
            case REGISTER_STUDENT_ON_MODULES:
                registerStudentOnModuleCommand.setId(id);
                registerStudentOnModuleCommand.setModules(modules);
                return registerStudentOnModuleCommand;
            case UNREGISTER_STUDENT_ON_MODULES:
                unregisterStudentOnModuleCommand.setId(id);
                unregisterStudentOnModuleCommand.setModules(modules);
                return unregisterStudentOnModuleCommand;
            default:
                return null;
        }
    }
}
