package org.chen2lei.service.register.business;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.chen2lei.common.MySqlSession;
import org.chen2lei.service.register.db.RegisterUser;
import org.chen2lei.service.register.vo.RegisterVO;
import org.springframework.stereotype.Component;

import org.chen2lei.service.register.business.RegisterBusiness;

@Component
public class RegisterBusiness {
	
	Logger logger = Logger.getLogger(RegisterBusiness.class);
	public String newUser(RegisterVO vo){
		logger.debug("trying to new a user");
		SqlSession sqlSession = MySqlSession.openMasterSession();
		
		RegisterUser registerUser = null;
		try {
			registerUser = sqlSession
					.selectOne("db.RegisterUserMapper.selectUserByTelNumber", vo.getTelNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug(registerUser);
		
		RegisterUser newUser = new RegisterUser();
		
		newUser.setName(vo.getName());
		newUser.setTelNumber(vo.getTelNumber());
		newUser.setPassword(vo.getPassword());
		newUser.setEmail(vo.getEmail());
		sqlSession.insert("db.RegisterUserMapper.addUser", newUser);
		
		logger.debug(newUser);
		return newUser.getTelNumber();
	}
}
