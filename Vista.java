// Vista.java
import java.util.Map;
import java.util.Scanner;

public class Vista {
    private Scanner scanner;

    public Vista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        System.out.println("Sistema de Gestión Escolar");
        System.out.println("1. Gestionar Materias");
        System.out.println("2. Gestionar Usuarios");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarMenuMaterias() {
        System.out.println("\nGestión de Materias");
        System.out.println("1. Agregar Materia");
        System.out.println("2. Buscar Materia");
        System.out.println("3. Eliminar Materia");
        System.out.println("4. Actualizar Materia");
        System.out.println("5. Mostrar todas las Materias");
        System.out.println("6. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarMenuUsuarios() {
        System.out.println("\nGestión de Usuarios");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Buscar Usuario");
        System.out.println("3. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }

    public Materia obtenerDatosMateria() {
        System.out.print("Ingrese el código de la materia: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese el nombre de la materia: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la categoría de la materia: ");
        String categoria = scanner.nextLine();
        System.out.print("Ingrese la nota de la materia: ");
        float nota = Float.parseFloat(scanner.nextLine());
        System.out.print("Ingrese el nombre del usuario responsable: ");
        String usuario = scanner.nextLine();
        return new Materia(codigo, nombre, categoria, nota, usuario);
    }

    public String obtenerNombreMateria() {
        System.out.print("Ingrese el nombre de la materia: ");
        return scanner.nextLine();
    }

    public void mostrarMateria(Materia materia) {
        if (materia != null) {
            System.out.println(materia);
        } else {
            System.out.println("Materia no encontrada.");
        }
    }

    public void mostrarMaterias(Map<Integer, Materia> materias) {
        if (materias != null && !materias.isEmpty()) {
            for (Materia materia : materias.values()) {
                System.out.println(materia);
            }
        } else {
            System.out.println("No hay materias registradas.");
        }
    }

    public Usuario obtenerDatosUsuario() {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el tipo de usuario (Docente, Estudiante, Padre): ");
        String tipo = scanner.nextLine();
        switch (tipo.toLowerCase()) {
            case "docente":
                return new Docente(nombre);
            case "estudiante":
                return new Estudiante(nombre);
            case "padre":
                return new Padre(nombre);
            default:
                System.out.println("Tipo de usuario no válido. Registrando como Estudiante.");
                return new Estudiante(nombre);
        }
    }

    public String obtenerNombreUsuario() {
        System.out.print("Ingrese el nombre del usuario: ");
        return scanner.nextLine();
    }

    public void mostrarUsuario(Usuario usuario) {
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario.getNombre() + " (" + usuario.getClass().getSimpleName() + ")");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int obtenerOpcion() {
        return Integer.parseInt(scanner.nextLine());
    }
}
