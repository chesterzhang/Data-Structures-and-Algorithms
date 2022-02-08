package leetcode;

import java.util.Arrays;

public class Leetcode300 {

    private int[] memo;//memo[i] 表示nums[0...i]的最长上升子序列

    public int lengthOfLIS(int[] nums) {

        memo=new int[nums.length+1];
        Arrays.fill(memo,1);

        for (int i = 0; i < nums.length; i++) {
            int maxPrevIdx=-1;//用来存储 memo[0...j]中最大的元素索引,同时nums[maxPrevIdx] < nums[i]
            int maxPrev=0;//用来存储 memo[0...j]中最大的元素
            for (int j = i-1; j >=0 ; j--) {
                if (nums[j]< nums[i] && memo[j]> maxPrev){
                    maxPrevIdx=j;
                    maxPrev=memo[j];
                }
            }
            if (maxPrevIdx!=-1){
                memo[i]=memo[maxPrevIdx]+1;
            }

        }

        int res=1;
        for(int i=0;i< memo.length;i++){
            if (memo[i]>res){
                res=memo[i];
            }
        }

        return res;

    }


//    public int lengthOfLIS3(int[] nums){
//        memo=new int[nums.length+1];
//        Arrays.fill(memo,1);
//
//        dfs(nums,-1,0);
//
//        return memo[0];
//    }
//
//    private int dfs(int[] nums, int lastIdx, int idx){
//
//        if (idx>=nums.length){
//            return 0;
//        }
//        if (memo[idx]!=1){
//            return memo[idx];
//        }
//        if (lastIdx!=-1 && nums[lastIdx]>=nums[idx]){
//            memo[idx]= Math.max(memo[idx],dfs(nums,lastIdx,idx+1));
//            return memo[idx];
//        }
//
//        memo[idx]=Math.max(memo[idx],1+dfs(nums,idx,idx+1));
//        memo[idx]=Math.max(memo[idx],dfs(nums,lastIdx,idx+1));
//        return memo[idx];
//
//    }



}

