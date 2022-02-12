public class HeapSort {

    private HeapSort(){}

    public static <E extends Comparable<E>> void sort(E[] data){
        //1.一个一个元素加入到MaxHeap当中 O(nlogn)
//        MaxHeap<E> maxHeap =new MaxHeap<>();
//        for (E e:data) {
//            maxHeap.add(e);
//        }

        //2.使用heapify操作将一个数组直接变成一个堆 O(n)
        MaxHeap<E> maxHeap=new MaxHeap<>(data);

        for (int i = data.length-1; i >=0 ; i--) {
            data[i]=maxHeap.extractMax();
        }


    }

    public  static <E extends Comparable<E>> void sort2(E[] data){
        if (data.length<=1) {
            return;
        }
        for (int i =  (data.length-2)/2; i >=0 ; i--) {
            shiftDown(i,data,data.length);
        }

        for (int i = data.length-1; i >=0 ; i--) {
            swap(0,i,data);
            shiftDown(0,data,i);
        }

    }

    //对data[0,n)所形成的最大堆中,索引为idx的元素执行shiftDown
    private static <E extends Comparable<E>> void shiftDown(int idx,E[] data,int n){
        while (leftIdx(idx)<n){//到了叶子节点就不用再shiftDown了
            int j=leftIdx(idx);
            if ((j+1)<n){//说明有右孩子
                //右孩子更大
                if (data[j+1].compareTo(data[j])>0){
                    j++;
                }
            }
            //data[j]是idx节点左右孩子的最大值
            if (data[idx].compareTo(data[j])>=0){
                break;
            }
            swap(idx,j,data);
            idx=j;
        }
    }

    private static int leftIdx(int index){
        return index*2+1;
    }

    private static <E extends Comparable<E>>  void swap(int i , int j,E[] data){
        E temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }

}
