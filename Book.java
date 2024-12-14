public class Book implements Comparable<Book> {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int compareTo(Book other) {
        if (other == null) {
            // Manejar el caso en que other es null
            return 1; // Por ejemplo, podrías devolver un valor positivo para indicar que este libro es "mayor" que null
        }
        return this.title.compareTo(other.title);
    }
    
    @Override
    public String toString() {
        return "Titulo: " + title + ", Autor: " + author;
    }
}
