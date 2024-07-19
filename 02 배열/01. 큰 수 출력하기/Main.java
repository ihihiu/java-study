import java.util.*;

public class Main {

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int pre = 0;
        for (int num : arr){
            if (num > pre){
                answer.add(num);
            }
            pre = num;
        }
        return answer;
    }

        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            int n = kb.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i ++ ){
                arr[i] = kb.nextInt();
            }
            for (int x : T.solution(n, arr)){
                System.out.print(x + " ");
            }
        }
    }
