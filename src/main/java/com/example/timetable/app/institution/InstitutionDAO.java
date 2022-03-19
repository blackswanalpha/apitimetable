package com.example.timetable.app.institution;

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
public class InstitutionDAO {
	
	 PreparedStatement cst;
	    Connection conn;
	    @Autowired
	    DataSource dataSource;
		public InstitutionDAO() {
			super();
			  this.cst = null;
		        this.conn = null;
		}
		
	    public int getNextPrimaryKey() throws SQLException {
	        final String column_name = "institution_id";
	        final String table_name = "institution";
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
	    
	    
	    
		
		 public List<InstitutionBean> fetchAllInstitutions() throws SQLException {
		        final String selectSQL = "SELECT institution_id,institution_name,institution_desc,institution_email,institution_mobile,institution_logo	 FROM institution";
		        final List<InstitutionBean> institutionList = new ArrayList<InstitutionBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            this.cst = this.conn.prepareStatement(selectSQL);
		            final ResultSet rs = this.cst.executeQuery();
		            while (rs.next()) {
		                final InstitutionBean institution = new InstitutionBean();
		                institution.setInstitutionId(rs.getInt("institution_id"));
		                
		                institution.setInstitutionName(rs.getString("institution_name"));
		                institution.setInstitutionDesc(rs.getString("institution_desc"));
		                institution.setInstitutionEmail(rs.getString("institution_email"));
		                institution.setInstitutionLogo(rs.getString("institution_logo"));
	             
		                institution.setInstitutionMobile(rs.getInt("institution_mobile"));
		                
		               
		                institutionList.add(institution);
		            }
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return institutionList;
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return institutionList;
		    }
		    public List<InstitutionBean> createInstitution(final InstitutionBean institutionBean) throws SQLException {
		        final String selectSQL = "INSERT INTO institution(institution_id,institution_name,institution_desc,institution_email,institution_mobile,institution_logo) values(" + this.getNextPrimaryKey() + ", '" +  institutionBean.getInstitutionName() +  "', '" + institutionBean.getInstitutionDesc()+  "', '" + institutionBean.getInstitutionEmail() +  "', "  + institutionBean.getInstitutionMobile()+  ", '" + institutionBean.getInstitutionLogo() +  "');";
		        List<InstitutionBean> institutionList = new ArrayList<InstitutionBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<InstitutionBean>)this.fetchAllInstitutions();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        institutionList = (List<InstitutionBean>)this.fetchAllInstitutions();
		        return institutionList;
		    }
		    
		    public List<InstitutionBean> updateInstitution(final InstitutionBean institutionBean) throws SQLException {
		        final String sql = "update institution set institution_name='" + institutionBean.getInstitutionName() +"' institution_desc='" + institutionBean.getInstitutionDesc()+"' institution_email='"+ institutionBean.getInstitutionEmail()+"' institution_logo='"+ institutionBean.getInstitutionLogo() +"'  institution_mobile=" + institutionBean.getInstitutionMobile()  + " where institution_id=" + institutionBean.getInstitutionId();
		        System.out.println(sql);
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<InstitutionBean>)this.fetchAllInstitutions();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<InstitutionBean>)this.fetchAllInstitutions();
		    }
		    
		    public List<InstitutionBean> deleteInstitution(final InstitutionBean institutionBean) throws SQLException {
		        final String sql = "DELETE FROM institution WHERE institution_id=" + institutionBean.getInstitutionId();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<InstitutionBean>)this.fetchAllInstitutions();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<InstitutionBean>)this.fetchAllInstitutions();
		    }
		    
	
	

}
