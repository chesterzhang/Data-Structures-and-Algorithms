import java.util.PriorityQueue;

public class Leetcode215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();//最小堆
        for (int i = 0; i < nums.length; i++) {
            pq.add(i);
            if (pq.size()>k){
                pq.poll();
            }
        }

        return pq.peek();
    }

}
