public class Usuario {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

class Docente extends Usuario {
    public Docente(String nombre) {
        super(nombre);
    }
}

class Estudiante extends Usuario {
    public Estudiante(String nombre) {
        super(nombre);
    }
}

class Padre extends Usuario {
    public Padre(String nombre) {
        super(nombre);
    }
}
