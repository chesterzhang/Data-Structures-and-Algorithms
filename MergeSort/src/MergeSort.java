import java.util.Arrays;

public class MergeSort {

    //设为private,防止被实例化
    private  MergeSort(){}

    public  static  <E extends Comparable<E> > void sort(E[] arr){
        sort(arr,0,arr.length-1);
    }

    private static  <E extends Comparable<E> > void sort(E[] arr, int l, int r){
        if (l>=r){
            return;
        }
        int mid=l+(r-l)/2; //  等价于(l+r)/2
        sort(arr, l,mid);
        sort(arr,mid+1,r);
        if(arr[mid+1].compareTo(arr[mid])>0){
            return;
        }
        merge(arr,l,mid,r);
    }

    //合并arr[l,mid][,arr[mid+1,r]
    private static <E extends Comparable<E> > void merge(E arr[],int l, int mid, int r){
        E[] temp= Arrays.copyOfRange(arr,l,r+1);

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
        int n =1000000;
        //Integer[] arr=ArrayGenerator.generateRandomArray(n,n);//完全随机数据
        Integer[] arr=ArrayGenerator.generateOrderedArray(n);//完全有序数据
        SortingHelper.sortTest("MergeSort",arr,n);
    }


}
