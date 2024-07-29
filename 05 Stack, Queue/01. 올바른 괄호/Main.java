import java.util.*;

public class Main {
        public String solution(String str) {

            Stack<Character> stack = new Stack<>();

            for (char x : str.toCharArray()){
                if (x == '(') stack.push(x);
                else {
                    if (stack.isEmpty()) return "NO";
                    else stack.pop();
                }
            }
            if (stack.isEmpty()) return "YES";
            else return "NO";

        }


        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            String str = kb.next();
            System.out.println(T.solution(str));
        }
    }
