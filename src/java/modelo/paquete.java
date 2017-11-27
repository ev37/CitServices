
package modelo;
/**
 *
 * @author Walter
 */
public class paquete {
    private int idPaquete;
    private String nombre;
    private String descripcion;
    private int idTipoServicio;
    private double costo;
    private double precioVenta;

    public paquete() {
        this.idPaquete = 0;
        this.nombre = null;
        this.descripcion = null;
        this.idTipoServicio = 0;
        this.costo = 0;
        this.precioVenta = 0;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(int idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
}
