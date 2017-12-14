
package ModeloAdministrador;

public class Reclamos {
    private int id_reclamo;
    private String estado;
    private String Solucion;
    private int id_cliente;
    private String cliente;
    private String tiporeclamo;
    private String descripcion;
    
    public Reclamos() {
        this.id_reclamo = 0;
        this.estado = null;
        this.Solucion = null;
        this.id_cliente = 0;
        this.cliente = null;
        this.tiporeclamo = null;
        this.descripcion = null;
    }

    public int getId_reclamo() {
        return id_reclamo;
    }

    public void setId_reclamo(int id_reclamo) {
        this.id_reclamo = id_reclamo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSolucion() {
        return Solucion;
    }

    public void setSolucion(String Solucion) {
        this.Solucion = Solucion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTiporeclamo() {
        return tiporeclamo;
    }

    public void setTiporeclamo(String tiporeclamo) {
        this.tiporeclamo = tiporeclamo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
