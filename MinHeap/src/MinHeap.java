import java.util.Random;

public class MinHeap<E extends  Comparable<E>> {

    private Array<E> data;

    public MinHeap(int capacity){
        data=new Array<>(capacity);
    }

    public MinHeap(){
        data=new Array<>();
    }

    //heapify 操作, 传入一个数组, 根据这个数组构造出一个最小堆
    public MinHeap(E[] arr){
        data=new Array(arr.length);
        for (int i = 0; i < arr.length; i++) {
            data.addLast(arr[i]);
        }
        for (int i = parent(arr.length-1); i >=0 ; i--) {
            shiftDown(i);
        }
    }


    public int getSize(){
        return data.getSize();
    }

    boolean isEmpty(){
        return data.isEmpty();
    }

    private int parent(int index){
        if (index==0){
            throw new IllegalArgumentException("index-0 doesn't have parent. ");
        }
        return (index-1)/2;
    }

    private int leftChild(int index){
        return index*2+1;
    }

    private int rightChild(int index){
        return index*2+2;
    }

    private  void swap(int idx1, int idx2){
        E temp=data.get(idx1);
        data.set(idx1,data.get(idx2));
        data.set(idx2,temp);
    }

    public E  findMin(){
        if (data.isEmpty()){
            throw new IllegalArgumentException("Cannot findMin when the heap is empty!");
        }
        return data.get(0);
    }

    //判断某个节点是否为叶子节点
    public boolean isLeaf(int idx){
        //如果左孩子索引越界,说明没有左孩子,连左孩子都没有肯定是叶子节点
        return  leftChild(idx)< data.getSize();
    }

    private void shiftUp(int idx){
        while (idx>0 ){//只要没有达到根节点, 就继续尝试与父节点交换

            //如果父节点更大, 就与父节点进行交换
            if (data.get(parent(idx)).compareTo(data.get(idx))>0){
                swap(idx,parent(idx));
                idx=parent(idx);
            }else {//否则, 跳出循环
                break;
            }
        }
    }

    private void shiftDown(int idx){

        while (isLeaf(idx)){//到了叶子节点就不用再shiftDown了,跳出循环

            int j=leftChild(idx);//j初始为左孩子索引
            if ((j+1)<data.getSize()){//说明有右孩子
                //而且右孩子比左孩子更小, 那就和右孩子交换
                if (data.get(j+1).compareTo(data.get(j))<0){
                    j++;//j更新为右孩子索引
                }
            }

            //data[j]是idx节点左右孩子的最小值
            //如果 data[idx] 比 data[j] 还要小,就不需要向下交换了, 直接跳出循环
            if (data.get(idx).compareTo(data.get(j))<0){
                break;
            }
            //否则交换 data[idx] 和 data[j], 接着向下shiftdown
            swap(idx,j);
            idx=j;
        }
    }

    public void add(E e){
        data.addLast(e);
        shiftUp(data.getSize()-1);
    }






    public E extractMin(){
        E ret=findMin();
        swap(0,data.getSize()-1);
        data.removeLast();
        shiftDown(0);
        return ret;
    }


    //取出最小值,并且替换成e
    public E replace(E e){
        E ret=findMin();
        data.set(0,e);
        shiftDown(0);
        return ret;
    }

    public static void main(String[] args) {
        int n=1000;

        Random random=new Random();

        //测试向空堆里面添加元素, 删除元素
        MinHeap<Integer> minHeap1=new MinHeap<>();

        for (int i = 0; i < n; i++) {
            minHeap1.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr1=new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i]= minHeap1.extractMin();
        }

        for (int i = 1 ; i <n ; i++) {
            if (arr1[i-1]>arr1[i]){
                throw  new IllegalArgumentException("MinHeap erro !");
            }
        }

        //测试将一个数组构造成一个堆
        //随机数组
        Integer[] arr2=new Integer[n];
        for (int i = 0; i < n; i++) {
            arr2[i]=random.nextInt(Integer.MAX_VALUE);
        }

        //heapify操作
        MinHeap<Integer> minHeap2=new MinHeap<>(arr2);

        for (int i = 0; i < n; i++) {
            arr2[i]= minHeap2.extractMin();
        }

        for (int i = 1 ; i <n ; i++) {
            if (arr2[i-1]>arr2[i]){
                throw  new IllegalArgumentException("MinHeap erro !");
            }
        }


        System.out.println("Test MinHeap completed!");

    }



}




