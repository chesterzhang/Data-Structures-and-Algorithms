package leetcode;

import java.util.Arrays;

// 将 类的名称换成 Solution 即可
public class Leetcode198 {
    int[] memo;//memo[i]表示从[i...n]的最佳偷法

    public int rob(int[] nums) {
        memo=new int[nums.length];
        Arrays.fill(memo,-1);
        return dfs(nums,0);
    }

    //在nums[idx,...]内进行偷,返回最大金额,idx为总的索引,而不是arr的索引
    private  int dfs(int[] v,int idx){
        if (idx>=v.length){
            return 0;
        }
        if (memo[idx]!=-1){
            return memo[idx];
        }

        memo[idx]=Math.max(memo[idx],v[idx]+dfs(v,idx+2));
        memo[idx]=Math.max(memo[idx],dfs(v,idx+1));

        return memo[idx];
    }

    public int rob2(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        if (nums.length == 1){
            return nums[0];
        }

        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i < nums.length;i++){
            memo[i] = Math.max(nums[i] + memo[i-2], memo[i -1]);
        }

        return memo[nums.length -1];
    }


}
