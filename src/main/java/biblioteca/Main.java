package biblioteca;

import javax.swing.JOptionPane;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== CREACIÓN DE LIBROS ===\n");
        
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", 1605, 9788408024652L, GeneroLibro.NOVELA);
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, 9788437604948L, GeneroLibro.NOVELA);
        Libro libro3 = new Libro("La casa de los espíritus", "Isabel Allende", 1982, 9788401493529L, GeneroLibro.NOVELA);
        Libro libro4 = new Libro("Cien años de soledad - Copia", "Gabriel García Márquez", 1967, 9788437604948L, GeneroLibro.NOVELA);
        
        System.out.println("Libro 1: " + libro1);
        System.out.println("Libro 2: " + libro2);
        System.out.println("Libro 3: " + libro3);
        System.out.println("Libro 4: " + libro4);
        
        System.out.println("\n=== PRUEBA DE MÉTODOS PRESTAR Y DEVOLVER ===");
        System.out.println("Disponible libro1: " + libro1.isDisponible());
        libro1.prestar();
        System.out.println("Después de prestar: " + libro1.isDisponible());
        libro1.devolver();
        System.out.println("Después de devolver: " + libro1.isDisponible());
        
        System.out.println("\n=== PRUEBA DE HASHCODE Y EQUALS ===");
        System.out.println("HashCode libro1: " + libro1.hashCode());
        System.out.println("HashCode libro2: " + libro2.hashCode());
        System.out.println("HashCode libro4: " + libro4.hashCode());
        System.out.println("libro2.equals(libro4): " + libro2.equals(libro4) + " (mismo ISBN)");
        System.out.println("libro1.equals(libro2): " + libro1.equals(libro2) + " (ISBN diferente)");
        
        System.out.println("\n=== PRUEBA DE CATÁLOGO DE LIBROS ===\n");
        
        CatalogoLibros catalogo = new CatalogoLibros();
        catalogo.guardar(libro1);
        catalogo.guardar(libro2);
        catalogo.guardar(libro3);
        
        System.out.println("Cantidad de libros: " + catalogo.cantidad());
        catalogo.imprimir();
        
        System.out.println("Búsqueda de 'Gabriel García Márquez':");
        List<Libro> librosAutor = catalogo.buscar("Gabriel García Márquez");
        for (Libro libro : librosAutor) {
            System.out.println("  - " + libro.getTitulo());
        }
        
        System.out.println("\nLibro en posición 1: " + catalogo.obtener(1).getTitulo());
        
        System.out.println("\n=== INICIANDO MENÚ INTERACTIVO ===");
        mostrarMenu(catalogo);
    }
    
    static void mostrarMenu(CatalogoLibros catalogo) {
        int opcion = -1;
        
        while (opcion != 0) {
            String menu = "--- GESTOR DE CATÁLOGO ---\n\n" +
                    "1. Agregar libro\n" +
                    "2. Ver todos los libros\n" +
                    "3. Buscar libro por ISBN\n" +
                    "4. Buscar libros por autor\n" +
                    "5. Obtener libro en posición\n" +
                    "6. Prestar libro\n" +
                    "7. Devolver libro\n" +
                    "8. Eliminar libro por posición\n" +
                    "0. Salir\n\n" +
                    "Seleccione una opción:";
            
            String input = JOptionPane.showInputDialog(null, menu);
            
            if (input == null) {
                opcion = 0;
            } else {
                try {
                    opcion = Integer.parseInt(input);
                    
                    switch (opcion) {
                        case 1:
                            agregarLibro(catalogo);
                            break;
                        case 2:
                            verTodosLibros(catalogo);
                            break;
                        case 3:
                            buscarPorIsbn(catalogo);
                            break;
                        case 4:
                            buscarPorAutor(catalogo);
                            break;
                        case 5:
                            obtenerLibroPosicion(catalogo);
                            break;
                        case 6:
                            prestarLibro(catalogo);
                            break;
                        case 7:
                            devolverLibro(catalogo);
                            break;
                        case 8:
                            eliminarPorPosicion(catalogo);
                            break;
                        case 0:
                            JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido");
                }
            }
        }
    }
    
    static void agregarLibro(CatalogoLibros catalogo) {
        String titulo = JOptionPane.showInputDialog(null, "Título del libro:");
        if (titulo == null || titulo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
        } else {
            String autor = JOptionPane.showInputDialog(null, "Autor:");
            if (autor == null || autor.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
            } else {
                String anioStr = JOptionPane.showInputDialog(null, "Año de publicación:");
                if (anioStr == null) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada");
                } else {
                    String isbnStr = JOptionPane.showInputDialog(null, "ISBN (13 dígitos):");
                    if (isbnStr == null) {
                        JOptionPane.showMessageDialog(null, "Operación cancelada");
                    } else {
                        String generoStr = JOptionPane.showInputDialog(null, "Género (NOVELA, FICCION, POESIA, RELATO):");
                        if (generoStr == null) {
                            JOptionPane.showMessageDialog(null, "Operación cancelada");
                        } else {
                            try {
                                int anio = Integer.parseInt(anioStr);
                                long isbn = Long.parseLong(isbnStr);
                                GeneroLibro genero = GeneroLibro.valueOf(generoStr.toUpperCase());
                                Libro nuevoLibro = new Libro(titulo, autor, anio, isbn, genero);
                                catalogo.guardar(nuevoLibro);
                                JOptionPane.showMessageDialog(null, "Libro agregado exitosamente");
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error: Datos no válidos");
                            } catch (IllegalArgumentException e) {
                                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                            }
                        }
                    }
                }
            }
        }
    }
    
    static void verTodosLibros(CatalogoLibros catalogo) {
        if (catalogo.estaVacia()) {
            JOptionPane.showMessageDialog(null, "El catálogo está vacío");
        } else {
            StringBuilder sb = new StringBuilder("LIBROS EN EL CATÁLOGO:\n\n");
            for (int i = 0; i < catalogo.cantidad(); i++) {
                Libro libro = catalogo.obtener(i);
                sb.append("Pos ").append(i).append(": ").append(libro.getTitulo());
                sb.append(" - ").append(libro.getAutor()).append(" (").append(libro.getAnioPublicacion()).append(")\n");
            }
            sb.append("\nTotal: ").append(catalogo.cantidad()).append(" libro(s)");
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
    
    static void buscarPorIsbn(CatalogoLibros catalogo) {
        String isbn = JOptionPane.showInputDialog(null, "Ingrese el ISBN a buscar:");
        if (isbn == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
        } else {
            Libro libro = catalogo.buscarPorIsbn(isbn);
            if (libro != null) {
                JOptionPane.showMessageDialog(null, "Libro encontrado:\n" + libro);
            } else {
                JOptionPane.showMessageDialog(null, "Libro no encontrado con ISBN: " + isbn);
            }
        }
    }
    
    static void buscarPorAutor(CatalogoLibros catalogo) {
        String autor = JOptionPane.showInputDialog(null, "Ingrese el autor a buscar:");
        if (autor == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
        } else {
            List<Libro> libros = catalogo.buscar(autor);
            if (libros.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron libros del autor: " + autor);
            } else {
                StringBuilder sb = new StringBuilder("Libros de " + autor + ":\n\n");
                for (Libro libro : libros) {
                    sb.append("- ").append(libro.getTitulo()).append(" (").append(libro.getAnioPublicacion()).append(")\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        }
    }
    
    static void obtenerLibroPosicion(CatalogoLibros catalogo) {
        String posStr = JOptionPane.showInputDialog(null, "Ingrese la posición:");
        if (posStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
        } else {
            try {
                int pos = Integer.parseInt(posStr);
                Libro libro = catalogo.obtener(pos);
                if (libro != null) {
                    JOptionPane.showMessageDialog(null, "Libro en posición " + pos + ":\n" + libro);
                } else {
                    JOptionPane.showMessageDialog(null, "Posición fuera de rango");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido");
            }
        }
    }
    
    static void prestarLibro(CatalogoLibros catalogo) {
        String posStr = JOptionPane.showInputDialog(null, "Ingrese la posición del libro a prestar:");
        if (posStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
        } else {
            try {
                int pos = Integer.parseInt(posStr);
                Libro libro = catalogo.obtener(pos);
                if (libro != null) {
                    if (libro.isDisponible()) {
                        libro.prestar();
                        JOptionPane.showMessageDialog(null, "Libro prestado exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "El libro no está disponible");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Posición fuera de rango");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido");
            }
        }
    }
    
    static void devolverLibro(CatalogoLibros catalogo) {
        String posStr = JOptionPane.showInputDialog(null, "Ingrese la posición del libro a devolver:");
        if (posStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
        } else {
            try {
                int pos = Integer.parseInt(posStr);
                Libro libro = catalogo.obtener(pos);
                if (libro != null) {
                    libro.devolver();
                    JOptionPane.showMessageDialog(null, "Libro devuelto exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Posición fuera de rango");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido");
            }
        }
    }
    
    static void eliminarPorPosicion(CatalogoLibros catalogo) {
        String posStr = JOptionPane.showInputDialog(null, "Ingrese la posición a eliminar:");
        if (posStr == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
        } else {
            try {
                int pos = Integer.parseInt(posStr);
                if (catalogo.obtener(pos) != null) {
                    catalogo.eliminar(pos);
                    JOptionPane.showMessageDialog(null, "Libro eliminado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Posición fuera de rango");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido");
            }
        }
    }
}
