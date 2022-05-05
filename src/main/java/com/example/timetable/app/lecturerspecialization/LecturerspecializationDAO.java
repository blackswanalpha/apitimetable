package com.example.timetable.app.lecturerspecialization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.example.timetable.app.lecturerspecialization.LecturerspecializationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.timetable.app.lecturerspecialization.LecturerspecializationBean;

@Repository
public class LecturerspecializationDAO {
	 PreparedStatement cst;
	    Connection conn;
	    @Autowired
	    DataSource dataSource;
		public LecturerspecializationDAO() {
			super();
			  this.cst = null;
		        this.conn = null;
		}
		
	    public int getNextPrimaryKey() throws SQLException {
	        final String column_name = "lecturer_specialization_id";
	        final String table_name = "lecturer_specialization";
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
	    
	    
	     
		
		 public List<LecturerspecializationBean> fetchAllLecturerspecializations() throws SQLException {
		        final String selectSQL = "SELECT lecturer_specialization_id,  lecturer_specialization_lecturer_id, lecturer_specialization_specialization_id	 	 FROM lecturer_specialization";
		        final List<LecturerspecializationBean> lecturerspecializationList = new ArrayList<LecturerspecializationBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            this.cst = this.conn.prepareStatement(selectSQL);
		            final ResultSet rs = this.cst.executeQuery();
		            while (rs.next()) {
		                final LecturerspecializationBean lecturerspecialization = new LecturerspecializationBean();
		                lecturerspecialization.setLecturerspecializationId(rs.getInt("lecturer_specialization_id"));
		                
		                lecturerspecialization.setLecturerspecializationLecturerId(rs.getInt("lecturer_specialization_lecturer_id"));
		                lecturerspecialization.setLecturerspecializationSpecializationId(rs.getInt("lecturer_specialization_specialization_id"));
		               
		             
		                
		               
		                lecturerspecializationList.add(lecturerspecialization);
		            }
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return lecturerspecializationList;
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return lecturerspecializationList;
		    }
		    public List<LecturerspecializationBean> createLecturerspecialization(final LecturerspecializationBean lecturerspecializationBean) throws SQLException {
		        final String selectSQL = "INSERT INTO lecturer_specialization(lecturer_specialization_id,  lecturer_specialization_lecturer_id, lecturer_specialization_specialization_id) values(" + this.getNextPrimaryKey() + ", " +  lecturerspecializationBean.getLecturerspecializationLecturerId() +  ", " + lecturerspecializationBean.getLecturerspecializationSpecializationId() +   ");";
		        List<LecturerspecializationBean> lecturerspecializationList = new ArrayList<LecturerspecializationBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<LecturerspecializationBean>)this.fetchAllLecturerspecializations();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        lecturerspecializationList = (List<LecturerspecializationBean>)this.fetchAllLecturerspecializations();
		        return lecturerspecializationList;
		    }
		    
		    public List<LecturerspecializationBean> updateLecturerspecialization(final LecturerspecializationBean lecturerspecializationBean) throws SQLException {
		        final String sql = "update lecturer_specialization set lecturer_specialization_lecturer_id=" + lecturerspecializationBean.getLecturerspecializationLecturerId() +",  lecturer_specialization_specialization_id=" + lecturerspecializationBean.getLecturerspecializationSpecializationId()  + "  where lecturer_specialization_id=" + lecturerspecializationBean.getLecturerspecializationId();
		        System.out.println(sql);
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<LecturerspecializationBean>)this.fetchAllLecturerspecializations();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<LecturerspecializationBean>)this.fetchAllLecturerspecializations();
		    }

	public List<LecturerspecializationBean> deleteLecturerspecialization(final LecturerspecializationBean lecturerspecializationBean) throws SQLException {
		final String sql = "update lecturerspecialization set lecturerspecialization_status_id = 2  WHERE lecturerspecialization_id=" +lecturerspecializationBean.getLecturerspecializationId();
		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<LecturerspecializationBean>)this.fetchAllLecturerspecializations();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<LecturerspecializationBean>)this.fetchAllLecturerspecializations();
	}

	public List<LecturerspecializationBean> undoLecturerspecialization(LecturerspecializationBean lecturerspecializationBean) throws SQLException {
		final String sql = "update lecturerspecialization set lecturerspecialization_status_id = 1  WHERE lecturerspecialization_id=" + lecturerspecializationBean.getLecturerspecializationId();

		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<LecturerspecializationBean>)this.fetchAllLecturerspecializations();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<LecturerspecializationBean>)this.fetchAllLecturerspecializations();
	}

}

