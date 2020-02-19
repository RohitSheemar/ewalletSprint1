package userService;

public interface Validation {
	//String passwordPattern="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	String userIdPattern="[1-9][0-9][0-9][0-9]";
	String passwordPattern="[A-Z][0-9][0-9][0-9][a-z]";
	String PhoneNumberPattern="[1-9][0-9]{9}";
	String namePattern="[A-Z][a-z]*";
	String emailPattern="^[A-Za-z0-9+_.-]+@(.+)$";

	public static boolean validatedata(String data,String pattern)
	{
		return data.matches(pattern);
	}
}
