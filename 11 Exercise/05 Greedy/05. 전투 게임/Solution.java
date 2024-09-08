import java.util.*;
class Info implements Comparable<Info>{
    public int idx;
    public Character team;
    public int power;
    Info(int idx, Character team, int power) {
        this.idx = idx;
        this.team = team;
        this.power = power;
    }
    @Override
    public int compareTo(Info ob) {
        return this.power - ob.power;
    }

}
class Solution {
    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];
        ArrayList<Info> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Character team = students[i].split(" ")[0].charAt(0);
            int power = Integer.parseInt(students[i].split(" ")[1]);
            arr.add(new Info(i, team, power));
        }
        Collections.sort(arr);
        HashMap<Character, Integer> tP = new HashMap<>();
        int j = 0, total = 0;
        for (int i = 1; i < n; i++) {
            for ( ; j < i; j++) {
                if (arr.get(j).power < arr.get(i).power) {
                    total += arr.get(j).power;
                    char key = arr.get(j).team;
                    tP.put(key, tP.getOrDefault(key, 0) + arr.get(j).power);
                }
                else break;
            }
            answer[arr.get(i).idx] = total - tP.getOrDefault(arr.get(i).team, 0);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}