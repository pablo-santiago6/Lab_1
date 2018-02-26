

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> myArray = new ArrayList<Integer>();
		int request = sc.nextInt();
		
		for(int i =0; i < request; i++){
			int command = sc.nextInt();
			int number = 0;
			if(command != 3 && command != 4)number = sc.nextInt();
			
			switch(command){
			case 1: myArray.add(number);break;
			case 2: if(!myArray.isEmpty())myArray.remove((Object)number);break;
			case 3: System.out.println("-> \"" + myArray.size() + "\"");break;

			}
			
		}

	}
}
	
