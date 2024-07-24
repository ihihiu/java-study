import java.util.*;

public class Main {
        public int solution(int n, int[][] arr) {
            int answer = 0, max = -1;
            for (int k = 0; k < n; k++) {
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (arr[i][j] == arr[k][j]){
                            cnt++;
                            break;
                        }
                    }
                }
                if (cnt > max){
                    max = cnt;
                    answer = k + 1;
                }
            }

            return answer;
        }


        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            int n = kb.nextInt();
            int[][] arr = new int[n][5];
            for (int i = 0; i < n; i ++){
                for (int j = 0; j < 5; j ++){
                    arr[i][j] = kb.nextInt();
                }
            }
            System.out.println(T.solution(n, arr));
        }
    }
