public class LoopIQueue<T> implements IQueue<T> {

    private  T[] data;
    private  int front, tail;
    private int size;

    public LoopIQueue(int capacity){
        data=(T[]) new Object[capacity+1];
        front=0;
        tail=0;
        size=0;
    }

    public LoopIQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }


    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }


    @Override
    public void enqueue(T e) {
        if ((tail+1)%data.length==front){
            this.resize(this.getCapacity()*2);
        }
        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;
    }

    private void resize(int newCapacity) {
        T[] newData=(T[]) new Object[newCapacity+1];
        for (int i = 0; i < size; i++) {
            newData[i]=this.data[(front+i)%data.length];
        }
        this.data=newData;
        this.front=0;
        this.tail=this.size;
    }

    //循环队列的dequeue避免了除了首个元素外的所有元素的赋值,直接移动front即可
    //降低了dequeue均摊复杂度
    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot deque from am empty queue! ");
        }
        T ret=data[front];
        data[front]=null;
        front=(front+1)& data.length;
        size--;
        if (size==getCapacity()/4 && getCapacity()/2!=0){
            resize(getCapacity()/2);
        }
        return  ret;
    }

    @Override
    public T getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty! ");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res =new StringBuilder();
        res.append("Queue size:"+getSize()+", capacity:"+getCapacity()+"\n");
        res.append("front [");
        for (int i = front; i !=tail ; i=(i+1)% data.length) {
            res.append(data[i]);
            if((i+1)% data.length!=tail ){
                res.append(", ");
            }
        }
        res.append("] tail");
        return  res.toString();
    }

    public static void main(String[] args) {
       LoopIQueue<Integer> queue=new LoopIQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}

