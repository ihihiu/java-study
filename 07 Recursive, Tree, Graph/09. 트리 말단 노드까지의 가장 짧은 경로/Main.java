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
    public int dfs(int depth, Node root){
        if (root.lt == null && root.rt == null) return depth;
        else return Math.min(dfs(depth + 1, root.lt), dfs(depth + 1, root.rt));
    }
    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.dfs(0, tree.root));
    }
}
