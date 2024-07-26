import java.util.*;

public class Main {
        public String solution(String a, String b) {
            String answer = "YES";
            HashMap<Character, Integer> map = new HashMap<>();
            for (char key : a.toCharArray()){
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (char key : b.toCharArray()){
                map.put(key, map.getOrDefault(key, 0) - 1);
            }
            for (char key : map.keySet()){
                if (map.get(key) != 0) {
                    answer = "NO";
                    break;
                }
            }

            return answer;
        }


        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            String a = kb.next();
            String b = kb.next();
            System.out.println(T.solution(a, b));
        }
    }
