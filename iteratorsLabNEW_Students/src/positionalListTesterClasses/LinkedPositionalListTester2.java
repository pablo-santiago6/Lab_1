package positionalListTesterClasses;


import java.util.Iterator;

import interfaces.Position;
import llPositionalList.LinkedPositionalList;

public class LinkedPositionalListTester2 {

	public static void main(String[] args) {
		LinkedPositionalList<Integer> list1 = new LinkedPositionalList<>(); 

		Position<Integer> f = list1.addFirst(1); 
		Position<Integer> l = list1.addLast(10);
		Position<Integer> c = list1.addAfter(f, 4); 
		list1.addBefore(c, 3); 
		list1.addAfter(f, 2); 
		Position<Integer> pp = list1.addBefore(l, 7); 
		list1.addAfter(pp, 8);
		list1.addBefore(l, 9);
		showList("list1 = ", list1);
		showList2("list1 = ", list1);
		
		Position<Integer> p1 = list1.after(pp); 
		System.out.println("Removing from list1: " + list1.remove(p1));	
		showList("list1 = ", list1);
		showList2("list1 = ", list1);
		System.out.println("Removing from list1: " + list1.remove(list1.first()));	
		showList("list1 = ", list1);
		showList2("list1 = ", list1);
		System.out.println("Removing from list1: " + list1.remove(list1.last()));	
		showList("list1 = ", list1);
		showList2("list1 = ", list1);
		
		removeEvenValues(list1); 
		showList("After removing even numbers, list1 = ", list1); 
		showList2("After removing even numbers, list1 = ", list1); 
	}

	private static void removeEvenValues(LinkedPositionalList<Integer> list) {
		Iterator<Integer> iter = list.iterator(); 
		while (iter.hasNext())
			if (iter.next() % 2 == 0)
				iter.remove();
		
	}

	private static void showList(String msg, LinkedPositionalList<Integer> list) {
		System.out.print(msg); 
		for (Position<Integer> v : list.positions()) 
			System.out.print(v.getElement() + " "); 
		System.out.println(" -- size = " + list.size()); 
	}

	private static void showList2(String msg, LinkedPositionalList<Integer> list) {
		System.out.print(msg); 
		Iterator<Integer> iter = list.iterator(); 
		while (iter.hasNext())
			System.out.print(iter.next() + " "); 
		System.out.println(" -- size = " + list.size()); 
	}

}
