import java.util.*;
class Solution {
    public String[] solution(String[] subjects, String[] course){
        int n = subjects.length;
        String[] answer = new String[n];
        HashMap<String, Integer> sh = new HashMap<>();
        for (int i = 0; i < n; i++) sh.put(subjects[i], i);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        int[] indegree = new int[n];
        for (String x: course) {
            int a = sh.get(x.split(" ")[0]);
            int b = sh.get(x.split(" ")[1]);
            graph.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        int idx = 0;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            answer[idx++] = subjects[now];
            for (int x : graph.get(now)) {
                indegree[x]--;
                if (indegree[x] == 0) queue.offer(x);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        String[] res = T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"});
        System.out.println(Arrays.toString(res));
        //System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})[0]);
        //System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
    }
}