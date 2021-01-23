/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import command.Command;
import dto.ClassDTO;
import dto.ModuleDTO;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Nurul
 */
@Local
public interface FactoryLocal {

    //Methods
    Command createCommand(int code, ClassDTO classDTO);

    Command createCommand(int code, int id);

    Command createCommand(int code, int id, ClassDTO classDTO);

    Command createCommand(int code);

    Command createCommand(int code, int id, ModuleDTO moduleDTO);

    Command createCommand(int code, int id, ArrayList<ModuleDTO> modules);
}
