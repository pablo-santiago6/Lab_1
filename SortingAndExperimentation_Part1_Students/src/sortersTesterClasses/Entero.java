package sortersTesterClasses;

import sorterClasses.InsertionSortSorter;

import java.util.Comparator;

public class Entero {
    private int value;
    private Comparator<Entero> cmp = null;
    private InsertionSortSorter<Entero> sorter = new InsertionSortSorter<>();
    public Entero(int v){ value = v;}
    public int getValue(){return value;}
    public  String toString() { return value + "";}

    public void tester(Entero[] arr){
        sorter.sort(arr, cmp);
    }

}
