import java.util.*;

class Edge implements Comparable<Edge>{
    int v, cost;
    Edge(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob){
        return  this.cost - ob.cost;
    }
}

class Main{
    static int n, m;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
    static int[] distance;
    static int max = Integer.MAX_VALUE;

    public void solution(int v){
        distance = new int[n + 1];
        Arrays.fill(distance, max);
        distance[v] = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));
        while (!pQ.isEmpty()){
            Edge now = pQ.poll();
            if (now.cost > distance[now.v]) continue;
            for (Edge x : graph.get(now.v)){
                int cost = x.cost + distance[now.v];
                if (cost < distance[x.v]){
                    distance[x.v] = cost;
                    pQ.offer(new Edge(x.v, cost));
                }
            }
        }
    }

    public static void main(String args[]) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < m; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        T.solution(1);
        for (int i = 2; i <= n; i++){
            if (distance[i] == max) System.out.println(i + " : impossible");
            else System.out.println(i + " : " + distance[i]);
        }
    }
}