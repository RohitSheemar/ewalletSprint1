package util;
import java.util.HashMap;
import java.util.Map;

import bean.User;

public class Collections {
	
	public static Map<Integer,User> users=new HashMap<>();
	static {
		users.put(1001, new User(1001,"9041179854","rohitsheemar@gmail.com","R123r","Rohit","Sheemar"));
		users.put(1002, new User(1002,"9041190411","rahulsharma@gmail.com","S123s","Rahul","Sharma"));
		users.put(1003, new User(1003,"7985479854","shivateja@gmail.com","T123t","Shiva","Teja"));
		users.put(1004, new User(1004,"9041904190","alokkumar@gmail.com","A123a","Alok","Kumar"));
		users.put(1005, new User(1005,"9090909090","rishablath@gmail.com","L123l","Rishab","Lath"));
	}
	public static Map<Integer, User> loginDetails()
	{
		return users;
	}
}
