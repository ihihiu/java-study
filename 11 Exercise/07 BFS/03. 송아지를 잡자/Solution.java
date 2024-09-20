import java.util.*;
class Solution {
    public int solution(int s, int e){
        int[][] ch = new int[2][200001];
        Queue<Integer> queue = new LinkedList<>();
        ch[0][s] = 1;
        queue.offer(s);
        int L = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            L++;
            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                for (int nx : new int[] {x - 1, x + 1, x * 2}) {
                    if (nx >= 0 && nx <= 200000 && ch[L % 2][nx] == 0) {
                        ch[L % 2][nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            e += L;
            if (e > 200000) return -1;
            if (ch[L % 2][e] == 1) return L;
        }
        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}