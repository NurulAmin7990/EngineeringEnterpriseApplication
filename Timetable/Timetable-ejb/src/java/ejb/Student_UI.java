/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dto.ClassDTO;
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
public class Student_UI implements Student_UIRemote {

//Enterprise Java Bean for Factory
    @EJB
    FactoryLocal factory;

    @Override
    public StudentDTO viewStudent(int id) {
        return (StudentDTO) factory
                .createCommand(Factory.FIND_STUDENT, id)
                .execute();
    }

    @Override
    public ArrayList<ClassDTO> findTimetable(int id) {
        return (ArrayList<ClassDTO>) factory
                .createCommand(Factory.FIND_TIMETABLE, id)
                .execute();
    }
}
