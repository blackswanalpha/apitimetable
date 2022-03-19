package com.example.timetable.app.course;

import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping({ "/timetable/course" })
public class CourseController {

	
	 @Autowired
	    CourseDAO courseDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllCourses" })
	    public List<CourseBean> fetchAllCourses() throws SQLException {
	        return (List<CourseBean>)this.courseDAO.fetchAllCourses();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createCourse" })
	    public List<CourseBean> createCourse(@RequestBody final CourseBean courseBean) throws SQLException {
	        return (List<CourseBean>)this.courseDAO.createCourse(courseBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateCourse" })
	    public List<CourseBean> updateCourse(@RequestBody final CourseBean courseBean) throws SQLException {
	        return (List<CourseBean>)this.courseDAO.updateCourse(courseBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteCourse" })
	    public List<CourseBean> deleteCourse(@RequestBody final CourseBean courseBean) throws SQLException {
	        return (List<CourseBean>)this.courseDAO.deleteCourse(courseBean);
	    }


	@RequestMapping(method = { RequestMethod.POST }, value = { "/undoCourse" })
	public List<CourseBean> undoCourse(@RequestBody final CourseBean courseBean) throws SQLException {
		return (List<CourseBean>)this.courseDAO.undoCourse(courseBean);
	}
	    

}

