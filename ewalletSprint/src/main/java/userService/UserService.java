package userService;

import bean.User;
import dao.UserDao;

public class UserService implements IService {
	UserDao ud=new UserDao();
	@Override
	public  User getDetails(int uid){
		return ud.getDetails(uid);
	}
	
}
