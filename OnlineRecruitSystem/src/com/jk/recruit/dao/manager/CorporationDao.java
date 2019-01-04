package com.jk.recruit.dao.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jk.recruit.po.Corporation;
import com.jk.recruit.util.DBUtil;

public class CorporationDao implements ICorporationDao {

	@Override
	public List<Corporation> findAllCorporationByInfo(String key) {
		// TODO Auto-generated method stub
		String sql = "select * from corporation";
		if (!"".equals(key)) {
			sql += " where name like '%" + key + "%'";
			sql += " or territory like '%" + key + "%'";
			sql += " or stage like '%" + key + "%'";
			sql += " or scale like '%" + key + "%'";
			sql += " order by buildTime";
		}
		List cList = new ArrayList();
		try {
			cList = db.getQueryList(sql, new Object[] {});
		} catch (Exception e) {
			cList = new ArrayList();
			e.printStackTrace();
		}
		return cList;
	}

	DBUtil db = new DBUtil();

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
	public void addCorporation(Corporation c) {
		// TODO Auto-generated method stub
		String sql = "insert into corporation(name, territory, stage, scale, page, buildTime) values (?,?,?,?,?,?)";
		try {
			db.execute(sql,
					new Object[] { c.getName(), c.getTerritory(), c.getStage(), c.getScale(), c.getPage(), c.getBuildTime()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCorporation(Corporation c, int id) {
		// TODO Auto-generated method stub
		String sql = "update corporation set name=?, territory=?, stage=?, scale=?, page=? where id = ?";
		try {
			db.execute(sql,
					new Object[] { c.getName(), c.getTerritory(), c.getStage(), c.getScale(), c.getPage(), id });

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCorporation(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from corporation where id = ?";
		try {
			db.execute(sql, new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
