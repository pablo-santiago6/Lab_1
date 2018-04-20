import java.util.ArrayList;
import java.util.Scanner;

public class MAIN {

    public static void main(String args[]){
        Scanner scanner= new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        mergeSort(arr,0,size - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void merge(int[] arr, int leftBoud , int rightBound , int middle ){
        int leftSize = (middle - leftBoud + 1);
        int rightSize = rightBound - middle;

        int[] leftArr = new  int[leftSize];
        int[] rightArr = new int[rightSize];

        for (int i = 0; i < leftSize; ++i) {
            leftArr[i]=arr[leftBoud + i];
        }
        for (int j = 0; j < rightSize; ++j) {
            rightArr[j] = arr[middle + j  + 1];
        }

        int i = 0 , j = 0;
        int k = leftBoud;

        while(i< leftSize && j < rightSize) {

            if (leftArr[i] <= rightArr[j]) { arr[k] = leftArr[i]; i++;}

            else{ arr[k] = rightArr[j];j++;}
            k++;
        }

        while( i < leftSize){
            arr[k] = leftArr[i];
            i++;k++;
        }

        while( i < rightSize){
            arr[k] = rightArr[i];
            j++;k++;
        }
    }

    public static int[] mergeSort(int[] arr , int leftBound , int rightBound){
        if(leftBound < rightBound){
            int middle = (leftBound+rightBound)/2;
            mergeSort(arr, leftBound, middle);
            mergeSort(arr , middle + 1 , rightBound);

            merge(arr,leftBound,rightBound,middle);
        }
        return arr;
    }


}
