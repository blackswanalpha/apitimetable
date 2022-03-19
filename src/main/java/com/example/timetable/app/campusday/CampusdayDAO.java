package com.example.timetable.app.campusday;

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
public class CampusdayDAO {
	PreparedStatement cst;
    Connection conn;
    @Autowired
    DataSource dataSource;
	public CampusdayDAO() {
		super();
		  this.cst = null;
	        this.conn = null;
	}
	
    public int getNextPrimaryKey() throws SQLException {
        final String column_name = "campusday_id";
        final String table_name = "campusday";
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
    
    
    
	
	 public List<CampusdayBean> fetchAllCampusdays() throws SQLException {
	        final String selectSQL = "SELECT campusday_id,campusday_campus_id ,campusday_day_id ,campusday_timeslot_id ,campusday_mode_id	 FROM campusday";
	        final List<CampusdayBean> campusdayList = new ArrayList<CampusdayBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            this.cst = this.conn.prepareStatement(selectSQL);
	            final ResultSet rs = this.cst.executeQuery();
	            while (rs.next()) {
	                final CampusdayBean campusday = new CampusdayBean();
	                campusday.setCampusdayId(rs.getInt("campusday_id"));
	                
	                campusday.setCampusdayTimeslotId(rs.getInt("campusday_timeslot_id "));
	                campusday.setCampusdayDayId(rs.getInt("campusday_day_id "));
	                campusday.setCampusdayCampusId(rs.getInt("campusday_campus_id"));
	                campusday.setCampusdayModeId(rs.getInt("campusday_mode_id"));
	             
	                
	               
	                campusdayList.add(campusday);
	            }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return campusdayList;
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return campusdayList;
	    }
	    public List<CampusdayBean> createCampusday(final CampusdayBean campusdayBean) throws SQLException {
	        final String selectSQL = "INSERT INTO campusday(campusday_id,campusday_day_id,campusday_timeslot_id,campusday_campus_id,campusday_mode_id) values(" + this.getNextPrimaryKey() + ", " +  campusdayBean.getCampusdayId() +  ", " + campusdayBean.getCampusdayTimeslotId()+  ", " + campusdayBean.getCampusdayCampusId()+  ", " + campusdayBean.getCampusdayModeId() +   ");";
	        List<CampusdayBean> campusdayList = new ArrayList<CampusdayBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<CampusdayBean>)this.fetchAllCampusdays();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        campusdayList = (List<CampusdayBean>)this.fetchAllCampusdays();
	        return campusdayList;
	    }
	    
	    public List<CampusdayBean> updateCampusday(final CampusdayBean campusdayBean) throws SQLException {
	        final String sql = "update campusday set campusday_day_id =" + campusdayBean.getCampusdayId() +",  campusday_timeslot_id=" + campusdayBean.getCampusdayTimeslotId()+",  campusday_campus_id=" + campusdayBean.getCampusdayCampusId()+",  campusday_mode_id=" + campusdayBean.getCampusdayModeId()  + "  where campusday_id=" + campusdayBean.getCampusdayId();
	        System.out.println(sql);
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(sql)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<CampusdayBean>)this.fetchAllCampusdays();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return (List<CampusdayBean>)this.fetchAllCampusdays();
	    }
	    
	    public List<CampusdayBean> deleteCampusday(final CampusdayBean campusdayBean) throws SQLException {
	        final String sql = "DELETE FROM campusday WHERE campusday_id=" + campusdayBean.getCampusdayId();
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(sql)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<CampusdayBean>)this.fetchAllCampusdays();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return (List<CampusdayBean>)this.fetchAllCampusdays();
	    }


}
