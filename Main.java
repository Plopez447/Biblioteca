import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        while (true) {
            String[] options = {"Insertar libro", "Insertar usuario", "Buscar libro", "Buscar usuario", "Eliminar libro", "Eliminar usuario", "Salir"};
            int option = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Biblioteca", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (option) {
                case 0:
                    String title = JOptionPane.showInputDialog("Ingrese el título del libro:");
                    String author = JOptionPane.showInputDialog("Ingrese el autor del libro:");
                    
                    // Verificar si se ingresaron datos válidos
                    if (title != null && !title.isEmpty() && author != null && !author.isEmpty()) {
                        arbol.insertBook(new Book(title, author));
                        JOptionPane.showMessageDialog(null, "Libro insertado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese un título y un autor válidos.");
                    }
                    break;
                case 1:
                    String username = JOptionPane.showInputDialog("Ingrese el nombre de usuario:");
                    String ageString = JOptionPane.showInputDialog("Ingrese la edad del usuario:");
                    
                    // Verificar si se ingresaron datos válidos
                    if (username != null && !username.isEmpty() && ageString != null && !ageString.isEmpty()) {
                        int age = Integer.parseInt(ageString);
                        arbol.insertUser(new User(username, age));
                        JOptionPane.showMessageDialog(null, "Usuario insertado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese un nombre de usuario y una edad válidos.");
                    }
                    break;
                case 2:
                    String searchTitle = JOptionPane.showInputDialog("Ingrese el título del libro a buscar:");
                    Book foundBook = arbol.searchBookInOrder(searchTitle);
                    if (foundBook != null) {
                        JOptionPane.showMessageDialog(null, "El libro está en la biblioteca: " + foundBook);
                    } else {
                        JOptionPane.showMessageDialog(null, "El libro no está en la biblioteca.");
                    }
                    break;
                case 3:
                    String searchUsername = JOptionPane.showInputDialog("Ingrese el nombre de usuario a buscar:");
                    if (searchUsername != null) {
                        User foundUser = arbol.searchUserPostOrder(searchUsername);
                        if (foundUser != null) {
                            JOptionPane.showMessageDialog(null, "El usuario está registrado en la biblioteca: " + foundUser);
                        } else {
                            JOptionPane.showMessageDialog(null, "El usuario no está registrado en la biblioteca.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El nombre de usuario ingresado es nulo.");
                    }
                    break;
                case 4:
                    String deleteTitle = JOptionPane.showInputDialog("Ingrese el título del libro a eliminar:");
                    arbol.deleteBook(deleteTitle);
                    JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.");
                    break;
                case 5:
                    String deleteUsername = JOptionPane.showInputDialog("Ingrese el nombre de usuario a eliminar:");
                    arbol.deleteUser(deleteUsername);
                    JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
