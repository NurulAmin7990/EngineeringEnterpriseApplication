/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import dto.ClassDTO;
import javax.ejb.Local;

/**
 *
 * @author Nurul
 */
@Local
public interface AddClassCommandLocal extends Command{

    //Method
    Object execute();

    //Setter
    void setClassDTO(ClassDTO classDTO);
    
}
