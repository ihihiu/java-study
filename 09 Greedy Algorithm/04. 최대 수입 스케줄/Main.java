import java.util.*;

class Lecture implements Comparable<Lecture>{
    int money, day;
    Lecture(int money, int day){
        this.money = money;
        this.day = day;
    }
    public int compareTo(Lecture o){
        return o.day - this.day;
    }
}

class Main{
    static int n, maxDay = 0;
    static ArrayList<Lecture> arr = new ArrayList<>();

    public int solution(){
        int answer = 0;
        Collections.sort(arr);
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        for (int i = maxDay; i >= 1; i--){
            for ( ; j < n; j++){
                if (arr.get(j).day < i) break;
                pQ.offer(arr.get(j).money);
            }
            if (!pQ.isEmpty()) answer += pQ.poll();
        }

        return answer;

    }
    public static void main(String args[]){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        for (int i = 0; i < n; i++){
            int money = kb.nextInt();
            int day = kb.nextInt();
            arr.add(new Lecture(money, day));
            if (day > maxDay) maxDay = day;
        }
        System.out.println(T.solution());
    }
}