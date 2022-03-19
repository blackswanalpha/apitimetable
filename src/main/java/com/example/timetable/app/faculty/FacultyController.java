package com.example.timetable.app.faculty;

import java.sql.SQLException;
import java.util.List;

import com.example.timetable.app.faculty.FacultyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.timetable.app.faculty.FacultyBean;
import com.example.timetable.app.faculty.FacultyDAO;

@RestController
@RequestMapping({ "/timetable/faculty" })
public class FacultyController {

	
	 @Autowired
	    FacultyDAO facultyDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllFacultys" })
	    public List<FacultyBean> fetchAllFacultys() throws SQLException {
	        return (List<FacultyBean>)this.facultyDAO.fetchAllFacultys();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createFaculty" })
	    public List<FacultyBean> createFaculty(@RequestBody final FacultyBean facultyBean) throws SQLException {
	        return (List<FacultyBean>)this.facultyDAO.createFaculty(facultyBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateFaculty" })
	    public List<FacultyBean> updateFaculty(@RequestBody final FacultyBean facultyBean) throws SQLException {
	        return (List<FacultyBean>)this.facultyDAO.updateFaculty(facultyBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteFaculty" })
	    public List<FacultyBean> deleteFaculty(@RequestBody final FacultyBean facultyBean) throws SQLException {
	        return (List<FacultyBean>)this.facultyDAO.deleteFaculty(facultyBean);
	    }
	@RequestMapping(method = { RequestMethod.POST }, value = { "/undoFaculty" })
	public List<FacultyBean> undoFaculty(@RequestBody final FacultyBean facultyBean) throws SQLException {
		return (List<FacultyBean>)this.facultyDAO.undoFaculty(facultyBean);
	}




}
