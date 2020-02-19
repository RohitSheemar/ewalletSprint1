package ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bean.User;
import userService.UserService;
import userService.Validation;
import util.Collections;

public class Client {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		UserService service=new UserService();
		while(true) {
			System.out.println("==============MENU====================");
	        System.out.println("1. Register");
	        System.out.println("2. Login");
	        System.out.println("3. Update Details");
	        System.out.println("4. Exit");
	        System.out.println("Enter your choice\n");
	        String choice;
			try {
				choice = br.readLine();
				switch (choice) {				
				case "1":
					int uid = 0;
					String mb;
					String em;
					String pw;
					String fn;
					String ln;
					System.out.println("Enter the user id: ");
					while(true)
					{
					String UserId=br.readLine();
					boolean b1 = Validation.validatedata(UserId, Validation.userIdPattern);
					if(b1 == true)
					{
					try
					{	
						uid= Integer.parseInt(UserId);
						break;
					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Enter valid userId!!!");
					}
					}
					else
					{
						System.out.println("Wrong input.Enter Valid id:");
					}
					}
					System.out.println("Enter the first name: ");
					while(true)
					{
					String firstName=br.readLine();
					boolean b1 = Validation.validatedata(firstName, Validation.namePattern);
					if(b1 == true)
					{
					try 
					{	
						fn =firstName;
						break;
					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Enter name Again!!!");
					}
					}
					else
					{
						System.out.println("Wrong input.Enter Valid characters:");
					}
					}
					
					System.out.println("Enter the last name: ");
					while(true)
					{
					String lastName=br.readLine();
					boolean b1 = Validation.validatedata(lastName, Validation.namePattern);
					if(b1 == true)
					{
					try 
					{	
						ln =lastName;
						break;
					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Enter valid last name Again!!!");
					}
					}
					else
					{
						System.out.println("Wrong name.Enter Valid characters:");
					}
					}
					
					System.out.println("Enter the PhoneNumber number: ");
					while(true)
					{
					String PhoneNumber=br.readLine();
					boolean b1 = Validation.validatedata(PhoneNumber,Validation.PhoneNumberPattern);
					if(b1 == true)
					{
						try 
						{
							mb= PhoneNumber;
							break;
						}
						catch(Exception e)
						{
							e.printStackTrace();
							System.out.println("Enter PhoneNumber number Again!!!");
						}
					}
					else
					{
						System.out.println("Wrong PhoneNumberNo Enter Again!!!");
					}
					}
					
					System.out.println("Enter your email address: ");
					while(true)
					{
					String email=br.readLine();
					boolean b1 = Validation.validatedata(email,Validation.emailPattern);
					if(b1 == true)
					{
						try 
						{
							em= email;
							break;
						}
						catch(Exception e)
						{
							e.printStackTrace();
							System.out.println("Enter valid email address!!!");
						}
					}
					else
					{
						System.out.println("Wrong Email. Enter Again!!!");
					}
					}
					System.out.println("Enter the password: ");
					while(true)
					{
					String password=br.readLine();
					boolean b1 = Validation.validatedata(password, Validation.passwordPattern);
					if(b1 == true)
					{
					try 
					{	
						pw =password;
						break;
					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Enter valid password !!!");
					}
					}
					else
					{
						System.out.println("Wrong password.Enter Valid password:");
					}
					}
					
					Collections.users.put(uid, new User(uid,mb,em,pw,fn,ln));
					System.out.println("Profile created");
					break;
					
				case "2":
					System.out.println("Enter the user id: ");
					while(true)
					{
					String UserId=br.readLine();
					boolean b1 = Validation.validatedata(UserId, Validation.userIdPattern);
					if(b1 == true)
					{
					try
					{	
						uid= Integer.parseInt(UserId);
						break;
					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Enter valid userId!!!");
					}
					}
					else
					{
						System.out.println("Wrong input.Enter Valid id:");
					}
					}
					System.out.println("Enter the password: ");
					while(true)
					{
					String password=br.readLine();
					boolean b1 = Validation.validatedata(password, Validation.passwordPattern);
					if(b1 == true)
					{
					try 
					{	
						pw =password;
						break;
					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Enter valid password !!!");
					}
					}
					else
					{
						System.out.println("Wrong password.Enter Valid password:");
					}
					
					}					
				   if(Collections.users.containsKey(uid))
					{
						String s=Collections.users.get(uid).getPassword();
						if(s.equals(pw))
						{
							System.out.println("You have successfully logged in");
							System.out.println("User ID: "+Collections.users.get(uid).getUserId());
							System.out.println("PhoneNumber : "+Collections.users.get(uid).getPhoneNumber());
							System.out.println("User name: "+Collections.users.get(uid).getFirstName()+" "+ Collections.users.get(uid).getLastName());
							System.out.println("Email: "+Collections.users.get(uid).getEmail());
							System.out.println("Password: "+Collections.users.get(uid).getPassword());
						}
						else
							System.out.println("wrong password");
						
					}
					else
						System.out.println("user id not registered");
					break;
					
				case "3":
					System.out.println("Enter the user id: ");
					while(true)
					{
					String UserId=br.readLine();
					boolean b1 = Validation.validatedata(UserId, Validation.userIdPattern);
					if(b1 == true)
					{
					try
					{	
						uid= Integer.parseInt(UserId);
						break;
					}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Enter valid userId!!!");
					}
					}
					else
					{
						System.out.println("Wrong input.Enter Valid id:");
					}
					}
					User u1=service.getDetails(uid);
					if(u1!= null)
					{
					System.out.println("What u want to update: ");
					System.out.println("1. Email");
					System.out.println("2. Password");
					String ch;
					ch=br.readLine();
					switch(ch)
					{
					case "1" :
						System.out.println("Enter the new email address: ");
						while(true)
						{
						String email=br.readLine();
						boolean b1 = Validation.validatedata(email,Validation.emailPattern);
						if(b1 == true)
						{
							try 
							{
								em= email;
								break;
							}
							catch(Exception e)
							{
								e.printStackTrace();
								System.out.println("Enter valid email Again!!!");
							}
						}
						else
						{
							System.out.println("Wrong PhoneNumberNo Enter Again!!!");
						}
						}
						u1.setEmail(em);
						System.out.println("Email address updated");
						break;
					case "2" :
						System.out.println("Enter the new password: ");
						while(true)
						{
						String password=br.readLine();
						boolean b1 = Validation.validatedata(password,Validation.passwordPattern);
						if(b1 == true)
						{
							try 
							{
								pw= password;
								break;
							}
							catch(Exception e)
							{
								e.printStackTrace();
								System.out.println("Enter valid password!!!");
							}
						}
						else
						{
							System.out.println("Wrong Password Enter Again!!!");
						}
						}
						u1.setPassword(pw);
						System.out.println("Password updated");
						break;
						
					}
					}
					else
					{
						System.out.println("Please enter the registered PhoneNumber");
					}	
					break;
	
					case "4":					   
					   System.out.println("Thank You. Have a nice day!!");
					   System.exit(0);
	                   break;
	                   
	            default:
	            	  System.out.println("Invalid choice");
		        }
			}
			catch (IOException e) {
				e.printStackTrace();
			}

	    }
    }
}


