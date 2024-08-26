import java.util.*;

class Info implements Comparable<Info> {
    String name;
    int time;
    Info(String name, int time){
        this.name = name;
        this.time = time;
    }
    @Override
    public int compareTo(Info o){
        return this.time - o.time;
    }
}

class Solution {
    public int getTime(String x){
        int hour = Integer.parseInt(x.split(":")[0]);
        int minute = Integer.parseInt(x.split(":")[1]);
        return hour * 60 + minute;
    }
    public String[] solution(String[] reports, String times){
        String[] answer = {};
        ArrayList<Info> arr = new ArrayList<>();
        for (String x : reports) {
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            arr.add(new Info(a, getTime(b)));
        }
        Collections.sort(arr);
        int start = getTime(times.split(" ")[0]);
        int end = getTime(times.split(" ")[1]);
        ArrayList<String> res = new ArrayList<>();
        for (Info ob : arr) {
            if (ob.time >= start && ob.time <= end) res.add(ob.name);
            if (ob.time > end) break;
        }
        answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}