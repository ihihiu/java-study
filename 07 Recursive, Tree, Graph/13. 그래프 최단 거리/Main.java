import java.util.*;

public class Main {
    static int n, m;
    static int[] distance;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = 1;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for (int x : graph.get(now)){
                if (visited[x] == 0){
                    visited[x] = 1;
                    queue.offer(x);
                    distance[x] = distance[now] + 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        distance = new int[n + 1];
        visited = new int[n + 1];
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n + 1; i++){
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++){
            graph.get(kb.nextInt()).add(kb.nextInt());
        }
        T.BFS(1);
        for (int i = 2; i < n + 1; i++){
            System.out.println(i + " : " + distance[i]);
        }
    }
}
