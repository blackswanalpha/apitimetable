package com.example.timetable.app.lecturerworkstation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository
public class LecturerworkstationDAO {
	PreparedStatement cst;
    Connection conn;
    @Autowired
    DataSource dataSource;
	public LecturerworkstationDAO() {
		super();
		  this.cst = null;
	        this.conn = null;
	}
	
    public int getNextPrimaryKey() throws SQLException {
        final String column_name = "lecturer_work_station_id";
        final String table_name = "lecturer_work_station";
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
    
    
    
	
	 public List<LecturerworkstationBean> fetchAllLecturerworkstations() throws SQLException {
	        final String selectSQL = "SELECT lecturer_work_station_id,lecturer_work_station_lecturer_id,lecturer_work_station_campus_id	 FROM lecturer_work_station";
	        final List<LecturerworkstationBean> lecturer_work_stationList = new ArrayList<LecturerworkstationBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            this.cst = this.conn.prepareStatement(selectSQL);
	            final ResultSet rs = this.cst.executeQuery();
	            while (rs.next()) {
	                final LecturerworkstationBean lecturer_work_station = new LecturerworkstationBean();
	                lecturer_work_station.setLecturerworkstationId(rs.getInt("lecturer_work_station_id"));
	                
	                lecturer_work_station.setLecturerworkstationLecturerId(rs.getInt("lecturer_work_station_lecturer_id"));
	                lecturer_work_station.setLecturerworkstationCampusId(rs.getInt("lecturer_work_station_campus_id"));
	               
	             
	                
	               
	                lecturer_work_stationList.add(lecturer_work_station);
	            }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return lecturer_work_stationList;
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return lecturer_work_stationList;
	    }
	    public List<LecturerworkstationBean> createLecturerworkstation(final LecturerworkstationBean lecturer_work_stationBean) throws SQLException {
	        final String selectSQL = "INSERT INTO lecturer_work_station(lecturer_work_station_id,lecturer_work_station_lecturer_id,lecturer_work_station_campus_id) values(" + this.getNextPrimaryKey() + ", " +  lecturer_work_stationBean.getLecturerworkstationLecturerId() +  ", " + lecturer_work_stationBean.getLecturerworkstationCampusId() +   ");";
	        List<LecturerworkstationBean> lecturer_work_stationList = new ArrayList<LecturerworkstationBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<LecturerworkstationBean>)this.fetchAllLecturerworkstations();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        lecturer_work_stationList = (List<LecturerworkstationBean>)this.fetchAllLecturerworkstations();
	        return lecturer_work_stationList;
	    }
	    
	    public List<LecturerworkstationBean> updateLecturerworkstation(final LecturerworkstationBean lecturer_work_stationBean) throws SQLException {
	        final String sql = "update lecturer_work_station set lecturer_work_station_lecturer_id=" + lecturer_work_stationBean.getLecturerworkstationLecturerId() +",  lecturer_work_station_campus_id=" + lecturer_work_stationBean.getLecturerworkstationCampusId()  + "  where lecturer_work_station_id=" + lecturer_work_stationBean.getLecturerworkstationId();
	        System.out.println(sql);
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(sql)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<LecturerworkstationBean>)this.fetchAllLecturerworkstations();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return (List<LecturerworkstationBean>)this.fetchAllLecturerworkstations();
	    }
	    
	    public List<LecturerworkstationBean> deleteLecturerworkstation(final LecturerworkstationBean lecturer_work_stationBean) throws SQLException {
	        final String sql = "DELETE FROM lecturer_work_station WHERE lecturer_work_station_id=" + lecturer_work_stationBean.getLecturerworkstationId();
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(sql)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<LecturerworkstationBean>)this.fetchAllLecturerworkstations();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return (List<LecturerworkstationBean>)this.fetchAllLecturerworkstations();
	    }

}
