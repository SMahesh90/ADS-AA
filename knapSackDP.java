public class KnapSack {
    public int solve(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    // Include the item
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    // Exclude the item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3}; 
        int[] values = {10, 15, 40}; 
        int capacity = 6; 
        KnapSack knapSack = new KnapSack();
        int maxValue = knapSack.solve(weights, values, capacity);
        System.out.println("Max value: " + maxValue);
    }
}
