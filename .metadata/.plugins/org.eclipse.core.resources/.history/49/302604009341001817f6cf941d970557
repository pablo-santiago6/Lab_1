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
		// ... other internal fields ...
		private Node<E> current; 
		private boolean hasMoreElements; 

		public LLIteratorF2L(LinkedList<E> list) {
			theList = list; 
			// ... initialize other internal fields ...
		}

		public boolean hasNext() {
			// Write the new code and substitute next statement ....
			return false; 
		}

		public E next() throws NoSuchElementException {
			// Write the new code and substitute next statement ...
			return null;
		}

		public void remove() throws UnsupportedOperationException 
		{
			throw new UnsupportedOperationException("Remove is not implemented.");

		}
	}

}
