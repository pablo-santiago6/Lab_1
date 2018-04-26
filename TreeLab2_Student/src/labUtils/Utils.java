package labUtils;

import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Position;
import treeInterfaces.Tree;

import java.util.Iterator;

public class Utils {
	public static <E> void displayTree(String msg, Tree<E> t) { 
		System.out.println("\n\n" + msg); 
		t.display(); 
	}

	public static <E> void displayTreeElements(String msg, Tree<E> t) {
		System.out.println("\n\n" + msg); 
		for (E element : t)
			System.out.println(element); 
		
	}


	public static LinkedTree<Integer> buildExampleTreeAsLinkedTree() {
		LinkedTree<Integer> t = new LinkedTree<>(); 
		// ADD CODE AS SPECIFIED IN EXERCISE 2
        t.addRoot(4);

        t.addChild(t.root(),9);
        t.addChild(t.root(),20);

        Iterator<Position<Integer>> iter = t.children(t.root()).iterator();

        Position<Integer> e9 = iter.next();
        t.addChild(e9,7);
        t.addChild(e9,10);

        Position<Integer> e20 = iter.next();
        t.addChild(e20,15);
        t.addChild(e20,21);

        iter = t.children(e20).iterator();
        Position<Integer> e15 = iter.next();
        t.addChild(e15,12);
        t.addChild(e15,17);

        Iterator<Position<Integer>> iter2 = t.children(e15).iterator();
        iter2.next();
        Position<Integer> e17 = iter2.next();
        t.addChild(e17,19);

        Position<Integer> e21 = iter.next();
        t.addChild(e21,40);

        iter2 = t.children(e21).iterator();
        Position<Integer> e40 = iter2.next();
        t.addChild(e40,30);
        t.addChild(e40,45);

        return t;
	}
	
	public static LinkedBinaryTree<Integer> buildExampleTreeAsLinkedBinaryTree() { 
		LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>(); 
		// ADD CODE AS SPECIFIED IN EXERCISE 2
        t.addRoot(4);

        t.addLeft(t.root(),9);
        t.addRight(t.root(),20);

        Iterator<Position<Integer>> iter = t.children(t.root()).iterator();

        Position<Integer> e9 = iter.next();
        t.addLeft(e9,7);
        t.addRight(e9,10);

        Position<Integer> e20 = iter.next();
        t.addLeft(e20,15);
        t.addRight(e20,21);

        iter = t.children(e20).iterator();
        Position<Integer> e15 = iter.next();
        t.addLeft(e15,12);
        t.addRight(e15,17);

        Iterator<Position<Integer>> iter2 = t.children(e15).iterator();
        iter2.next();
        Position<Integer> e17 = iter2.next();
        t.addLeft(e17,19);

        Position<Integer> e21 = iter.next();
        t.addRight(e21,40);

        iter2 = t.children(e21).iterator();
        Position<Integer> e40 = iter2.next();
        t.addLeft(e40,30);
        t.addRight(e40,45);
		
		
		return t; 
	}


}
