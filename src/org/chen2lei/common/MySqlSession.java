package org.chen2lei.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.chen2lei.common.MySqlSession;
import org.chen2lei.core.db.MyBatisUtils;

public class MySqlSession{
	private static SqlSessionFactory masterSessionFactory;
	private static SqlSessionFactory slave01SessionFactory;
	
	static{
    	masterSessionFactory =
    		MyBatisUtils.getSqlSessionFactory(MySqlSession.class, "mybatis-config.xml", "master");
    		
    	slave01SessionFactory =
    		MyBatisUtils.getSqlSessionFactory(MySqlSession.class, "mybatis-config.xml", "slave01");
    }
	
	
	public static SqlSession openMasterSession(){
		return masterSessionFactory.openSession(true);
	}
	
	public static SqlSession openSlaveSession(){
		return slave01SessionFactory.openSession();
	}
}
