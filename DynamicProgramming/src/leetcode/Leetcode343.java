package leetcode;

import java.util.Arrays;

// 将 类的名称换成 Solution 即可
public class Leetcode343 {

    private int[] memo;

    //n>=2
    public int integerBreak(int n) {
        memo=new int[n+1];
        Arrays.fill(memo,-1);
        memo[2]=1;
        memo[1]=0;
        return dfs(n);
    }

    //计算memo[n],也就是n可以拆分的数字相乘最大值
    private int dfs(int n){
        if (memo[n]!=-1){
            return memo[n];
        }

        for (int i = 1; i <=n-1 ; i++) {
            memo[n] = Math.max(memo[n], i * (n - i));
            memo[n] = Math.max(memo[n], i * dfs(n - i));

        }
        return memo[n];

    }

    //使用动态规划,自底向上
    public int integerBreak2(int n){
        if (n==2){
            return 1;
        }

        memo=new int[n+1];

        memo[2]=1;

        for (int i = 3 ; i <=n ; i++) {
            for (int j = 1; j <=i-1 ; j++) {
                memo[i]=Math.max(memo[i],j*(i-j));//下一层不再继续拆分
                memo[i]=Math.max(memo[i],j*memo[i-j]);//下一层继续拆分
            }
        }
        return memo[n];

    }

    public static void main(String[] args) {
        Leetcode343 l=new Leetcode343();
        System.out.println(l.integerBreak(10));
    }

}
