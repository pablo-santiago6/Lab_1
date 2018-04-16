package sortersTesterClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import sorterClasses.*;
import interfaces.Sorter;

public class IntegerSorterTester {
	//private static Sorter<Integer> sorter;
	private static Random rnd;
	private static ArrayList<Sorter<Integer>> sortersList = new ArrayList<>();

	public static void main(String[] args) {
		sortersList.add(new BubbleSortSorter<Integer>());
		sortersList.add(new SelectionSortSorter<Integer>());
		sortersList.add(new InsertionSortSorter<Integer>());
		sortersList.add(new combSorter<Integer>());
		sortersList.add((new cocktailSort<Integer>()));
		sortersList.add(new HeapSortSorter<>());


		test("Sorting Using Default Comparator<Integer>", null);
		test("Sorting Using IntegerComparator1", new IntegerComparator1());
		test("Sorting Using IntegerComparator2", new IntegerComparator2());
		test(new Integer[]{3, 4, 2, 57},"Specific case test",null);
    }

	private static void test(String msg, Comparator<Integer> cmp) {
		rnd = new Random(101);

		System.out.println("\n\n*******************************************************");
		System.out.println("*** " + msg + "  ***");
		System.out.println("*******************************************************");

		Integer[] original, arr;
		// generate random arrays is size i and test...
		for (int i=1; i<=20; i += 5) {
			original = randomValues(i);
			showArray("\n ---Original array of size " + i + " to sort:", original);

			for (int s=0; s<sortersList.size(); s++) {
				Sorter<Integer> sorter = sortersList.get(s);
				arr = original.clone();
				sorter.sort(arr, cmp);
				showArray(sorter.getName() + ": ", arr);
			}
		}
	}

	public static void test(Integer[] arr, String msg , Comparator<Integer> cmp){
        System.out.println("\n\n*******************************************************");
        System.out.println("*** " + msg + "  ***");
        System.out.println("*******************************************************");

        showArray("\n ---Original array of size " + arr.length + " to sort:", arr);

        for (int s=0; s<sortersList.size(); s++) {
            Sorter<Integer> sorter = sortersList.get(s);
            Integer[] arr0 = arr.clone();
            sorter.sort(arr0, cmp);
            showArray(sorter.getName() + ": ", arr0);
        }
    }

	private static void showArray(String msg, Integer[] a) {
		System.out.print(msg);
		for (int i=0; i<a.length; i++)
			System.out.print("\t" + a[i]);
		System.out.println();
	}

	private static Integer[] randomValues(int i) {
		Integer[] a = new Integer[i];
		for (int j=0; j<i; j++)
			a[j] = rnd.nextInt(100);
		return a;
	}

}
