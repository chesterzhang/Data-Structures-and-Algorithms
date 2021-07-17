import java.util.Random;

public class MaxHeapTest {

    public static void main(String[] args) {
        int n=100;

        MaxHeap<Integer> maxHeap=new MaxHeap<>();
        Random random=new Random();


        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= maxHeap.extractMax();
        }

        for (int i = 1 ; i <n ; i++) {
            if (arr[i-1]<arr[i]){
                throw  new IllegalArgumentException("MaxHeap erro !");
            }
        }

        System.out.println("Test MaxHeap completed!");
        
    }
}
