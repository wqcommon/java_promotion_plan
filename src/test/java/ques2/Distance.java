package ques2;

/**
 * @author: wenqiang
 * @date: 2020-04-30 15:22
 *
 * 求A、B间有多少种走法
 */
public class Distance {

    public static void main(String[] args) {

    }


    /**
     * 方案1 递归
     * @param n
     * @return
     */
    private static int  ans1(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n == 3){
            return 4;
        }
        return ans1(n - 1) + ans1(n - 2) + ans1(n -3);
    }

    /**
     * 方案2 动态规划
     * @param n
     * @return
     */
    private static int ans2(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n == 3){
            return 4;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    /**
     * 方案3 不使用数组 动态规划
     * @param n
     * @return
     */
    private static int ans3(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n == 3){
            return 4;
        }
        int f1 = 1, f2 = 2, f3 = 4;
        for(int i = 4; i <= n; i++){
            int ans = f1  + f2 + f3;
            f1 = f2;
            f2 = f3;
            f3 =  ans;
        }
        return f3;
    }
}
