import java.util.*;
class Solution {
    //1. 최솟값이 고유한지 확인하기
    //2. 최솟값이 유일한지 확인하기
    public int getMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int x: arr){
            min = Math.min(min, x);
        }
        return min;
    }

    public boolean isOne(int[] arr){
        int min = getMin(arr);
        int cnt = 0;
        for (int x : arr){
            if (x == min) cnt++;
        }
        return cnt == 1;
    }

    public int getIndex(int[] arr){
        int min = getMin(arr);
        for (int i = 0; i < 3; i++){
            if (arr[i] == min) return i;
        }
        return 0;
    }

    public int solution(int[][] fruit){
        int answer = 0;
        int n = fruit.length;
        int[] check = new int[n];
        for (int i = 0; i < n; i++){
            if (check[i] == 1) continue;
            if (!isOne(fruit[i])) continue;
            int idx = getIndex(fruit[i]);
            for (int j = i + 1; j < n; j++){
                if (check[j] == 1) continue;
                if (!isOne(fruit[j])) continue;
                int idx1 = getIndex(fruit[i]);
                int idx2 = getIndex(fruit[j]);
                if (idx1 != idx2 && fruit[i][idx2] > 0 && fruit[j][idx1] > 0){
                    if (fruit[i][idx1] + 1 <= fruit[i][idx2] - 1 && fruit[j][idx2] + 1 <= fruit[j][idx1] - 1 ){
                        fruit[i][idx1]++;
                        fruit[i][idx2]--;
                        fruit[j][idx2]++;
                        fruit[j][idx1]--;
                        check[i] = 1;
                        check[j] = 1;
                        break;
                    }
                }
            }
        }
        for (int[] x : fruit){
            answer += getMin(x);
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}