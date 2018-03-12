package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.util.NoSuchElementException;

import linkedLists.LinkedList;
import linkedLists.AbstractSLList.SNode;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	int length; 
	
	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
		length++;
		first = (SNode<E>) nuevo;
		last = first;
		
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		length++;
		if(target == last){ last = ((SNode<E>)nuevo); }
		((SNode<E>)nuevo).setNext(((SNode<E>)target).getNext());
		((SNode<E>)target).setNext((SNode<E>) nuevo);
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		((SNode<E>)findNodePrevTo(target)).setNext(((SNode<E>)nuevo));
		((SNode<E>)nuevo).setNext(((SNode<E>)target));
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		return this.first;
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		return this.last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		
		Node<E> next = ((SNode<E>)target).getNext();
		if(next == null){
			throw new NoSuchElementException("This node is the last node");
		}
		else{
			return next;
		}
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		Node<E> prev = findNodePrevTo(target);
		if(prev == null) throw new NoSuchElementException("this node is the first one");
		else{
			return prev;
		}
	}

	public int length() {
		return this.length;
	}

	public void removeNode(Node<E> target) {
		if(target == last){ last = (SNode<E>)findNodePrevTo(target); }
		((SNode<E>)findNodePrevTo(target)).setNext(((SNode<E>)target).getNext());
		length--;
		target = null;
		
	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}
	
	private Node<E> findNodePrevTo(Node<E> target){
		if(target == first){ return null;}
		else { 
			SNode<E> prev = first; 
			while (prev != null && prev.getNext() != target) 
				prev = prev.getNext();  
			return prev; 
		}
	}

}
