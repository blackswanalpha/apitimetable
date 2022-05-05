package com.example.timetable.app.timeslot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.example.timetable.app.timeslot.TimeslotBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TimeslotDAO {
	PreparedStatement cst;
    Connection conn;
    @Autowired
    DataSource dataSource;
	public TimeslotDAO() {
		super();
		  this.cst = null;
	        this.conn = null;
	}
	
    public int getNextPrimaryKey() throws SQLException {
        final String column_name = "timeslot_id";
        final String table_name = "timeslot";
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
    
    
    
	
	 public List<TimeslotBean> fetchAllTimeslots() throws SQLException {
	        final String selectSQL = "SELECT timeslot_id,timeslot_name,timeslot_desc,timeslot_campus_id,timeslot_mode_id,campus_name,mode_name	 FROM timeslot,campus,mode where not  timeslot_status_id = 2 and timeslot_mode_id=mode_id and timeslot_mode_id =mode_id ";
	        final List<TimeslotBean> timeslotList = new ArrayList<TimeslotBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            this.cst = this.conn.prepareStatement(selectSQL);
	            final ResultSet rs = this.cst.executeQuery();
	            while (rs.next()) {
	                final TimeslotBean timeslot = new TimeslotBean();
	                timeslot.setTimeslotId(rs.getInt("timeslot_id"));
	                
	                timeslot.setTimeslotName(rs.getString("timeslot_name"));
	                timeslot.setTimeslotDesc(rs.getString("timeslot_desc"));
					timeslot.setCampusName(rs.getString("campus_name"));
					timeslot.setModeName(rs.getString("mode_name"));
	                timeslot.setTimeslotCampusId(rs.getInt("timeslot_campus_id"));
	                timeslot.setTimeslotModeId(rs.getInt("timeslot_mode_id"));
	             
	                
	               
	                timeslotList.add(timeslot);
	            }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return timeslotList;
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return timeslotList;
	    }
	    public List<TimeslotBean> createTimeslot(final TimeslotBean timeslotBean) throws SQLException {
	        final String selectSQL = "INSERT INTO timeslot(timeslot_id,timeslot_name,timeslot_desc,timeslot_campus_id,timeslot_mode_id	,timeslot_status_id	) values(" + this.getNextPrimaryKey() + ", '" +  timeslotBean.getTimeslotName() +  "', '" + timeslotBean.getTimeslotDesc()+  "', " + timeslotBean.getTimeslotCampusId()+  ", " + timeslotBean.getTimeslotModeId() +   ",1);";
	        List<TimeslotBean> timeslotList = new ArrayList<TimeslotBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<TimeslotBean>)this.fetchAllTimeslots();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        timeslotList = (List<TimeslotBean>)this.fetchAllTimeslots();
	        return timeslotList;
	    }
	    
	    public List<TimeslotBean> updateTimeslot(final TimeslotBean timeslotBean) throws SQLException {
	        final String sql = "update timeslot set timeslot_name='" + timeslotBean.getTimeslotName() +"',  timeslot_desc='" + timeslotBean.getTimeslotDesc()+"',  timeslot_campus_id=" + timeslotBean.getTimeslotCampusId()+",  timeslot_mode_id=" + timeslotBean.getTimeslotModeId()  + "  where timeslot_id=" + timeslotBean.getTimeslotId();
	        System.out.println(sql);
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(sql)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<TimeslotBean>)this.fetchAllTimeslots();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return (List<TimeslotBean>)this.fetchAllTimeslots();
	    }

	public List<TimeslotBean> deleteTimeslot(final TimeslotBean timeslotBean) throws SQLException {
		final String sql = "update timeslot set timeslot_status_id = 2  WHERE timeslot_id=" + timeslotBean.getTimeslotId();
		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<TimeslotBean>)this.fetchAllTimeslots();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<TimeslotBean>)this.fetchAllTimeslots();
	}


	public List<TimeslotBean> undoTimeslot(TimeslotBean timeslotBean) throws SQLException {
		final String sql = "update timeslot set timeslot_status_id = 1  WHERE timeslot_id=" + timeslotBean.getTimeslotId();

		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<TimeslotBean>)this.fetchAllTimeslots();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<TimeslotBean>)this.fetchAllTimeslots();
	}


}
