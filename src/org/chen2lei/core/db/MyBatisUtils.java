package org.chen2lei.core.db;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	public static SqlSessionFactory getSqlSessionFactory(Class<?> cls,String configFileName, String env ){
    	InputStream inputStream = cls.getResourceAsStream(configFileName);
    	return new SqlSessionFactoryBuilder().build(inputStream, env); 
	}
}
