import java.util.*;

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt = rt = null;
    }
}

public class Main {
    Node root;
    public void PreOrder(Node root){
        if (root == null) return;
        else{
            System.out.print(root.data + " ");
            PreOrder(root.lt);
            PreOrder(root.rt);
        }
    }
    public void InOrder(Node root){
        if (root == null) return;
        else{
            InOrder(root.lt);
            System.out.print(root.data + " ");
            InOrder(root.rt);
        }
    }
    public void PostOrder(Node root){
        if (root == null) return;
        else{
            PostOrder(root.lt);
            PostOrder(root.rt);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        System.out.print("전위순회 출력 : ");
        tree.PreOrder(tree.root);
        System.out.println();
        System.out.print("중위순회 출력 : ");
        tree.InOrder(tree.root);
        System.out.println();
        System.out.print("후위순회 출력 : ");
        tree.PostOrder(tree.root);

    }
}
