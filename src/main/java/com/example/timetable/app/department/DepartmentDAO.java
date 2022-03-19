package com.example.timetable.app.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.example.timetable.app.department.DepartmentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class DepartmentDAO {
	
	
	 PreparedStatement cst;
	    Connection conn;
	    @Autowired
	    DataSource dataSource;
		public DepartmentDAO() {
			super();
			  this.cst = null;
		        this.conn = null;
		}
		
	    public int getNextPrimaryKey() throws SQLException {
	        final String column_name = "department_id";
	        final String table_name = "department";
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
	    
	    
	    
		
		 public List<DepartmentBean> fetchAllDepartments() throws SQLException {
		        final String selectSQL = "SELECT department_id,department_name,department_desc,department_email,department_mobile,department_faculty_id	 FROM department where not department_status_id = 2";
		        final List<DepartmentBean> departmentList = new ArrayList<DepartmentBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            this.cst = this.conn.prepareStatement(selectSQL);
		            final ResultSet rs = this.cst.executeQuery();
		            while (rs.next()) {
		                final DepartmentBean department = new DepartmentBean();
		                department.setDepartmentId(rs.getInt("department_id"));
		                
		                department.setDepartmentName(rs.getString("department_name"));
		                department.setDepartmentDesc(rs.getString("department_desc"));
		                department.setDepartmentEmail(rs.getString("department_email"));
		               
	             
		                department.setDepartmentMobile(rs.getInt("department_mobile"));
		                department.setDepartmentFacultyId(rs.getInt("department_faculty_id"));
		               
		                departmentList.add(department);
		            }
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return departmentList;
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return departmentList;
		    }
		    public List<DepartmentBean> createDepartment(final DepartmentBean departmentBean) throws SQLException {
		        final String selectSQL = "INSERT INTO department(department_id,department_name,department_desc,department_email,department_mobile,department_faculty_id,department_status_id) values(" + this.getNextPrimaryKey() + ", '" +  departmentBean.getDepartmentName() +  "', '" + departmentBean.getDepartmentDesc()+  "', '" + departmentBean.getDepartmentEmail() +  "', "  + departmentBean.getDepartmentMobile()+", "  + departmentBean.getDepartmentFacultyId()+ ",1);";
		        List<DepartmentBean> departmentList = new ArrayList<DepartmentBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<DepartmentBean>)this.fetchAllDepartments();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        departmentList = (List<DepartmentBean>)this.fetchAllDepartments();
		        return departmentList;
		    }
		    
		    public List<DepartmentBean> updateDepartment(final DepartmentBean departmentBean) throws SQLException {
		        final String sql = "update department set department_name='" + departmentBean.getDepartmentName() +"', department_desc='" + departmentBean.getDepartmentDesc()+"', department_email='"+ departmentBean.getDepartmentEmail() +"',  department_mobile=" + departmentBean.getDepartmentMobile()+",  department_faculty_id=" + departmentBean.getDepartmentFacultyId()  + " where department_id=" + departmentBean.getDepartmentId();
		        System.out.println(sql);
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<DepartmentBean>)this.fetchAllDepartments();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<DepartmentBean>)this.fetchAllDepartments();
		    }

	public List<DepartmentBean> deleteDepartment(final DepartmentBean departmentBean) throws SQLException {
		final String sql = "update department set department_status_id = 2  WHERE department_id=" +departmentBean.getDepartmentId();
		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<DepartmentBean>)this.fetchAllDepartments();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<DepartmentBean>)this.fetchAllDepartments();
	}

	public List<DepartmentBean> undoDepartment(DepartmentBean departmentBean) throws SQLException {
		final String sql = "update department set department_status_id = 1  WHERE department_id=" + departmentBean.getDepartmentId();

		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<DepartmentBean>)this.fetchAllDepartments();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<DepartmentBean>)this.fetchAllDepartments();
	}



}
