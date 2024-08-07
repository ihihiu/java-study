import java.util.*;

public class Main {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    public void DFS(int v){
        if (v == n) answer++;
        else{
            for (int nv : graph.get(v)){
                if (visited[nv] == 0){
                    visited[nv] = 1;
                    DFS(nv);
                    visited[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
        }
        visited = new int[n + 1];
        for (int i = 0; i < m; i++){
            graph.get(kb.nextInt()).add(kb.nextInt());
        }
        visited[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
