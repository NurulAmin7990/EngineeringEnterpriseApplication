/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dto.ClassDTO;
import dto.StudentDTO;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author Nurul
 */
@Remote
public interface Student_UIRemote {

    StudentDTO viewStudent(int id);

    ArrayList<ClassDTO> findTimetable(int id);

}
