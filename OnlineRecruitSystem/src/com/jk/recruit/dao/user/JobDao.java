package com.jk.recruit.dao.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jk.recruit.po.Education;
import com.jk.recruit.po.Recruitment;
import com.jk.recruit.po.User;
import com.jk.recruit.po.Work;
import com.jk.recruit.util.DBUtil;

public class JobDao implements IJobDao {

	DBUtil db = new DBUtil();
	@Override
	public List<Recruitment> findAllRecruitByInfo(String key) {
		// TODO Auto-generated method stub
		String sql = "select * from recruitment";
		if (!"".equals(key)) {
			sql += " where postTitle like '%" + key + "%'";
			sql += " or description like '%" + key + "%'";
			sql += " or postPlace like '%" + key + "%'";
			sql += " or postType like '%" + key + "%'";
			sql += " or city like '%" + key + "%'";
			sql += " order by releaseTime";
		}
		List reList = new ArrayList();
		try {
			reList = db.getQueryList(sql, new Object[] {});
		} catch (Exception e) {
			reList = new ArrayList();
			e.printStackTrace();
		}
		return reList;
	}

	@Override
	public Map<String, Object> findCorporationById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from corporation c where c.id = ?";
		Map<String, Object> cMap = new HashMap();
		try {
			cMap = db.getObject(sql, new Object[] { id });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			cMap = new HashMap();
			e.printStackTrace();
		}
		return cMap;
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
	public List<Education> findEducationByUserId(int userId) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
	public Map<String, Object> findRecruitmentInfo(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from recruitment r where r.id = ?";
		Map<String, Object> recruitMap = new HashMap();
		try {
			recruitMap = db.getObject(sql, new Object[] { id });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			recruitMap = new HashMap();
			e.printStackTrace();
		}
		return recruitMap;
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
	public void addResume(int userId, int postId) {
		// TODO Auto-generated method stub
		String sql = "insert into job_resume(userId, postId) "
				+"values(?,?)";
		try {
			db.execute(sql, new Object[] {userId, postId});	
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
