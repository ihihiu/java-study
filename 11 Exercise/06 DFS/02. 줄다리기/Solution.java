import java.util.*;
class Solution {
    int answer;
    int[][] relation;
    Stack<Integer> pm;
    int[] ch;

    public void DFS(int depth) {
        if (depth == 7) answer++;
        else {
            for (int i = 1; i < 8; i++) {
                if (!pm.isEmpty() && relation[pm.peek()][i] == 1) continue;
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm.push(i);
                    DFS(depth + 1);
                    ch[i] = 0;
                    pm.pop();
                }
            }
        }
    }

    public int solution(int[][] fight){
        answer = 0;
        relation = new int[8][8];
        for (int[] x : fight) {
            int a = x[0];
            int b = x[1];
            relation[a][b] = 1;
            relation[b][a] = 1;
        }
        pm = new Stack<>();
        ch = new int[8];
        DFS(0);
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
