import java.util.*;
class Solution {
    public int solution(int[][] board){
        int answer = 0;
        int ax = 0, ay = 0, ad = 0;
        int bx = 0, by = 0, bd = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (board[i][j] == 2){
                    ax = i;
                    ay = j;
                }
                if (board[i][j] == 3){
                    bx = i;
                    by = j;
                }
            }
        }
        while (answer < 10000){
            if (ax == bx && ay == by){
                return answer;
            }
            answer++;
            int aax = ax + dx[ad];
            int aay = ay + dy[ad];
            if (aax < 0 || aax >= 10 || aay < 0 || aay >= 10 || board[aax][aay] == 1){
                ad = (ad + 1) % 4;
            }
            else{
                ax = aax;
                ay = aay;
            }
            int bbx = bx + dx[bd];
            int bby = by + dy[bd];
            if (bbx < 0 || bbx >= 10 || bby < 0 || bby >= 10 || board[bbx][bby] == 1){
                bd = (bd + 1) % 4;
            }
            else{
                bx = bbx;
                by = bby;
            }

        }
        return 0;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}