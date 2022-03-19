package com.example.timetable.app.unit;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.timetable.app.unit.UnitBean;
import com.example.timetable.app.unit.UnitDAO;

@RestController
@RequestMapping({ "/timetable/unit" })
public class UnitController {
	 @Autowired
	    UnitDAO unitDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllUnits" })
	    public List<UnitBean> fetchAllUnits() throws SQLException {
	        return (List<UnitBean>)this.unitDAO.fetchAllUnits();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createUnit" })
	    public List<UnitBean> createUnit(@RequestBody final UnitBean unitBean) throws SQLException {
	        return (List<UnitBean>)this.unitDAO.createUnit(unitBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateUnit" })
	    public List<UnitBean> updateUnit(@RequestBody final UnitBean unitBean) throws SQLException {
	        return (List<UnitBean>)this.unitDAO.updateUnit(unitBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteUnit" })
	    public List<UnitBean> deleteUnit(@RequestBody final UnitBean unitBean) throws SQLException {
	        return (List<UnitBean>)this.unitDAO.deleteUnit(unitBean);
	    }

	@RequestMapping(method = { RequestMethod.POST }, value = { "/undoUnit" })
	public List<UnitBean> undoUnit(@RequestBody final UnitBean unitBean) throws SQLException {
		return (List<UnitBean>)this.unitDAO.undoUnit(unitBean);
	}
}
	    

