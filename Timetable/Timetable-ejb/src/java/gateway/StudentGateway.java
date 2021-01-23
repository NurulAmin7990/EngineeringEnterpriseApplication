/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway;

import dto.ModuleDTO;
import dto.StudentDTO;
import entity.Module;
import entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Nurul
 */
@Stateless
public class StudentGateway implements StudentGatewayLocal {

    //Entity Manager for Java Persistence API
    @PersistenceContext
    EntityManager em;

    //Methods
    @Override
    public boolean registerStudentOnModule(int id, ArrayList<ModuleDTO> modules) {
        try {
            Query sq = em.createNamedQuery("Student.findById").setParameter("id", id);
            Student s = (Student) sq.getSingleResult();
            if (s != null) {
                for (ModuleDTO m : modules) {
                    Query mq = em.createNamedQuery("Module.findById").setParameter("id", m.getId());
                    Module module = (Module) mq.getSingleResult();
                    if (module != null) {
                        module.registerStudent(s);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean unregisterStudentOnModule(int id, ArrayList<ModuleDTO> modules) {
        try {
            Query sq = em.createNamedQuery("Student.findById").setParameter("id", id);
            Student s = (Student) sq.getSingleResult();
            if (s != null) {
                for (ModuleDTO m : modules) {
                    Query mq = em.createNamedQuery("Module.findById").setParameter("id", m.getId());
                    Module module = (Module) mq.getSingleResult();
                    if (module != null) {
                        module.unregisterStudent(s);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public StudentDTO getStudent(int id) {
        try {
            Student student = (Student) em.createNamedQuery("Student.findById").setParameter("id", id).getSingleResult();
            return new StudentDTO(student.getId(), student.getFirstname(), student.getLastname(), student.getDateofbirth(), student.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent() {
        try {
            List<Student> studentList = em.createNamedQuery("Student.findAll").getResultList();

            ArrayList<StudentDTO> studentDTOList = new ArrayList<>(studentList.size());
            for (Student s : studentList) {
                studentDTOList.add(new StudentDTO(s.getId(), s.getFirstname(), s.getLastname(), s.getDateofbirth(), s.getEmail()));
            }
            return studentDTOList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
