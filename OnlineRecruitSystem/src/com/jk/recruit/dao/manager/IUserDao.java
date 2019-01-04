package com.jk.recruit.dao.manager;

import java.util.List;
import java.util.Map;

import com.jk.recruit.po.Education;
import com.jk.recruit.po.User;
import com.jk.recruit.po.Work;

public interface IUserDao {

	public List<User> findAllUserByInfo(String key) ;
	public void addUser(User user);
	public void updateUser(User user,int oldId);
	public Map<String,Object> findUserInfo(int id) ;
	/**
	 * 根据用户的ID号查询其简历信息与工作经验
	 * 
	 */
	public List<Education> findEducationByUserId(int userId);
	public List<Work> findJobByUserId(int userId);
	public void addEducation(Education edu);
	public void addWork(Work work);
	public Map<String,Object> findEducationById(int id);
	public Map<String,Object> findWorkById(int id);
	public void updateEducation(Education edu, int id);
	public void updateWork(Work work, int id);
	public void deleteUserById(int id);
	public void deleteEducation(int id);
	public void deleteWork(int id);
	
	public List<User>findResume(int recuitId);
}

