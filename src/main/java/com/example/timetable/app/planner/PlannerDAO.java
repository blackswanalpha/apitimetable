package com.example.timetable.app.planner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.example.timetable.app.planner.PlannerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PlannerDAO {
	 PreparedStatement cst;
	    Connection conn;
	    @Autowired
	    DataSource dataSource;
		public PlannerDAO() {
			super();
			  this.cst = null;
		        this.conn = null;
		}
		
	    public int getNextPrimaryKey() throws SQLException {
	        final String column_name = "planner_id";
	        final String table_name = "planner";
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
	    
	    
	    
		
		 public List<PlannerBean> fetchAllPlanners() throws SQLException {
		        final String selectSQL = "SELECT planner_id,planner_semester_id,planner_unit_id,semester_name,unit_name	 FROM planner,semester,unit  where not planner_status_id = 2 and planner_semester_id= semester_id and planner_unit_id = unit_id";
		        final List<PlannerBean> plannerList = new ArrayList<PlannerBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            this.cst = this.conn.prepareStatement(selectSQL);
		            final ResultSet rs = this.cst.executeQuery();
		            while (rs.next()) {
		                final PlannerBean planner = new PlannerBean();
		                planner.setPlannerId(rs.getInt("planner_id"));
						planner.setSemesterName(rs.getString("semester_name"));
						planner.setUnitName(rs.getString("unit_name"));
		                planner.setPlannerSemesterId(rs.getInt("planner_semester_id"));
		                planner.setPlannerUnitId(rs.getInt("planner_unit_id"));
		               
		             
		                
		               
		                plannerList.add(planner);
		            }
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return plannerList;
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return plannerList;
		    }
		    public List<PlannerBean> createPlanner(final PlannerBean plannerBean) throws SQLException {
		        final String selectSQL = "INSERT INTO planner(planner_id,planner_semester_id,planner_unit_id,planner_status_id) values(" + this.getNextPrimaryKey() + ", " +  plannerBean.getPlannerSemesterId() +  ", " + plannerBean.getPlannerUnitId() +   ",1);";
		        List<PlannerBean> plannerList = new ArrayList<PlannerBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<PlannerBean>)this.fetchAllPlanners();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        plannerList = (List<PlannerBean>)this.fetchAllPlanners();
		        return plannerList;
		    }
		    
		    public List<PlannerBean> updatePlanner(final PlannerBean plannerBean) throws SQLException {
		        final String sql = "update planner set planner_semester_id=" + plannerBean.getPlannerSemesterId() +",  planner_unit_id=" + plannerBean.getPlannerUnitId()  + "  where planner_id=" + plannerBean.getPlannerId();
		        System.out.println(sql);
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<PlannerBean>)this.fetchAllPlanners();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<PlannerBean>)this.fetchAllPlanners();
		    }


	public List<PlannerBean> deletePlanner(final PlannerBean plannerBean) throws SQLException {
		final String sql = "update planner set planner_status_id = 2  WHERE planner_id=" +plannerBean.getPlannerId();
		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<PlannerBean>)this.fetchAllPlanners();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<PlannerBean>)this.fetchAllPlanners();
	}

	public List<PlannerBean> undoPlanner(PlannerBean plannerBean) throws SQLException {
		final String sql = "update planner set planner_status_id = 1  WHERE planner_id=" + plannerBean.getPlannerId();

		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<PlannerBean>)this.fetchAllPlanners();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<PlannerBean>)this.fetchAllPlanners();
	}


}
