/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import ejb.RoomHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Nurul
 */
@Stateless
public class GetAllRoomCommand implements GetAllRoomCommandLocal {

    //Enterprise Java Bean
    @EJB
    private RoomHandlerLocal roomHandler;

    @Override
    public Object execute() {
        return roomHandler.getAllRoom();
    }
}
