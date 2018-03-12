/**
 * 
 */
package linkedLists;

import java.util.NoSuchElementException;

/**
 * @author pirvos
 *
 */
public class SLList<E> extends AbstractSLList<E> {
	private SNode<E> head; 
	private int length; 

	public SLList() {   // to create an empty list instance
		head = null; 
		length = 0; 
	}
	
	public void addFirstNode(Node<E> nuevo) {
		// Pre: nuevo is not a node in the list
		((SNode<E>) nuevo).setNext(head); 
		head = (SNode<E>) nuevo; 
		length++; 
	}

	public void addLastNode(Node<E> nuevo) { 
		SNode<E> sNuevo = (SNode<E>) nuevo; 
		sNuevo.setNext(null);
		if (length == 0)
			head = sNuevo; 
		else {   // find current last node and add the new one after that last node
			SNode<E> p = head; 
			while (p.getNext() != null) 
				p = p.getNext(); 
			p.setNext(sNuevo);
		}
		length++; 
	}
	
	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		// Pre: target is a node in the list
		// Pre: nuevo is not a node in the list
		((SNode<E>) nuevo).setNext(((SNode<E>) target).getNext()); 
		((SNode<E>) target).setNext((SNode<E>) nuevo); 
		length++; 
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		// Pre: target is a node in the list
		// Pre: nuevo is not a node in the list

		if (target == head)
			this.addFirstNode(nuevo); 
		else { 
			Node<E> prevNode = findNodePrevTo(target);  
			this.addNodeAfter(prevNode, nuevo); 
		}
	}

	private Node<E> findNodePrevTo(Node<E> target) {
		// Pre: target is a node in the list
		if (target == head) 
			return null; 
		else { 
			SNode<E> prev = head; 
			while (prev != null && prev.getNext() != target) 
				prev = prev.getNext();  
			return prev; 
		}
	}

	public Node<E> getLastNode() 
	throws NoSuchElementException 
	{
		if (head == null)
			throw new NoSuchElementException("getLastNode(): Empty list."); 
		else { 
			SNode<E> curr = head; 
			while (((SNode<E>) curr).getNext() != null)
				curr = curr.getNext(); 
			return curr; 
		}
	}

	public Node<E> getNodeAfter(Node<E> target) 
	throws NoSuchElementException 
	{
		// Pre: target is a node in the list
		SNode<E> aNode = ((SNode<E>) target).getNext(); 
		if (aNode == null)  
			throw new NoSuchElementException("getNextNode(...) : target is the last node."); 
		else 
			return aNode;
	}


	public Node<E> getNodeBefore(Node<E> target) 
	throws NoSuchElementException 
	{
		// Pre: target is a node in the list
		if (target == head)  
			throw new NoSuchElementException("getPrevNode(...) : target is the first node."); 
		else 
			return findNodePrevTo(target);
	}

	public int length() {
		return this.length;
	}

	public void removeNode(Node<E> target) {
		// Pre: target is a node in the list; hence, the list is not empty
		
		if (target == head) 
			head = head.getNext(); 
		else { 
			SNode<E> prevNode = (SNode<E>) this.getNodeBefore(target); 
			prevNode.setNext(((SNode<E>) target).getNext()); 
		}
		((SNode<E>) target).clean();   // clear all references from target
		length--; 
	}

	
	public Node<E> getFirstNode() 
	throws NoSuchElementException 
	{
		if (head == null)
			throw new NoSuchElementException("getFirstNode() : linked list is empty..."); 
		
		// the linked list is not empty....
		return head;
	}
	
	/**
	 * Prepares every node so that the garbage collector can free 
	 * its memory space, at least from the point of view of the
	 * list. This method is supposed to be used whenever the 
	 * list object is not going to be used anymore. Removes all
	 * physical nodes (data nodes and control nodes, if any)
	 * from the linked list
	 */
	private void destroy() {
		while (head != null) { 
			SNode<E> nnode = head.getNext(); 
			head.setElement(null); 
			head.setNext(null); 
			head = nnode; 
		}
	}
	
	/**
	 * The execution of this method removes all the data nodes
	 * from the current instance of the list. The list becomes
	 * an empty list. Notice that in general this is not the
	 * same as destroy(). However, in this type of list it
	 * can be done by first invoking the destroy method and
	 * then make length = 0. 
	 * 
	 * NOTE: For other types of list, this strategy may not
	 * be correct as it is here.
	 */
	public void makeEmpty() { 
		destroy(); 
		length = 0; 
	}
		
	protected void finalize() throws Throwable {
		//System.out.println("GC is WORKING!");
		//System.out.println("Number of nodes to remove is: "+ this.length); 
		try {
			this.destroy(); 
		} finally {
			super.finalize();
		}
	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}

}
