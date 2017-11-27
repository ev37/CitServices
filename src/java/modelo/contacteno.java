package modelo;

/**
 *
 * @author Walter
 */
public class contacteno {
    private int id_contacteno;
    private String nombre;
    private String apellido;
    private String cargoDepartamento;
    private int telefono;
    private String email;
    private String comentario;
    private String empresa;

    public contacteno() {
        this.id_contacteno = 0;
        this.nombre = null;
        this.apellido = null;
        this.cargoDepartamento = null;
        this.telefono = 0;
        this.email = null;
        this.comentario = null;
        this.empresa = null;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    public int getId_contacteno() {
        return id_contacteno;
    }

    public void setId_contacteno(int id_contacteno) {
        this.id_contacteno = id_contacteno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargoDepartamento() {
        return cargoDepartamento;
    }

    public void setCargoDepartamento(String cargoDepartamento) {
        this.cargoDepartamento = cargoDepartamento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
}
