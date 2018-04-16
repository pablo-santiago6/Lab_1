package llPositionalList;

import interfaces.Position;
import interfaces.PositionalList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PLIteratorL2F<E> implements Iterator<Position<E>> {

	PositionalList<E> list; 
	Position<E> current, recent; 
	public PLIteratorL2F(PositionalList<E> list) { 
		this.list = list; 
		current = list.last(); 
		recent = null; 
	}
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public Position<E> next() throws NoSuchElementException {
		if (!hasNext()) 
			throw new NoSuchElementException("No more elements to iterate over."); 
		recent = current; 
		current = list.before(current); 
		return recent;
	}
	
	public void remove() throws IllegalStateException { 
		if (recent == null)
			throw new IllegalStateException("Invalid state to apply remove."); 
		list.remove(recent); 
		recent = null; 
	}

}
