package client;

import dao.StoreInformation;
import dao.LoginAccess;

public class Main {
	
	
	public static void main(String[] args) {
		
		LoginAccess login = new LoginAccess();
		StoreInformation store = new StoreInformation();
		
        login.startLogin();
        
        store.startApplication();
		
        
	}
	
	

}
