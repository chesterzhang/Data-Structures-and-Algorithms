import java.util.Arrays;

public class HeapSortTest {

    public static void main(String[] args) {
        int n=1000000;
        Integer[] arr=ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2= Arrays.copyOf(arr,arr.length);
        Integer[] arr3= Arrays.copyOf(arr,arr.length);

        SortingHelper.sortTest("MergeSort",arr,n);
        SortingHelper.sortTest("QuickSort",arr2,n);
        SortingHelper.sortTest("HeapSort",arr3,n);
    }
}

