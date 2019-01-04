package com.jk.recruit.dao.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jk.recruit.po.Corporation;
import com.jk.recruit.po.Recruitment;
import com.jk.recruit.po.Work;
import com.jk.recruit.util.DBUtil;

public class RecruitDao implements IRecruitDao {

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
	public void addRecruitment(Recruitment recruit) {
		// TODO Auto-generated method stub
		String sql = "insert into recruitment(postTitle, description, postPlace, salary, postType, eduBg, "
		+"city, employeeType, corporationId, releaseTime) values (?,?,?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] { recruit.getPostTitle(), recruit.getDescription(), recruit.getPostPlace(), recruit.getSalary(),
							recruit.getPostType(), recruit.getEduBg(), recruit.getCity(), recruit.getEmployeeType(), 
							recruit.getCorporationId(), recruit.getReleaseTime()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateRecruitment(Recruitment recruit, int oldId) {
		// TODO Auto-generated method stub
		String sql = "update recruitment set postTitle=?, description=?, postPlace=?, salary=?, postType=?, eduBg=?, " + 
				"city=?, employeeType=?, releaseTime=? where id = ?";
		try {
			db.execute(sql, new Object[] {recruit.getPostTitle(), recruit.getDescription(), recruit.getPostPlace(), recruit.getSalary(),
					recruit.getPostType(), recruit.getEduBg(), recruit.getCity(), recruit.getEmployeeType(), 
					recruit.getReleaseTime(), oldId});
					
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
	public List<Recruitment> findRecruitmentByCorporation(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from recruitment where corporationId = ?";

		List reList = new ArrayList();
		try {
			reList = db.getQueryList(sql, new Object[] { id });
		} catch (Exception e) {
			reList = new ArrayList();
			e.printStackTrace();
		}
		return reList;
	}

	

	@Override
	public void deleteRecruitById(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from recruitment where id = ?";
		try {
			db.execute(sql, new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
