public class PriorityQueue<E extends Comparable<E>> implements  Queue<E> {

    private MinHeap<E> maxHeap;
    public PriorityQueue(){
        maxHeap=new MinHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMin();
    }

    @Override
    public E getFront() {
        return maxHeap.findMin();
    }

}
