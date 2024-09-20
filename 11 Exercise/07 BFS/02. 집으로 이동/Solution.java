import java.util.*;
class Solution {
    public int solution(int[] pool, int a, int b, int home){
        int[][] ch = new int[2][10001];
        for (int p : pool) {
            ch[0][p] = 1;
            ch[1][p] = 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        ch[0][0] = 1;
        ch[1][0] = 1;
        int L = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                if (now[1] == home) return L;
                int nx = now[1] + a;
                if (nx <= 10000 && ch[0][nx] == 0) {
                    ch[0][nx] = 1;
                    queue.offer(new int[]{0, nx});
                }
                nx = now[1] - b;
                if (nx >= 0 && ch[1][nx] == 0 && now[0] == 0) {
                    ch[1][nx] = 1;
                    queue.offer(new int[]{1, nx});
                }
            }
            L++;
        }


        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}