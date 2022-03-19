package com.example.timetable.app.building;

import java.sql.SQLException;
import java.util.List;

import com.example.timetable.app.building.BuildingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({ "/timetable/building" })
public class BuildingController {
	 @Autowired
	    BuildingDAO buildingDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllBuildings" })
	    public List<BuildingBean> fetchAllBuildings() throws SQLException {
	        return (List<BuildingBean>)this.buildingDAO.fetchAllBuildings();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createBuilding" })
	    public List<BuildingBean> createBuilding(@RequestBody final BuildingBean buildingBean) throws SQLException {
	        return (List<BuildingBean>)this.buildingDAO.createBuilding(buildingBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateBuilding" })
	    public List<BuildingBean> updateBuilding(@RequestBody final BuildingBean buildingBean) throws SQLException {
	        return (List<BuildingBean>)this.buildingDAO.updateBuilding(buildingBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteBuilding" })
	    public List<BuildingBean> deleteBuilding(@RequestBody final BuildingBean buildingBean) throws SQLException {
	        return (List<BuildingBean>)this.buildingDAO.deleteBuilding(buildingBean);
	    }

	@RequestMapping(method = { RequestMethod.POST }, value = { "/undoBuilding" })
	public List<BuildingBean> undoBuilding(@RequestBody final BuildingBean buildingBean) throws SQLException {
		return (List<BuildingBean>)this.buildingDAO.undoBuilding(buildingBean);
	}
}
