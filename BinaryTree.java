// Clase para representar un nodo en un árbol binario
class TreeNode<T extends Comparable<T>> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    // Constructor
    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// Clase para representar un árbol binario
public class BinaryTree<T extends Comparable<T>> {
    TreeNode<T> root;

    // Constructor
    public BinaryTree() {
        this.root = null;
    }

    // Método para insertar un elemento en el árbol
    public void insert(T data) {
        this.root = insertRecursive(this.root, data);
    }

    // Método recursivo para insertar un elemento en el árbol
    private TreeNode<T> insertRecursive(TreeNode<T> node, T data) {
        if (node == null) {
            return new TreeNode<>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insertRecursive(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertRecursive(node.right, data);
        }

        return node;
    }

    // Método para buscar un elemento en el árbol
    public T search(T data) {
        return searchRecursive(this.root, data);
    }

    // Método recursivo para buscar un elemento en el árbol
    private T searchRecursive(TreeNode<T> node, T data) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.data) == 0) {
            return node.data;
        } else if (data.compareTo(node.data) < 0) {
            return searchRecursive(node.left, data);
        } else {
            return searchRecursive(node.right, data);
        }
    }
}
