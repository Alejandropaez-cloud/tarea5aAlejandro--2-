package biblioteca;

import java.util.Objects;

public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private final long isbn;
    private GeneroLibro genero;
    private boolean disponible;

    // Constructor parametrizado (validando isbn de 13 dígitos)
    public Libro(String titulo, String autor, int anioPublicacion, long isbn, GeneroLibro genero) {
        if (String.valueOf(isbn).length() != 13) {
            throw new IllegalArgumentException("El ISBN debe tener exactamente 13 dígitos");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.isbn = isbn;
        this.genero = genero;
        this.disponible = true; // Por defecto, los libros están disponibles
    }

    // Constructor por defecto
    public Libro() {
        this("Título desconocido", "Autor desconocido", 2025, 1234567890123L, GeneroLibro.NOVELA);
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public long getIsbn() {
        return isbn;
    }

    public GeneroLibro getGenero() {
        return genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // Setters (excepto isbn y disponible sin setter directo)
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void setGenero(GeneroLibro genero) {
        this.genero = genero;
    }

    // Método prestar
    public void prestar() {
        if (disponible) {
            disponible = false;
        }
    }

    // Método devolver
    public void devolver() {
        disponible = true;
    }

    // toString
    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", isbn=" + isbn +
                ", genero=" + genero +
                ", disponible=" + disponible +
                '}';
    }

    // equals basado en isbn
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return isbn == libro.isbn;
    }

    // hashCode basado en isbn
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
