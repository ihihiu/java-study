import java.util.*;

public class Main {

    public String solution(String str) {
        String answer = "YES";
        int len = str.length();
        str = str.toLowerCase();
        for (int i = 0; i < len/2; i++){
            if (str.charAt(i) != str.charAt(len - i - 1)){
                answer = "NO";
                break;
            }
        }

        return answer;
    }

        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            String str = kb.next();
            System.out.println(T.solution(str));
        }
    }
