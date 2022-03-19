package com.example.timetable.app.specialization;

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
public class SpecializationDAO {
	 PreparedStatement cst;
	    Connection conn;
	    @Autowired
	    DataSource dataSource;
		public SpecializationDAO() {
			super();
			  this.cst = null;
		        this.conn = null;
		}
		
	    public int getNextPrimaryKey() throws SQLException {
	        final String column_name = "specialization_id";
	        final String table_name = "specialization";
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
	    
	    
	    
		
		 public List<SpecializationBean> fetchAllSpecializations() throws SQLException {
		        final String selectSQL = "SELECT specialization_id,specialization_name,specialization_desc	 FROM specialization";
		        final List<SpecializationBean> specializationList = new ArrayList<SpecializationBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            this.cst = this.conn.prepareStatement(selectSQL);
		            final ResultSet rs = this.cst.executeQuery();
		            while (rs.next()) {
		                final SpecializationBean specialization = new SpecializationBean();
		                specialization.setSpecializationId(rs.getInt("specialization_id"));
		                
		                specialization.setSpecializationName(rs.getString("specialization_name"));
		                specialization.setSpecializationDesc(rs.getString("specialization_desc"));
		               
		             
		                
		               
		                specializationList.add(specialization);
		            }
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return specializationList;
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return specializationList;
		    }
		    public List<SpecializationBean> createSpecialization(final SpecializationBean specializationBean) throws SQLException {
		        final String selectSQL = "INSERT INTO specialization(specialization_id,specialization_name,specialization_desc) values(" + this.getNextPrimaryKey() + ", '" +  specializationBean.getSpecializationName() +  "', '" + specializationBean.getSpecializationDesc() +   "');";
		        List<SpecializationBean> specializationList = new ArrayList<SpecializationBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<SpecializationBean>)this.fetchAllSpecializations();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        specializationList = (List<SpecializationBean>)this.fetchAllSpecializations();
		        return specializationList;
		    }
		    
		    public List<SpecializationBean> updateSpecialization(final SpecializationBean specializationBean) throws SQLException {
		        final String sql = "update specialization set specialization_name='" + specializationBean.getSpecializationName() +"',  specialization_desc='" + specializationBean.getSpecializationDesc()  + "'  where specialization_id=" + specializationBean.getSpecializationId();
		        System.out.println(sql);
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<SpecializationBean>)this.fetchAllSpecializations();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<SpecializationBean>)this.fetchAllSpecializations();
		    }
		    
		    public List<SpecializationBean> deleteSpecialization(final SpecializationBean specializationBean) throws SQLException {
		        final String sql = "DELETE FROM specialization WHERE specialization_id=" + specializationBean.getSpecializationId();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<SpecializationBean>)this.fetchAllSpecializations();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<SpecializationBean>)this.fetchAllSpecializations();
		    }

}
