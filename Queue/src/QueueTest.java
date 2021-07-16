import java.util.Random;

public class QueueTest {

    //测试队列q运行count个enqueue和dequeue操作时间, 单位:秒
    private static  double test(Queue<Integer> q,int opCount){
        long startTime =System.nanoTime();

        Random rd=new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(rd.nextInt(Integer.MAX_VALUE));
        }

        //循环队列的又是主要在于deque操作时间均摊复杂度降到了O(1)
        //如果将dequeue操作注释掉,效果差别不大
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime =System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    //测试队列和循环队列的性能差异
    public static void main(String[] args) {
        int opCount=100000;

        ArrayQueue<Integer> aq=new ArrayQueue<>();
        LoopQueue<Integer> lq=new LoopQueue<>();

        System.out.println("普通队列花费时间: "+ QueueTest.test(aq,opCount));
        System.out.println("循环队列花费时间: "+ QueueTest.test(lq,opCount));

    }

}






