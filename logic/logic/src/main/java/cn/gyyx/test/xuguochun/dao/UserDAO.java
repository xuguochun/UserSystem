package cn.gyyx.test.xuguochun.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.gyyx.test.xuguochun.beans.UserInfo;

public class UserDAO implements IUserDAO {

	private SqlSessionFactory sqlSessionFactory;
	
	/*
	 * UserDAO 构造函数
	 */
	public UserDAO()
	{
		sqlSessionFactory = Mybatis.getSqlAccountSessionFactory();
	}
	
	/*
	 * 获取用户列表
	 * @param String[] accounts
	 * @return
	 */
	public List<UserInfo> GetList(String[] accounts) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IUserDAO Mapper = sqlSession.getMapper(IUserDAO.class);
		List<UserInfo> userlist=Mapper.GetList(accounts);
		sqlSession.close();
		return userlist;
	}

	/*
	 * 插入用户信息
	 * @param UserInfo userInfo
	 * @return
	 */
	public void InsertUserInfo(UserInfo userInfo) {
		
		SqlSession session = sqlSessionFactory.openSession();
		
		try{
			
			IUserDAO userDao = session.getMapper(IUserDAO.class);
			userDao.InsertUserInfo(userInfo);
			
		}finally{
			
			if(session!=null)
			{
				session.commit();
				session.close();
			}
		}
		
	}

}
