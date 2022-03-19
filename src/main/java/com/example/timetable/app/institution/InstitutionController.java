package com.example.timetable.app.institution;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping({ "/timetable/institution" })
public class InstitutionController {

	
	
	 @Autowired
	    InstitutionDAO institutionDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllInstitutions" })
	    public List<InstitutionBean> fetchAllInstitutions() throws SQLException {
	        return (List<InstitutionBean>)this.institutionDAO.fetchAllInstitutions();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createInstitution" })
	    public List<InstitutionBean> createInstitution(@RequestBody final InstitutionBean institutionBean) throws SQLException {
	        return (List<InstitutionBean>)this.institutionDAO.createInstitution(institutionBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateInstitution" })
	    public List<InstitutionBean> updateInstitution(@RequestBody final InstitutionBean institutionBean) throws SQLException {
	        return (List<InstitutionBean>)this.institutionDAO.updateInstitution(institutionBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteInstitution" })
	    public List<InstitutionBean> deleteInstitution(@RequestBody final InstitutionBean institutionBean) throws SQLException {
	        return (List<InstitutionBean>)this.institutionDAO.deleteInstitution(institutionBean);
	    }
	    

}
