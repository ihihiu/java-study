import java.util.*;

public class Main {
        public int solution(String s, String t) {
            int answer = 0;
            HashMap<Character, Integer> HM = new HashMap<>();
            HashMap<Character, Integer> map = new HashMap<>();
            for (char x : t.toCharArray()){
                HM.put(x, HM.getOrDefault(x, 0) + 1);
            }

            int len = t.length();
            for (int i = 0; i < len; i++){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            if (map.equals(HM)) answer++;
            int lt = 0;

            for (int rt = len; rt < s.length(); rt++){
                map.put(s.charAt(rt), map.getOrDefault(s.charAt(rt), 0) + 1);
                map.put(s.charAt(lt), map.get(s.charAt(lt)) - 1);
                if (map.get(s.charAt(lt)) == 0) map.remove(s.charAt(lt));
                if (map.equals(HM)) answer++;
                lt++;
            }

            return answer;
        }


        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            String s = kb.next();
            String t = kb.next();
            System.out.println(T.solution(s, t));
        }
    }
