public class MaxHeap<E extends  Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data=new Array<>(capacity);
    }

    public MaxHeap(){
        data=new Array<>();
    }

    public MaxHeap(E[] arr){
        data=new Array<>(arr);
        heapify(arr);
    }

    public   void heapify(E[] arr){
        if (arr.length<=1) {
            return;
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

    public void add(E e){
        data.addLast(e);
        shiftUp(data.getSize()-1);
    }

    private void shiftUp(int idx){
        while (idx>0 ){
            if (data.get(parent(idx)).compareTo(data.get(idx))<0){
                data.swap(idx,parent(idx));
                idx=parent(idx);
            }else {
                break;
            }
        }
    }
    public E  findMax(){
        if (data.isEmpty()){
            throw new IllegalArgumentException("Cannot findMax when the heap is empty!");
        }
        return data.get(0);
    }

    public E extractMax(){
        E ret=findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();
        shiftDown(0);
        return ret;
    }

    private void shiftDown(int idx){
        while (leftChild(idx)<data.getSize()){//到了叶子节点就不用再shiftDown了
            int j=leftChild(idx);
            if ((j+1)<data.getSize()){//说明有右孩子
                //右孩子更大
                if (data.get(j+1).compareTo(data.get(j))>0){
                    j++;
                }
            }
            //data[j]是idx节点左右孩子的最大值
            if (data.get(idx).compareTo(data.get(j))>=0){
                break;
            }
            data.swap(idx,j);
            idx=j;
        }
    }

    //取出最大值,并且替换成e
    public E replace(E e){
        E ret=findMax();
        data.set(0,e);
        shiftDown(0);
        return ret;
    }



}


