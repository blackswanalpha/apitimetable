package com.example.timetable.app.lecturerworkstation;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({ "/timetable/lecturerworkstation" })
public class LecturerworkstationController {
	 @Autowired
	    LecturerworkstationDAO lecturerworkstationDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllLecturerworkstations" })
	    public List<LecturerworkstationBean> fetchAllLecturerworkstations() throws SQLException {
	        return (List<LecturerworkstationBean>)this.lecturerworkstationDAO.fetchAllLecturerworkstations();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createLecturerworkstation" })
	    public List<LecturerworkstationBean> createLecturerworkstation(@RequestBody final LecturerworkstationBean lecturerworkstationBean) throws SQLException {
	        return (List<LecturerworkstationBean>)this.lecturerworkstationDAO.createLecturerworkstation(lecturerworkstationBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateLecturerworkstation" })
	    public List<LecturerworkstationBean> updateLecturerworkstation(@RequestBody final LecturerworkstationBean lecturerworkstationBean) throws SQLException {
	        return (List<LecturerworkstationBean>)this.lecturerworkstationDAO.updateLecturerworkstation(lecturerworkstationBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteLecturerworkstation" })
	    public List<LecturerworkstationBean> deleteLecturerworkstation(@RequestBody final LecturerworkstationBean lecturerworkstationBean) throws SQLException {
	        return (List<LecturerworkstationBean>)this.lecturerworkstationDAO.deleteLecturerworkstation(lecturerworkstationBean);
	    }
	    


}
