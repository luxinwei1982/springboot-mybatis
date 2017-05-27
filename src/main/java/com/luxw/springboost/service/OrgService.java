package com.luxw.springboost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxw.springboost.mapper.OrgMapper;
import com.luxw.springboost.model.Orgn;

@Service
public class OrgService {
	@Autowired
    private OrgMapper orgMapper;

    public List<Orgn> getOrgsInfo(){

        return orgMapper.getOrgns();
    }
    
    public Orgn getOrgInfo(Long id){
        return orgMapper.getOrgn(id);
    }
    
    public int deleteOrgn(Long id){
        return orgMapper.deleteOrgn(id);
    }
    
    public int insertOrgn(Orgn orgn){
        return orgMapper.insertOrgn(orgn);
    }
    
    public int updateOrgn(Orgn orgn){
        return orgMapper.updateOrgn(orgn);
    }
}
