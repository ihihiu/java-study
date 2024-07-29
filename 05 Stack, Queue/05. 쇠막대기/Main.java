import java.util.*;

public class Main {
        public int solution(String str) {
            int answer = 0;
            Stack<Character> stack = new Stack<>();

            int cnt = 0;
            char pre = ' ';
            for (char x : str.toCharArray()){
                if (x == '('){
                    cnt++;
                    stack.push(x);
                }
                else{
                    if (pre == '('){
                        stack.pop();
                        cnt--;
                        answer += cnt;
                    } else{
                        stack.pop();
                        answer++;
                        cnt--;
                    }
                }
                pre = x;
            }

            return answer;
        }


        public static void main(String[] args) {
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            String str = kb.next();
            System.out.println(T.solution(str));
        }
    }
