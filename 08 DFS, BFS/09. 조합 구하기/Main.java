import java.util.*;

public class Main {
    static int n, m;
    static int[] tmp;
    public void DFS(int depth, int start){
        if (depth == m){
            for (int x : tmp) System.out.print(x + " ");
            System.out.println();
        }
        else{
            for (int i = start; i < n + 1; i++){
                tmp[depth] = i;
                DFS(depth + 1, i + 1);
            }
        }
    }

    public static void main(String args[]){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        tmp = new int[m];
        T.DFS(0, 1);
    }
}
