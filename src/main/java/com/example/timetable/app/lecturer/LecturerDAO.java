package com.example.timetable.app.lecturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.example.timetable.app.lecturer.LecturerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class LecturerDAO {
	PreparedStatement cst;
    Connection conn;
    @Autowired
    DataSource dataSource;
	public LecturerDAO() {
		super();
		  this.cst = null;
	        this.conn = null;
	}
	
    public int getNextPrimaryKey() throws SQLException {
        final String column_name = "lecturer_id";
        final String table_name = "lecturer";
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
    
    
    
	
	 public List<LecturerBean> fetchAllLecturers() throws SQLException {
	        final String selectSQL = "SELECT lecturer_id,lecturer_name,lecturer_contact,lecturer_email,lecturer_staff_no,lecturer_image,lecturer_gender,lecturer_location,lecturer_active,lecturer_type_id,lecturer_login_id	 FROM lecturer";
	        final List<LecturerBean> lecturerList = new ArrayList<LecturerBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            this.cst = this.conn.prepareStatement(selectSQL);
	            final ResultSet rs = this.cst.executeQuery();
	            while (rs.next()) {
	                final LecturerBean lecturer = new LecturerBean();
	                lecturer.setLecturerId(rs.getInt("lecturer_id"));
	                
	                lecturer.setLecturerName(rs.getString("lecturer_name"));
	                lecturer.setLecturerEmail(rs.getString("lecturer_email"));
	                lecturer.setLecturerImage(rs.getString("lecturer_image"));
	                lecturer.setLecturerGender(rs.getString("lecturer_gender"));
	                lecturer.setLecturerLocation(rs.getString("lecturer_location"));
	                lecturer.setLecturerActive(rs.getString("lecturer_active"));
	                lecturer.setLecturerContact(rs.getInt("lecturer_contact"));
	                lecturer.setLecturerLoginId(rs.getInt("lecturer_login_id"));               
	                lecturer.setLecturerTypeId(rs.getInt("lecturer_staff_no"));
	                lecturer.setLecturerStaffNo(rs.getInt("lecturer_type_id"));
	      	      
	      	            
	                
	               
	                lecturerList.add(lecturer);
	            }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return lecturerList;
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return lecturerList;
	    }
	    public List<LecturerBean> createLecturer(final LecturerBean lecturerBean) throws SQLException {
	        final String selectSQL = "INSERT INTO lecturer(lecturer_id,lecturer_name,lecturer_email,lecturer_image,lecturer_gender,lecturer_location,lecturer_active,lecturer_login_id,lecturer_staff_no,lecturer_type_id,lecturer_contact) values(" + this.getNextPrimaryKey() + ", '" +  lecturerBean.getLecturerName() +  "', '" + lecturerBean.getLecturerEmail() +  "', '" + lecturerBean.getLecturerImage() +  "', '" + lecturerBean.getLecturerGender() +  "', '" + lecturerBean.getLecturerLocation() +  "', '" + lecturerBean.getLecturerActive() +  "', " + lecturerBean.getLecturerLoginId() +  ", " + lecturerBean.getLecturerStaffNo() +  ", " + lecturerBean.getLecturerTypeId() +  ", " + lecturerBean.getLecturerContact()+   ");";
	        List<LecturerBean> lecturerList = new ArrayList<LecturerBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<LecturerBean>)this.fetchAllLecturers();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        lecturerList = (List<LecturerBean>)this.fetchAllLecturers();
	        return lecturerList;
	    }
	    
	    public List<LecturerBean> updateLecturer(final LecturerBean lecturerBean) throws SQLException {
	        final String sql = "update lecturer set lecturer_name='" + lecturerBean.getLecturerName() +"',  lecturer_email='" + lecturerBean.getLecturerEmail()+"',  lecturer_image='" + lecturerBean.getLecturerImage()+"',  lecturer_gender='" + lecturerBean.getLecturerGender()+"',  lecturer_location='" + lecturerBean.getLecturerLocation()+"',  lecturer_active='" + lecturerBean.getLecturerActive()+"',  lecturer_email='" + lecturerBean.getLecturerEmail()+"',  lecturer_login_id=" + lecturerBean.getLecturerLoginId()+"',  lecturer_staff_no=" + lecturerBean.getLecturerStaffNo()+",  lecturer_type_id=" + lecturerBean.getLecturerTypeId() +",  lecturer_contact=" + lecturerBean.getLecturerContact()   + "  where lecturer_id=" + lecturerBean.getLecturerId();
	        System.out.println(sql);
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(sql)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<LecturerBean>)this.fetchAllLecturers();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return (List<LecturerBean>)this.fetchAllLecturers();
	    }

	public List<LecturerBean> deleteLecturer(final LecturerBean lecturerBean) throws SQLException {
		final String sql = "update lecturer set lecturer_status_id = 2  WHERE lecturer_id=" +lecturerBean.getLecturerId();
		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<LecturerBean>)this.fetchAllLecturers();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<LecturerBean>)this.fetchAllLecturers();
	}

	public List<LecturerBean> undoLecturer(LecturerBean lecturerBean) throws SQLException {
		final String sql = "update lecturer set lecturer_status_id = 1  WHERE lecturer_id=" + lecturerBean.getLecturerId();

		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<LecturerBean>)this.fetchAllLecturers();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<LecturerBean>)this.fetchAllLecturers();
	}


}
