package jbr.springmvc.dao;

import jbr.springmvc.model.LoginBean;
import jbr.springmvc.model.UserBean;

public interface UserDao {

	void register(UserBean user);
	UserBean validateUser(LoginBean login);
}
