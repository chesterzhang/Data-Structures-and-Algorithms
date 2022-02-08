package leetcode;

// 将 类的名称换成 Solution 即可
public class Leetcode416 {
    private int[][] memo;//memo[i][c]表示从nums[0...i]中是否存在组合把容量为c的背包填满
    //-1表示没计算,0表示不可以,1表示可以
    
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }

        // 如果压根就不是2的整数倍, 直接return false
        if (sum%2!=0){
            return false;
        }

        memo=new int[nums.length][sum/2+1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j]=-1;
            }
        }

        return  partition(nums, nums.length-1, sum/2);
    }


    //判断从nums[0...i]能否刚好放入容量为 c 的背包
    private  boolean partition(int[] w ,int i,int c){
        if (c==0){
            return true;
        }
        if (i<0 || c<0){
            return false;
        }

        if (memo[i][c]!=-1){
            return memo[i][c]==1;
        }

        if (partition(w,i-1,c) || partition(w ,i-1,c-w[i])) {
            memo[i][c]=1;
            return true;
        }else {
            memo[i][c]=0;
            return false;
        }


    }

}
