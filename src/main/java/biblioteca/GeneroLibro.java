package biblioteca;

public enum GeneroLibro {
    NOVELA("Narrativa extensa de ficción"),
    FICCION("Obras literarias de carácter imaginario"),
    POESIA("Composición literaria en verso"),
    RELATO("Narración breve de un acontecimiento");

    private final String descripcion;

    GeneroLibro(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
