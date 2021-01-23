/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dto.RoomDTO;
import gateway.RoomGatewayLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Nurul
 */
@Stateless
public class RoomHandler implements RoomHandlerLocal {

    //Enterpise Java Bean for gateway
    @EJB
    RoomGatewayLocal roomGateway;

    //Methods
    @Override
    public ArrayList<RoomDTO> getAllRoom() {
        return roomGateway.getAllRoom();
    }
}
