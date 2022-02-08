package leetcode;

// 将 类的名称换成 Solution 即可
public class Leetcode70 {

    int[] memo;

    // climbStaris + dfs 记忆化搜索, 自顶向下
    public int climbStairs(int n) {
        memo=new int[n+1];//memo[n],memo[n-1], memo[1],memo[0],其中memo[0]没用,只是占个位方便索引

        for (int i = 0; i < memo.length; i++) {
            memo[i]=-1;
        }

        if (n>=1){
            memo[1]=1;
        }
        if (n>=2){
            memo[2]=2;
        }

        return dfs(n);
    }

    private int dfs(int n){

        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }

        if (memo[n]!=-1){
            return memo[n];
        }

        memo[n]=dfs(n-1)+dfs(n-2);

        return  memo[n];
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
        if (n>=1){
            memo[1]=1;
        }
        if (n>=2){
            memo[2]=2;
        }

        for (int i = 3; i <=n ; i++) {
            memo[i]=memo[i-1]+memo[i-2];
        }
        return memo[n];
    }

}
