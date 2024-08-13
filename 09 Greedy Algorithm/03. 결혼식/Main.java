import java.util.*;

class Time implements Comparable<Time>{
    int time;
    char state;
    Time(int time, char state){
        this.time = time;
        this.state = state;
    }
    @Override
    public int compareTo(Time o){
        if (this.time == o.time) return this.state - o.state;
        return this.time - o.time;
    }
}

public class Main {
    public int solution(int n, ArrayList<Time> arr){
        int answer = 0;
        Collections.sort(arr);
        int cnt = 0;
        for (Time t : arr){
            if (t.state == 's'){
                cnt++;
                if (cnt > answer) answer = cnt;
            }
            else cnt--;
        }
        return answer;
    }

    public static void main(String args[]) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Time(kb.nextInt(), 's'));
            arr.add(new Time(kb.nextInt(), 'e'));
        }
        System.out.println(T.solution(n, arr));
    }

}
