package com.luxw.springboost.mapper;

import java.util.List;

import com.luxw.springboost.model.Orgn;

public interface OrgMapper {
	public List<Orgn> getOrgns();
	public Orgn getOrgn(Long id);
	public int deleteOrgn(Long id);
	public int insertOrgn(Orgn orgn);
	public int updateOrgn(Orgn orgn);
	public int getOrgnCount();
}
