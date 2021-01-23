/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dto.ClassDTO;
import dto.StudentDTO;
import ejb.Student_UIRemote;
import java.util.ArrayList;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Nurul
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentTest {

    private static EJBContainer ec;
    private static Context ctx;

    public StudentTest() {
    }

    @BeforeClass
    public static void setUpClass() throws NamingException {
        ec = EJBContainer.createEJBContainer();
        ctx = ec.getContext();
    }

    @AfterClass
    public static void tearDownClass() throws NamingException {
        ec.close();
    }

    //Test student functions
    //Find student
    @Test
    public void test_1() throws Exception {
        Student_UIRemote instance = (Student_UIRemote) ctx.lookup("java:global/classes/Student_UI");
        int id = 1;
        StudentDTO student = instance.viewStudent(id);
        assertEquals(1, student.getId());
    }

    //View timetable
    @Test
    public void test_2() throws Exception {
        Student_UIRemote instance = (Student_UIRemote) ctx.lookup("java:global/classes/Student_UI");
        int id = 1;
        ArrayList<ClassDTO> timetableList = instance.findTimetable(id);
        assertEquals(2, timetableList.size());
    }
}
