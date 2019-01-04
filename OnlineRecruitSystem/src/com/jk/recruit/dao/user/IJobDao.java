package com.jk.recruit.dao.user;

import java.util.List;
import java.util.Map;

import com.jk.recruit.po.Education;
import com.jk.recruit.po.Recruitment;
import com.jk.recruit.po.User;
import com.jk.recruit.po.Work;

public interface IJobDao {
	public List<Recruitment> findAllRecruitByInfo(String key) ;
	public Map<String,Object> findRecruitmentInfo(int id) ;
	public Map<String,Object> findCorporationById(int id);
	public Map<String,Object> findUserInfo(int id) ;
	public List<Education> findEducationByUserId(int userId);
	public List<Work> findJobByUserId(int userId);
	public void addEducation(Education edu);
	public void addWork(Work work);
	public void updateUser(User user, int oldId);
	public Map<String,Object> findEducationById(int id);
	public Map<String,Object> findWorkById(int id);
	public void updateEducation(Education edu, int id);
	public void updateWork(Work work, int id);
	public void deleteEducation(int id);
	public void deleteWork(int id);
	public void addResume(int userId, int postId);
}
