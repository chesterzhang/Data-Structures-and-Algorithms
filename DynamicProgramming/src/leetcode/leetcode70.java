package leetcode;

public class leetcode70 {

    int[] memo;

    // climbStaris + dfs 记忆化搜索, 自顶向下
    public int climbStairs(int n) {
        memo=new int[n+1];//memo[n],memo[n-1], memo[1],memo[0],其中memo[0]没用,只是占个位方便索引

        for (int i = 0; i < memo.length; i++) {
            memo[i]=-1;
        }

        return dfs(n);
    }

    private int dfs(int remainStairs){

        if (remainStairs==1){
            memo[1]=1;
            return 1;
        }
        if (remainStairs==2){
            memo[2]=2;
            return 2;
        }

        if (memo[remainStairs]!=-1){
            return memo[remainStairs];
        }

        if (remainStairs-1>=1){
            memo[remainStairs-1]=dfs(remainStairs-1);
        }
        if (remainStairs-2>=1){
            memo[remainStairs-2]=dfs(remainStairs-2);
        }

        memo[remainStairs]=memo[remainStairs-1]+memo[remainStairs-2];
        return  memo[remainStairs];
    }

    //动态规划,自底向上
    public int climbStairs2(int n) {
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }

        memo=new int[n+1];
        memo[1]=1;
        memo[2]=2;

        for (int i = 3; i <=n ; i++) {
            memo[i]=memo[i-1]+memo[i-2];
        }
        return memo[n];
    }

}
