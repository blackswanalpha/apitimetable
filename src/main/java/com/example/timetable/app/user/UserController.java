package com.example.timetable.app.user;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping({ "/timetable/user" })
public class UserController {
	 @Autowired
	    UserDAO  userDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllUsers" })
	    public List<UserBean> fetchAllUsers() throws SQLException {
	        return (List<UserBean>)this. userDAO.fetchAllUsers();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createUser" })
	    public List<UserBean> createUser(@RequestBody final UserBean  userBean) throws SQLException {
	        return (List<UserBean>)this. userDAO.createUser( userBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateUser" })
	    public List<UserBean> updateUser(@RequestBody final UserBean  userBean) throws SQLException {
	        return (List<UserBean>)this. userDAO.updateUser( userBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteUser" })
	    public List<UserBean> deleteUser(@RequestBody final UserBean  userBean) throws SQLException {
	        return (List<UserBean>)this. userDAO.deleteUser( userBean);
	    }
	    
}
