import java.util.*;

class Main{
    public int solution(int[] arr, int m){
        int inf = Integer.MAX_VALUE;
        int[] dp = new int[m + 1];
        Arrays.fill(dp, inf);
        dp[0] = 0;
        for (int x : arr){
            for (int j = x; j <= m; j++){
                dp[j] = Math.min(dp[j], dp[j - x] + 1);
            }
        }
        return dp[m];

    }

    public static void main(String args[]) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        System.out.println(T.solution(arr, m));
    }
}