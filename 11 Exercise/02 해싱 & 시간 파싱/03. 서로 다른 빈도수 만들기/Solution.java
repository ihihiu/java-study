import java.util.*;
class Solution {
    public int solution(String s){
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Integer> ch = new HashSet<>();
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char key : map.keySet()) {
            while (ch.contains(map.get(key))) {
                answer++;
                map.put(key, map.get(key) - 1);
            }
            if (map.get(key) == 0) continue;
            ch.add(map.get(key));
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}