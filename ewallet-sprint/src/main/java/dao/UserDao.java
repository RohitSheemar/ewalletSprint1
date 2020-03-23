package dao;

import java.util.Map;

import bean.User;
import util.Collections;


public class UserDao implements Idao {
	
	@Override
	public User getDetails(int uid) {
		
		Map<Integer,User> mp=Collections.loginDetails();
		return mp.get(uid);
	}

}

