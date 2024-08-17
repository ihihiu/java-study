import java.util.*;
class Solution {
    public int solution(int[] nums){
        int answer = 0;
        int n = nums.length;
        ArrayList<Integer> idx = new ArrayList<>();
        for (int i = 1; i < n - 1; i++){
            if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]){
                idx.add(i);
            }
        }
        for (int i : idx){
            int lt = i, rt = i;
            int cnt = 1;
            while (lt - 1 >= 0 && nums[lt - 1] < nums[lt]){
                cnt++;
                lt--;
            }
            while (rt + 1 < n && nums[rt + 1] < nums[rt]){
                cnt++;
                rt++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}