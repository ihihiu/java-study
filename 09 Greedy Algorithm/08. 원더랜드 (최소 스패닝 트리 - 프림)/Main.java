import java.util.*;

class Edge implements Comparable<Edge>{
    int vertex, cost;
    Edge(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob){
        return this.cost - ob.cost;
    }
}

class Main{
    public static void main(String args[]) {
        Scanner kb = new Scanner(System.in);
        int v = kb.nextInt();
        int e = kb.nextInt();
        int[] visited = new int[v + 1];
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i <= v; i++){
            graph.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < e; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        int answer = 0;
        pQ.offer(new Edge(1, 0));
        while (!pQ.isEmpty()) {
            Edge now = pQ.poll();
            if (visited[now.vertex] == 0){
                visited[now.vertex] = 1;
                answer += now.cost;
                for (Edge x : graph.get(now.vertex)){
                    pQ.offer(new Edge(x.vertex, x.cost));
                }
            }
        }
        System.out.println(answer);

    }
}