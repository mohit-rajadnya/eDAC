package dao;

import java.util.List;

import pojos.User;

public interface IUserDao {
	
	//add am ethod for user registration
	String registerUser(User user);
	String registerUserWithGetCurrentSession(User user);
	//add a method to fetch user details by userid
	User getUserDetails(int userId);
	//add a method to fetch all user details
	List<User> fetchAllUserDetails();
}
