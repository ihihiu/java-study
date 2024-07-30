import java.util.*;

public class Main {
    public int solution(int n, int m, int[] arr){
        int start = Arrays.stream(arr).max().getAsInt();
        int end = Arrays.stream(arr).sum();
        int answer = end;
        while (start <= end){
            int mid = (start + end) / 2;
            int cnt = 1, sum = 0;
            for (int a : arr){
                sum += a;
                if (sum > mid){
                    cnt++;
                    sum = a;
                }
            }

            if (cnt <= m){
                answer = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }


        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}
