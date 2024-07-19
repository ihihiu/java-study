import java.util.*;

public class Main {

    public String solution(int n, String str) {
        char[] code = new char[n];
        n--;
        for (int i = str.length() - 1; i > -1; i = i - 7) {
            int tmp = 0;
            for (int j = 0; j < 7; j++) {
                if (str.charAt(i - j) == '#') {
                    tmp += Math.pow(2, j);
                }
            }
            code[n--] = (char) tmp;
        }
        String answer = new String(code);
        return answer;
    }

        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            int n = kb.nextInt();
            String str = kb.next();
            System.out.print(T.solution(n, str));
        }
    }
