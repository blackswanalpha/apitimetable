package com.example.timetable.app.rank;

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
public class RankDAO {
	 PreparedStatement cst;
	    Connection conn;
	    @Autowired
	    DataSource dataSource;
		public RankDAO() {
			super();
			  this.cst = null;
		        this.conn = null;
		}
		
	    public int getNextPrimaryKey() throws SQLException {
	        final String column_name = "rank_id";
	        final String table_name = "RANK";
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
	    
	    
	    
		
		 public List<RankBean> fetchAllUsers() throws SQLException {
		        final String selectSQL = "SELECT rank_id,rank_status FROM rank";
		        final List<RankBean> userList = new ArrayList<RankBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            this.cst = this.conn.prepareStatement(selectSQL);
		            final ResultSet rs = this.cst.executeQuery();
		            while (rs.next()) {
		                final RankBean user = new RankBean();
		                user.setrank_id(rs.getLong("rank_id"));
		                user.setrank_status(rs.getString("rank_status"));
		               
		                userList.add(user);
		            }
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return userList;
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return userList;
		    }
		    public List<RankBean> createUser(final RankBean userBean) throws SQLException {
		        final String selectSQL = "INSERT INTO rank (rank_id, rank_status) values(" + this.getNextPrimaryKey() + ", '" + userBean.getrank_status() +  "');";
		        List<RankBean> userList = new ArrayList<RankBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<RankBean>)this.fetchAllUsers();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        userList = (List<RankBean>)this.fetchAllUsers();
		        return userList;
		    }
		    
		    public List<RankBean> updateGroup(final RankBean groupBean) throws SQLException {
		        final String sql = "update rank set rank_status='" + groupBean.getrank_status() + "'" + " where rank_id=" + groupBean.getrank_id();
		        System.out.println(sql);
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<RankBean>)this.fetchAllUsers();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<RankBean>)this.fetchAllUsers();
		    }
		    
		    public List<RankBean> deleteGroup(final RankBean groupBean) throws SQLException {
		        final String sql = "DELETE FROM rank WHERE rank_id=" + groupBean.getrank_id();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<RankBean>)this.fetchAllUsers();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<RankBean>)this.fetchAllUsers();
		    }
		    
		    
		    
		    
}
