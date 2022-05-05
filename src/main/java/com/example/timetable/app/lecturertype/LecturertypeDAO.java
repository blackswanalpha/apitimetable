package com.example.timetable.app.lecturertype;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.example.timetable.app.lecturertype.LecturertypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class LecturertypeDAO {
	PreparedStatement cst;
    Connection conn;
    @Autowired
    DataSource dataSource;
	public LecturertypeDAO() {
		super();
		  this.cst = null;
	        this.conn = null;
	}
	
    public int getNextPrimaryKey() throws SQLException {
        final String column_name = "lecturer_type_id";
        final String table_name = "lecturer_type";
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
    
    
    
	
	 public List<LecturertypeBean> fetchAllLecturertypes() throws SQLException {
	        final String selectSQL = "SELECT lecturer_type_id,lecturer_type_name,lecturer_type_desc,lecturer_type_max_no_of_units	 FROM lecturer_type where not lecturer_type_status_id = 2";
	        final List<LecturertypeBean> lecturertypeList = new ArrayList<LecturertypeBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            this.cst = this.conn.prepareStatement(selectSQL);
	            final ResultSet rs = this.cst.executeQuery();
	            while (rs.next()) {
	                final LecturertypeBean lecturertype = new LecturertypeBean();
	                lecturertype.setLecturertypeId(rs.getInt("lecturer_type_id"));
	                
	                lecturertype.setLecturertypeName(rs.getString("lecturer_type_name"));
	                lecturertype.setLecturertypeDesc(rs.getString("lecturer_type_desc"));
	                lecturertype.setLecturertypeMax(rs.getInt("lecturer_type_max_no_of_units"));
	    	        
	             
	                
	               
	                lecturertypeList.add(lecturertype);
	            }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return lecturertypeList;
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return lecturertypeList;
	    }
	    public List<LecturertypeBean> createLecturertype(final LecturertypeBean lecturertypeBean) throws SQLException {
	        final String selectSQL = "INSERT INTO lecturer_type(lecturer_type_id,lecturer_type_name,lecturer_type_desc,lecturer_type_max_no_of_units,lecturer_type_status_id 	) values(" + this.getNextPrimaryKey() + ", '" +  lecturertypeBean.getLecturertypeName() +  "', '" + lecturertypeBean.getLecturertypeDesc()+  "', " + lecturertypeBean.getLecturertypeMax() +   ",1);";
	        List<LecturertypeBean> lecturertypeList = new ArrayList<LecturertypeBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<LecturertypeBean>)this.fetchAllLecturertypes();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        lecturertypeList = (List<LecturertypeBean>)this.fetchAllLecturertypes();
	        return lecturertypeList;
	    }
	    
	    public List<LecturertypeBean> updateLecturertype(final LecturertypeBean lecturertypeBean) throws SQLException {
	        final String sql = "update lecturer_type set lecturer_type_name='" + lecturertypeBean.getLecturertypeName() +"',  lecturer_type_desc='" + lecturertypeBean.getLecturertypeDesc()+"',  lecturer_type_max_no_of_lecturertypes=" + lecturertypeBean.getLecturertypeMax()  + "  where lecturer_type_id=" + lecturertypeBean.getLecturertypeId();
	        System.out.println(sql);
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(sql)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<LecturertypeBean>)this.fetchAllLecturertypes();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return (List<LecturertypeBean>)this.fetchAllLecturertypes();
	    }

	public List<LecturertypeBean> deleteLecturertype(final LecturertypeBean lecturertypeBean) throws SQLException {
		final String sql = "update lecturer_type set lecturer_type_status_id = 2  WHERE lecturer_type_id=" + lecturertypeBean.getLecturertypeId();
		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<LecturertypeBean>)this.fetchAllLecturertypes();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<LecturertypeBean>)this.fetchAllLecturertypes();
	}


	public List<LecturertypeBean> undoLecturertype(LecturertypeBean lecturertypeBean) throws SQLException {
		final String sql = "update lecturer_type set lecturer_type_status_id = 1  WHERE lecturer_type_id=" + lecturertypeBean.getLecturertypeId();

		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<LecturertypeBean>)this.fetchAllLecturertypes();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<LecturertypeBean>)this.fetchAllLecturertypes();
	}

}
