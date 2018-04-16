package testers;

import classes.SLLStack;

public class Tester1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SLLStack<Integer> s = new SLLStack<Integer>(); 
		int[] a = { 3, 2, 4, 55, 5, 1, 1, 17, 9, 3, 0, 4, 5, 7, 17, 28, 0, 9, 10, 40, 21, 22, 5, 6, -1}; 
		for (int n : a) { 
				if (n == 0) 
					s.showReverse(); 
				else if (n % 2 == 1)
					s.push(n); 
				else
					System.out.println("Extracting element: " + s.pop()); 
			}

		s.showReverse(); 
	}

}
