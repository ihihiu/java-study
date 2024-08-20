import java.util.*;
class Solution {
    public int[] solution(int[] enter, int[] exit){
        int n = enter.length;
        for (int i = 0; i < n; i++){
            enter[i]--;
            exit[i]--;
        }
        int[] ch = new int[n];
        int[] answer = new int[n];
        int in = 0, out = 0, cnt = 0;
        while (in < n || out < n) {
            if (ch[exit[out]] == 1) {
                cnt--;
                ch[exit[out]] = 0;
                answer[exit[out]] += cnt;
                for (int i = 0; i < n; i++) {
                    if (i != exit[out]){
                        if (ch[i] == 1) answer[i] += 1;
                    }
                }
                out++;
            } else {
                ch[enter[in]] = 1;
                cnt++;
                in++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
