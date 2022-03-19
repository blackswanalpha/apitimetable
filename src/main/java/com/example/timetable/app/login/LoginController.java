package com.example.timetable.app.login;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping({ "/timetable/login" })
public class LoginController {
	
	 @Autowired
	    LoginDAO loginDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllLogins" })
	    public List<LoginBean> fetchAllLogins() throws SQLException {
	        return (List<LoginBean>)this.loginDAO.fetchAllLogins();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createLogin" })
	    public List<LoginBean> createLogin(@RequestBody final LoginBean loginBean) throws SQLException {
	        return (List<LoginBean>)this.loginDAO.createLogin(loginBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateLogin" })
	    public List<LoginBean> updateLogin(@RequestBody final LoginBean loginBean) throws SQLException {
	        return (List<LoginBean>)this.loginDAO.updateLogin(loginBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteLogin" })
	    public List<LoginBean> deleteLogin(@RequestBody final LoginBean loginBean) throws SQLException {
	        return (List<LoginBean>)this.loginDAO.deleteLogin(loginBean);
	    }
	    

}
