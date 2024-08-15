import java.util.*;

class Main{
    public int solution(int[] arr){
        int answer = 0;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i< arr.length; i++){
            for (int j = 0; j < i; j++){
                if (arr[i] > arr[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }

    public static void main(String args[]) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}