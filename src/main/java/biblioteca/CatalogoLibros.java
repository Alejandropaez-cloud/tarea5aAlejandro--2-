package biblioteca;

import java.util.ArrayList;
import java.util.Collections;

public class CatalogoLibros {

    private final ArrayList<Libro> lista;

    public int buscarPorTitulo(String titulo){
        ordenarPorTitulo();
        Libro aux = new Libro();
        aux.setTitulo(titulo);
        return  Collections.binarySearch(lista, aux, (l1,l2)->l1.getTitulo().compareTo(l2.getTitulo()));
    }

    

    public void ordenarPorTitulo(){
        Collections.sort(lista, (l1,l2)->l1.getTitulo().compareTo(l2.getTitulo()));
    }

    public void ordenarPorPublicacion(){
        Collections.sort(lista, (l1,l2)->l2.getAnioPublicacion()-l1.getAnioPublicacion());
        //Collections.sort(lista, (libroa, librob)->Integer.compare(libroa.getAnioPublicacion(), librob.getAnioPublicacion()));
    }

    public CatalogoLibros() {
        lista = new ArrayList<>(100);
    }

    public int cantidad(){
        return lista.size();
    }

    public boolean estaVacia(){
        return lista.isEmpty();
    }

    public void guardar(Libro libro){
        lista.add(libro);
    }

    public void imprimir(){
        lista.forEach(System.out::println);
    }

    public Libro obtener(int posicion){
        if (posicion<0 || posicion>lista.size()-1){
            return null;
        }
        return lista.get(posicion);
    }

    public void cambiar(int pos, Libro nuevo){
        if (pos>=0&&pos<lista.size()){
            lista.set(pos, nuevo);
        }
    }

    public int buscar(Libro libro){
        return lista.indexOf(libro);
    }

    public ArrayList<Libro> buscarAutor(String autor){
        var listaAux = new ArrayList<Libro>();
        for (Libro libro : lista) {
            if (autor.equalsIgnoreCase(libro.getAutor())){
                listaAux.add(libro);
            }
        }
        return listaAux;
    }

    public Libro buscarIsbn(String isbn){
        try {
            long isbnLong = Long.parseLong(isbn);
            for (Libro libro : lista) {
                if (libro.getIsbn() == isbnLong){
                    return libro;
                }
            }
        } catch (NumberFormatException e) {
            // ISBN inválido
        }
        return null;
    }

    public void eliminar(int pos){
        if (pos>=0&&pos<lista.size()){
            lista.remove(pos);
        }
    }

    public void eliminar(String isbn){
        Libro aux = buscarIsbn(isbn);
        if (aux!=null){
            lista.remove(aux);
        }
    }
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

