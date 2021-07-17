import java.util.Arrays;

public class MergeSort {

    //设为private,防止被实例化
    private  MergeSort(){}

    public  static  <T extends Comparable<T> > void sort(T[] arr){
        sort(arr,0,arr.length-1);
    }

    private static  <T extends Comparable<T> > void sort(T[] arr, int l, int r){
        if (l>=r){
            return;
        }
        int mid=l+(r-l)/2; //  等价于(l+r)/2
        sort(arr, l,mid);
        sort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    //合并arr[l,mid][,arr[mid+1,r]
    private static <T extends Comparable<T> > void merge(T arr[],int l, int mid, int r){
        T[] temp= Arrays.copyOfRange(arr,l,r+1);

        int i=0, j=mid-l+1;

        for (int k = l; k <=r; k++) {
            if (i>mid-l){
                arr[k]=temp[j];
                j++;
                continue;
            }
            if(j>r-l){
                arr[k]=temp[i];
                i++;
                continue;
            }

            //比较arr[i] 和 arr[j]
            if (temp[i].compareTo(temp[j])<=0){
                arr[k]=temp[i];
                i++;
            }else{
                arr[k]=temp[j];
                j++;
            }

        }

    }

    public static void main(String[] args) {
        int n =100000;
        Integer[] arr=ArrayGenerator.generateRandomArray(n,n);
        SortingHelper.sortTest("MergeSort",arr,n);
    }


}
