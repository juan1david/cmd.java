// Controlador.java
public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            vista.mostrarMenuPrincipal();
            int opcion = vista.obtenerOpcion();
            switch (opcion) {
                case 1:
                    gestionarMaterias();
                    break;
                case 2:
                    gestionarUsuarios();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void gestionarMaterias() {
        boolean volver = false;
        while (!volver) {
            vista.mostrarMenuMaterias();
            int opcion = vista.obtenerOpcion();
            switch (opcion) {
                case 1:
                    Materia materia = vista.obtenerDatosMateria();
                    modelo.agregarMateria(materia);
                    break;
                case 2:
                    String nombreMateria = vista.obtenerNombreMateria();
                    modelo.buscarMateria(nombreMateria);
                    break;
                case 3:
                    String nombreEliminar = vista.obtenerNombreMateria();
                    modelo.eliminarMateria(nombreEliminar);
                    break;
                case 4:
                    String nombreActualizar = vista.obtenerNombreMateria();
                    Materia materiaActualizar = vista.obtenerDatosMateria();
                    modelo.actualizarMateria(nombreActualizar, materiaActualizar);
                    break;
                case 5:
                    modelo.mostrarMaterias();
                    break;
                case 6:
                    volver = true;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void gestionarUsuarios() {
        boolean volver = false;
        while (!volver) {
            vista.mostrarMenuUsuarios();
            int opcion = vista.obtenerOpcion();
            switch (opcion) {
                case 1:
                    Usuario usuario = vista.obtenerDatosUsuario();
                    modelo.registrarUsuario(usuario);
                    break;
                case 2:
                    String nombreUsuario = vista.obtenerNombreUsuario();
                    modelo.buscarUsuario(nombreUsuario);
                    break;
                case 3:
                    volver = true;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
