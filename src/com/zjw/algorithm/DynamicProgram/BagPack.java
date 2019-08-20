package com.zjw.algorithm;

public class BagPack {

    /*
        0-1背包问题，有n种物品，总容量为c
     */
    public int zeroOnePack(int n, int c, int[] value, int[] weight){
        int[] dp = new int[c + 1];

        for(int i = 0; i < n; i++){
            for(int j = c; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        return dp[c];
    }

    /*
        完全背包
     */
    public int completePack(int n, int c, int[] value, int[] weight){
        int[] dp = new int[c + 1];

        for(int i = 0; i < n; i++){
            for(int j = weight[i]; j <= c; j++){
                dp[j] = Math.max(dp[j], dp[j - weight[j]] + value[j]);
            }
        }

        return dp[c];
    }

    /*
        多重背包
     */
    public int multiPack(int n, int c, int[] value, int[] weight, int[] nums){
        int[] dp = new int[c + 1];

        for(int i = 0; i < n; i++){
            if(weight[i] * nums[i] > c){
                comPack(dp, value[i], weight[i]);
            }else{
                int k = 1, nu = nums[i];
                while(k < nu){
                    onePack(dp, k * value[i], k * weight[i]);
                    nu -= k;
                    k <<= 1;
                }
                onePack(dp, nu * value[i], nu * weight[i]);
            }
        }

        return dp[c];
    }

    public void onePack(int[] dp, int value, int weight){
        for(int j = dp.length - 1; j >= weight; j--){
            dp[j] = Math.max(dp[j], dp[j - weight]);
        }
    }

    public void comPack(int[] dp, int value, int weight){
        for(int j = weight; j <= dp.length - 1; j++){
            dp[j] = Math.max(dp[j], dp[j - weight]);
        }
    }
}
