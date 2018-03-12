package linkedLists;

import java.util.NoSuchElementException;

public class DLDHDTList<E> extends AbstractDLList<E> {
    private DNode<E> header, trailer;
    private int length;

    public DLDHDTList() {
        header = new DNode<>(null, null, null);
        trailer = new DNode<>(null, header, null);
        header.setNext(trailer);
    }

    public void addFirstNode(Node<E> nuevo) {
        addNodeAfter(header, nuevo);
    }

    public void addLastNode(Node<E> nuevo) {
        DNode<E> dnuevo = (DNode<E>) nuevo;
        DNode<E> nBefore = trailer.getPrev();
        nBefore.setNext(dnuevo);
        trailer.setPrev(dnuevo);
        dnuevo.setPrev(nBefore);
        dnuevo.setNext(trailer);
        length++;
    }

    public void addNodeAfter(Node<E> target, Node<E> nuevo) {
        DNode<E> dnuevo = (DNode<E>) nuevo;
        DNode<E> nBefore = (DNode<E>) target;
        DNode<E> nAfter = nBefore.getNext();
        nBefore.setNext(dnuevo);
        nAfter.setPrev(dnuevo);
        dnuevo.setPrev(nBefore);
        dnuevo.setNext(nAfter);
        length++;
    }

    public void addNodeBefore(Node<E> target, Node<E> nuevo) {
        DNode<E> dnuevo = (DNode<E>) nuevo;
        DNode<E> nBefore = (DNode<E>) target;
        nBefore.getPrev().setNext(dnuevo);
        dnuevo.setNext(nBefore);
        length++;
    }

    public Node<E> createNewNode() {
        return new DNode<E>();
    }

    public Node<E> getFirstNode() throws NoSuchElementException {
        if (length == 0)
            throw new NoSuchElementException("List is empty.");
        return header.getNext();
    }

    public Node<E> getLastNode() throws NoSuchElementException {
        if (length == 0)
            throw new NoSuchElementException("List is empty.");
        return trailer.getPrev();
    }

    public Node<E> getNodeAfter(Node<E> target)
            throws NoSuchElementException {
        DNode<E> temp = ((DNode<E>) this.getFirstNode());
        DNode<E> dtarget = ((DNode<E>) target);
        if (dtarget == getLastNode()) {
            throw new NoSuchElementException("Element does not exist , node is the last");
        } else return dtarget.getNext();

    }

    public Node<E> getNodeBefore(Node<E> target)
            throws NoSuchElementException {
        if (target == getFirstNode()) {
            throw new NoSuchElementException("Node does not have a Node before");
        } else return ((DNode<E>) target).getPrev();

    }

    public int length() {
        return length;
    }

    public void removeNode(Node<E> target) {
        // ADD CODE HERE to disconnect target from the linked list, reduce lent, clean target...
        if (target == getLastNode()) ((DNode<E>) target).getPrev().setNext(null);
        else if (target == getFirstNode()) ((DNode<E>) target).getNext().setPrev(null);
        else {
            ((DNode<E>) target).getPrev().setNext(((DNode<E>) target).getNext());
            ((DNode<E>) target).getNext().setPrev(((DNode<E>) target).getPrev());
        }
        ((DNode<E>) target).setNext(null);
        ((DNode<E>) target).setPrev(null);
        ((DNode<E>) target).clean();
        length--;

    }

    public Object[] toArray() {
        DNode<E> temp = ((DNode)getFirstNode());
        Object[] arr = new Object[length()];
        for(int i = 0; i <= length(); i++) {
            arr[i] = temp;
            temp = temp.getNext();
        }
        return arr;
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
		while (header != null) { 
			DNode<E> nnode = header.getNext(); 
			header.clean(); 
			header = nnode; 
		}
	}
	
	/**
	 * The execution of this method removes all the data nodes from
	 * the current instance of the list, leaving it as a valid empty
	 * doubly linked list with dummy header and dummy trailer nodes. 
	 */
	public void makeEmpty() { 
		// TODO
	}
		
	protected void finalize() throws Throwable {
	    try {
			this.destroy(); 
	    } finally {
	        super.finalize();
	    }
	}

}
