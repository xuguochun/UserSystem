/*------------------------------------------------------------------------- 
* 版权所有：北京光宇在线科技有限责任公司
* 作者：胡明远
* 联系方式：xuguochun@gyyx.cn
* 创建时间： 2014/10/29 17:58:58
* 版本号：v1.0 
* 本类主要用途描述：
* 
-------------------------------------------------------------------------*/ 
package cn.gyyx.test.xuguochun.dao;

import java.util.List;

import cn.gyyx.test.xuguochun.beans.*;

public interface IUserDAO {

	List<UserInfo> GetList(String[] accounts);
	
	void InsertUserInfo(UserInfo userInfo);
}
