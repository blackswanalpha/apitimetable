package com.example.timetable.app.semester;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.example.timetable.app.semester.SemesterBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SemesterDAO {
	PreparedStatement cst;
    Connection conn;
    @Autowired
    DataSource dataSource;
	public SemesterDAO() {
		super();
		  this.cst = null;
	        this.conn = null;
	}
	
    public int getNextPrimaryKey() throws SQLException {
        final String column_name = "semester_id";
        final String table_name = "semester";
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
    
    
    
	
	 public List<SemesterBean> fetchAllSemesters() throws SQLException {
	        final String selectSQL = "SELECT semester_id,semester_name,semester_year	 FROM semester where not  semester_status_id = 2";
	        final List<SemesterBean> semesterList = new ArrayList<SemesterBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            this.cst = this.conn.prepareStatement(selectSQL);
	            final ResultSet rs = this.cst.executeQuery();
	            while (rs.next()) {
	                final SemesterBean semester = new SemesterBean();
	                semester.setSemesterId(rs.getInt("semester_id"));
	                
	                semester.setSemesterName(rs.getString("semester_name"));
	                semester.setSemesterYear(rs.getInt("semester_year"));
	               
	             
	                
	               
	                semesterList.add(semester);
	            }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return semesterList;
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return semesterList;
	    }
	    public List<SemesterBean> createSemester(final SemesterBean semesterBean) throws SQLException {
	        final String selectSQL = "INSERT INTO semester(semester_id,semester_name,semester_year,semester_status_id) values(" + this.getNextPrimaryKey() + ", '" +  semesterBean.getSemesterName() +  "', " + semesterBean.getSemesterYear() +   ",1);";
	        List<SemesterBean> semesterList = new ArrayList<SemesterBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<SemesterBean>)this.fetchAllSemesters();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        semesterList = (List<SemesterBean>)this.fetchAllSemesters();
	        return semesterList;
	    }
	    
	    public List<SemesterBean> updateSemester(final SemesterBean semesterBean) throws SQLException {
	        final String sql = "update semester set semester_name='" + semesterBean.getSemesterName() +"',  semester_year=" + semesterBean.getSemesterYear()  + "  where semester_id=" + semesterBean.getSemesterId();
	        System.out.println(sql);
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(sql)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<SemesterBean>)this.fetchAllSemesters();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return (List<SemesterBean>)this.fetchAllSemesters();
	    }

	public List<SemesterBean> deleteSemester(final SemesterBean semesterBean) throws SQLException {
		final String sql = "update semester set semester_status_id = 2  WHERE semester_id=" + semesterBean.getSemesterId();
		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<SemesterBean>)this.fetchAllSemesters();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<SemesterBean>)this.fetchAllSemesters();
	}


	public List<SemesterBean> undoSemester(SemesterBean semesterBean) throws SQLException {
		final String sql = "update semester set semester_status_id = 1  WHERE semester_id=" + semesterBean.getSemesterId();

		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<SemesterBean>)this.fetchAllSemesters();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<SemesterBean>)this.fetchAllSemesters();
	}
}
