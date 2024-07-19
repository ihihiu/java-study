import java.util.*;

public class Main {

    public int solution(String str) {
        String ans = "";
        for (char x : str.toCharArray()) {
            if (!Character.isAlphabetic(x)) {
                ans += x;
            }
        }
        return Integer.valueOf(ans);
    }

        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            String str = kb.nextLine();
            System.out.println(T.solution(str));
        }
    }
