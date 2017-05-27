package com.luxw.springboost.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luxw.springboost.model.Orgn;
import com.luxw.springboost.service.OrgService;

//@Controller
@RestController
public class OrgController {
	private Logger logger = Logger.getLogger(OrgController.class);

    @Autowired
    private OrgService orgService;

    @RequestMapping(value = "/getorginfo", method = RequestMethod.GET)
    public Orgn getOrgInfo(@RequestParam(value = "id", required = true) Long id) {
    	return orgService.getOrgInfo(id);
	}
    
    @RequestMapping(value = "/getorgns")
    public List<Orgn> getOrgns() {
    	return orgService.getOrgsInfo();
    }
    
    @RequestMapping(value = "/deleteorgn", method = RequestMethod.GET)
    public String deleteOrgn(@RequestParam(value = "id", required = true) Long id) {
    	orgService.deleteOrgn(id);
    	String str="删除ID为"+id+"的记录";
    	return str;
    }
    
    @RequestMapping(value = "/insertorgn", method = RequestMethod.GET)
    public String insertOrgn(@RequestParam(value = "orgid", required = true) String orgId,
    		@RequestParam(value = "orgname", required = true) String orgName,
    		@RequestParam(value = "parentorgid", required = true) String parentOrgId,
    		@RequestParam(value = "company", required = true) String company,
    		@RequestParam(value = "department", required = true) String department,
    		@RequestParam(value = "orgtype", required = true) String orgType) {
    	Orgn orgn=new Orgn();
    	orgn.setOrgId(orgId);
    	orgn.setOrgName(orgName);
    	orgn.setParentOrgId(parentOrgId);
    	orgn.setCompany(company);
    	orgn.setDepartment(department);
    	orgn.setOrgType(orgType);
    	orgService.insertOrgn(orgn);
    	String str="添加OrgId为"+orgn.getOrgId()+"的记录";
    	return str;
    }
    
    @RequestMapping(value = "/updateorgn", method = RequestMethod.GET)
    public String updateOrgn(@RequestParam(value = "id", required = true) Long id,
    		@RequestParam(value = "orgid", required = false) String orgId,
    		@RequestParam(value = "orgname", required = false) String orgName,
    		@RequestParam(value = "parentorgid", required = false) String parentOrgId,
    		@RequestParam(value = "company", required = false) String company,
    		@RequestParam(value = "department", required = false) String department,
    		@RequestParam(value = "orgtype", required = false) String orgType) {
    	Orgn orgn=new Orgn();
    	orgn = orgService.getOrgInfo(id);
    	if(orgId!=null) {
        	orgn.setOrgId(orgId);
    	}
    	if(orgName!=null){
        	orgn.setOrgName(orgName);
    	}
    	if(parentOrgId!=null) {
        	orgn.setParentOrgId(parentOrgId);
    	}
    	if(company!=null) {
        	orgn.setCompany(company);
    	}
    	if(department!=null) {
        	orgn.setDepartment(department);
    	}
    	if(orgType!=null) {
        	orgn.setOrgType(orgType);
    	}
    	orgService.updateOrgn(orgn);
    	String str="已修改id为"+orgn.getId()+"的记录";
    	return str;
    }
}
