package testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import service.Validation;


public class ValidationTesting {
	
	Scanner sc=new Scanner(System.in);

	 
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
	
	assertEquals(true,b,"Invalid Email id");
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
