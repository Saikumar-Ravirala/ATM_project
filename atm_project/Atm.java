package atm_project;

import java.util.Scanner;

public class Atm{
	
	public static void main(String[] args) {
		System.out.println("WELCOME \nPLS ENTER UR LOGIN CRED.");
		BackGroundOperation o =new BackGroundOperation();
		
		Scanner sc = new Scanner(System.in);
		
		CustomerDetails  c = o.credChecker(sc);
		
		o.menu(c,sc);
		
		sc.close();
	}
}	
