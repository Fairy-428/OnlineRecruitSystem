package com.jk.recruit.dao.login;

import com.jk.recruit.po.User;
import com.jk.recruit.util.DBUtil;

public class LoginDao implements ILoginDao {
	private DBUtil db = new DBUtil();
	@Override
	public User canLogin(User user) {
		// TODO Auto-generated method stub
		String sql = "select * from user where name = ? and password = ?";
		User user2 = new User();	
		try {
			user2 = (User)db.getObject(User.class, sql, new Object[] {user.getName(), user.getPassword()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			user2 = new User();	
			e.printStackTrace();
		}
		return user2;
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

}
