package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import jbr.springmvc.model.LoginBean;
import jbr.springmvc.model.UserBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDaoImpl {
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void register(UserBean user) {
		String sql = "insert into users values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] { user.getUsername(), user.getPassword(),
						user.getFirstname(), user.getLastname(),
						user.getEmail(), user.getAddress(), user.getPhone() });
	}

	public UserBean validateUser(LoginBean login) {
		String sql = "select * from users where username='"
				+ login.getUsername() + "' and password='"
				+ login.getPassword() + "'";
		List<UserBean> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}
}

class UserMapper implements RowMapper<UserBean> {
	public UserBean mapRow(ResultSet rs, int arg1) throws SQLException {
		UserBean user = new UserBean();
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setEmail(rs.getString("email"));
		user.setAddress(rs.getString("address"));
		user.setPhone(rs.getInt("phone"));
		return user;
	}
}
