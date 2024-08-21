import java.util.*;
class Solution {
    public int[] solution(String s){
        int[] answer = new int[5];
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()){
            if (map.get(key) > max) max = map.get(key);
        }
        Arrays.fill(answer, max);
        for (char key : map.keySet()){
            int idx = key - 'a';
            answer[idx] = max - map.get(key);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
