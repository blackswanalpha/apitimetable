package com.example.timetable.app.lecturertype;

import java.sql.SQLException;
import java.util.List;

import com.example.timetable.app.lecturertype.LecturertypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping({ "/timetable/lecturertype" })
public class LecturertypeController {
	 @Autowired
	    LecturertypeDAO lecturertypeDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllLecturertypes" })
	    public List<LecturertypeBean> fetchAllLecturertypes() throws SQLException {
	        return (List<LecturertypeBean>)this.lecturertypeDAO.fetchAllLecturertypes();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createLecturertype" })
	    public List<LecturertypeBean> createLecturertype(@RequestBody final LecturertypeBean lecturertypeBean) throws SQLException {
	        return (List<LecturertypeBean>)this.lecturertypeDAO.createLecturertype(lecturertypeBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateLecturertype" })
	    public List<LecturertypeBean> updateLecturertype(@RequestBody final LecturertypeBean lecturertypeBean) throws SQLException {
	        return (List<LecturertypeBean>)this.lecturertypeDAO.updateLecturertype(lecturertypeBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteLecturertype" })
	    public List<LecturertypeBean> deleteLecturertype(@RequestBody final LecturertypeBean lecturertypeBean) throws SQLException {
	        return (List<LecturertypeBean>)this.lecturertypeDAO.deleteLecturertype(lecturertypeBean);
	    }
	@RequestMapping(method = { RequestMethod.POST }, value = { "/undoLecturertype" })
	public List<LecturertypeBean> undoLecturertype(@RequestBody final LecturertypeBean lecturertypeBean) throws SQLException {
		return (List<LecturertypeBean>)this.lecturertypeDAO.undoLecturertype(lecturertypeBean);
	}





}
