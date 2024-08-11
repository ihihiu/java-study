import java.util.*;

public class Main {
    public void DFS(int depth, int n, int m, ArrayList<Integer> tmp) {
        if (depth == m) {
            for (int x : tmp) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i < n + 1; i++) {
                tmp.add(i);
                DFS(depth + 1, n, m, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        ArrayList<Integer> tmp = new ArrayList<>();
        T.DFS(0, n, m, tmp);
    }
}
