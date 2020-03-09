package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import businesslogic.Validation;
import dao.CRUDOperations;
import model.User;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Welcome to Week - 3 Application");
		System.out.println("Enter your choice");
		System.out.println("1. SIGN UP");
		System.out.println("2. SIGN IN");
		System.out.println("3. DISPLAY USER DETAILS");
		System.out.println("3. ADD BLOG");
		System.out.println("4. VIEW BLOG");
		System.out.println("5. SEARCH BLOG");
		String email=null;
		String password=null;

		User user = null;
		
		// Syntax of creating an array list
		List<User> list=new ArrayList<User>();
		Map<Integer,User> map= new HashMap<Integer,User>();
		
		
		CRUDOperations crud=new CRUDOperations();
		int choice = 0;
		// Getting user inputs
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String yes;
		do {
			choice =Integer.parseInt(br.readLine());
		switch(choice) {
		case 1:
			System.out.println("New Sign Up");
			System.out.println("Enter Username:");
			email = br.readLine();
			System.out.println("Enter Password:");
			password = br.readLine();
			Validation validate=new Validation();
			if(validate.checkUserDetails(email,password)){
			user=new User(email,password);
			
			crud.addUser(user);
			crud.addMapUser(0, user);
			
			}
			break;
		case 3:
			System.out.println("User Details");
			list = crud.getAllUsers();
			map = crud.getAllMapUsers();
			System.out.println("Display using list");
			for(User userlist:list) {
				System.out.println(userlist.getUsername());
				System.out.println(userlist.getPassword());
			}
			System.out.println("Display using map");
			for(Map.Entry<Integer, User> maplist:map.entrySet()) {
				System.out.println("Key " + maplist.getKey()+ " Username "+ maplist.getValue().getUsername() + "Password "+maplist.getValue().getPassword());
			}
			break;
			
		}
		System.out.println("Do you want to continue");
		yes=br.readLine();
		}while(yes.equals("yes"));
		
		
	}
}
