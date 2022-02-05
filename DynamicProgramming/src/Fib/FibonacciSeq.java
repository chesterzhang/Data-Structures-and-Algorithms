package Fib;

//自顶向下递归, 使用记忆化搜索进行剪枝
public class FibonacciSeq {

    int[] memo;//用来存储已经计算好了的斐波那契数列

    FibonacciSeq(int n){
        memo=new int[n+1];
        for (int i = 0; i < memo.length; i++) {
            memo[i]=-1;
        }
    }

    public int fib(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }

        if (memo[n]==-1){
            memo[n]=fib(n-1)+fib(n-2);
            return memo[n];
        }else {
            return memo[n];
        }
    }

    public static void main(String[] args) {
        int n=50;
        FibonacciSeq fbsq=new FibonacciSeq(n);

        long startTime=System.nanoTime();
        fbsq.fib(n);
        long endTime=System.nanoTime();
        double time=endTime-startTime;

        System.out.println("fib"+n+"花费时间"+time/1000000000.0+"秒");
    }



}
