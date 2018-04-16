package sorterClasses;

<<<<<<< HEAD
public class combSorter{
=======
public class combSorter<E> extends AbstractMaxValueSorter {
>>>>>>> 9888c7ad89c7b7dd7fbbaf9bac3899d6ac6ea419

    public combSorter() {
        super("     Comb Sorter");
    }

    @Override
    //worst case is when it doest find any elements to swap until the gap is 0
    protected void relocateMaxValueToLastPositionAmongFirst(int i) {
        double f = 1.3;
        int gap = (int) Math.floor((i-1)/f) ;
        for (int j=0; j < i-1 ; j++) {
            if (cmp.compare(arr[j], arr[(j + gap)]) > 0) {
                super.swapArrayElements(j,((gap + j)));
            }
            if((gap-f)>0)gap = (int) Math.floor(gap/f);


        }
    }
}


