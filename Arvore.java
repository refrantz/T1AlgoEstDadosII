import java.util.ArrayList;

public class Arvore {
    private static final class Node {

        public String content;
        public Node left;
        public Node right;

        public Node(String content){
            this.left = null;
            this.right = null;
            this.content = content;
        }

    }

    private int index = 1;
    private Node root;
    private int count;
    private ArrayList<Node> nodos = new ArrayList<Node>();

    public Arvore(){
        root = null;
        this.count = 0;
    }

    public void setRoot(Node root){
        this.root = root;
    }

    public void add(String s, String s2, String s3){
        Node n;
        Node n2 = new Node(s2);
        Node n3 = new Node(s3);
        if(size() == 0){
            n = new Node(s);
            nodos.add(n);
            setRoot(n);
            count++;
        }else{
            n = nodos.get(index);
            index++;
        }
        n.left = n2;
        n.right = n3;
        nodos.add(n2);
        nodos.add(n3);
        count += 2;
    }

    /*
    public Node getNode(String content) {
        return getNode(root, content);
    }

    public Node getNode(Node node, String content) {
      
        if (node == null || node.content.equals(content)) {
            return node;
        }
      
        Node n = getNode(node.left ,content);
        if(n != null){
            return n;
        }else{
            return getNode(node.right, content);
        }
 
      }
    */

    public int size(){
        return this.count;
    }

    @Override
    public String toString(){
        StringBuilder nodosString = new StringBuilder();
        nodosString.append("Numero de computadores: " + size() + " | numero de computadores em equilibrio: " + totalBalanced() + "\n");
        /*
        for(Node n : nodos){
            if(n.left != null){
                nodosString.append("Computador: " + n.content + " | filho esquerda: " + n.left.content + " | esforco filho esquerda: " + getSum(n.left) + " | filho direita: " + n.right.content + " | esforco filho direita: " + getSum(n.right) + " | está balanceado? " + isBalanced(n) + "\n");
            }else{
                nodosString.append("Computador: " + n.content + " | filho esquerda: " + "vazio" + " | esforco filho esquerda: " + "0" + " | filho direita: " + "vazio" + " | esforco filho direita: " + "0" + "\n");
            }
        }
        */
        return nodosString.toString();
    }

    public int getSum(Node n){
        if(n.left == null || n.right == null){
            return Integer.parseInt(n.content);
        }
        int soma = getSum(n.left) + getSum(n.right);
        return soma;
    }

    public boolean isBalanced(Node n){
        if(n.left != null){
            return getSum(n.left) == getSum(n.right);
        }else{
            return false;
        }

    }

    public int totalBalanced(){
        int total = 0;
        for(Node n : nodos){
            if(isBalanced(n)){
                total++;
            }
        }
        return total;
    }

    public int rootSum(){
        return getSum(root);
    }
}
