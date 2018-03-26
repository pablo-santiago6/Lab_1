package sortersTesterClasses;

import sorterClasses.BubbleSortSorter;
import sorterClasses.InsertionSortSorter;

import java.util.Comparator;

public class tester {

    public static  void main(String args[]){

        Integer[] arr = {5,9,20,22,20,5,4,13,17,8,22,1,3,7,11,9,10};
        Integer[] arr0 = {5,9,20,22,20,5,4,13,17,8,22,1,3,7,11,9,10};
        IntegerComparator1 cmp1 = new IntegerComparator1();
        IntegerComparator2 cmp2 = new IntegerComparator2();

        Integer[] arr1 = tester(arr,cmp1);
        Integer[] arr2 = tester(arr0,cmp2);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr2[i]+ " ");
        }
    }

    public static Integer[] tester(Integer[] arr , Comparator cmp){
        InsertionSortSorter<Integer> sorter = new InsertionSortSorter<>();
        sorter.sort(arr,cmp);
        return arr;
    }
}
