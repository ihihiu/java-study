import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public ArrayList<Character> solution(int n, int[] A, int[] B) {
        ArrayList<Character> answer = new ArrayList<>(n);

        for (int i = 0; i < n; i++){
            int a = A[i], b = B[i];
            if (a == b){
                answer.add('D');
            } else if (Math.abs(a - b) == 1) {
                if(a > b) answer.add('A');
                else answer.add('B');
            } else{
                if (a > b) answer.add('B');
                else answer.add('A');
            }
        }

        return answer;
    }

        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            int n = kb.nextInt();
            int[] A = new int[n];
            int[] B = new int[n];
            for (int i = 0; i < n; i ++ ){
                A[i] = kb.nextInt();
            }
            for (int i = 0; i < n; i ++ ){
                B[i] = kb.nextInt();
            }
            for (char x : T.solution(n, A, B)) {
                System.out.println(x);
            }
        }
    }
