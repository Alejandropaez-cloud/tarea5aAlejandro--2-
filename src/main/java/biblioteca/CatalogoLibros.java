package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLibros {
    
    // El unico atributo encapsulado de esta clase va a ser "listadeobjetos"
    private ArrayList<Libro> libros;

    // Constructor predeterminado.
    public CatalogoLibros(){
        // (creará e inicializará la lista con una capacidad inicial de 
        // 100 elementos, por eficiencia).
        libros = new ArrayList<>(100);
        //initialCapacity = Capacidad inicial.
    }

    // Método cantidad().
    // Devuelve el número de libros.
    public int cantidad(){
        return libros.size();
    }

    // Método estaVacia().
    // Devuelve si la lista está vacía.
    public boolean estaVacia(){
        return libros.isEmpty();
        // libros.isEmpty() --> Returns true if this list contains no elements.
    }

    // Método obtener(int pos).
    // Devuelve el libro de la posición indicada.
    public Libro obtener(int pos){
        if (pos < 0 || pos >= libros.size()) {
            return null;
        }
        return libros.get(pos);
    }

    // Método cambiar(int pos)
    // Cambia el libro de la posicion indicada.
    public void cambiar (int pos, Libro nuevo){
        if (pos >= 0 && pos < libros.size() && nuevo != null) {
            libros.set(pos, nuevo);
        }
    }

    // Método guardar(Libro libro)
    // Agrega un libro al final de la lista.
    public void guardar (Libro libro){
        if (libro != null) {
            libros.add(libro);
        }
    }

    // Método eliminar(int pos)
    // Elimina el libro que se encuentra en la posición indicada.
    public void eliminar(int pos) {
        if (pos >= 0 && pos < libros.size()) {
            libros.remove(pos);
        }
    }

    // Método eliminar(String isbn)
    // Elimina el objeto libro que tiene ese isbn si se encuentra en la lista.
    public void eliminar(String isbn) {
        if (isbn != null) {
            libros.removeIf(libro -> String.valueOf(libro.getIsbn()).equals(isbn));
        }
    }

    // Método imprimir()
    // Imprime los datos de los libros de la lista.
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("El catálogo está vacío.");
            return;
        }
        System.out.println("\n=== CATÁLOGO DE LIBROS ===");
        for (int i = 0; i < libros.size(); i++) {
            System.out.println("Posición " + i + ": " + libros.get(i));
        }
        System.out.println("Total de libros: " + cantidad() + "\n");
    }

    // Método buscar(Libro libro)
    // Busca el libro en la lista y devuelve la posición en la que se encuentra.
    public int buscar(Libro libro) {
        return libros.indexOf(libro);
    }

    // Método buscar(String autor)
    // Busca todos los libros de ese autor y los devuelve en una lista de libros.
    public List<Libro> buscar(String autor) {
        List<Libro> resultado = new ArrayList<>();
        if (autor != null) {
            for (Libro libro : libros) {
                if (libro.getAutor().equalsIgnoreCase(autor)) {
                    resultado.add(libro);
                }
            }
        }
        return resultado;
    }

    // Método buscar(String isbn)
    // Busca el libro que tiene ese isbn y lo devuelve si existe, en caso contrario devuelve null.
    public Libro buscarPorIsbn(String isbn) {
        if (isbn != null) {
            for (Libro libro : libros) {
                if (String.valueOf(libro.getIsbn()).equals(isbn)) {
                    return libro;
                }
            }
        }
        return null;
    }

    // Deberes finde 
    /*
    Método compareto:
    Es un método que sirve para comparar objetos y ordenarlos.
    Pertenece a la interfaz "Comparable"
    El método se firma de la siguiente manera: "public int compareTo (T otro)"
    Ejemplo:
        public class Libro implements Comparable <Libro>
        ...
    Siempre duevuelve un int */
    // Array bidimensionales:
    /*
    Basicamente es un array de arrays.
    Se parece a una tabla, matriz o cuadrícula.
    Declaración: 
        int[][] matriz;
    Inicialización:
        int[][] matriz = new int[3][4];
    ejemplo:
        matriz[1][2] = 10;
        System.out.println(matriz[1][2]);
    Como recorrer un arra bidimensional:
        for (int i = 0; i < matriz.length; i++) {          // filas
        for (int j = 0; j < matriz[i].length; j++) {       // columnas
            System.out.print(matriz[i][j] + " ");
        }
        System.out.println();
    }


  */
}
