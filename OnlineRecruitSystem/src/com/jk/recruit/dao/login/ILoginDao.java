package com.jk.recruit.dao.login;

import com.jk.recruit.po.User;

public interface ILoginDao {
	public User canLogin(User user);
	public void addUser(User user);
}
