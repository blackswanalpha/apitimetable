package com.example.timetable.app.room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.example.timetable.app.room.RoomBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RoomDAO {
	
	 PreparedStatement cst;
	    Connection conn;
	    @Autowired
	    DataSource dataSource;
		public RoomDAO() {
			super();
			  this.cst = null;
		        this.conn = null;
		}
		
	    public int getNextPrimaryKey() throws SQLException {
	        final String column_name = "room_id";
	        final String table_name = "room";
	        final String sql = "SELECT MAX(" + column_name + ") FROM " + table_name;
	        int primary = 0;
	        try {
	            this.conn = this.dataSource.getConnection();
	            this.cst = this.conn.prepareStatement(sql);
	            final ResultSet rs = this.cst.executeQuery();
	            while (rs.next()) {
	                primary = rs.getInt(1);
	                ++primary;
	            }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return primary;
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return primary;
	    }
	    
	    
	    
		
		 public List<RoomBean> fetchAllRooms() throws SQLException {
		        final String selectSQL = "SELECT room_id,room_name,room_desc,room_capacity,room_building_id,room_department_id ,room_lab		 FROM room where not room_status_id = 2";
		        final List<RoomBean> roomList = new ArrayList<RoomBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            this.cst = this.conn.prepareStatement(selectSQL);
		            final ResultSet rs = this.cst.executeQuery();
		            while (rs.next()) {
		                final RoomBean room = new RoomBean();
		                room.setRoomId(rs.getInt("room_id"));
		                
		                room.setRoomName(rs.getString("room_name"));
		                room.setRoomDesc(rs.getString("room_desc"));
		                room.setRoomCapacity(rs.getString("room_capacity"));
		                room.setRoomLab(rs.getString("room_lab"));
	             
		                room.setRoomBuildingId(rs.getInt("room_building_id"));
		                room.setRoomDepartmentId(rs.getInt("room_department_id"));
		               
		                roomList.add(room);
		            }
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return roomList;
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return roomList;
		    }
		    public List<RoomBean> createRoom(final RoomBean roomBean) throws SQLException {
		        final String selectSQL = "INSERT INTO room(room_id,room_lab,room_name,room_desc,room_capacity,room_building_id,room_department_id,room_status_id)  values(" + this.getNextPrimaryKey()+ ", '" +  roomBean.getRoomLab() + "', '" +  roomBean.getRoomName() +  "', '" + roomBean.getRoomDesc()+  "', '" + roomBean.getRoomCapacity() +  "', "  + roomBean.getRoomBuildingId()+", "  + roomBean.getRoomDepartmentId()+ ",1);";
		        List<RoomBean> roomList = new ArrayList<RoomBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<RoomBean>)this.fetchAllRooms();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        roomList = (List<RoomBean>)this.fetchAllRooms();
		        return roomList;
		    }
		    
		    public List<RoomBean> updateRoom(final RoomBean roomBean) throws SQLException {
		        final String sql = "update room set room_name='" + roomBean.getRoomName()+"', room_lab='" + roomBean.getRoomLab() +"',room_desc='" + roomBean.getRoomDesc()+"', room_capacity='"+ roomBean.getRoomCapacity() +"',  room_department_id=" + roomBean.getRoomDepartmentId()+",  room_building_id=" + roomBean.getRoomBuildingId()  + " where room_id=" + roomBean.getRoomId();
		        System.out.println(sql);
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<RoomBean>)this.fetchAllRooms();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<RoomBean>)this.fetchAllRooms();
		    }

	public List<RoomBean> deleteRoom(final RoomBean roomBean) throws SQLException {
		final String sql = "update room set room_status_id = 2  WHERE room_id=" +roomBean.getRoomId();
		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<RoomBean>)this.fetchAllRooms();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<RoomBean>)this.fetchAllRooms();
	}

	public List<RoomBean> undoRoom(RoomBean roomBean) throws SQLException {
		final String sql = "update room set room_status_id = 1  WHERE room_id=" + roomBean.getRoomId();

		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<RoomBean>)this.fetchAllRooms();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<RoomBean>)this.fetchAllRooms();
	}
		    
	

}

