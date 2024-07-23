import java.util.*;

public class Main {
        public int solution(int n, int[][] arr) {
            int answer = 0;
            for (int i = 0; i < n; i++) {
                int rowSum = 0, colSum = 0;
                for (int j = 0; j < n; j++) {
                    rowSum += arr[i][j];
                    colSum += arr[j][i];
                }
                answer = Math.max(answer, Math.max(rowSum, colSum));
            }
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < n; i++) {
                sum1 += arr[i][i];
                sum2 += arr[i][n - 1 - i];
            }
            answer = Math.max(answer, Math.max(sum1, sum2));


            return answer;
        }


        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            int n = kb.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i ++){
                for (int j = 0; j < n; j ++){
                    arr[i][j] = kb.nextInt();
                }
            }
            System.out.println(T.solution(n, arr));
        }
    }
