package com.example.timetable.app.department;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping({ "/timetable/department" })
@Api( tags = "Clients")
public class DepartmentController {
	
	
	
	 @Autowired
	    DepartmentDAO  departmentDAO;


	@ApiOperation(value = "This method is used to get the clients.")
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllDepartments" })
	    public List<DepartmentBean> fetchAllDepartments() throws SQLException {
	        return (List<DepartmentBean>)this.departmentDAO.fetchAllDepartments();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createDepartment" })
	    public List<DepartmentBean> createDepartment(@RequestBody final DepartmentBean  departmentBean) throws SQLException {
	        return (List<DepartmentBean>)this.departmentDAO.createDepartment(departmentBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateDepartment" })
	    public List<DepartmentBean> updateDepartment(@RequestBody final DepartmentBean  departmentBean) throws SQLException {
	        return (List<DepartmentBean>)this.departmentDAO.updateDepartment(departmentBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteDepartment" })
	    public List<DepartmentBean> deleteDepartment(@RequestBody final DepartmentBean  departmentBean) throws SQLException {
	        return (List<DepartmentBean>)this.departmentDAO.deleteDepartment(departmentBean);
	    }


	@RequestMapping(method = { RequestMethod.POST }, value = { "/undoDepartment" })
	public List<DepartmentBean> undoDepartment(@RequestBody final DepartmentBean departmentBean) throws SQLException {
		return (List<DepartmentBean>)this.departmentDAO.undoDepartment(departmentBean);
	}

	@RequestMapping( method = { RequestMethod.GET },value = "/report/{format}")
	public ResponseEntity<InputStreamResource> generateReport(@PathVariable  String format) throws IOException, JRException, SQLException {
		return this.departmentDAO.exportReport(format);
	}

	@RequestMapping(value = "/download/{format}", method = RequestMethod.GET)
	public StreamingResponseBody getSteamingFile(HttpServletResponse response, @PathVariable  String format) throws IOException, JRException, SQLException {
		this.departmentDAO.exportReport(format);
		String path = "C:\\Users\\h\\Desktop\\Reports";
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename='department."+format+"'");
		InputStream inputStream = new FileInputStream(new File(path+"\\department.xlsx"));

		return outputStream -> {
			int nRead;
			byte[] data = new byte[1024];
			while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
				outputStream.write(data, 0, nRead);
			}
			inputStream.close();
		};
	}


}
