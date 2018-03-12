package linkedLists;

public abstract class AbstractDLList<E> implements LinkedList<E> {
	/**
	 * Class to represent a node of the type used in doubly linked lists. 
	 * @author pedroirivera-vega
	 *
	 * @param <T> Data type of element in a node.
	 */
	protected static class DNode<T> implements Node<T> {
		private T element; 
		private DNode<T> prev, next; 

		// Constructors
		public DNode() {
			this(null, null, null); 
		}
		
		public DNode(T e) { 
			this(e, null, null); 
		}
		
		public DNode(T e, DNode<T> p, DNode<T> n) { 
			element = e; 
			prev = p; 
			next = n; 
		}
		
		// Methods
		public DNode<T> getPrev() {
			return prev;
		}
		public void setPrev(DNode<T> prev) {
			this.prev = prev;
		}
		public DNode<T> getNext() {
			return next;
		}
		public void setNext(DNode<T> next) {
			this.next = next;
		}
		public T getElement() {
			return element; 
		}

		public void setElement(T data) {
			element = data; 
		} 
		
		/**
		 * Just set all fields to null. 
		 */
		public void clean() { 
			element = null; 
			prev = next = null; 
		}
		
	}
}
