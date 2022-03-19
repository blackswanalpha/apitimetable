package com.example.timetable.app.planner;

import java.sql.SQLException;
import java.util.List;

import com.example.timetable.app.planner.PlannerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping({ "/timetable/planner" })
public class plannerController {
	 @Autowired
	    PlannerDAO plannerDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllPlanners" })
	    public List<PlannerBean> fetchAllPlanners() throws SQLException {
	        return (List<PlannerBean>)this.plannerDAO.fetchAllPlanners();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createPlanner" })
	    public List<PlannerBean> createPlanner(@RequestBody final PlannerBean plannerBean) throws SQLException {
	        return (List<PlannerBean>)this.plannerDAO.createPlanner(plannerBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updatePlanner" })
	    public List<PlannerBean> updatePlanner(@RequestBody final PlannerBean plannerBean) throws SQLException {
	        return (List<PlannerBean>)this.plannerDAO.updatePlanner(plannerBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deletePlanner" })
	    public List<PlannerBean> deletePlanner(@RequestBody final PlannerBean plannerBean) throws SQLException {
	        return (List<PlannerBean>)this.plannerDAO.deletePlanner(plannerBean);
	    }
	@RequestMapping(method = { RequestMethod.POST }, value = { "/undoPlanner" })
	public List<PlannerBean> undoPlanner(@RequestBody final PlannerBean plannerBean) throws SQLException {
		return (List<PlannerBean>)this.plannerDAO.undoPlanner(plannerBean);
	}




}
