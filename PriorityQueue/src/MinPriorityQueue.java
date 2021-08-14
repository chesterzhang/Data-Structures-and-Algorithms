public class MinPriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MinHeap<E> minHeap;
    public MinPriorityQueue(){
        minHeap=new MinHeap<>();
    }

    @Override
    public int getSize() {
        return minHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return minHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        minHeap.add(e);
    }

    @Override
    public E dequeue() {
        return minHeap.extractMin();
    }

    @Override
    public E getFront() {
        return minHeap.findMin();
    }

}
