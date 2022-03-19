package com.example.timetable.app.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.example.timetable.app.course.CourseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class CourseDAO {
	 PreparedStatement cst;
	    Connection conn;
	    @Autowired
	    DataSource dataSource;
		public CourseDAO() {
			super();
			  this.cst = null;
		        this.conn = null;
		}
		
	    public int getNextPrimaryKey() throws SQLException {
	        final String column_name = "course_id";
	        final String table_name = "course";
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
	    
	    
	    
		
		 public List<CourseBean> fetchAllCourses() throws SQLException {
		        final String selectSQL = "SELECT course_id,course_name,course_desc,course_department_id	 FROM course where not course_status_id = 2";
		        final List<CourseBean>courseList = new ArrayList<CourseBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            this.cst = this.conn.prepareStatement(selectSQL);
		            final ResultSet rs = this.cst.executeQuery();
		            while (rs.next()) {
		                final CourseBean course = new CourseBean();
		               course.setCourseId(rs.getInt("course_id"));
		                
		               course.setCourseName(rs.getString("course_name"));
		               course.setCourseDepartmentId(rs.getInt("course_department_id"));
		               course.setCourseDesc(rs.getString("course_desc"));
		               

		               
		               courseList.add(course);
		            }
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return courseList;
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return courseList;
		    }
		    public List<CourseBean> createCourse(final CourseBean courseBean) throws SQLException {
		        final String selectSQL = "INSERT INTO course(course_id,course_name,course_department_id,course_desc,course_status_id) values(" + this.getNextPrimaryKey() + ", '" + courseBean.getCourseName() +  "', " +courseBean.getCourseDepartmentId()+  ", '" +courseBean.getCourseDesc() +  "',1);";
		        List<CourseBean>courseList = new ArrayList<CourseBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<CourseBean>)this.fetchAllCourses();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		       courseList = (List<CourseBean>)this.fetchAllCourses();
		        return courseList;
		    }
		    
		    public List<CourseBean> updateCourse(final CourseBean courseBean) throws SQLException {
		        final String sql = "update course set course_name='" + courseBean.getCourseName() +"', course_department_id=" +courseBean.getCourseDepartmentId()+",course_desc='"+courseBean.getCourseDesc() + "' where course_id=" +courseBean.getCourseId();
		        System.out.println(sql);
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<CourseBean>)this.fetchAllCourses();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<CourseBean>)this.fetchAllCourses();
		    }
		    
		    public List<CourseBean> deleteCourse(final CourseBean courseBean) throws SQLException {
		        final String sql = "update course set course_status_id = 2  WHERE course_id=" +courseBean.getCourseId();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<CourseBean>)this.fetchAllCourses();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<CourseBean>)this.fetchAllCourses();
		    }

	public List<CourseBean> undoCourse(CourseBean courseBean) throws SQLException {
		final String sql = "update course set course_status_id = 1  WHERE course_id=" + courseBean.getCourseId();

		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<CourseBean>)this.fetchAllCourses();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<CourseBean>)this.fetchAllCourses();
	}

}
