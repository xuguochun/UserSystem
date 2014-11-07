package cn.gyyx.test.xuguochun.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mybatis {
	
	private static SqlSessionFactory sqlUserSessionFactory;
	
	static{
		
		try {
			String resource = "mybatis/config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			if (sqlUserSessionFactory == null) {
				sqlUserSessionFactory = new SqlSessionFactoryBuilder().build(reader,"user" );
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取工厂会话
	 * @return
	 */
	public static SqlSessionFactory getSqlAccountSessionFactory() {
 
        return sqlUserSessionFactory;
    }

}
