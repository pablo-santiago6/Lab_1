package linkedLists;

import interfaces.LinkedList;
import interfaces.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLDHDTListIterableL2F<E> extends DLDHDTList<E> 
									  implements Iterable<E> 
{
	public Iterator<E> iterator() {
		return new LLIteratorF2L<E>(this);
	}

	private static class LLIteratorF2L<E> 
	implements Iterator<E> 
	{ 
		private LinkedList<E> theList;   // the list to iterate over
		private Node<E> current; 
		private boolean hasMoreElements; 

		public LLIteratorF2L(LinkedList<E> list) {
			theList = list; 
			if(theList.length() != 0){
				current = theList.getLastNode();
				hasMoreElements = true;
			}
		}

		public boolean hasNext() {
			return hasMoreElements; 
		}

		public E next() throws NoSuchElementException {
			if(!hasMoreElements){
				throw new NoSuchElementException("Iterator is over");
			}
			else{
				E r = current.getElement();
				try{
					current = theList.getNodeBefore(current);
				} catch(NodeOutOfBoundsException e){
					current = null;
					hasMoreElements = false;
				}
				return r;
				
			}
		}

		public void remove() throws UnsupportedOperationException 
		{
			throw new UnsupportedOperationException("Remove is not implemented.");

		}
	}

}
