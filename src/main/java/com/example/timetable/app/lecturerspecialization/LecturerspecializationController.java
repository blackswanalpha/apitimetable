package com.example.timetable.app.lecturerspecialization;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({ "/timetable/lecturerspecialization" })
public class LecturerspecializationController {
	 @Autowired
	    LecturerspecializationDAO lecturerspecializationDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllLecturerspecializations" })
	    public List<LecturerspecializationBean> fetchAllLecturerspecializations() throws SQLException {
	        return (List<LecturerspecializationBean>)this.lecturerspecializationDAO.fetchAllLecturerspecializations();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createLecturerspecialization" })
	    public List<LecturerspecializationBean> createLecturerspecialization(@RequestBody final LecturerspecializationBean lecturerspecializationBean) throws SQLException {
	        return (List<LecturerspecializationBean>)this.lecturerspecializationDAO.createLecturerspecialization(lecturerspecializationBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateLecturerspecialization" })
	    public List<LecturerspecializationBean> updateLecturerspecialization(@RequestBody final LecturerspecializationBean lecturerspecializationBean) throws SQLException {
	        return (List<LecturerspecializationBean>)this.lecturerspecializationDAO.updateLecturerspecialization(lecturerspecializationBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteLecturerspecialization" })
	    public List<LecturerspecializationBean> deleteLecturerspecialization(@RequestBody final LecturerspecializationBean lecturerspecializationBean) throws SQLException {
	        return (List<LecturerspecializationBean>)this.lecturerspecializationDAO.deleteLecturerspecialization(lecturerspecializationBean);
	    }
	  
}
