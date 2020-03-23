package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import bean.User;
import dao.UserDao;
import util.Collections;

public class ServiceTesting {
	

	Scanner sc=new Scanner(System.in);

	
	@Test
	void serviceTest()
	{ 
	int uid1=sc.nextInt();
	UserDao ud=new UserDao();
	if(!Collections.loginDetails().containsKey(uid1))
		assertFalse(true,"Invalid user id");
	User d=ud.getDetails(uid1);
	User e=Collections.loginDetails().get(uid1);
	assertEquals(d, e);
	}
	

}
