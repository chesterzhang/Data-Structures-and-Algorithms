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


    public static void main(String[] args) {

        //1.测试由 链表 实现的队列功能

//        LinkedListQueue <Integer> queue=new LinkedListQueue <>();
//        for (int i = 0; i < 10; i++) {
//            queue.enqueue(i);
//            System.out.println(queue);
//            if (i%3==2){
//                queue.dequeue();
//                System.out.println(queue);
//            }
//        }

        //2.测试由 数组, 循环数组, 链表 实现的队列功能
        LinkedListQueue <Integer> queue1=new LinkedListQueue <>();
        ArrayQueue<Integer> queue2=new ArrayQueue <>();
        LoopQueue<Integer> queue3= new LoopQueue<>();

        int opCount=100000;


        System.out.println("linkedlist queue花费时间: "+ QueueTest.test(queue1,opCount));
        System.out.println("array queue花费时间: "+ QueueTest.test(queue2,opCount));
        System.out.println("loop queue花费时间: "+ QueueTest.test(queue3,opCount));


    }
}
