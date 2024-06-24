// Main.java
public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        Modelo modelo = new Modelo(vista); // Pasar la instancia de Vista al constructor de Modelo
        Controlador controlador = new Controlador(modelo, vista);
        controlador.iniciar();
    }
}
