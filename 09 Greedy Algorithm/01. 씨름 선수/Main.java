import java.util.*;

class Body implements Comparable<Body>{
    int h, w;
    Body(int h, int w){
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Body o){
        return o.h - this.h;
    }
}

public class Main {
    public int solution(int n, ArrayList<Body> arr){
        int answer = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for (Body ob: arr){
            if (ob.w > max) {
                answer++;
                max = ob.w;
            }
        }
        return answer;
    }

    public static void main(String args[]) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for (int i = 0; i < n; i++){
            arr.add(new Body(kb.nextInt(), kb.nextInt()));
        }
        System.out.println(T.solution(n, arr));
    }
}
