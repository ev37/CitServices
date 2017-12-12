
package modeloCliente;


public class cliente {
    
    private int idCliente;
    private String direccion;
    private int telefono_movil;
    private int telefono_casa;

    public cliente() {
        this.idCliente = 0;
        this.telefono_movil = 0;
        this.telefono_casa = 0;
    }
    
    
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getTelefono_movil() {
        return telefono_movil;
    }

    public void setTelefono_movil(int telefono_movil) {
        this.telefono_movil = telefono_movil;
    }

    public int getTelefono_casa() {
        return telefono_casa;
    }

    public void setTelefono_casa(int telefono_casa) {
        this.telefono_casa = telefono_casa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
