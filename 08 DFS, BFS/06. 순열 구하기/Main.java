import java.util.*;

public class Main {
    static int n, m;
    static int[] arr, visited;
    public void DFS(int depth, ArrayList<Integer> tmp){
        if (depth == m){
            for (int x : tmp) System.out.print(x + " ");
            System.out.println();
        }
        else {
            for (int i = 0; i < n; i++){
                if (visited[i] == 0){
                    visited[i] = 1;
                    tmp.add(arr[i]);
                    DFS(depth + 1, tmp);
                    visited[i] = 0;
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }


    public static void main(String args[]){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i ++) arr[i] = kb.nextInt();
        ArrayList<Integer> tmp = new ArrayList<>();
        visited = new int[n];
        T.DFS(0, tmp);
    }
}
