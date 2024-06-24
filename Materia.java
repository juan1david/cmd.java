public class Materia {
    private int codigo;
    private String nombre;
    private String categoria;
    private float nota;
    private String usuario;

    public Materia(int codigo, String nombre, String categoria, float nota, String usuario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.nota = nota;
        this.usuario = usuario;
    }

    public Materia() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", nota=" + nota +
                ", usuario='" + usuario + '\'' +
                '}';
    }
}
