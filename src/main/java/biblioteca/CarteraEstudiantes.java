package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class CarteraEstudiantes {

    // El único atributo encapsulado de esta clase va a ser "lista de estudiantes"
    private ArrayList<Estudiante> estudiantes;

    // Constructor predeterminado.
    public CarteraEstudiantes(){
        // (creará e inicializará la lista con una capacidad inicial de 
        // 100 elementos, por eficiencia).
        estudiantes = new ArrayList<>(100);
    }

    // Método cantidad().
    // Devuelve el número de estudiantes.
    public int cantidad(){
        return estudiantes.size();
    }

    // Método estaVacia().
    // Devuelve si la lista está vacía.
    public boolean estaVacia(){
        return estudiantes.isEmpty();
    }

    // Método obtener(int pos).
    // Devuelve el estudiante de la posición indicada.
    public Estudiante obtener(int pos){
        if (pos < 0 || pos >= estudiantes.size()) {
            return null;
        }
        return estudiantes.get(pos);
    }

    // Método cambiar(int pos)
    // Cambia el estudiante de la posición indicada.
    public void cambiar(int pos, Estudiante nuevo){
        if (pos >= 0 && pos < estudiantes.size() && nuevo != null) {
            estudiantes.set(pos, nuevo);
        }
    }

    // Método guardar(Estudiante estudiante)
    // Agrega un estudiante al final de la lista.
    public void guardar(Estudiante estudiante){
        if (estudiante != null) {
            estudiantes.add(estudiante);
        }
    }

    // Método eliminar(int pos)
    // Elimina el estudiante que se encuentra en la posición indicada.
    public void eliminar(int pos) {
        if (pos >= 0 && pos < estudiantes.size()) {
            estudiantes.remove(pos);
        }
    }

    // Método eliminar(String dni)
    // Elimina el estudiante que tiene ese dni si se encuentra en la lista.
    public void eliminar(String dni) {
        if (dni != null) {
            estudiantes.removeIf(estudiante -> estudiante.getDni().equals(dni));
        }
    }

    // Método imprimir()
    // Imprime los datos de los estudiantes de la lista.
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("La cartera de estudiantes está vacía.");
            
        }
        System.out.println("\n=== CARTERA DE ESTUDIANTES ===");
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println("Posición " + i + ": " + estudiantes.get(i));
        }
        System.out.println("Total de estudiantes: " + cantidad() + "\n");
    }

    // Método buscar(Estudiante estudiante)
    // Busca el estudiante en la lista y devuelve la posición en la que se encuentra.
    public int buscar(Estudiante estudiante) {
        return estudiantes.indexOf(estudiante);
    }

    // Método buscar(String dni)
    // Busca el estudiante con ese dni y lo devuelve.
    public Estudiante buscarPorDni(String dni) {
        if (dni != null) {
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getDni().equals(dni)) {
                    return estudiante;
                }
            }
        }
        return null;
    }

    // Método buscar(String nombre, String apellido1)
    // Busca todos los estudiantes con ese nombre y apellido.
    public List<Estudiante> buscarPorNombre(String nombre) {
        List<Estudiante> resultado = new ArrayList<>();
        if (nombre != null) {
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getNombre().equalsIgnoreCase(nombre)) {
                    resultado.add(estudiante);
                }
            }
        }
        return resultado;
    }

    // comprobar si existe un Estudiante
    public boolean existeEstudiante(String dni){
        return buscarPorDni(dni) != null;
    }
}
