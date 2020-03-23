package ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bean.User;
import service.UserService;
import service.Validation;
import userDefinedException.EmailNotValid;
import userDefinedException.NameNotValid;
import userDefinedException.PasswordNotValid;
import userDefinedException.PhoneNumberNotValid;
import userDefinedException.UserIdNotValid;
import util.Collections;

public class Client {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		UserService service=new UserService();
		while(true) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("====================MENU======================");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	        System.out.println("1. ---------------Register----------->>>>>>>>>");
	        System.out.println("2. ----------------Login------------->>>>>>>>>");
	        System.out.println("3. ------------Update Details-------->>>>>>>>>");
	        System.out.println("4. ----------------Exit-------------->>>>>>>>>"); 
	        System.out.println("Enter your choice\n");
	        String choice;
			try {
				choice = br.readLine();
				switch (choice) {				
				case "1":
					int uid;
					String phone;
					String em;
					String pw;
					String firstname;
					String lastname;
					System.out.println("Enter the first name: ");
					while(true)
					{
					String firstName=br.readLine();
					boolean b1 = Validation.validatedata(firstName, Validation.namePattern);
					try 
					{
						if(b1 == true)
						{
							firstname =firstName;
							break;
						}
						else
						{
							throw new NameNotValid("Please enter valid name");
						}
					}
					catch(NameNotValid e)
					{
						System.out.println(e.getMessage());
					}
					}
					
					System.out.println("Enter the last name: ");
					while(true)
					{
					String lastName=br.readLine();
					boolean b1 = Validation.validatedata(lastName, Validation.namePattern);
					try 
					{
						if(b1 == true)
						{
							lastname =lastName;
							break;
						}
						else
						{
							throw new NameNotValid("Please enter valid name");
						}
					}
					catch(NameNotValid e)
					{
						System.out.println(e.getMessage());
					}
					}
					
					System.out.println("Enter the Phone Number: ");
					while(true)
					{
					String PhoneNumber=br.readLine();
					boolean b1 = Validation.validatedata(PhoneNumber,Validation.PhoneNumberPattern);
					try 
					{
						if(b1 == true)
						{
							phone= PhoneNumber;
							break;
						}
						else
							throw new PhoneNumberNotValid("Please enter valid phone number");
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					}
					
					System.out.println("Enter your email address: ");
					while(true)
					{
					String email=br.readLine();
					boolean b1 = Validation.validatedata(email,Validation.emailPattern);
					try 
					{
						if(b1 == true)
						{
							em= email;
							break;
						}
						else
							throw new EmailNotValid("Please enter valid email address");
					}
					catch(EmailNotValid e)
					{
						System.out.println(e.getMessage());
					}
					}
					
					System.out.println("Enter the password: ");
					while(true)
					{
					String password=br.readLine();
					boolean b1 = Validation.validatedata(password, Validation.passwordPattern);
					try 
					{
						if(b1 == true)
						{
						pw =password;
						break;
						}
						else
							throw new PasswordNotValid("Please enter valid password");
					}
					catch(PasswordNotValid e)
					{
						System.out.println(e.getMessage());
					}
					}
					uid=1001;
					Collections.users.put(uid, new User(uid,phone,em,pw,firstname,lastname));
					System.out.println("Profile created");
					break;
					
				case "2":
					System.out.println("Enter the user id: ");
					while(true)
					{
					String UserId=br.readLine();
					boolean b1 = Validation.validatedata(UserId, Validation.userIdPattern);
					try
					{
						if(b1 == true)
						{
						uid= Integer.parseInt(UserId);
						break;
						}
						else
						{
							throw new UserIdNotValid("Please enter valid user id");
						}			
					}
					catch(UserIdNotValid e)
					{
						System.out.println(e.getMessage());
					}
					}
					
					System.out.println("Enter the password: ");
					while(true)
					{
					String password=br.readLine();
					boolean b1 = Validation.validatedata(password, Validation.passwordPattern);
					try 
					{
						if(b1 == true)
						{
						pw =password;
						break;
						}
						else
							throw new PasswordNotValid("Please enter valid password");
					}
					catch(PasswordNotValid e)
					{
						System.out.println(e.getMessage());
					}
					}	
				   if(Collections.users.containsKey(uid))
					{
						String s=Collections.users.get(uid).getPassword();
						if(s.equals(pw))
						{
							System.out.println("You have successfully logged in");
							System.out.println("---------------------------------------------");
							System.out.println("  User ID:     "+Collections.users.get(uid).getUserId());
							System.out.println("  Phone No:    "+Collections.users.get(uid).getPhoneNumber());
							System.out.println("  User Name:   "+Collections.users.get(uid).getFirstName()+" "+ Collections.users.get(uid).getLastName());
							System.out.println("  Email ID:    "+Collections.users.get(uid).getEmail());
							System.out.println("  Password:    "+Collections.users.get(uid).getPassword());
							System.out.println("----------------------------------------------");
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
					try
					{
						if(b1 == true)
						{
						uid= Integer.parseInt(UserId);
						break;
						}
						else
						{
							throw new UserIdNotValid("Please enter valid user id");
						}			
					}
					catch(UserIdNotValid e)
					{
						System.out.println(e.getMessage());
					}
					}
					User u1=service.getDetails(uid);
					if(u1!= null)
					{
					System.out.println("What u want to update: ");
					System.out.println("1. Email");
					System.out.println("2. Phone number");
					System.out.println("3. Password");

					
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
						try 
						{
							if(b1 == true)
							{
								em= email;
								break;
							}
							else
								throw new EmailNotValid("Please enter valid email address");
						}
						catch(EmailNotValid e)
						{
							System.out.println(e.getMessage());
						}
						}
						u1.setEmail(em);
						System.out.println("Email address updated");
						break;
					case "2" :
						System.out.println("Enter the new phone number: ");
						while(true)
						{
						String PhoneNumber=br.readLine();
						boolean b1 = Validation.validatedata(PhoneNumber,Validation.PhoneNumberPattern);
						try 
						{
							if(b1 == true)
							{
								phone= PhoneNumber;
								break;
							}
							else
								throw new PhoneNumberNotValid("Please enter valid phone number");
						}
						catch(Exception e)
						{
							System.out.println(e.getMessage());
						}
						}
						u1.setPhoneNumber(phone);
						System.out.println("Phone number updated");
						break;
					case "3" :
						System.out.println("Enter the new password: ");
						while(true)
						{
						String password=br.readLine();
						boolean b1 = Validation.validatedata(password, Validation.passwordPattern);
						try 
						{
							if(b1 == true)
							{
							pw =password;
							break;
							}
							else
								throw new PasswordNotValid("Please enter valid password");
						}
						catch(PasswordNotValid e)
						{
							System.out.println(e.getMessage());
						}
						}	
						u1.setPassword(pw);
						System.out.println("Password updated");
						break;
						
					}
					}
					else
					{
						System.out.println("Please enter the registered user ID ");
					}
				    break;
	
					case "4":					   
					   System.out.println("Thank You. Have a nice day!!");
	                   break;
	                   
	            default:
	            	  System.out.println("Invalid choice");
		        }
			}
			catch (IOException e) {
				e.printStackTrace();
				System.out.println("invalid input");
			}

	    }
    }
}


