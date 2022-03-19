package com.example.timetable.app.day;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping({ "/timetable/day" })
public class DayController {
	 @Autowired
	    DayDAO dayDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllDays" })
	    public List<DayBean> fetchAllDays() throws SQLException {
	        return (List<DayBean>)this.dayDAO.fetchAllDays();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createDay" })
	    public List<DayBean> createDay(@RequestBody final DayBean dayBean) throws SQLException {
	        return (List<DayBean>)this.dayDAO.createDay(dayBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateDay" })
	    public List<DayBean> updateDay(@RequestBody final DayBean dayBean) throws SQLException {
	        return (List<DayBean>)this.dayDAO.updateDay(dayBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteDay" })
	    public List<DayBean> deleteDay(@RequestBody final DayBean dayBean) throws SQLException {
	        return (List<DayBean>)this.dayDAO.deleteDay(dayBean);
	    }
	    


}

