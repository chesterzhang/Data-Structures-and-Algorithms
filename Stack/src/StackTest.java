import java.util.Random;

public class StackTest {

    public  static  double test(Stack<Integer> stack, int opCount){
        long startTime =System.nanoTime();

        Random rd =new Random();

        for (int i = 0; i < opCount; i++) {
            stack.push(rd.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime =System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    public static void main(String[] args) {

        //测试有底层由数组和链表 实现的栈的性能差异
        LinkedListStack<Integer> stack1 = new LinkedListStack<>();
        ArrayStack<Integer> stack2= new ArrayStack<>();
        int opCount=100000;

        System.out.println("LinkedListStack花费时间:"+test(stack1,opCount)+" s.");
        System.out.println("StackArray花费时间:"+test(stack2,opCount)+" s.");

    }
}
