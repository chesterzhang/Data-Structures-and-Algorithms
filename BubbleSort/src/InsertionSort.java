public class InsertionSort {

    private InsertionSort(){}

    /*
    public static <T extends Comparable<T>> void sort(T[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >=1 ; j--) {
                if(arr[j].compareTo(arr[j-1])<0){
                    swap(arr,j,j-1);
                }else {
                    break;
                }
            }
        }
    }
    */

    //优化后的算法,改swap操作为向后赋值
    public static <T extends Comparable<T>> void sort(T[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >=1 ; j--) {
                if(arr[j].compareTo(arr[j-1])<0){
                    arr[j]=arr[j-1];
                }else {
                    arr[j]=arr[i];
                    break;
                }
            }
        }
    }

    private static <T> void swap(T[] arr, int i, int j){
        T temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000,100000};
        for (int n :dataSize){
            Integer[] arr=ArrayGenerator.generateRandomArray(n,n);
            SortingHelper.sortTest("InsertionSort",arr,n);
        }
    }

}


