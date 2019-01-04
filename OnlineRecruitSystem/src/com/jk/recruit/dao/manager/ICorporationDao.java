package com.jk.recruit.dao.manager;

import java.util.List;
import java.util.Map;

import com.jk.recruit.po.Corporation;
import com.jk.recruit.po.Recruitment;

public interface ICorporationDao {
	public List<Corporation> findAllCorporationByInfo(String key);
	public Map<String,Object> findCorporationById(int id);
	public void addCorporation(Corporation c);
	public void updateCorporation(Corporation c, int id);
	public void deleteCorporation(int id);
}
