package com.example.timetable.app.faculty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.example.timetable.app.faculty.FacultyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;






@Repository
public class FacultyDAO {

	
	
	 PreparedStatement cst;
	    Connection conn;
	    @Autowired
	    DataSource dataSource;
		public FacultyDAO() {
			super();
			  this.cst = null;
		        this.conn = null;
		}
		
	    public int getNextPrimaryKey() throws SQLException {
	        final String column_name = "faculty_id";
	        final String table_name = "faculty";
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
	    
	    
	    
		
		 public List<FacultyBean> fetchAllFacultys() throws SQLException {
		        final String selectSQL = "SELECT faculty_id,faculty_name,faculty_desc,faculty_email,faculty_mobile,faculty_institution_id	 FROM faculty where not faculty_status_id = 2";
		        final List<FacultyBean> facultyList = new ArrayList<FacultyBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            this.cst = this.conn.prepareStatement(selectSQL);
		            final ResultSet rs = this.cst.executeQuery();
		            while (rs.next()) {
		                final FacultyBean faculty = new FacultyBean();
		                faculty.setFacultyId(rs.getInt("faculty_id"));
		                
		                faculty.setFacultyName(rs.getString("faculty_name"));
		                faculty.setFacultyDesc(rs.getString("faculty_desc"));
		                faculty.setFacultyEmail(rs.getString("faculty_email"));


						faculty.setFacultyInstitutionId(rs.getInt("faculty_institution_id"));
		                faculty.setFacultyMobile(rs.getInt("faculty_mobile"));
		                
		               
		                facultyList.add(faculty);
		            }
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return facultyList;
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return facultyList;
		    }
		    public List<FacultyBean> createFaculty(final FacultyBean facultyBean) throws SQLException {
		        final String selectSQL = "INSERT INTO faculty(faculty_id,faculty_name,faculty_desc,faculty_email,faculty_mobile,faculty_institution_id,faculty_status_id) values(" + this.getNextPrimaryKey() + ", '" +  facultyBean.getFacultyName() +  "', '" + facultyBean.getFacultyDesc()+  "', '" + facultyBean.getFacultyEmail() +  "', "  + facultyBean.getFacultyMobile()+ ", "  + facultyBean.getFacultyInstitutionId()+ ",1);";
		        List<FacultyBean> facultyList = new ArrayList<FacultyBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<FacultyBean>)this.fetchAllFacultys();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        facultyList = (List<FacultyBean>)this.fetchAllFacultys();
		        return facultyList;
		    }
		    
		    public List<FacultyBean> updateFaculty(final FacultyBean facultyBean) throws SQLException {
		        final String sql = "update faculty set faculty_name='" + facultyBean.getFacultyName() +"', faculty_desc='" + facultyBean.getFacultyDesc()+"', faculty_email='"+ facultyBean.getFacultyEmail() +"',  faculty_mobile=" + facultyBean.getFacultyMobile()  + " where faculty_id=" + facultyBean.getFacultyId();
		        System.out.println(sql);
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<FacultyBean>)this.fetchAllFacultys();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<FacultyBean>)this.fetchAllFacultys();
		    }

	public List<FacultyBean> deleteFaculty(final FacultyBean facultyBean) throws SQLException {
		final String sql = "update faculty set faculty_status_id = 2  WHERE faculty_id=" +facultyBean.getFacultyId();
		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<FacultyBean>)this.fetchAllFacultys();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<FacultyBean>)this.fetchAllFacultys();
	}

	public List<FacultyBean> undoFaculty(FacultyBean facultyBean) throws SQLException {
		final String sql = "update faculty set faculty_status_id = 1  WHERE faculty_id=" + facultyBean.getFacultyId();

		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<FacultyBean>)this.fetchAllFacultys();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<FacultyBean>)this.fetchAllFacultys();
	}



}
