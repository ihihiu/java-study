import java.util.*;
class Solution {
    int n;
    LinkedList<String> tmp;
    ArrayList<String> res;

    public void DFS(int start, String s) {
        if (start == n && tmp.size() == 4) {
            String ans = "";
            for (String x : tmp) {
                ans += x + '.';
            }
            ans = ans.substring(0, ans.length() - 1);
            res.add(ans);
        }
        else {
            for (int i = start; i < n; i++) {
                String str = s.substring(start, i + 1);
                if (str.charAt(0) == '0' && str.length() > 1) return;
                if (Integer.parseInt(str) > 255) return;
                tmp.add(str);
                DFS(i + 1, s);
                tmp.pollLast();
            }
        }
    }

    public String[] solution(String s){
        n = s.length();
        tmp = new LinkedList<>();
        res = new ArrayList<>();

        DFS(0, s);
        String[] answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) answer[i] = res.get(i);

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}