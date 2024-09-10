import java.util.*;
class Solution {
    int answer, target, size;
    boolean flag;
    ArrayList<Integer> nums;
    int[] ch;

    public void DFS(int depth, int tmp) {
        if (flag) return;
        if (depth == size) {
            if (tmp > target) {
                answer = tmp;
                flag = true;
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    DFS(depth + 1, tmp * 10 + nums.get(i));
                    ch[i] = 0;
                }
            }
        }
    }
    public int solution(int n){
        answer = 0;
        nums = new ArrayList<>();
        target = n;
        flag = false;
        int number = n;
        while (number != 0) {
            nums.add(number % 10);
            number /= 10;
        }
        size = nums.size();
        ch = new int[size];
        nums.sort((a, b) -> a - b);
        DFS(0, 0);
        if (flag == false) return -1;
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}