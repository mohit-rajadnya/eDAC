package dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import pojos.Role;
import pojos.User;

public interface IUserDao {
//add a method for user registration : open session
	String registerUser(User user);
	//add a method for user registration : get curnt session
		String registerUserWithGetCurntSession(User user);
		//add a method to fetch user details by user id
		User getUserDetails(int userId);
		//add a method to fetch all user details
		List<User> fetchAllUserDetails();
		//add a method for fetching selected userdetails
		List<User> fetchSelectedUserDetails(LocalDate start , LocalDate end, Role user);
		User authenticateUser(String email , String password);
		List<User> fetchSelectedUserNames(LocalDate start , LocalDate end , Role user);
		String changePassword(int userId ,String newPwd);
		//apply discount to customers who have reged before a particular reg date
		String applyDiscount(double discount,LocalDate date);
		//unsubscribe user, i/p : user ID
		String deleteUserDetails(int userId);
		//save an image in db
		String saveImage(String email,String imageFilePath)throws IOException;
		//restore image frm database
		String restoreImage(int userId, String destImagePath)throws IOException;
		

}
