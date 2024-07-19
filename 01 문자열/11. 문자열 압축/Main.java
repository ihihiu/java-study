import java.util.*;

public class Main {

    public String solution(String str) {
        String answer = "";

        char now = str.charAt(0);
        int cnt = 1;
        for (int i = 1; i < str.length(); i++) {
            if (now == str.charAt(i)){
                cnt++;
            } else {
                answer += now;
                if (cnt > 1){
                    answer += String.valueOf(cnt);
                }
                now = str.charAt(i);
                cnt = 1;
            }
        }

        answer += now;
        if (cnt > 1){
            answer += cnt;
        }


        return answer;
    }

        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            String str = kb.next();
            System.out.print(T.solution(str));
        }
    }
