import java.util.*;

public class Main {
    static int n;
    public void DFS(int depth, ArrayList<Integer> tmp){
        if (depth == n) {
            if (tmp.size() != 0) {
                for (int x : tmp) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }
        else{
            tmp.add(depth + 1);
            DFS(depth + 1, tmp);
            tmp.remove(tmp.size() - 1);
            DFS(depth + 1, tmp);
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        ArrayList<Integer> tmp = new ArrayList<>();
        T.DFS(0, tmp);

    }
}
