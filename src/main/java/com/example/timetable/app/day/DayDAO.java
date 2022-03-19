package com.example.timetable.app.day;

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
public class DayDAO {
	PreparedStatement cst;
    Connection conn;
    @Autowired
    DataSource dataSource;
	public DayDAO() {
		super();
		  this.cst = null;
	        this.conn = null;
	}
	
    public int getNextPrimaryKey() throws SQLException {
        final String column_name = "day_id";
        final String table_name = "day";
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
    
    
    
	
	 public List<DayBean> fetchAllDays() throws SQLException {
	        final String selectSQL = "SELECT day_id,day_name,day_desc	 FROM day";
	        final List<DayBean> dayList = new ArrayList<DayBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            this.cst = this.conn.prepareStatement(selectSQL);
	            final ResultSet rs = this.cst.executeQuery();
	            while (rs.next()) {
	                final DayBean day = new DayBean();
	                day.setDayId(rs.getInt("day_id"));
	                
	                day.setDayName(rs.getString("day_name"));
	                day.setDayDesc(rs.getString("day_desc"));
	               
	             
	                
	               
	                dayList.add(day);
	            }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return dayList;
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return dayList;
	    }
	    public List<DayBean> createDay(final DayBean dayBean) throws SQLException {
	        final String selectSQL = "INSERT INTO day(day_id,day_name,day_desc) values(" + this.getNextPrimaryKey() + ", '" +  dayBean.getDayName() +  "', '" + dayBean.getDayDesc() +   "');";
	        List<DayBean> dayList = new ArrayList<DayBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<DayBean>)this.fetchAllDays();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        dayList = (List<DayBean>)this.fetchAllDays();
	        return dayList;
	    }
	    
	    public List<DayBean> updateDay(final DayBean dayBean) throws SQLException {
	        final String sql = "update day set day_name='" + dayBean.getDayName() +"',  day_desc='" + dayBean.getDayDesc()  + "'  where day_id=" + dayBean.getDayId();
	        System.out.println(sql);
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(sql)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<DayBean>)this.fetchAllDays();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return (List<DayBean>)this.fetchAllDays();
	    }
	    
	    public List<DayBean> deleteDay(final DayBean dayBean) throws SQLException {
	        final String sql = "DELETE FROM day WHERE day_id=" + dayBean.getDayId();
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(sql)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<DayBean>)this.fetchAllDays();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return (List<DayBean>)this.fetchAllDays();
	    }


}
