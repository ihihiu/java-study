import java.util.*;

class Brick implements Comparable<Brick>{
    int a, h, w;
    Brick(int a, int h, int w) {
        this.a = a;
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Brick o){
        return o.a - this.a;
    }
}

class Main{
    public int solution(ArrayList<Brick> arr){
        int answer = 0;
        Collections.sort(arr);
        int[] dp = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++){
            dp[i] = arr.get(i).h;
            for (int j = 0; j < i; j++){
                if (arr.get(i).w < arr.get(j).w){
                    dp[i] = Math.max(dp[i], dp[j] + arr.get(i).h);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }

    public static void main(String args[]) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Brick> arr = new ArrayList<>();
        for (int i = 0; i < n; i++){
            arr.add(new Brick(kb.nextInt(), kb.nextInt(), kb.nextInt()));
        }
        System.out.println(T.solution(arr));
    }
}