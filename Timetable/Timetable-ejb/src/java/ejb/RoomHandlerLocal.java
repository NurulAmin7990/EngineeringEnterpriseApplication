/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dto.RoomDTO;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Nurul
 */
@Local
public interface RoomHandlerLocal {

    ArrayList<RoomDTO> getAllRoom();

}
