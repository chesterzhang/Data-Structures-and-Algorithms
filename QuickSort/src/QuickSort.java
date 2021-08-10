import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private QuickSort(){}
    private static  Random RandomGenerator=new Random();//随机数生成器

    public static  <E extends Comparable<E>> void sortOneWay(E[] arr){
        sortOneWay(arr,0,arr.length-1);//单路快排
    }

    private static  <E extends Comparable<E>> void sortOneWay(E[] arr, int l, int r){
        if (l>=r){
            return;
        }

        int p=partition1(arr,l,r);
        sortOneWay(arr,l,p-1);
        sortOneWay(arr,p+1,r);
    }

    public static  <E extends Comparable<E>> void sortTwoWays(E[] arr){
        sortTwoWays(arr,0,arr.length-1);//双路快排
    }

    private static  <E extends Comparable<E>> void sortTwoWays(E[] arr, int l, int r){
        if (l>=r){
            return;
        }

        int p=partition2(arr,l,r);
        sortTwoWays(arr,l,p-1);
        sortTwoWays(arr,p+1,r);
    }

    public static  <E extends Comparable<E>> void sortThreeWays(E[] arr){
        sortThreeWays(arr,0,arr.length-1);//三路快排
    }

    private static  <E extends Comparable<E>> void sortThreeWays(E[] arr, int l, int r){
        if (l>=r){
            return;
        }

        int[] p=partition3(arr,l,r);
        sortThreeWays(arr,l,p[0]-1);
        sortThreeWays(arr,p[1]+1,r);
    }



    //单路快排
    private static <E extends  Comparable<E>> int partition1(E[] arr, int l ,int r){
        //在arr中随机选择一个元素,与arr[l]进行交换,防止对于有序数组,退化成O(n^2)
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
    private static <E extends  Comparable<E>> int partition2(E[] arr, int l ,int r){
        int randomIdx= l+ RandomGenerator.nextInt(r-l+1);
        swap(arr,l,randomIdx);

        int i=l+1,j=r;

        while (i<=j){
            //先判断 i 这边
            if (arr[i].compareTo(arr[l])<0){
                i++;
            }else{//若 arr[i] 与 partition元素 相等, 放到左边
                swap(arr,i,j);
                j--;
            }

            //一个准则: 循环控制量必须要和循环判断条件紧密结合!!!
            //一旦改变循环控制量,必须马上进入循环条件判断,否则接下来的执行代码压根不满足在循环内的条件
            if (i>j)
                break;


            //先判断 j 这边
            if (arr[j].compareTo(arr[l])>0){
                j--;
            }else {//若 arr[i] 与 partition元素 相等, 放到右边
                swap(arr,i,j);
                i++;
            }
        }

        //遍历结束后, j==i-1, arr[l,j]<= partition, arr[i,r]>=partition
        //arr[l] 必须要和 arr[j] 交换, 而不能和arr[i]交换 因为arr[i]可能比partition要大
        swap(arr,l,j);
        return j;

    }

    //三路快排
    private static <E extends  Comparable<E>> int[] partition3(E[] arr, int l ,int r){
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

    //静态方法只能调用静态方法,若不写static,则调用的时候会报错
    private  static <E>void swap(E[] arr,int a, int b){
        E temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }


    public static void main(String[] args) {

        int n =1000000;

        //对于完全随机的数组,归并和单路快排均为O(NlogN)
        //但单路快排在分治过程中,避免了频繁的数组复制操作,性能略优
        Integer[] arr1=ArrayGenerator.generateRandomArray(n,n);//随机数据
        Integer[] arr2= Arrays.copyOf(arr1,arr1.length);

        System.out.println("随机数据");
        SortingHelper.sortTest("MergeSort",arr1,n);
        SortingHelper.sortTest("QuickSortOneWay",arr2,n);


        //对于有序数组, 归并排序会进化成O(N)
        arr1=ArrayGenerator.generateOrderedArray(n);//有序数据
        arr2= Arrays.copyOf(arr1,arr1.length);

        System.out.println("有序数据");
        SortingHelper.sortTest("MergeSort",arr1,n);
        SortingHelper.sortTest("QuickSortOneWay",arr2,n);

        //对于全部元素相等的数组,归并排序进化成(logN), 单路快排会退化成O(n^2),双路快排依然是O(NlogN), 三路快排进化成O(N)
        arr1=ArrayGenerator.generateRandomArray(n,1);//重复数据
        arr2= Arrays.copyOf(arr1,arr1.length);
        Integer[] arr3= Arrays.copyOf(arr1,arr1.length);

        System.out.println("重复数据");
        SortingHelper.sortTest("MergeSort",arr1,n);
        //单路直接达到最大递归深度, 栈溢出
        SortingHelper.sortTest("QuickSortTwoWays",arr2,n);
        SortingHelper.sortTest("QuickSortThreeWays",arr3,n);

    }

}



