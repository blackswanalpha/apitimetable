package com.example.timetable.app.rank;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




	@RestController
	@RequestMapping({ "/timetable/rank" })
	public class RankController {

		 @Autowired
		    RankDAO userDAO;
		    
		    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllRanks" })
		    public List<RankBean> fetchAllUsers() throws SQLException {
		        return (List<RankBean>)this.userDAO.fetchAllUsers();
		    }
		    
		    @RequestMapping(method = { RequestMethod.POST }, value = { "/createRank" })
		    public List<RankBean> createUser(@RequestBody final RankBean userBean) throws SQLException {
		        return (List<RankBean>)this.userDAO.createUser(userBean);
		    }
		    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateRank" })
		    public List<RankBean> updateGroup(@RequestBody final RankBean groupBean) throws SQLException {
		        return (List<RankBean>)this.userDAO.updateGroup(groupBean);
		    }
		    
		    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteRank" })
		    public List<RankBean> deleteGroup(@RequestBody final RankBean groupBean) throws SQLException {
		        return (List<RankBean>)this.userDAO.deleteGroup(groupBean);
		    }
		    
	}


