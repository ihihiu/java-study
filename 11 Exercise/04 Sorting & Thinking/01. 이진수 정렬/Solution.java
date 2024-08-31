import java.util.*;

class Number implements Comparable<Number> {
    int decimal;
    int cnt;
    Number(int decimal, int cnt) {
        this.decimal = decimal;
        this.cnt = cnt;
    }
    @Override
    public int compareTo(Number ob) {
        if (this.cnt == ob.cnt) return this.decimal - ob.decimal;
        return this.cnt - ob.cnt;
    }
}

class Solution {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];
        ArrayList<Number> arr = new ArrayList<>();
        for (int num : nums) {
            int cnt = 0;
            int n = num;
            while (n != 0) {
                if (n % 2 == 1) cnt++;
                n /= 2;
            }
            arr.add(new Number(num, cnt));
        }
        Collections.sort(arr);
        for (int i = 0; i < nums.length; i++) {
            answer[i] = arr.get(i).decimal;
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}