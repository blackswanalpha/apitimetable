package com.example.timetable.app.mode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.timetable.app.mode.ModeBean;


@Repository
public class ModeDAO {
	PreparedStatement cst;
    Connection conn;
    @Autowired
    DataSource dataSource;
	public ModeDAO() {
		super();
		  this.cst = null;
	        this.conn = null;
	}
	
    public int getNextPrimaryKey() throws SQLException {
        final String column_name = "mode_id";
        final String table_name = "mode";
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
    
    
    
	
	 public List<ModeBean> fetchAllModes() throws SQLException {
	        final String selectSQL = "SELECT mode_id,mode_name,mode_desc	 FROM mode";
	        final List<ModeBean> modeList = new ArrayList<ModeBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            this.cst = this.conn.prepareStatement(selectSQL);
	            final ResultSet rs = this.cst.executeQuery();
	            while (rs.next()) {
	                final ModeBean mode = new ModeBean();
	                mode.setModeId(rs.getInt("mode_id"));
	                
	                mode.setModeName(rs.getString("mode_name"));
	                mode.setModeDesc(rs.getString("mode_desc"));
	               
	             
	                
	               
	                modeList.add(mode);
	            }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return modeList;
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return modeList;
	    }
	    public List<ModeBean> createMode(final ModeBean modeBean) throws SQLException {
	        final String selectSQL = "INSERT INTO mode(mode_id,mode_name,mode_desc) values(" + this.getNextPrimaryKey() + ", '" +  modeBean.getModeName() +  "', '" + modeBean.getModeDesc() +   "');";
	        List<ModeBean> modeList = new ArrayList<ModeBean>();
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<ModeBean>)this.fetchAllModes();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        modeList = (List<ModeBean>)this.fetchAllModes();
	        return modeList;
	    }
	    
	    public List<ModeBean> updateMode(final ModeBean modeBean) throws SQLException {
	        final String sql = "update mode set mode_name='" + modeBean.getModeName() +"',  mode_desc='" + modeBean.getModeDesc()  + "'  where mode_id=" + modeBean.getModeId();
	        System.out.println(sql);
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(sql)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<ModeBean>)this.fetchAllModes();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return (List<ModeBean>)this.fetchAllModes();
	    }
	    
	    public List<ModeBean> deleteMode(final ModeBean modeBean) throws SQLException {
	        final String sql = "DELETE FROM mode WHERE mode_id=" + modeBean.getModeId();
	        try {
	            this.conn = this.dataSource.getConnection();
	            (this.cst = this.conn.prepareStatement(sql)).execute();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return (List<ModeBean>)this.fetchAllModes();
	        }
	        finally {
	            this.conn.close();
	        }
	        this.conn.close();
	        return (List<ModeBean>)this.fetchAllModes();
	    }


}
