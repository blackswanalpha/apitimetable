package com.example.timetable.app.room;

import java.sql.SQLException;
import java.util.List;

import com.example.timetable.app.room.RoomBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({ "/timetable/room" })
public class RoomController {
	 @Autowired
	    RoomDAO roomDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllRooms" })
	    public List<RoomBean> fetchAllRooms() throws SQLException {
	        return (List<RoomBean>)this.roomDAO.fetchAllRooms();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createRoom" })
	    public List<RoomBean> createRoom(@RequestBody final RoomBean roomBean) throws SQLException {
	        return (List<RoomBean>)this.roomDAO.createRoom(roomBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateRoom" })
	    public List<RoomBean> updateRoom(@RequestBody final RoomBean roomBean) throws SQLException {
	        return (List<RoomBean>)this.roomDAO.updateRoom(roomBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteRoom" })
	    public List<RoomBean> deleteRoom(@RequestBody final RoomBean roomBean) throws SQLException {
	        return (List<RoomBean>)this.roomDAO.deleteRoom(roomBean);
	    }
	@RequestMapping(method = { RequestMethod.POST }, value = { "/undoRoom" })
	public List<RoomBean> undoRoom(@RequestBody final RoomBean roomBean) throws SQLException {
		return (List<RoomBean>)this.roomDAO.undoRoom(roomBean);
	}



}
