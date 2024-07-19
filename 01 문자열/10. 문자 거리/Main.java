import java.util.*;

public class Main {

    public int[] solution(String s, char t) {
        int[] answer = new int[s.length()];
        int value = 1000000;

        for (int i = 0; i < s.length(); i ++){
            if (s.charAt(i) == t) {
                value = 0;
                answer[i] = value++;
            } else{
                answer[i] = value++;
            }
        }

        for (int j = s.length() - 2; j > -1; j--) {
            if (s.charAt(j) != t) {
                if (answer[j] > answer[j + 1] + 1){
                    answer[j] = answer[j + 1] + 1;
                }
            }
        }

        return answer;

    }

        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            String s = kb.next();
            char t = kb.next().charAt(0);
            for (int x : T.solution(s, t)){
                System.out.print(x + " ");
            }
        }
    }
