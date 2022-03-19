package com.example.timetable.app.unit;

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
public class UnitDAO {
	
	 PreparedStatement cst;
	    Connection conn;
	    @Autowired
	    DataSource dataSource;
		public UnitDAO() {
			super();
			  this.cst = null;
		        this.conn = null;
		}
		
	    public int getNextPrimaryKey() throws SQLException {
	        final String column_name = "unit_id";
	        final String table_name = "unit";
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
	    
	    
	    
		
		 public List<UnitBean> fetchAllUnits() throws SQLException {
		        final String selectSQL = "SELECT unit_id,unit_name,unit_desc,unit_code,unit_course_id,unit_specialization_id ,unit_requireS_lab		 FROM unit where not  unit_status_id = 2 ";
		        final List<UnitBean> unitList = new ArrayList<UnitBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            this.cst = this.conn.prepareStatement(selectSQL);
		            final ResultSet rs = this.cst.executeQuery();
		            while (rs.next()) {
		                final UnitBean unit = new UnitBean();
		                unit.setUnitId(rs.getInt("unit_id"));
		                
		                unit.setUnitName(rs.getString("unit_name"));
		                unit.setUnitDesc(rs.getString("unit_desc"));
		                unit.setUnitCode(rs.getString("unit_code"));
		                unit.setUnitRequireLab(rs.getString("unit_requires_lab"));
	             
		                unit.setUnitCourseId(rs.getInt("unit_course_id"));
		                unit.setUnitSpecializationId(rs.getInt("unit_specialization_id"));
		               
		                unitList.add(unit);
		            }
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return unitList;
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return unitList;
		    }
		    public List<UnitBean> createUnit(final UnitBean unitBean) throws SQLException {
		        final String selectSQL = "INSERT INTO unit(unit_id,unit_code,unit_name,unit_desc,unit_requires_lab,unit_course_id,unit_specialization_id,unit_status_id) values(" + this.getNextPrimaryKey()+ ", '" +  unitBean.getUnitCode() + "', '" +  unitBean.getUnitName() +  "', '" + unitBean.getUnitDesc()+  "', '" + unitBean.getUnitRequireLab() +  "', "  + unitBean.getUnitCourseId()+", "  + unitBean.getUnitSpecializationId()+ ",1);";
		        List<UnitBean> unitList = new ArrayList<UnitBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<UnitBean>)this.fetchAllUnits();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        unitList = (List<UnitBean>)this.fetchAllUnits();
		        return unitList;
		    }
		    
		    public List<UnitBean> updateUnit(final UnitBean unitBean) throws SQLException {
		        final String sql = "update unit set unit_name='" + unitBean.getUnitName()+"', unit_code=" + unitBean.getUnitCode() +", unit_desc='" + unitBean.getUnitDesc()+"', unit_requires_lab='"+ unitBean.getUnitRequireLab() +"',  unit_course_id=" + unitBean.getUnitCourseId()+",  unit_specialization_id=" + unitBean.getUnitSpecializationId()  + " where unit_id=" + unitBean.getUnitId();
		        System.out.println(sql);
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<UnitBean>)this.fetchAllUnits();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<UnitBean>)this.fetchAllUnits();
		    }
		    
		    public List<UnitBean> deleteUnit(final UnitBean unitBean) throws SQLException {
		        final String sql = "update unit set unit_status_id = 2  WHERE unit_id=" + unitBean.getUnitId();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<UnitBean>)this.fetchAllUnits();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<UnitBean>)this.fetchAllUnits();
		    }


	public List<UnitBean> undoUnit(UnitBean unitBean) throws SQLException {
		final String sql = "update unit set unit_status_id = 1  WHERE unit_id=" + unitBean.getUnitId();

		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<UnitBean>)this.fetchAllUnits();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<UnitBean>)this.fetchAllUnits();
	}
}
