import java.util.*;
class Solution {
    HashMap<Character, Integer> sH;
    Deque<Character> tmp;
    int n;
    ArrayList<String> res;

    public void DFS(){
        if (tmp.size() == n) {
            String ans = "";
            for (char x : tmp) {
                ans += x;
            }
            res.add(ans);
        }
        else {
            for (char key : sH.keySet()) {
                if (sH.get(key) == 0) continue;
                tmp.addFirst(key);
                tmp.addLast(key);
                sH.put(key, sH.get(key) - 2);
                DFS();
                tmp.pollFirst();
                tmp.pollLast();
                sH.put(key, sH.get(key) + 2);
            }
        }
    }

    public String[] solution(String s){
        String[] answer = {};
        sH = new HashMap<>();
        tmp = new LinkedList<>();
        n = s.length();
        res = new ArrayList<>();

        for (char x : s.toCharArray()) {
            sH.put(x, sH.getOrDefault(x, 0) + 1);
        }
        int odd = 0;
        char mid = '#';
        for (char key : sH.keySet()) {
            if (sH.get(key) % 2 == 1) {
                odd++;
                mid = key;
            }
        }
        if (odd > 1) return answer;
        if (mid != '#') {
            tmp.add(mid);
            sH.put(mid, sH.get(mid) - 1);
        }
        DFS();
        answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}