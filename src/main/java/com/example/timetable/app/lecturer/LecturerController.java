package com.example.timetable.app.lecturer;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping({ "/timetable/lecturer" })
public class LecturerController {
	 @Autowired
	    LecturerDAO lecturerDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllLecturers" })
	    public List<LecturerBean> fetchAllLecturers() throws SQLException {
	        return (List<LecturerBean>)this.lecturerDAO.fetchAllLecturers();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createLecturer" })
	    public List<LecturerBean> createLecturer(@RequestBody final LecturerBean lecturerBean) throws SQLException {
	        return (List<LecturerBean>)this.lecturerDAO.createLecturer(lecturerBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateLecturer" })
	    public List<LecturerBean> updateLecturer(@RequestBody final LecturerBean lecturerBean) throws SQLException {
	        return (List<LecturerBean>)this.lecturerDAO.updateLecturer(lecturerBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteLecturer" })
	    public List<LecturerBean> deleteLecturer(@RequestBody final LecturerBean lecturerBean) throws SQLException {
	        return (List<LecturerBean>)this.lecturerDAO.deleteLecturer(lecturerBean);
	    }
	    


}
