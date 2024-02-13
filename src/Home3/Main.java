package Home3;

public class Main {
    public static void main(String[] args) {


    }
}

class MyTree {
    Node root;

    boolean add(int val) {
        if (root != null) {
            boolean result = addNode(root, val);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node(val);
            root.color = Color.BLACK;
            return true;
        }
    }

    boolean addNode(Node node, int val) {
        if (node.val == val) {
            return false;
        } else {
            if (node.val > val) {
                if (node.leftNode != null) {
                    boolean result = addNode(node.leftNode, val);
                    node.leftNode = rebalance(node.leftNode);
                    return result;
                } else {
                    node.leftNode = new Node(val);
                    return true;
                }
            } else {
                if (node.rightNode != null) {
                    boolean result = addNode(node.rightNode, val);
                    node.rightNode = rebalance(node.rightNode);
                    return result;
                } else {
                    node.rightNode = new Node(val);
                    return true;
                }
            }
        }
    }

    Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightNode != null && result.rightNode.color == Color.RED &&
                    (result.leftNode == null || result.leftNode.color == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftNode != null && result.leftNode.color == Color.RED &&
                    result.leftNode.leftNode != null && result.leftNode.leftNode.color == Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftNode != null && result.leftNode.color == Color.RED &&
                    result.rightNode != null && result.rightNode.color == Color.RED) {
                needRebalance = true;
                swapColor(result);
            }
        }
        while (needRebalance);
        return result;
    }

    Node rightSwap(Node node) {
        Node rightChild = node.rightNode;
        Node betweenChild = rightChild.leftNode;
        rightChild.leftNode = node;
        node.rightNode = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    Node leftSwap(Node node) {
        Node leftChild = node.leftNode;
        Node betweenChild = leftChild.rightNode;
        leftChild.rightNode = node;
        node.leftNode = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    void swapColor(Node node) {
        node.rightNode.color = Color.BLACK;
        node.leftNode.color = Color.BLACK;
        node.color = Color.RED;
    }
}

class Node {
    int val;
    Color color;
    Node leftNode, rightNode;

    public Node(int val) {
        this(val, null, null);
    }

    public Node(int val, Node leftNode, Node rightNode) {
        this.val = val;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.color = Color.RED;
    }
}

enum Color {
    RED,   //
    BLACK  //
}