public class Nodos {
    Book book;
    User user;
    Nodos left;
    Nodos right;

    public Nodos(Book book) {
        this.book = book;
        this.user = null;
        this.left = null;
        this.right = null;
    }

    public Nodos(User user) {
        this.book = null;
        this.user = user;
        this.left = null;
        this.right = null;
    }
}
