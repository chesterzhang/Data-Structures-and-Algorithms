package Fib;

// 使用动态规划, 自底向上解决问题
public class FibonacciSeq2 {

    int[] memo;//用来存储已经计算好了的斐波那契数列

    public int fib(int n){
        memo=new int[n+1];

        memo[0]=0;
        memo[1]=1;

        for (int i=2;i<=n; i++){
            memo[i]=memo[i-1]+memo[i-2];
        }

        return memo[n];
    }

    public static void main(String[] args) {
        int n=50;
        FibonacciSeq2 fbsq=new FibonacciSeq2();

        long startTime=System.nanoTime();
        fbsq.fib(n);
        long endTime=System.nanoTime();
        double time=endTime-startTime;

        System.out.println("fib"+n+"花费时间"+time/1000000000.0+"秒");
    }

}
