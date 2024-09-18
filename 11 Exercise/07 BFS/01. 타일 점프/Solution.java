import java.util.*;
class Solution {
    public int solution(int[] nums){
        int n = nums.length;
        int[] ch = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        ch[0] = 1;
        int L = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                for (int j = 1; j <= nums[now]; j++) {
                    int x = now + j;
                    if (x == n - 1) return L + 1;
                    if (ch[x] == 0) {
                        ch[x] = 1;
                        queue.offer(x);
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}