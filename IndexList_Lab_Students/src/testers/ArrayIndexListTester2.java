package testers;

import java.util.Random;

import arrayIndexList.ArrayIndexList;

public class ArrayIndexListTester2 {

	public static void main(String[] args) { 
		Random r = new Random(5);   // fixing seed of random sequence to 5
		
		ArrayIndexList<Integer> list = new ArrayIndexList<>(); 
		for (int i=0; i<15; i++) 
			list.add(r.nextInt(100));
		showList(list, " : THE ORIGINAL LIST."); 
		
		Object[] a1 = list.toArray(); 
		showArray(a1, "a1 after executing a1 = list.toArray().");
		
		a1[3] = 12345; 
		showList(list, " : THE ORIGINAL LIST."); 
		list.remove(3); 
		showList(list, " : after removing element at position 3 and doing a1[3] = 12345."); 
		showArray(a1, "a1 after changing element 3 to 12345");
		
		Integer[] a2 = {1, 2, 3, 4, 5}; 
		showArray(a2, "a2 after being initialized to {1, 2, 3, 4, 5}");
		
		Integer[] a3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17}; 
		
		Integer[] a4 = list.toArray(a2); 
		showArray(a2, "a2 after executing Integer[] a4 = list.toArray(a2).");
		showArray(a4, "a4 after executing Integer[] a4 = list.toArray(a2).");
		
		a4 = list.toArray(a3); 
		showArray(a3, "a3 after executing a4 = list.toArray(a3).");
		showArray(a4, "a4 after executing a4 = list.toArray(a3).");
		a3[3] = 999; 
		a4[4] = 999; 
		showArray(a3, "a3 after executing a3[3] = 999, a4[4] = 999.");
		showArray(a4, "a4 after executing a3[3] = 999, a4[4] = 999.");		
	}
	
	private static void showList(ArrayIndexList<Integer> list, String msg) { 
		System.out.println("Content of list " + msg); 
		
		for (int i=0; i<list.size(); i++) 
			System.out.print(list.get(i) + " "); 

		System.out.println(); 
		System.out.println("-----------------------------------------"); 
		
	}
	
	private static void showArray(Object[] arr, String msg) { 
		System.out.println("Content of array " + msg); 
		
		for (int i=0; i<arr.length; i++) 
			System.out.print(arr[i] + " "); 
		
		System.out.println(); 
		System.out.println("-----------------------------------------"); 
		
	}
}
