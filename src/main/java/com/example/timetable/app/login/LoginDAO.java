package com.example.timetable.app.login;

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
public class LoginDAO {

	
	 PreparedStatement cst;
	    Connection conn;
	    @Autowired
	    DataSource dataSource;
		public LoginDAO() {
			super();
			  this.cst = null;
		        this.conn = null;
		}
		
	    public int getNextPrimaryKey() throws SQLException {
	        final String column_name = "login_id";
	        final String table_name = "login";
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
	    
	    
	    
		
		 public List<LoginBean> fetchAllLogins() throws SQLException {
		        final String selectSQL = "SELECT login_id,login_username,login_password,login_rank_id	 FROM login";
		        final List<LoginBean> loginList = new ArrayList<LoginBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            this.cst = this.conn.prepareStatement(selectSQL);
		            final ResultSet rs = this.cst.executeQuery();
		            while (rs.next()) {
		                final LoginBean login = new LoginBean();
		                login.setLoginId(rs.getInt("login_id"));
		                
		                login.setLoginName(rs.getString("login_username"));
		                login.setLoginPassword(rs.getString("login_password"));
		               
		                login.setLoginRankId(rs.getInt("login_rank_id"));
		                
		               
		                loginList.add(login);
		            }
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return loginList;
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return loginList;
		    }
		    public List<LoginBean> createLogin(final LoginBean loginBean) throws SQLException {
		        final String selectSQL = "INSERT INTO login(login_id,login_username,login_password,login_rank_id) values(" + this.getNextPrimaryKey() + ", '" +  loginBean.getLoginName() +  "', '" + loginBean.getLoginPassword() +  "', "  + loginBean.getLoginRankId() +  ");";
		        List<LoginBean> loginList = new ArrayList<LoginBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<LoginBean>)this.fetchAllLogins();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        loginList = (List<LoginBean>)this.fetchAllLogins();
		        return loginList;
		    }
		    
		    public List<LoginBean> updateLogin(final LoginBean loginBean) throws SQLException {
		        final String sql = "update login set login_username='" + loginBean.getLoginName() +"',  login_password='" + loginBean.getLoginPassword()+"',  login_rank_id=" + loginBean.getLoginRankId()   + " where login_id=" + loginBean.getLoginId();
		        System.out.println(sql);
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<LoginBean>)this.fetchAllLogins();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<LoginBean>)this.fetchAllLogins();
		    }
		    
		    public List<LoginBean> deleteLogin(final LoginBean loginBean) throws SQLException {
		        final String sql = "DELETE FROM login WHERE login_id=" + loginBean.getLoginId();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<LoginBean>)this.fetchAllLogins();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<LoginBean>)this.fetchAllLogins();
		    }
		    
}
