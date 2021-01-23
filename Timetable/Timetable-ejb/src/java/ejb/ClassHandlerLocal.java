/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dto.ClassDTO;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Nurul
 */
@Local
public interface ClassHandlerLocal {

    //Methods
    void addClass(ClassDTO classDTO);

    void deleteClass(int id);

    ClassDTO findClass(int id);

    ArrayList<ClassDTO> getAllClass();

    ArrayList<ClassDTO> getAllClassById(int id);

    void updateClass(int id, ClassDTO classDTO);
    
}
