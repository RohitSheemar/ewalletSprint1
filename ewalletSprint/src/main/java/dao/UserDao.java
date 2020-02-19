package dao;

import java.util.Map;

import bean.User;
import util.Collections;


public class UserDao implements Idao {
	Collections col=new Collections();
	
	@Override
	public User getDetails(int uid) {
		Map<Integer,User> mp=Collections.details();
		User u=mp.get(uid);
		return u;
	}

}

