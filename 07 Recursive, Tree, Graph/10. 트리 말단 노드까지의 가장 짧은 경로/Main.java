import java.util.*;
class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt = rt= null;
    }
}
public class Main {
    Node root;
    public int bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++){
                Node now = queue.poll();
                if (now.lt == null && now.rt == null) return depth;
                if (now.lt != null) queue.offer(now.lt);
                if (now.rt != null) queue.offer(now.rt);
            }
            depth += 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.bfs(tree.root));
    }
}
