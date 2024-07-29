import java.util.*;

public class Main {
        public int solution(int n, int m, int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();

            for (int x : moves){
                int now = 0;
                for (int i = 0; i < n; i++){
                    if (board[i][x - 1] != 0){
                        now = board[i][x - 1];
                        board[i][x - 1] = 0;
                        if (!stack.isEmpty() && stack.peek() == now){
                            answer += 2;
                            stack.pop();
                        }
                        else stack.push(now);
                        break;
                    }
                }
            }

            return answer;
        }


        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            int n = kb.nextInt();
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j ++){
                    board[i][j] = kb.nextInt();
                }
            }
            int m = kb.nextInt();
            int[] moves = new int[m];
            for (int i = 0; i < m; i++){
                moves[i] = kb.nextInt();
            }
            System.out.println(T.solution(n, m, board, moves));
        }
    }
