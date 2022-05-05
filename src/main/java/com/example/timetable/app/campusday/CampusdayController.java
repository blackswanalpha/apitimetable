package com.example.timetable.app.campusday;

import java.sql.SQLException;
import java.util.List;

import com.example.timetable.app.campusday.CampusdayBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.timetable.app.campusday.CampusdayBean;
import com.example.timetable.app.campusday.CampusdayDAO;






@RestController
@RequestMapping({ "/timetable/campusday" })
public class CampusdayController {
	 @Autowired
	    CampusdayDAO campusdayDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllCampusdays" })
	    public List<CampusdayBean> fetchAllCampusdays() throws SQLException {
	        return (List<CampusdayBean>)this.campusdayDAO.fetchAllCampusdays();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createCampusday" })
	    public List<CampusdayBean> createCampusday(@RequestBody final CampusdayBean campusdayBean) throws SQLException {
	        return (List<CampusdayBean>)this.campusdayDAO.createCampusday(campusdayBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateCampusday" })
	    public List<CampusdayBean> updateCampusday(@RequestBody final CampusdayBean campusdayBean) throws SQLException {
	        return (List<CampusdayBean>)this.campusdayDAO.updateCampusday(campusdayBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteCampusday" })
	    public List<CampusdayBean> deleteCampusday(@RequestBody final CampusdayBean campusdayBean) throws SQLException {
	        return (List<CampusdayBean>)this.campusdayDAO.deleteCampusday(campusdayBean);
	    }
	@RequestMapping(method = { RequestMethod.POST }, value = { "/undoCampusday" })
	public List<CampusdayBean> undoCampusday(@RequestBody final CampusdayBean campusdayBean) throws SQLException {
		return (List<CampusdayBean>)this.campusdayDAO.undoCampusday(campusdayBean);
	}
	    


}