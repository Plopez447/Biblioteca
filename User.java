public class User implements Comparable<User> {
    String username;
    int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User other) {
        if (other == null) {
            // Manejar el caso en que other es null
            return 1; // Por ejemplo, podrías devolver un valor positivo para indicar que este usuario es "mayor" que null
        }
        return this.username.compareTo(other.username);
    }
    
    @Override
    public String toString() {
        return "Nombre: " + username + ", Edad: " + age;
    }
}
