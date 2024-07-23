import java.util.*;

public class Main {
        public int[] solution(int n, int[] arr) {
            int[] answer = new int[n];
            for (int i = 0; i < n; i++) {
                answer[i] = 1;
            }
            for (int i = 0; i < n; i++) {
                int score = arr[i];
                for (int j = 0; j < n; j++) {
                    if (arr[j] < score) {
                        answer[j]++;
                    }
                }
            }

            return answer;
        }


        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            int n = kb.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i ++){
                arr[i] = kb.nextInt();
            }
            for (int x : T.solution(n, arr)){
                System.out.print(x + " ");

            }
        }
    }
