package biblioteca;

import java.time.LocalDate;

public class Préstamo {
    
    // Creacion de los atributos.
    private Prestamo(Estudiante estudiante, Libro libro){
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = fechaPrestamo.plusDays(15);
    }
    
