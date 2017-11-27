package modelo;

public class RenovacionContratos {
    private int id_contracion;   
    private String fecha_contratacion;
    private String fecha_renovacion;
    private String fecha_culminacion;
    private int id_cliente;
    private int id_paquete;
    private String direccion;
    private String zona;
    private int id_municipio;
    private int id_empleado;

    public int getId_contracion() {
        return id_contracion;
    }

    public void setId_contracion(int id_contracion) {
        this.id_contracion = id_contracion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(String fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public String getFecha_renovacion() {
        return fecha_renovacion;
    }

    public void setFecha_renovacion(String fecha_renovacion) {
        this.fecha_renovacion = fecha_renovacion;
    }

    public String getFecha_culminacion() {
        return fecha_culminacion;
    }

    public void setFecha_culminacion(String fecha_culminacion) {
        this.fecha_culminacion = fecha_culminacion;
    }

    public int getId_paquete() {
        return id_paquete;
    }

    public void setId_paquete(int id_paquete) {
        this.id_paquete = id_paquete;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
    
}
