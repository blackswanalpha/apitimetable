package com.example.timetable.app.campus;

import java.sql.SQLException;
import java.util.List;

import com.example.timetable.app.campus.CampusBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({ "/timetable/campus" })
public class CampusController {
	 @Autowired
	    CampusDAO campusDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllCampuss" })
	    public List<CampusBean> fetchAllCampuss() throws SQLException {
	        return (List<CampusBean>)this.campusDAO.fetchAllCampuss();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createCampus" })
	    public List<CampusBean> createCampus(@RequestBody final CampusBean campusBean) throws SQLException {
	        return (List<CampusBean>)this.campusDAO.createCampus(campusBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateCampus" })
	    public List<CampusBean> updateCampus(@RequestBody final CampusBean campusBean) throws SQLException {
	        return (List<CampusBean>)this.campusDAO.updateCampus(campusBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteCampus" })
	    public List<CampusBean> deleteCampus(@RequestBody final CampusBean campusBean) throws SQLException {
	        return (List<CampusBean>)this.campusDAO.deleteCampus(campusBean);
	    }
	@RequestMapping(method = { RequestMethod.POST }, value = { "/undoCampus" })
	public List<CampusBean> undoCampus(@RequestBody final CampusBean campusBean) throws SQLException {
		return (List<CampusBean>)this.campusDAO.undoCampus(campusBean);
	}



}

