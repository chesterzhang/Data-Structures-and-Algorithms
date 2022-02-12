public class BubbleSort {

    private  BubbleSort(){}

    public  static <E extends  Comparable<E>> void sort(E[] data){
        //
        for (int i = 0; i < data.length-1; i++) {
            for (int j = 0; j < data.length-i-1; j++) {
                if (data[j].compareTo(data[j+1])>0){
                    swap(data,j,j+1);
                }
            }

        }
    }

    public  static <E extends  Comparable<E>> void sort2(E[] data){
        //
        for (int i = 0; i < data.length-1; i++) {
            boolean isSwapped=false;
            for (int j = 0; j < data.length-i-1; j++) {
                if (data[j].compareTo(data[j+1])>0){
                    swap(data,j,j+1);
                    isSwapped=true;
                }
            }
            if (isSwapped==false){//没有交换,说明已经有序了。
                break;
            }
        }
    }

    public  static <E extends  Comparable<E>> void sort3(E[] data){
        int loopCount=data.length-1;
        for (int i = 0; i < loopCount; i++) {
           int swapIdx=0;
            for (int j = 0; j < data.length-i-1; j++) {
                if (data[j].compareTo(data[j+1])>0){
                    swap(data,j,j+1);
                    swapIdx=j+1;
                }
            }
            loopCount= swapIdx-1;
        }
    }

    private static  <E extends  Comparable<E>> void swap(E[] data,int a ,int b){
        E temp= data[a];
        data[a]=data[b];
        data[b]=temp;
    }

    public static void main(String[] args) {
        int n= 100000;
        //Integer[] arr=ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr=ArrayGenerator.generateOrderedArray(n);
        SortingHelper.sortTest("BubbleSort",arr,n);

    }
}
