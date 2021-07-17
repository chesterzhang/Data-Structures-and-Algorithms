import java.util.Random;

public class QuickSort {

    private QuickSort(){}
    private static  Random RandomGenerator=new Random();

    public static  <T extends Comparable<T>> void sort(T[] arr){
        //sort(arr,0,arr.length-1);//单路,双路快排
        sortThreeWays(arr,0,arr.length-1);//三路快排
    }

    public static  <T extends Comparable<T>> void sort(T[] arr, int l, int r){
        if (l>=r){
            return;
        }

        int p=partition2(arr,l,r);
        sort(arr,l,p-1);
        sort(arr,p+1,r);
    }

    public static  <T extends Comparable<T>> void sortThreeWays(T[] arr, int l, int r){
        if (l>=r){
            return;
        }

        int[] p=partition3(arr,l,r);
        sortThreeWays(arr,l,p[0]-1);
        sortThreeWays(arr,p[1]+1,r);
    }

    //静态方法只能调用静态方法,若不写static,则调用的时候会报错
    private  static <T>void swap(T[] arr,int a, int b){
        T temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    //单路快排
    private static <T extends  Comparable<T>> int partition(T[] arr, int l ,int r){
        //在arr中随机选择一个元素,与arr[l]进行交换,防止对于有序数组,退化成O(n)
        int randomIdx= l+ RandomGenerator.nextInt(r-l+1);
        swap(arr,l,randomIdx);

        int i=l;
        int j=l+1;

        while ( j<=r ){
            if (arr[j].compareTo(arr[l])<=0){

                swap(arr,i+1,j);
                i++;
                j++;//时时刻刻都要照顾到循环控制变量
            }else {
                j++;
            }
        }
        //交换arr[l] arr[j]
        swap(arr,l,i);

        return i;
    }

    //双路快排
    private static <T extends  Comparable<T>> int partition2(T[] arr, int l ,int r){
        int randomIdx= l+ RandomGenerator.nextInt(r-l+1);
        swap(arr,l,randomIdx);

        int i=l+1,j=r;

        while (i<=j){
            if (arr[i].compareTo(arr[l])<0){
                i++;
            }else{
                swap(arr,i,j);
                j--;
            }

            //一个准则: 循环控制量必须要和循环判断条件紧密结合!!!
            //一旦改变循环控制量,必须马上进入循环条件判断,否则接下来的执行代码压根不满足在循环内的条件
            if (i>j)
                break;

            if (arr[j].compareTo(arr[l])>0){
                j--;
            }else {
                swap(arr,i,j);
                i++;
            }
        }

        //这里必须要和 j 交换
        swap(arr,l,j);
        return j;
    }

    //三路快排
    private static <T extends  Comparable<T>> int[] partition3(T[] arr, int l ,int r){
        int randomIdx= l+ RandomGenerator.nextInt(r-l+1);
        swap(arr,l,randomIdx);

        int lt=l,i=l+1,gt=r+1;

        while (i<gt){
            if (arr[i].compareTo(arr[l])<0){
                swap(arr,i,lt+1);
                lt++;
                i++;
            }else if(arr[i].compareTo(arr[l])==0){
                i++;
            }else {
                swap(arr,i,gt-1);
                gt--;
            }

        }

        swap(arr,l,lt);

        int[] ret={lt,gt-1};
        return ret;


    }



    public static void main(String[] args) {
        int n =100000;

        Integer[] arr=ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2=ArrayGenerator.generateOrderedArray(n);
        Integer[] arr3=ArrayGenerator.generateRandomArray(n,1);

        //对于完全随机的数组,归并和单路快排均为O(n)
        //但单路快排在分分治过程中,避免了频繁的new内存,性能更优
        SortingHelper.sortTest("MergeSort",arr,n);
        SortingHelper.sortTest("QuickSort",arr,n);

        //对于有序数组, 选择arr[0]作为partition的p 的快排会退化成O(n^2)
        SortingHelper.sortTest("MergeSort",arr2,n);
        SortingHelper.sortTest("QuickSort",arr2,n);

        //对于全部有序的数组,单路快排会退化成O(n^2),解决方法是使用三路快排
        SortingHelper.sortTest("MergeSort",arr3,n);
        SortingHelper.sortTest("QuickSort",arr3,n);


    }

}



