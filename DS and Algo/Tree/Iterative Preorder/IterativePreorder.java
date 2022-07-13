import java.util.Stack;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
    }
}
public class IterativePreorder{

    public static void preorder(Node root){
        if(root==null) return;
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(curr!=null || st.isEmpty()==false){
            while(curr!=null){
                System.out.print(curr.data+" ");
                if(curr.right!=null)
                    st.push(curr.right);
                curr = curr.left;
            }
            if(st.isEmpty()==false)
                curr = st.pop();
        }
    }

    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.right = new Node(30);
        tree.left.left = new Node(40);
        tree.left.right = new Node(50);
        preorder(tree);
    }
}