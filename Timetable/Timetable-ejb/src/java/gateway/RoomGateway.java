/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway;

import dto.RoomDTO;
import entity.Room;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nurul
 */
@Stateless
public class RoomGateway implements RoomGatewayLocal {

    //Entity Manager for Java Persistence API
    @PersistenceContext
    EntityManager em;

    //Methods
    @Override
    public ArrayList<RoomDTO> getAllRoom() {
        try {
            List<Room> roomList = em.createNamedQuery("Room.findAll").getResultList();

            ArrayList<RoomDTO> roomDTOList = new ArrayList<>(roomList.size());
            for (Room r : roomList) {
                roomDTOList.add(new RoomDTO(r.getId(), r.getRoomnumber(), r.getRoomcapacity(), r.getBuildingname(), r.getLocation()));
            }
            return roomDTOList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
