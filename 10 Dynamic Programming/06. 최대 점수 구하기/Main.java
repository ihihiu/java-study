import java.util.*;

class Main{
    public int solution(int[][] arr, int m){
        int[] dp = new int[m + 1];
        for (int i = 0; i < arr.length; i++){
            for (int j = m; j >= arr[i][1]; j--){
                dp[j] = Math.max(dp[j], dp[j - arr[i][1]] + arr[i][0]);
            }
        }
        return dp[m];

    }

    public static void main(String args[]) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = kb.nextInt();
            arr[i][1] = kb.nextInt();
        }
        System.out.println(T.solution(arr, m));
    }
}