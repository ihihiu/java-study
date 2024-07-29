import java.util.*;

public class Main {
        public String solution(String a, String b) {

            Queue<Character> Q = new LinkedList<>();

            for (char x : a.toCharArray()){
                Q.offer(x);
            }

            for (char x : b.toCharArray()){
                if (x == Q.peek()) Q.poll();
                if (Q.isEmpty()) return "YES";
            }

            return "NO";

           }


        public static void main(String[] args) {
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            String a = kb.next();
            String b = kb.next();
            System.out.println(T.solution(a, b));
        }
    }
