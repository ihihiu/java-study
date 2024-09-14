import java.util.*;
class Solution {
    int[] dp;

    public int DFS(int start, String s) {
        if (dp[start] > 0) return dp[start];
        if (start < s.length() && s.charAt(start) == '0') return 0;
        if (start == s.length() - 1 || start == s.length()) return 1;
        else{
            int res = DFS(start + 1, s);
            int tmp = Integer.parseInt(s.substring(start, start + 2));
            if (tmp <= 26) res += DFS(start + 2, s);
            return dp[start] = res;
        }
    }


    public int solution(String s){
        dp = new int[101];
        int answer = DFS(0, s);
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}