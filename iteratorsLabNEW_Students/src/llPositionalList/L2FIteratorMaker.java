package llPositionalList;

import java.util.Iterator;

import interfaces.PLIteratorMaker;
import interfaces.Position;
import interfaces.PositionalList;

public class L2FIteratorMaker<E> implements PLIteratorMaker<E> {

	@Override
	public Iterator<Position<E>> makeIterator(PositionalList<E> pl) {
		return new PLIteratorL2F(pl);
	}

}
