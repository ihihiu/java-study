import java.util.*;

public class Main {
    int[] moves = {-1, 1, 5};
    int[] visited = new int[10001];
    Queue<Integer> queue = new LinkedList<>();
    public int bfs(int s, int e){
        visited[s] = 1;
        queue.offer(s);
        int L = 0;
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++){
                int now = queue.poll();
                for (int j = 0; j < 3; j++){
                    int x = now + moves[j];
                    if (x == e) return L + 1;
                    if (x >= 1 && x <= 10000 && visited[x] == 0){
                        visited[x] = 1;
                        queue.offer(x);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(T.bfs(s, e));
    }
}
