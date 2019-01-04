package com.jk.recruit.dao.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jk.recruit.po.Education;
import com.jk.recruit.po.User;
import com.jk.recruit.po.Work;
import com.jk.recruit.util.DBUtil;

public class UserDao implements IUserDao {
	DBUtil db = new DBUtil();

	@Override
	public List<User> findAllUserByInfo(String key) {
		// TODO Auto-generated method stub
		String sql = "select * from user";
		if(!"".equals(key)) {
			sql += " where name like '%" + key + "%'";
			
			sql += " or city like '%"+ key +"%'";
		}
		List uList = new ArrayList();
		try {
			uList = db.getQueryList(sql, new Object[] {});
		}catch(Exception e){
			uList = new ArrayList();
			e.printStackTrace();
		}
		return uList;
		
	}
	@Override
	public Map<String, Object> findUserInfo(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from user u where u.id = ?";
		Map<String, Object> uMap = new HashMap();
		try {
			uMap = db.getObject(sql, new Object[] {id});
		}catch (Exception e) {
			// TODO Auto-generated catch block
			uMap = new HashMap();
			e.printStackTrace();
		}
		return uMap;
	}    

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into user(name, sex, birthday, city, phone, email, homePage, description, jobCity, jobType, "
		+"salary, jobIntension, password) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] {user.getName(), user.getSex(), user.getBirthday(),user.getCity()
					, user.getPhone(), user.getEmail(), user.getHomePage(), user.getDescription(), user.getJobCity(),
					user.getJobType(), user.getSalary(), user.getJobIntension(),  user.getPassword()});	
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateUser(User user, int oldId) {
		// TODO Auto-generated method stub
		String sql = "update user set name=?, sex=?, birthday=?, city=?, phone=?, email=?, homePage=?, description=?, jobCity=?, jobType=?" + 
				", salary=?, jobIntension=?, password=? where id = ?";
		try {
			db.execute(sql, new Object[] {user.getName(), user.getSex(), user.getBirthday(),user.getCity()
					, user.getPhone(), user.getEmail(), "", user.getDescription(), user.getJobCity(),
					user.getJobType(), user.getSalary(), user.getJobIntension(),  user.getPassword(), oldId});
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public List<Education> findEducationByUserId(int userId) {
		// TODO Auto-generated method stub
		//String sql = "select e.id, e.school, e.startTime, e.endTime, e.eduBg, e.major, "+
		//"w.id, w.corporation, w.occupation, w.department, w.startTime, w.endTime, w.jobContent "+
		//"from education e, work w where e.id = user.id and w.id = user.id";
		String sql = "select * from education e where e.userId = ? order by e.startTime";
		List eList = new ArrayList();
		try {
			eList = db.getQueryList(sql, new Object[] {userId});
		}catch(Exception e){
			eList = new ArrayList();
			e.printStackTrace();
		}
		return eList;
	}

	@Override
	public List<Work> findJobByUserId(int userId) {
		// TODO Auto-generated method stub
		String sql = "select * from work w where w.userId = ? order by w.startTime";
		List wList = new ArrayList();
		try {
			wList = db.getQueryList(sql, new Object[] {userId});
		}catch(Exception e){
			wList = new ArrayList();
			e.printStackTrace();
		}
		return wList;
	}
	@Override
	public void addEducation(Education edu) {
		String sql = "insert into education(userId, school, startTime, endTime, eduBg, major) "
				+"values(?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] {edu.getUserId(), edu.getSchool(), edu.getStartTime(), edu.getEndTime(),
					 edu.getEduBg(), edu.getMajor()});	
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void addWork(Work work) {
		String sql = "insert into work(userId, corporation, occupation, department,"
				+" startTime, endTime, jobContent) values(?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] {work.getUserId(), work.getCorporation(), work.getOccupation(),
					work.getDepartment(), work.getStartTime(), work.getEndTime(), work.getJobContent()});	
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Map<String, Object> findEducationById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from education where id = ?";
		Map<String, Object> eduMap = new HashMap();
		try {
			eduMap = db.getObject(sql, new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			eduMap = new HashMap();
			e.printStackTrace();
		}
		return eduMap;
	}
	@Override
	public Map<String, Object> findWorkById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from work where id = ?";
		Map<String, Object> workMap = new HashMap();
		try {
			workMap = db.getObject(sql, new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			workMap = new HashMap();
			e.printStackTrace();
		}
		return workMap;
	}
	@Override
	public void updateEducation(Education edu, int id) {
		// TODO Auto-generated method stub
		String sql = "update education set school=?, major=?, eduBg=?, startTime=?, endTime=? where id = ?";
		try {
			db.execute(sql, new Object[] {edu.getSchool(), edu.getMajor(), edu.getEduBg(), edu.getStartTime(), edu.getEndTime(), id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void updateWork(Work work, int id) {
		// TODO Auto-generated method stub
		String sql = "update work set corporation=?, occupation=?, department=?, startTime=?, endTime=?, jobContent=? where id = ?";
		try {
			db.execute(sql, new Object[] {work.getCorporation(), work.getOccupation(), work.getDepartment(), work.getStartTime(), work.getEndTime(), work.getJobContent(), id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void deleteEducation(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from education where id = ?";
		try {
			db.execute(sql, new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void deleteWork(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from work where id = ?";
		try {
			db.execute(sql, new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from user where id = ?";
		try {
			db.execute(sql, new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<User> findResume(int recuitId) {
		// TODO Auto-generated method stub
		String sql = "select * from user where id in (select userId from job_resume where postId = ?)";
		
		List uList = new ArrayList();
		try {
			uList = db.getQueryList(sql, new Object[] {recuitId});
		}catch(Exception e){
			uList = new ArrayList();
			e.printStackTrace();
		}
		return uList;
	}

}
