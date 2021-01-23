/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dto.ClassDTO;
import dto.ModuleDTO;
import ejb.Timetabler_UIRemote;
import java.util.ArrayList;
import java.util.Date;
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
public class TimetablerTest {

    private static EJBContainer ec;
    private static Context ctx;

    public TimetablerTest() {
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

    //Test class functions
    //Create class
    @Test
    public void test_1() throws Exception {
        Timetabler_UIRemote instance = (Timetabler_UIRemote) ctx.lookup("java:global/classes/Timetabler_UI");
        Date date = new Date();
        ClassDTO classDTO = new ClassDTO(1, 1, date, date, date);
        instance.addClass(classDTO);
        ClassDTO result;
        ArrayList<ClassDTO> classList = instance.getAllClass();
        for (int i = 0; i < classList.size(); i++) {
            if (classList.get(i).toString() == classDTO.toString()) {
                result = classList.get(i);
                assertSame(classDTO, result);
            }
        }
    }

    //View class
    @Test
    public void test_2() throws Exception {
        Timetabler_UIRemote instance = (Timetabler_UIRemote) ctx.lookup("java:global/classes/Timetabler_UI");
        int size = instance.getAllClass().size();
        int expresult = 1;
        assertEquals(expresult, size);
    }

    //Update class
    @Test
    public void test_3() throws Exception {
        Timetabler_UIRemote instance = (Timetabler_UIRemote) ctx.lookup("java:global/classes/Timetabler_UI");
        Date date = new Date();
        int id = instance.getAllClass().get(instance.getAllClass().size() - 1).getId();
        ClassDTO classDTO = new ClassDTO(2, 2, date, date, date);
        instance.updateClass(id, classDTO);
        ClassDTO result;
        ArrayList<ClassDTO> classList = instance.getAllClass();
        for (int i = 0; i < classList.size(); i++) {
            if (classList.get(i).toString() == classDTO.toString()) {
                result = classList.get(i);
                assertSame(classDTO, result);
            }
        }
    }

    //View all class
    @Test
    public void test_4() throws Exception {
        Timetabler_UIRemote instance = (Timetabler_UIRemote) ctx.lookup("java:global/classes/Timetabler_UI");
        int size = instance.getAllClass().size();
        int expresult = 1;
        assertEquals(expresult, size);
    }

    //Delete class
    @Test
    public void test_5() throws Exception {
        Timetabler_UIRemote instance = (Timetabler_UIRemote) ctx.lookup("java:global/classes/Timetabler_UI");
        int id = instance.getAllClass().get(instance.getAllClass().size() - 1).getId();
        instance.deleteClass(id);
        int size = instance.getAllClass().size();
        int expresult = 0;
        assertEquals(expresult, size);
    }

    //Test module functions
    //Update module
    @Test
    public void test_6() throws Exception {
        Timetabler_UIRemote instance = (Timetabler_UIRemote) ctx.lookup("java:global/classes/Timetabler_UI");
        int id = instance.getAllModule().get(instance.getAllModule().size() - 1).getId();
        ModuleDTO moduleDTO = new ModuleDTO("test", 4, 2);
        instance.updateModule(id, moduleDTO);
        ModuleDTO result;
        ArrayList<ModuleDTO> moduleList = instance.getAllModule();
        for (int i = 0; i < moduleList.size(); i++) {
            if (moduleList.get(i).toString() == moduleDTO.toString()) {
                result = moduleList.get(i);
                assertSame(moduleDTO, result);
            }
        }
    }

    //View all module
    @Test
    public void test_7() throws Exception {
        Timetabler_UIRemote instance = (Timetabler_UIRemote) ctx.lookup("java:global/classes/Timetabler_UI");
        int size = instance.getAllModule().size();
        int expresult = 8;
        assertEquals(expresult, size);
    }

    //Test student functions
    //Register student on module
    @Test
    public void test_8() throws Exception {
        Timetabler_UIRemote instance = (Timetabler_UIRemote) ctx.lookup("java:global/classes/Timetabler_UI");
        int id = instance.getAllStudents().get(instance.getAllStudents().size() - 1).getId();
        ArrayList<ModuleDTO> modules = new ArrayList<ModuleDTO>();
        ModuleDTO moduleDTO_1 = new ModuleDTO(1, "Introduction to software lifecycle and modeling", 4, 1);
        ModuleDTO moduleDTO_2 = new ModuleDTO(2, "Introduction to Software Programming", 4, 2);
        modules.add(moduleDTO_1);
        modules.add(moduleDTO_2);
        instance.registerStudentOnModules(id, modules);
    }

    //Unregister student on module
    @Test
    public void test_9() throws Exception {
        Timetabler_UIRemote instance = (Timetabler_UIRemote) ctx.lookup("java:global/classes/Timetabler_UI");
        int id = instance.getAllStudents().get(instance.getAllStudents().size() - 1).getId();
        ArrayList<ModuleDTO> modules = new ArrayList<ModuleDTO>();
        ModuleDTO moduleDTO_1 = new ModuleDTO(1, "Introduction to software lifecycle and modeling", 4, 1);
        ModuleDTO moduleDTO_2 = new ModuleDTO(2, "Introduction to Software Programming", 4, 2);
        modules.add(moduleDTO_1);
        modules.add(moduleDTO_2);
        instance.unregisterStudentOnModules(id, modules);
    }

    //View all rooms
    @Test
    public void test_10() throws Exception {
        Timetabler_UIRemote instance = (Timetabler_UIRemote) ctx.lookup("java:global/classes/Timetabler_UI");
        int size = instance.getAllRoom().size();
        int expresult = 4;
        assertEquals(expresult, size);
    }
}
