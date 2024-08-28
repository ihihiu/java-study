import java.util.*;
class Solution {
    public int[] solution(int[] arrival, int[] state){
        int n = arrival.length;
        int[] answer = new int[n];
        Queue<Integer> in = new LinkedList<>();
        Queue<Integer> out = new LinkedList<>();
        int preState = 1;
        for (int idx = 0, cnt = 0, time = 0; ; time++) {
            if (in.isEmpty() && out.isEmpty() && idx < n) {
                if (arrival[idx] > time) {
                    time = arrival[idx];
                    preState = 1;
                }
            }
            while (idx < n && arrival[idx] <= time) {
                if (state[idx] == 0) in.offer(idx);
                else out.offer(idx);
                idx++;
            }
            if (preState == 1) {
                if (!out.isEmpty()) {
                    answer[out.poll()] = time;
                    preState = 1;
                } else {
                    answer[in.poll()] = time;
                    preState = 0;
                }
            } else if (preState == 0) {
                if (!in.isEmpty()) {
                    answer[in.poll()] = time;
                    preState = 0;
                } else {
                    answer[out.poll()] = time;
                    preState = 1;
                }
            }
            cnt++;
            if (cnt == n) break;
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}