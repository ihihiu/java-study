import java.util.*;

class Meeting implements Comparable<Meeting>{
    public int s, e;
    Meeting(int s, int e){
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Meeting o){
        if (this.e == o.e) return this.s - o.s;
        else return this.e - o.e;
    }
}

public class Main {
    public int solution(int n, ArrayList<Meeting> arr){
        int answer = 1;
        Collections.sort(arr);
        int end = arr.get(0).e;
        for (int i = 1; i < n; i++){
            if (arr.get(i).s >= end){
                answer++;
                end = arr.get(i).e;
            }
        }
        return answer;

    }

    public static void main(String args[]) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Meeting> arr = new ArrayList<>();
        for (int i = 0; i < n; i++){
            arr.add(new Meeting(kb.nextInt(), kb.nextInt()));
        }
        System.out.println(T.solution(n, arr));
    }

}
