import java.util.*;

public class KnapSack {
    public int solve(int []w,int []v,int cap){
        int n = w.length;
        int [][]dp = new int[n+1][cap + 1];
        for (int i=1;i<=n;i++){
            for (int j=0;j<=cap;j++){
                if (w[i-1] <= j){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i-1]]+v[i-1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][cap];
    }
    
    public static void main(String[] args) {
        int[] w = {1, 2, 3}; 
        int[] v = {10, 15, 40}; 
        int cap = 6; 
        KnapSack knapSack = new KnapSack();
        int maxValue = knapSack.solve(w, v, cap);
        System.out.println("Max value: " + maxValue);
    }
}
