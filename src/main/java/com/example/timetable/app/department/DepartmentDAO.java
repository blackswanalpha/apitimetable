package com.example.timetable.app.department;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.servlet.ServletContext;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import com.example.timetable.app.department.DepartmentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class DepartmentDAO {

	@Autowired
	private ServletContext servletContext;
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
		        final String selectSQL = "SELECT department_id,department_name,department_desc,department_email,department_mobile,department_faculty_id,faculty_name	 FROM department,faculty where not department_status_id = 2 and department_faculty_id = faculty_id  ";
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
						department.setFacultyName(rs.getString("faculty_name"));
	             
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

	public ResponseEntity<InputStreamResource> exportReport(String reportFormat) throws IOException, JRException, SQLException {
		String path = "C:\\Users\\h\\Desktop\\Reports";
		List<DepartmentBean> employees = fetchAllDepartments();
		//load file and compile it
		HttpHeaders headers = new HttpHeaders();

		//headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		byte[] pdf =new byte[0];
		byte[] contents =new byte[0];
		InputStreamResource resource = null;
		File file = ResourceUtils.getFile("classpath:department.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Tinka Network");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\department.html");
		}
		if (reportFormat.equalsIgnoreCase("pdf")) {
			headers.setContentType(MediaType.parseMediaType("text/plain; charset=utf-8"));
	JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\department.pdf");
			headers.setContentDisposition(ContentDisposition.attachment().filename("department.pdf").build());
		resource = new InputStreamResource(new FileInputStream(path + "\\department.pdf"));

			byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);
			pdf=data;

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(resource);
		}
		if (reportFormat.equalsIgnoreCase("docx")) {
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//	headers.setContentDisposition(ContentDisposition.inline().filename("department.docx").build());
	headers.setContentDisposition(ContentDisposition.attachment().filename("department.docx").build());
			//MediaType mt = new MediaType("application", "msword");

			//	headers.setContentType(mt);
			JRDocxExporter exporter = new JRDocxExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			File exportReportFile = new File( path+"\\department.docx");
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(exportReportFile));
			exporter.exportReport();
			File files = ResourceUtils.getFile("classpath:department.docx");



//			MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, "department.docx");
//			System.out.println("fileName: " + file);
//			System.out.println("mediaType: " + mediaType);

			System.out.println("resourcedfsefse");



		 contents = Files.readAllBytes(Paths.get(files.getAbsolutePath()));
//			Path paths = Paths.get(exportReportFile.getAbsolutePath());
//			ByteArrayResource resources = new ByteArrayResource(Files.readAllBytes(paths));

			resource = new InputStreamResource(new FileInputStream(path + "\\department.docx"));
			System.out.println("resource");

			headers.add("Coche-Control", "no-coche, no store, must-revalidate");
			headers.add("Pragma", "no-coche");
			headers.add( "Expires","0");
			//headers.set(HttpHeaders.CONTENT_TYPE, getContentTypeForAttachment(fileName));

			//ResporseEntity-Object- responseEntity ResponseEntity.ok().headers(headers).contentLength(file.length()).content Type(MediaType.parseMediaType(application/txt)).bodyresource):


			return new ResponseEntity<>(resource, headers, HttpStatus.OK);	}
		if (reportFormat.equalsIgnoreCase("xlsx")){
			//JasperReport  jasperReport = JasperCompileManager.compileReport(JRXmlLoader.load(inputStream)); // compile report

			Map<String, Object> params = new HashMap<>(); // init map with report's parameters
			params.put(JRParameter.REPORT_LOCALE, Locale.US);
			params.put(JRParameter.IS_IGNORE_PAGINATION, true);
			//JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection);  // prepare report - passs parameters and jdbc connection

			JRXlsxExporter exporter = new JRXlsxExporter(); // initialize exporter
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint)); // set compiled report as input
			File exportReportFile = new File( path+"\\department.xlsx");
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(exportReportFile));  // set output file via path with filename
			SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
			configuration.setOnePagePerSheet(true); // setup configuration
			configuration.setDetectCellType(true);
			exporter.setConfiguration(configuration); // set configuration
			exporter.exportReport();
		}

		System.out.println("resourcesfsfsd");
		return new ResponseEntity<>(resource, headers, HttpStatus.OK);

	}



}
