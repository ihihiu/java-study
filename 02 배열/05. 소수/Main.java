import java.util.*;

public class Main {
        public int solution(int n) {
            int answer = 1;
            if (n == 2) return answer;
            for (int i = 3; i < n + 1; i++){
                boolean flag = true;
                for (int j = 2; j < Math.sqrt(i) + 1; j++){
                    if (i % j == 0){
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer ++;
                }
            }
            return answer;
        }


        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            int n = kb.nextInt();
            System.out.println(T.solution(n));
        }
    }
