/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway;

import dto.ClassDTO;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Nurul
 */
@Local
public interface ClassGatewayLocal {

    //Methods
    boolean createClass(ClassDTO classDTO);

    boolean deleteClass(int id);

    ClassDTO findClass(int id);

    ArrayList<ClassDTO> getAllClass();

    ArrayList<ClassDTO> getAllClassById(int id);

    boolean updateClass(int id, ClassDTO classDTO);
    
}
