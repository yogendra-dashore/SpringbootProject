package com.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserRepo {

	@Autowired
	JdbcTemplate stmt;
	
	public void addUser(UserBean user) {
		
		String insertUser= "insert into User1(firstname,lastname,password) values(?,?,?)";

				stmt.update(insertUser,user.getFirstame(),user.getLastname(),user.getPassword());
	}
}
