import java.util.*;

public class Main {

    public String solution(String str) {
        String answer = "YES";
        str = str.toLowerCase();
        int lt = 0, rt = str.length() - 1;
        while (lt < rt){
            if (!Character.isAlphabetic(str.charAt(lt))) lt ++;
            else if (!Character.isAlphabetic(str.charAt(rt))) rt--;
            else {
                if (str.charAt(lt) == str.charAt(rt)) {
                    lt++;
                    rt--;
                } else{
                    return "NO";
                }
            }
        }
        return answer;
    }

        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            String str = kb.nextLine();
            System.out.println(T.solution(str));
        }
    }
