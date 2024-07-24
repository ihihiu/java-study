import java.util.*;

public class Main {
        public int solution(int n, int m, int[][] arr) {
            int answer = 0;
            for (int student = 1; student < n + 1; student++){
                int[] tmp = new int[n + 1];
                tmp[student] = 1;
                for (int i = 0; i < m; i++){
                    for (int j = 0; j < n; j++){
                        if (student == arr[i][j]){
                            break;
                        }
                        tmp[arr[i][j]] = 1;
                    }
                }
                for (int k = 1; k < n + 1; k++){
                    if (tmp[k] == 0){
                        answer++;
                    }
                }
            }

            return answer;
        }


        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            int n = kb.nextInt();
            int m = kb.nextInt();
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    arr[i][j] = kb.nextInt();
                }
            }
            System.out.println(T.solution(n, m, arr));

        }
    }
