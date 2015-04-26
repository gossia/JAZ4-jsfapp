package repository;

import java.util.ArrayList;

import domain.Address;
import domain.User;

public class DummyDb {
	
	public ArrayList<User> users;
	public ArrayList<Address> addresses;
	
	public DummyDb()
	{
		users = new ArrayList<User>();
		addresses = new ArrayList<Address>();
	}

}
