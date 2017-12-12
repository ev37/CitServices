/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloCliente;

/**
 *
 * @author javam
 */
public class tablaCliente {
    private int id_cliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private long dpi;
    private int tel_movil;
    private long nit;
    private String fecha_nac;
    private int tel_casa;

    public tablaCliente() {
        this.id_cliente = 0;
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
        this.dpi = 0;
        this.tel_movil = 0;
        this.nit = 0;
        this.fecha_nac = "";
        this.tel_casa = 0;
    }
    
    
    

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    public int getTel_movil() {
        return tel_movil;
    }

    public void setTel_movil(int tel_movil) {
        this.tel_movil = tel_movil;
    }

    public long getDpi() {
        return dpi;
    }

    public void setDpi(long dpi) {
        this.dpi = dpi;
    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    
    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int getTel_casa() {
        return tel_casa;
    }

    public void setTel_casa(int tel_casa) {
        this.tel_casa = tel_casa;
    }
    
    
    
}
