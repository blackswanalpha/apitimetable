package com.example.timetable.app.building;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.example.timetable.app.building.BuildingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class BuildingDAO {
	PreparedStatement cst;
    Connection conn;
    @Autowired
    DataSource dataSource;
	public BuildingDAO() {
		super();
		  this.cst = null;
	        this.conn = null;
	}
	
    public int getNextPrimaryKey() throws SQLException {
        final String column_name = "building_id";
        final String table_name = "building";
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
    
    
    
	
	 public List<BuildingBean> fetchAllBuildings() throws SQLException {
	        final String selectSQL = "SELECT building_id,building_name,building_desc,building_campus_id	 FROM building  where not building_status_id = 2";
	        final List<BuildingBean> buildingList = new ArrayList<BuildingBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            this.cst = this.conn.prepareStatement(selectSQL);
	            final ResultSet rs = this.cst.executeQuery();
	            while (rs.next()) {
	                final BuildingBean building = new BuildingBean();
	                building.setBuildingId(rs.getInt("building_id"));
					building.setBuildingCampusId(	rs.getInt("building_campus_id"));
	                building.setBuildingName(rs.getString("building_name"));
	                building.setBuildingDesc(rs.getString("building_desc"));
	               
	             
	                
	               
	                buildingList.add(building);
	            }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return buildingList;
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return buildingList;
	    }
	    public List<BuildingBean> createBuilding(final BuildingBean buildingBean) throws SQLException {
	        final String selectSQL = "INSERT INTO building(building_id,building_name,building_desc,building_campus_id	,building_status_id) values(" + this.getNextPrimaryKey() + ", '" +  buildingBean.getBuildingName() +  "', '" + buildingBean.getBuildingDesc() + "', " + buildingBean.getBuildingCampusId() +   ",1);";
	        List<BuildingBean> buildingList = new ArrayList<BuildingBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<BuildingBean>)this.fetchAllBuildings();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        buildingList = (List<BuildingBean>)this.fetchAllBuildings();
	        return buildingList;
	    }
	    
	    public List<BuildingBean> updateBuilding(final BuildingBean buildingBean) throws SQLException {
	        final String sql = "update building set building_name='" + buildingBean.getBuildingName() +"',  building_desc='" + buildingBean.getBuildingDesc() +"',  building_campus_id='" + buildingBean.getBuildingCampusId() + "  where building_id=" + buildingBean.getBuildingId();
	        System.out.println(sql);
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(sql)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<BuildingBean>)this.fetchAllBuildings();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return (List<BuildingBean>)this.fetchAllBuildings();
	    }

	public List<BuildingBean> deleteBuilding(final BuildingBean buildingBean) throws SQLException {
		final String sql = "update building set building_status_id = 2  WHERE building_id=" +buildingBean.getBuildingId();
		final String sqlroom = "update room set room_status_id = 2  WHERE room_building_id=" +buildingBean.getBuildingId();
		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
			(this.cst = this.conn.prepareStatement(sqlroom)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<BuildingBean>)this.fetchAllBuildings();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<BuildingBean>)this.fetchAllBuildings();
	}

	public List<BuildingBean> undoBuilding(BuildingBean buildingBean) throws SQLException {
		final String sql = "update building set building_status_id = 1  WHERE building_id=" + buildingBean.getBuildingId();
		final String sqlroom = "update room set room_status_id = 1  WHERE room_building_id=" +buildingBean.getBuildingId();
		try {
			this.conn = this.dataSource.getConnection();
			(this.cst = this.conn.prepareStatement(sql)).execute();
			(this.cst = this.conn.prepareStatement(sqlroom)).execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			return (List<BuildingBean>)this.fetchAllBuildings();
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return (List<BuildingBean>)this.fetchAllBuildings();
	}


}
