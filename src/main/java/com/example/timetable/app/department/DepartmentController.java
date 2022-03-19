package com.example.timetable.app.department;

import java.sql.SQLException;
import java.util.List;

import com.example.timetable.app.department.DepartmentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping({ "/timetable/department" })
public class DepartmentController {
	
	
	
	 @Autowired
	    DepartmentDAO  departmentDAO;
	    
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




}
