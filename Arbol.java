public class Arbol {
    Nodos root;

    public Arbol() {
        root = null;
    }

    public void insertBook(Book book) {
        root = insertBookRecursive(root, book);
    }

    private Nodos insertBookRecursive(Nodos node, Book book) {
        if (node == null) {
            return new Nodos(book);
        }

        if (book.compareTo(node.book) < 0) {
            node.left = insertBookRecursive(node.left, book);
        } else if (book.compareTo(node.book) > 0) {
            node.right = insertBookRecursive(node.right, book);
        }

        return node;
    }

    public void insertUser(User user) {
        root = insertUserRecursive(root, user);
    }

    private Nodos insertUserRecursive(Nodos node, User user) {
        if (node == null) {
            return new Nodos(user);
        }

        if (user.compareTo(node.user) < 0) {
            node.left = insertUserRecursive(node.left, user);
        } else if (user.compareTo(node.user) > 0) {
            node.right = insertUserRecursive(node.right, user);
        }

        return node;
    }

    // Búsqueda en postorden
    public Book searchBookPostOrder(String title) {
        return searchBookPostOrderRecursive(root, title);
    }

    private Book searchBookPostOrderRecursive(Nodos node, String title) {
        if (node == null) {
            return null;
        }
        
        Book foundBookLeft = searchBookPostOrderRecursive(node.left, title);
        if (foundBookLeft != null) {
            return foundBookLeft;
        }

        Book foundBookRight = searchBookPostOrderRecursive(node.right, title);
        if (foundBookRight != null) {
            return foundBookRight;
        }

        if (node.book != null && node.book.getTitle().equals(title)) {
            return node.book;
        }

        return null;
    }

    // Búsqueda en inorden
    public Book searchBookInOrder(String title) {
        return searchBookInOrderRecursive(root, title);
    }

    private Book searchBookInOrderRecursive(Nodos node, String title) {
        if (node == null) {
            return null;
        }

        Book foundBookLeft = searchBookInOrderRecursive(node.left, title);
        if (foundBookLeft != null) {
            return foundBookLeft;
        }

        if (node.book != null && node.book.getTitle().equals(title)) {
            return node.book;
        }

        Book foundBookRight = searchBookInOrderRecursive(node.right, title);
        if (foundBookRight != null) {
            return foundBookRight;
        }

        return null;
    }

    // Búsqueda en postorden para usuarios
    public User searchUserPostOrder(String username) {
        return searchUserPostOrderRecursive(root, username);
    }

    private User searchUserPostOrderRecursive(Nodos node, String username) {
        if (node == null) {
            return null;
        }
        
        User foundUserLeft = searchUserPostOrderRecursive(node.left, username);
        if (foundUserLeft != null) {
            return foundUserLeft;
        }

        User foundUserRight = searchUserPostOrderRecursive(node.right, username);
        if (foundUserRight != null) {
            return foundUserRight;
        }

        if (node.user != null && node.user.getUsername().equals(username)) {
            return node.user;
        }

        return null;
    }

    // Búsqueda en inorden para usuarios
    public User searchUserInOrder(String username) {
        return searchUserInOrderRecursive(root, username);
    }

    private User searchUserInOrderRecursive(Nodos node, String username) {
        if (node == null) {
            return null;
        }

        User foundUserLeft = searchUserInOrderRecursive(node.left, username);
        if (foundUserLeft != null) {
            return foundUserLeft;
        }

        if (node.user != null && node.user.getUsername().equals(username)) {
            return node.user;
        }

        User foundUserRight = searchUserInOrderRecursive(node.right, username);
        if (foundUserRight != null) {
            return foundUserRight;
        }

        return null;
    }

    public void deleteBook(String title) {
        root = deleteBookRecursive(root, title);
    }

    private Nodos deleteBookRecursive(Nodos node, String title) {
        if (node == null || node.book == null) {
            return null; // Agregar una verificación para el nodo o el libro nulo
        }
    
        if (title.compareTo(node.book.getTitle()) < 0) {
            node.left = deleteBookRecursive(node.left, title);
        } else if (title.compareTo(node.book.getTitle()) > 0) {
            node.right = deleteBookRecursive(node.right, title);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
    
            node.book = minValueBook(node.right);
            node.right = deleteBookRecursive(node.right, node.book.getTitle());
        }
        return node;
    }
    
    private Book minValueBook(Nodos node) {
        Book minv = node.book;
        while (node.left != null) {
            minv = node.left.book;
            node = node.left;
        }
        return minv;
    }

    public void deleteUser(String username) {
        root = deleteUserRecursive(root, username);
    }

    private Nodos deleteUserRecursive(Nodos node, String username) {
        if (node == null) {
            return null;
        }

        if (username.compareTo(node.user.getUsername()) < 0) {
            node.left = deleteUserRecursive(node.left, username);
        } else if (username.compareTo(node.user.getUsername()) > 0) {
            node.right = deleteUserRecursive(node.right, username);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.user = minValueUser(node.right);
            node.right = deleteUserRecursive(node.right, node.user.getUsername());
        }
        return node;
    }

    private User minValueUser(Nodos node) {
        User minv = node.user;
        while (node.left != null) {
            minv = node.left.user;
            node = node.left;
        }
        return minv;
    }
}
