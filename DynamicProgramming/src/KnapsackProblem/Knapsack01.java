package KnapsackProblem;

// 01背包问题
public class Knapsack01 {

    int[][] memo;

    //  自顶向下 + 剪枝
    public int solution1(int[] v, int[] w, int C)
    {
        memo=new int[v.length][C+1];//memo[idx][c]

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < C+1; j++) {
                memo[i][j]=-1;
            }
        }
        return dfs(v,w,0,C);
    }

    // 自底向上
    public int solution2(int[] v, int[] w, int C)
    {
        memo=new int[v.length][C+1];//memo[idx][c]

        for (int  j= 0; j < C+1; j++) {
            if (w[0]<=j){
                memo[0][j]=v[0];
            }else {
                memo[0][j]=0;
            }
        }

        for (int i = 1; i < v.length; i++) {
            for (int j = 0; j < C+1; j++) {
                memo[i][j]=memo[i-1][j];
                if (j>=w[i]){
                    memo[i][j]=Math.max(memo[i][j],v[i]+memo[i-1][j-w[i]]);
                }
            }
        }

        return memo[v.length-1][C];
    }


    //将 价值为v[idx,...], 体积为 w[idx,...] 的物品放入容积为 c 的背包
    private int dfs(int[] v, int[] w, int idx, int c ){

        if (idx>=v.length || c<=0  ){
            return 0;
        }

        if (memo[idx][c]!=-1){
            return memo[idx][c];
        }

        int res=0;
        if (c>=w[idx]){
            res=Math.max(res,v[idx]+dfs(v,w,idx+1,c-w[idx]));
            res=Math.max(res,dfs(v,w,idx+1,c));
        }
        else{
            res=Math.max(res,dfs(v,w,idx+1,c));
        }

        memo[idx][c]=res;
        return memo[idx][c];
    }

    public static void main(String[] args) {
        Knapsack01 k= new Knapsack01();
        int[] v={6,10,12};
        int[] w={1,1,3};
        int capacity=5;
        System.out.println(k.solution1(v,w,capacity));
        System.out.println(k.solution2(v,w,capacity));
    }

}
