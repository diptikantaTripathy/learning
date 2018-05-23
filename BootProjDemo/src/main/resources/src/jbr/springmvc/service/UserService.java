package jbr.springmvc.service;

import jbr.springmvc.model.LoginBean;
import jbr.springmvc.model.UserBean;
public interface UserService {

 UserBean validateUser(LoginBean login);
 boolean register(UserBean user);
}
