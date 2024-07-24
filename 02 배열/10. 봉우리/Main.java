import java.util.*;

public class Main {
        public int solution(int n, int[][] arr) {
            int answer = 0;
            int[][] graph = new int[n + 2][n + 2];

            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int i = 0; i < n + 2; i++) {
                graph[0][i] = 0;
                graph[n + 1][i] = 0;
            }
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    graph[i][j] = arr[i - 1][j - 1];
                }
            }
            int nx, ny;
            boolean flag;
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    flag = true;
                    for (int k = 0; k < 4; k++) {
                        nx = i + dx[k];
                        ny = j + dy[k];
                        if (graph[i][j] <= graph[nx][ny]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) answer++;
                }
            }

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
