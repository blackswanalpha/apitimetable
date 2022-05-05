package com.example.timetable.app.specialization;

import java.sql.SQLException;
import java.util.List;

import com.example.timetable.app.specialization.SpecializationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping({ "/timetable/specialization" })
public class SpecializationController {
	 @Autowired
	    SpecializationDAO specializationDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllSpecializations" })
	    public List<SpecializationBean> fetchAllSpecializations() throws SQLException {
	        return (List<SpecializationBean>)this.specializationDAO.fetchAllSpecializations();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createSpecialization" })
	    public List<SpecializationBean> createSpecialization(@RequestBody final SpecializationBean specializationBean) throws SQLException {
	        return (List<SpecializationBean>)this.specializationDAO.createSpecialization(specializationBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateSpecialization" })
	    public List<SpecializationBean> updateSpecialization(@RequestBody final SpecializationBean specializationBean) throws SQLException {
	        return (List<SpecializationBean>)this.specializationDAO.updateSpecialization(specializationBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteSpecialization" })
	    public List<SpecializationBean> deleteSpecialization(@RequestBody final SpecializationBean specializationBean) throws SQLException {
	        return (List<SpecializationBean>)this.specializationDAO.deleteSpecialization(specializationBean);
	    }
	@RequestMapping(method = { RequestMethod.POST }, value = { "/undoSpecialization" })
	public List<SpecializationBean> undoSpecialization(@RequestBody final SpecializationBean specializationBean) throws SQLException {
		return (List<SpecializationBean>)this.specializationDAO.undoSpecialization(specializationBean);
	}
	    

}
