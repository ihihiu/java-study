import java.util.*;

public class Main {
        public ArrayList<Integer> solution(int n, int[] arr) {
            ArrayList<Integer> answer = new ArrayList<>();
            for (int num : arr){
                int reverseNum = 0;
                while (num != 0){
                    reverseNum = reverseNum * 10 + (num % 10);
                    num /= 10;
                }
                if (reverseNum == 2) {
                    answer.add(reverseNum);
                } else if(reverseNum != 1) {
                    boolean flag = true;
                    for (int i = 2; i < Math.sqrt(reverseNum) + 1; i++) {
                        if (reverseNum % i == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) answer.add(reverseNum);
                }
            }

            return answer;
        }


        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            int n = kb.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i ++){
                arr[i] = kb.nextInt();
            }
            for (int num : T.solution(n, arr)){
                System.out.print(num + " ");
            }
        }
    }
