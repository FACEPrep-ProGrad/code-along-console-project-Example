package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.User;

public class CRUDOperations {
	static int value = 0;
	static Map<Integer,User> map = new HashMap<Integer,User>();
	static List<User> list = new ArrayList<User>();
	
	public List<User> addUser(User user) {
			list.add(user);
				return list;
		}
	
	public Map<Integer,User> addMapUser(int value,User user){
		++value;
		map.put(value,user);
		return map;
	}
	public List<User> getAllUsers(){
		return list;
	}
	public Map<Integer,User> getAllMapUsers(){
		return map;
	}
}
