import java.util.*;

public class Main {
    public int count(int[] arr, int mid){
        int cnt = 1;
        int pre = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (pre + mid <= arr[i]){
                cnt++;
                pre = arr[i];
            }
        }
        return cnt;
    }
    public int solution(int n, int m, int[] arr){
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1, rt = arr[n - 1] - arr[0];
        while (lt <= rt){
            int mid = (lt + rt) / 2;
            if(count(arr, mid) >= m){
                answer = mid;
                lt = mid + 1;
            }
            else rt = mid - 1;
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
