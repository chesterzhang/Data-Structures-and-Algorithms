public class ArrayIQueue<T> implements IQueue<T> {
    private Array<T> array;

    public ArrayIQueue(int capacity){
        array=new Array<>(capacity);
    }

    public ArrayIQueue(){
        array=new Array<>();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(T e) {
        array.addLast(e);
    }

    @Override
    public T dequeue() {
        return array.removeFirst();
    }

    @Override
    public T getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res =new StringBuilder();
        res.append("Queue");
        res.append(" front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if(i!=array.getSize()-1){
                res.append(", ");
            }
        }
        res.append("] tail");
        return  res.toString();
    }

    public static void main(String[] args) {
        ArrayIQueue<Integer> queue=new ArrayIQueue<>();
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


