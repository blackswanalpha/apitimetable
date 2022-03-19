package com.example.timetable.app.semester;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.timetable.app.semester.SemesterBean;
import com.example.timetable.app.semester.SemesterDAO;


@RestController
@RequestMapping({ "/timetable/semester" })
public class SemesterController {
	 @Autowired
	    SemesterDAO semesterDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllSemesters" })
	    public List<SemesterBean> fetchAllSemesters() throws SQLException {
	        return (List<SemesterBean>)this.semesterDAO.fetchAllSemesters();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createSemester" })
	    public List<SemesterBean> createSemester(@RequestBody final SemesterBean semesterBean) throws SQLException {
	        return (List<SemesterBean>)this.semesterDAO.createSemester(semesterBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateSemester" })
	    public List<SemesterBean> updateSemester(@RequestBody final SemesterBean semesterBean) throws SQLException {
	        return (List<SemesterBean>)this.semesterDAO.updateSemester(semesterBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteSemester" })
	    public List<SemesterBean> deleteSemester(@RequestBody final SemesterBean semesterBean) throws SQLException {
	        return (List<SemesterBean>)this.semesterDAO.deleteSemester(semesterBean);
	    }
	    

}
