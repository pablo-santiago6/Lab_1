package sorterClasses;

public class cocktailSort<E> extends AbstractMaxValueSorter {
    public cocktailSort() {
        super("  Cocktail Sort");
    }

    @Override
    protected void relocateMaxValueToLastPositionAmongFirst(int i) {

            for (int j=0; j < i-1; j++){
                if (cmp.compare(arr[j], arr[j+1]) > 0){
                    super.swapArrayElements(j, j+1);
                }
            }


            for (int j=i-1; j <=0; j--){
                if (cmp.compare(arr[j-1], arr[j]) > 0){
                    super.swapArrayElements(j-1, j);
                }
            }

    }
}
