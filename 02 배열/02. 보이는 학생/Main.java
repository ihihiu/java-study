import java.util.*;

public class Main {

    public int solution(int n, int[] arr) {
        int answer = 0;
        int max_height = 0;
        for (int height : arr){
            if (height > max_height){
                answer++;
                max_height = height;
            }
        }

        return answer;
    }

        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            int n = kb.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i ++ ){
                arr[i] = kb.nextInt();
            }
            System.out.println(T.solution(n, arr));
        }
    }
