
package modeloCliente;

public class Reclamo {
    private int idReclamo;
    private int numeroReclamo;
    private int idEstado;
    private int idCliente;
    private int idTipoReclamo;
    private String descripcion;
    private String tipoReclamo;

    public Reclamo() {
        this.idReclamo = 0;
        this.numeroReclamo = 0;
        this.idEstado = 0;
        this.idCliente = 0;
        this.idTipoReclamo = 0;
        this.tipoReclamo = null;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(int idReclamo) {
        this.idReclamo = idReclamo;
    }

    public int getNumeroReclamo() {
        return numeroReclamo;
    }

    public void setNumeroReclamo(int numeroReclamo) {
        this.numeroReclamo = numeroReclamo;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTipoReclamo() {
        return idTipoReclamo;
    }

    public void setIdTipoReclamo(int idTipoReclamo) {
        this.idTipoReclamo = idTipoReclamo;
    }

    public String getTipoReclamo() {
        return tipoReclamo;
    }

    public void setTipoReclamo(String tipoReclamo) {
        this.tipoReclamo = tipoReclamo;
    }
    
}
