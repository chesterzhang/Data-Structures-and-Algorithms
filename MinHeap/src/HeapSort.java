import java.util.Arrays;

public class HeapSort {

    private HeapSort(){}

    public static <E extends Comparable<E>> void sort(E[] data){
        //1.一个一个元素加入到MaxHeap当中 O(nlogn)
//        MinHeap<E> maxHeap =new MinHeap<>();
//        for (E e:data) {
//            minHeap.add(e);
//        }

        //2.使用heapify操作将一个数组直接变成一个堆 O(n)
        MinHeap<E> maxHeap=new MinHeap<>(data);

        for (int i =0 ; i < data.length ; i++) {
            data[i]=maxHeap.extractMin();
        }

    }

    public static void main(String[] args) {
        int n=1000000;
        Integer[] arr=ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2= Arrays.copyOf(arr,arr.length);
        Integer[] arr3= Arrays.copyOf(arr,arr.length);

        SortingHelper.sortTest("MergeSort",arr,n);
        SortingHelper.sortTest("QuickSortOneWay",arr2,n);
        SortingHelper.sortTest("HeapSort",arr3,n);
    }

}

