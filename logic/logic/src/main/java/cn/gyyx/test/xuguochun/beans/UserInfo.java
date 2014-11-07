/*------------------------------------------------------------------------- 
* 版权所有：北京光宇在线科技有限责任公司
* 作者：胡明远
* 联系方式：xuguochun@gyyx.cn
* 创建时间： 2014/10/29 17:58:58
* 版本号：v1.0 
* 本类主要用途描述：
* 
-------------------------------------------------------------------------*/ 

package cn.gyyx.test.xuguochun.beans;

/*
 * UserInfo
 */
public class UserInfo {

	private int code;
	private String username;
	private String password;
	private String sex;
	private int age;
	private String mail;
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	

	
	
}
