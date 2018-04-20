package llPositionalList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import interfaces.Position;
import interfaces.PositionalList;

public class PositionalListElementsBackwardIterator<E> implements Iterator<E> {

    Position<E> current, recent;

    PositionalList<E> list;

    public PositionalListElementsBackwardIterator(PositionalList<E> list) {
        this.list = list;
        current = list.last();
        recent = null;
    }


    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public E next() {
        if(!hasNext()) {
            throw new NoSuchElementException("No more elements to iterate.");
        }

        recent = current;
        current = list.before(current);
        return recent.getElement();

    }

}
