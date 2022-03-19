package com.example.timetable.app.mode;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;






@RestController
@RequestMapping({ "/timetable/mode" })
public class ModeController {
	 @Autowired
	    ModeDAO modeDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllModes" })
	    public List<ModeBean> fetchAllModes() throws SQLException {
	        return (List<ModeBean>)this.modeDAO.fetchAllModes();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createMode" })
	    public List<ModeBean> createMode(@RequestBody final ModeBean modeBean) throws SQLException {
	        return (List<ModeBean>)this.modeDAO.createMode(modeBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateMode" })
	    public List<ModeBean> updateMode(@RequestBody final ModeBean modeBean) throws SQLException {
	        return (List<ModeBean>)this.modeDAO.updateMode(modeBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteMode" })
	    public List<ModeBean> deleteMode(@RequestBody final ModeBean modeBean) throws SQLException {
	        return (List<ModeBean>)this.modeDAO.deleteMode(modeBean);
	    }
	    


}
