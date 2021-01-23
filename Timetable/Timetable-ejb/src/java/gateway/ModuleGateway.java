/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway;

import dto.ClassDTO;
import dto.ModuleDTO;
import entity.Module;
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
public class ModuleGateway implements ModuleGatewayLocal {

    //Entity Manager for Java Persistence API
    @PersistenceContext
    EntityManager em;

    @Override
    public boolean updateModule(int id, ModuleDTO moduleDTO) {
        try {
            entity.Module m = (entity.Module) em.createNamedQuery("Module.findById").setParameter("id", id).getSingleResult();
            m.setName(moduleDTO.getName());
            m.setLevel(moduleDTO.getLevel());
            m.setSemester(moduleDTO.getSemester());
            em.persist(m);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<ModuleDTO> getAllModule() {
        try {
            List<entity.Module> moduleList = em.createNamedQuery("Module.findAll").getResultList();

            ArrayList<ModuleDTO> moduleDTOList = new ArrayList<>(moduleList.size());
            for (entity.Module m : moduleList) {
                moduleDTOList.add(new ModuleDTO(m.getId(), m.getName(), m.getLevel(), m.getSemester()));
            }
            return moduleDTOList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<ModuleDTO> findUnregisteredModules(int id) {
        try {
            Query q = em.createNamedQuery("Module.findUnregisteredModules").setParameter(1, id);
            List<Module> list = q.getResultList();
            ArrayList<ModuleDTO> moduleList = new ArrayList<>(list.size());
            for (int i = 0; i < list.size(); i++) {
                Module m = (Module) list.get(i);
                moduleList.add(
                        new ModuleDTO(m.getId(), m.getName(), m.getLevel(), m.getSemester()));
            }
            return moduleList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<ModuleDTO> findRegisteredModules(int id) {
        try {
            Query q = em.createNamedQuery("Module.findRegisteredModules").setParameter(1, id);
            List<Module> list = q.getResultList();
            ArrayList<ModuleDTO> moduleList = new ArrayList<>(list.size());
            for (int i = 0; i < list.size(); i++) {
                Module m = (Module) list.get(i);
                moduleList.add(
                        new ModuleDTO(m.getId(), m.getName(), m.getLevel(), m.getSemester()));
            }
            return moduleList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
