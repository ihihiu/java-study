import java.util.*;

public class Main {
        public int solution(int n) {
            int answer = 0;
            int[] nums = new int[n];
            for (int i = 1; i < n; i++){
                nums[i] = i;
            }
            int lt = 1, sum = 0;
            for (int rt = 1; rt < n; rt++){
                sum += nums[rt];
                if (sum == n) answer++;
                while (sum >= n){
                    sum -= nums[lt++];
                    if (sum == n) answer++;
                }
            }

            return answer;
        }


        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            int n = kb.nextInt();
            System.out.println(T.solution(n));
        }
    }
