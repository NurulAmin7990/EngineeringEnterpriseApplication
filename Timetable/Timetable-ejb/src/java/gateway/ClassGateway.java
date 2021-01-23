/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway;

import dto.ClassDTO;
import entity.Class;
import entity.Module;
import entity.Room;
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
public class ClassGateway implements ClassGatewayLocal {

    //Entity Manager for Java Persistence API
    @PersistenceContext
    EntityManager em;

    //Methods
    @Override
    public boolean createClass(ClassDTO classDTO) {
        try {
            Class c = new Class();
            Room r = (Room) em.createNamedQuery("Room.findById").setParameter("id", classDTO.getRoomId()).getSingleResult();
            Module m = (Module) em.createNamedQuery("Module.findById").setParameter("id", classDTO.getModuleId()).getSingleResult();
            c.setRoomid(r);
            c.setModuleid(m);
            c.setDate(classDTO.getDate());
            c.setStarttime(classDTO.getStartTime());
            c.setEndtime(classDTO.getEndTime());
            em.persist(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteClass(int id) {
        try {
            Class c = (Class) em.createNamedQuery("Class.findById").setParameter("id", id).getSingleResult();
            em.remove(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateClass(int id, ClassDTO classDTO) {
        try {
            Class c = (Class) em.createNamedQuery("Class.findById").setParameter("id", id).getSingleResult();
            if (c.getRoomid().getId() != classDTO.getRoomId()) {
                Room r = (Room) em.createNamedQuery("Room.findById").setParameter("id", classDTO.getRoomId()).getSingleResult();
                c.setRoomid(r);
            }
            if (c.getModuleid().getId() != classDTO.getModuleId()) {
                Module m = (Module) em.createNamedQuery("Module.findById").setParameter("id", classDTO.getModuleId()).getSingleResult();
                c.setModuleid(m);
            }
            c.setDate(classDTO.getDate());
            c.setStarttime(classDTO.getStartTime());
            c.setEndtime(classDTO.getEndTime());
            em.persist(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ClassDTO findClass(int id) {
        try {
            return (ClassDTO) em.createNamedQuery("Class.findById").setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<ClassDTO> getAllClass() {
        try {
            List<Class> classList = em.createNamedQuery("Class.findAll").getResultList();

            ArrayList<ClassDTO> classDTOList = new ArrayList<>(classList.size());
            for (Class c : classList) {
                classDTOList.add(new ClassDTO(c.getId(), c.getRoomid().getId(), c.getModuleid().getId(), c.getDate(), c.getStarttime(), c.getEndtime()));
            }

            return classDTOList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<ClassDTO> getAllClassById(int id) {
        try {
            Query q = em.createNamedQuery("Class.findTimetable").setParameter("1", id);
            List<Class> classList = q.getResultList();
            ArrayList<ClassDTO> classDTOList = new ArrayList<>(classList.size());
            for (Class c : classList) {
                classDTOList.add(new ClassDTO(c.getId(), c.getRoomid().getId(), c.getModuleid().getId(), c.getDate(), c.getStarttime(), c.getEndtime()));
            }
            return classDTOList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
