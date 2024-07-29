import java.util.*;

public class Main {
        public int solution(String str) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();

            for (char x : str.toCharArray()){
                if (Character.isDigit(x)) stack.push(x - 48);
                else {
                    int b = stack.pop();
                    int a = stack.pop();
                    if (x == '+') stack.push(a + b);
                    else if (x == '-') stack.push(a - b);
                    else if (x == '*') stack.push(a * b);
                    else stack.push(a / b);
                }
            }
            answer = stack.pop();

            return answer;
        }


        public static void main(String[] args) {
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            String str = kb.next();
            System.out.println(T.solution(str));
        }
    }
