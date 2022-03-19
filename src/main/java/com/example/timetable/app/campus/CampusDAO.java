package com.example.timetable.app.campus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.example.timetable.app.campus.CampusBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class CampusDAO {
	PreparedStatement cst;
    Connection conn;
    @Autowired
    DataSource dataSource;
	public CampusDAO() {
		super();
		  this.cst = null;
	        this.conn = null;
	}
	
    public int getNextPrimaryKey() throws SQLException {
        final String column_name = "campus_id";
        final String table_name = "campus";
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
    
    
    
	
	 public List<CampusBean> fetchAllCampuss() throws SQLException {
	        final String selectSQL = "SELECT campus_id,campus_name,campus_desc,campus_location	 FROM campus where not campus_status_id = 2";
	        final List<CampusBean> campusList = new ArrayList<CampusBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            this.cst = this.conn.prepareStatement(selectSQL);
	            final ResultSet rs = this.cst.executeQuery();
	            while (rs.next()) {
	                final CampusBean campus = new CampusBean();
	                campus.setCampusId(rs.getInt("campus_id"));
	                
	                campus.setCampusName(rs.getString("campus_name"));
	                campus.setCampusDesc(rs.getString("campus_desc"));

					campus.setCampusLocation(rs.getString("campus_location"));
	                
	               
	                campusList.add(campus);
	            }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return campusList;
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return campusList;
	    }
	    public List<CampusBean> createCampus(final CampusBean campusBean) throws SQLException {
	        final String selectSQL = "INSERT INTO campus(campus_id,campus_name,campus_desc,campus_location,campus_status_id) values(" + this.getNextPrimaryKey() + ", '" +  campusBean.getCampusName() +  "', '" + campusBean.getCampusDesc()+  "', '" + campusBean.getCampusLocation() +   "',1);";
	        List<CampusBean> campusList = new ArrayList<CampusBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<CampusBean>)this.fetchAllCampuss();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        campusList = (List<CampusBean>)this.fetchAllCampuss();
	        return campusList;
	    }
	    
	    public List<CampusBean> updateCampus(final CampusBean campusBean) throws SQLException {
	        final String sql = "update campus set campus_name='" + campusBean.getCampusName() +"',  campus_desc='" + campusBean.getCampusDesc()+"',  campus_location='" + campusBean.getCampusLocation()  + "'  where campus_id=" + campusBean.getCampusId();
	        System.out.println(sql);
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(sql)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<CampusBean>)this.fetchAllCampuss();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return (List<CampusBean>)this.fetchAllCampuss();
	    }

	public List<CampusBean> deleteCampus(final CampusBean campusBean) throws SQLException {
		final String sql = "update campus set campus_status_id = 2  WHERE campus_id=" +campusBean.getCampusId();
		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<CampusBean>)this.fetchAllCampuss();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<CampusBean>)this.fetchAllCampuss();
	}

	public List<CampusBean> undoCampus(CampusBean campusBean) throws SQLException {
		final String sql = "update campus set campus_status_id = 1  WHERE campus_id=" + campusBean.getCampusId();

		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<CampusBean>)this.fetchAllCampuss();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<CampusBean>)this.fetchAllCampuss();
	}

}
