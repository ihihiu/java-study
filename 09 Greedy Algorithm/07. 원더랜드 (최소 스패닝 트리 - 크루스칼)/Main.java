import java.util.*;

class Edge implements Comparable<Edge>{
    int a, b, c;
    Edge(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public int compareTo(Edge o){
        return this.c - o.c;
    }
}

class Main{
    static int v, e;
    static ArrayList<Edge> arr = new ArrayList<>();
    static int[] parent;
    static int answer = 0;

    public static int find(int x){
        if (x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if (fa > fb) parent[fa] = fb;
        else parent[fb] = fa;
    }

    public int solution(){
        int cnt = 0;
        Collections.sort(arr);
        for (Edge ob : arr){
            if (find(ob.a) != find(ob.b)){
                answer += ob.c;
                union(ob.a, ob.b);
                cnt++;
                if (cnt == v - 1) break;
            }
        }
        return answer;
    }

    public static void main(String args[]) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        v = kb.nextInt();
        e = kb.nextInt();
        for (int i = 0; i < e; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            arr.add(new Edge(a, b, c));
        }
        parent = new int[v + 1];
        for (int i = 1; i <= v; i++){
            parent[i] = i;
        }
        System.out.println(T.solution());
    }
}