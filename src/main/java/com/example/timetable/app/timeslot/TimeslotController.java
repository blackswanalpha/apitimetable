package com.example.timetable.app.timeslot;

import java.sql.SQLException;
import java.util.List;

import com.example.timetable.app.timeslot.TimeslotBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({ "/timetable/timeslot" })
public class TimeslotController {
	 @Autowired
	    TimeslotDAO timeslotDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllTimeslots" })
	    public List<TimeslotBean> fetchAllTimeslots() throws SQLException {
	        return (List<TimeslotBean>)this.timeslotDAO.fetchAllTimeslots();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createTimeslot" })
	    public List<TimeslotBean> createTimeslot(@RequestBody final TimeslotBean timeslotBean) throws SQLException {
	        return (List<TimeslotBean>)this.timeslotDAO.createTimeslot(timeslotBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateTimeslot" })
	    public List<TimeslotBean> updateTimeslot(@RequestBody final TimeslotBean timeslotBean) throws SQLException {
	        return (List<TimeslotBean>)this.timeslotDAO.updateTimeslot(timeslotBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteTimeslot" })
	    public List<TimeslotBean> deleteTimeslot(@RequestBody final TimeslotBean timeslotBean) throws SQLException {
	        return (List<TimeslotBean>)this.timeslotDAO.deleteTimeslot(timeslotBean);
	    }
	@RequestMapping(method = { RequestMethod.POST }, value = { "/undoTimeslot" })
	public List<TimeslotBean> undoTimeslot(@RequestBody final TimeslotBean timeslotBean) throws SQLException {
		return (List<TimeslotBean>)this.timeslotDAO.undoTimeslot(timeslotBean);
	}


}
