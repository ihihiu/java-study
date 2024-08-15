import java.util.*;

class Main{
    static int[] parent;
    public static int findParent(int x){
        if (parent[x] != x) parent[x] = findParent(parent[x]);
        return parent[x];
    }
    public static void unionParent(int a, int b){
        int fa = findParent(a);
        int fb = findParent(b);
        if (fa < fb) parent[fb] = fa;
        else parent[fa] = fb;
    }

    public static void main(String args[]) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++){
            parent[i] = i;
        }
        for (int i = 0; i < m; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            unionParent(a, b);
        }
        int a = kb.nextInt();
        int b = kb.nextInt();
        if (findParent(a) == findParent(b)) System.out.println("YES");
        else System.out.println("NO");
    }
}