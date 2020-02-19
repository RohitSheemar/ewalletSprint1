package testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import bean.User;
import dao.UserDao;
import userService.Validation;
import util.Collections;


public class Testing1 {
	
	Scanner sc=new Scanner(System.in);

	
	@Test
	void serviceTest()
	{
	int uid1=sc.nextInt();
	UserDao ud=new UserDao();
	if(!Collections.details().containsKey(uid1))
		assertFalse(true,"Invalid user id");
	User d=ud.getDetails(uid1);
	User e=Collections.details().get(uid1);
	assertEquals(d, e);
	}
	
	@Test
	void uidPatternTest()
	{
	String ui=sc.next();
	String i=Validation.userIdPattern;
	boolean b=Validation.validatedata(ui,i);
	
	assertEquals(true,b,"Invalid user id");
	}

	@Test
	void mobilePatternTest()
	{
	String mob=sc.next();
	String m=Validation.PhoneNumberPattern;
	boolean b=Validation.validatedata(mob, m);
	
	assertEquals(true,b,"Invalid mobile no");
	}
	
	@Test
	void emailPatternTest()
	{
	String eml=sc.next();
	String e=Validation.emailPattern;
	boolean b=Validation.validatedata(eml, e);
	
	assertEquals(true,b,"Invalid securityEmaik id");
	}
	
	@Test
	void usernamePatternTest()
	{
	String fn=sc.next();
	String n=Validation.namePattern;
	boolean b=Validation.validatedata(fn, n);
	
	assertEquals(true,b,"Name should start with capital letter");
	}
	
	@Test
	void passwordPatternTest()
	{
	String pw=sc.next();
	String p=Validation.passwordPattern;
	boolean b=Validation.validatedata(pw,p);
	
	assertEquals(true,b,"Invalid passwprd");
	}
	
}
