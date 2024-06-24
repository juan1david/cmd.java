// Modelo.java
import java.util.Map;
import java.util.HashMap;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Modelo {
    private Map<Integer, Materia> listaMaterias;
    private Map<String, Usuario> listaUsuarios;
    private final String archivoMaterias = "materias.json";
    private final String archivoUsuarios = "usuarios.json";
    private Gson gson;
    private Vista vista;

    public Modelo(Vista vista) {
        this.listaMaterias = new HashMap<>();
        this.listaUsuarios = new HashMap<>();
        this.gson = new Gson();
        this.vista = vista;
        cargarMateriasDesdeArchivo();
        cargarUsuariosDesdeArchivo();
    }

    // Métodos para manejar materias
    public void agregarMateria(Materia materia) {
        listaMaterias.put(materia.getCodigo(), materia);
        guardarMateriasEnArchivo();
        vista.mostrarMensaje("Materia agregada exitosamente.");
    }

    public void buscarMateria(String nombre) {
        Materia materia = listaMaterias.get(nombre);
        vista.mostrarMateria(materia);
    }

    public void eliminarMateria(String nombre) {
        boolean eliminada = listaMaterias.remove(nombre) != null;
        if (eliminada) {
            guardarMateriasEnArchivo();
            vista.mostrarMensaje("Materia eliminada exitosamente.");
        } else {
            vista.mostrarMensaje("No se encontró la materia para eliminar.");
        }
    }

    public void actualizarMateria(String nombre, Materia materia) {
        if (listaMaterias.containsKey(nombre)) {
            listaMaterias.put(materia.getCodigo(), materia);
            guardarMateriasEnArchivo();
            vista.mostrarMensaje("Materia actualizada exitosamente.");
        } else {
            vista.mostrarMensaje("No se encontró la materia para actualizar.");
        }
    }

    public void mostrarMaterias() {
        if (!listaMaterias.isEmpty()) {
            vista.mostrarMaterias(listaMaterias);
        } else {
            vista.mostrarMensaje("No hay materias registradas.");
        }
    }

    // Métodos para manejar usuarios
    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.put(usuario.getNombre(), usuario);
        guardarUsuariosEnArchivo();
        vista.mostrarMensaje("Usuario registrado exitosamente.");
    }

    public void buscarUsuario(String nombre) {
        Usuario usuario = listaUsuarios.get(nombre);
        vista.mostrarUsuario(usuario);
    }

    private void cargarMateriasDesdeArchivo() {
        try (FileReader reader = new FileReader(archivoMaterias)) {
            Type tipoListaMaterias = new TypeToken<Map<Integer, Materia>>() {}.getType();
            listaMaterias = gson.fromJson(reader, tipoListaMaterias);
            if (listaMaterias == null) {
                listaMaterias = new HashMap<>();
            }
        } catch (IOException e) {
            System.out.println("Error al cargar materias desde el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado al cargar materias desde el archivo: " + e.getMessage());
        }
    }

    private void guardarMateriasEnArchivo() {
        try (FileWriter writer = new FileWriter(archivoMaterias)) {
            gson.toJson(listaMaterias, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar materias en el archivo: " + e.getMessage());
        }
    }

    private void cargarUsuariosDesdeArchivo() {
        try (FileReader reader = new FileReader(archivoUsuarios)) {
            Type tipoListaUsuarios = new TypeToken<Map<String, Usuario>>() {}.getType();
            listaUsuarios = gson.fromJson(reader, tipoListaUsuarios);
            if (listaUsuarios == null) {
                listaUsuarios = new HashMap<>();
            }
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios desde el archivo: " + e.getMessage());
            listaUsuarios = new HashMap<>();
        } catch (Exception e) {
            System.out.println("Error inesperado al cargar usuarios desde el archivo: " + e.getMessage());
        }
    }

    private void guardarUsuariosEnArchivo() {
        try (FileWriter writer = new FileWriter(archivoUsuarios)) {
            gson.toJson(listaUsuarios, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios en el archivo: " + e.getMessage());
        }
    }
}
