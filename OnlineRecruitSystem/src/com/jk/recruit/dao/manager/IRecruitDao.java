package com.jk.recruit.dao.manager;

import java.util.List;
import java.util.Map;

import com.jk.recruit.po.Corporation;
import com.jk.recruit.po.Education;
import com.jk.recruit.po.Recruitment;
import com.jk.recruit.po.User;
import com.jk.recruit.po.Work;

public interface IRecruitDao {
	public List<Recruitment> findAllRecruitByInfo(String key) ;
	public void addRecruitment(Recruitment recruit);
	public void updateRecruitment(Recruitment recruit,int oldId);
	public Map<String,Object> findRecruitmentInfo(int id) ;
	
	//public Map<String,Object> findCorporationByRecruitId(int id);
	public List<Recruitment> findRecruitmentByCorporation(int id);
	
	public void deleteRecruitById(int id);
	

}
