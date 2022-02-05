package leetcode;

public class leetcode343 {

    private int[] memo;

    //n>=2
    public int integerBreak(int n) {
        memo=new int[n+1];
        return dfs(n);
    }

    //计算memo[n],也就是n可以拆分的数字相乘最大值
    private int dfs(int n){
        if (n==1){
            memo[n]=1;
            return 1;
        }

        for (int i = 1; i <=n-1 ; i++) {
            if (memo[n-i]==0){
                memo[n]=Math.max(memo[n],i*(n-i));
                memo[n]=Math.max(memo[n],i*dfs(n-i));
            }else {
                memo[n]=Math.max(memo[n],i*(n-i));
                memo[n]=Math.max(memo[n],i*memo[n-i]);
            }

        }
        return memo[n];


    }

    //使用动态规划,自底向上
    public int integerBreak2(int n){
        if (n==2){
            return 1;
        }

        memo=new int[n+1];
        memo[1]=1;
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
        leetcode343 l=new leetcode343();
        System.out.println(l.integerBreak(10));
    }

}
