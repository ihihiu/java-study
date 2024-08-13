import java.util.*;

class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m;
    static int[][] graph;
    static ArrayList<Point> house = new ArrayList<>();
    static ArrayList<Point> pizzas = new ArrayList<>();
    static ArrayList<Point> tmp;
    static int answer = Integer.MAX_VALUE;

    public void DFS(int depth, int start, ArrayList<Point> tmp){
        if (depth == m){
            int sum = 0;
            for (Point h : house){
                int min = Integer.MAX_VALUE;
                for (Point now : tmp){
                    int dis = Math.abs(now.x - h.x) + Math.abs(now.y - h.y);
                    min = Math.min(min, dis);
                }
                sum += min;
            }
            answer = Math.min(answer, sum);
        }
        else{
            for (int i = start; i < pizzas.size(); i++){
                tmp.add(pizzas.get(i));
                DFS(depth + 1, i + 1, tmp);
                tmp.remove(tmp.size()- 1);
            }
        }
    }

    public void solution(){
        tmp = new ArrayList<Point>();
        DFS(0, 0, tmp);
    }

    public static void main(String args[]) {
        Main t = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int x = kb.nextInt();
                graph[i][j] = x;
                if (x == 1) house.add(new Point(i, j));
                if (x == 2) pizzas.add(new Point(i, j));
            }
        }
        t.solution();
        System.out.println(answer);
    }
}
