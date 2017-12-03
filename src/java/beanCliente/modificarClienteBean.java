package beanCliente;

import daoCliente.modificarClienteDao;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modeloCliente.cliente;

@ManagedBean
@ViewScoped
public class modificarClienteBean {
    private List<cliente> listaCliente = new ArrayList();
    private cliente clie = new cliente();
    
    public void modificar(){
        modificarClienteDao clienBean;
        try {
            clienBean = new modificarClienteDao();
            clienBean.modficar(clie);
            
        } catch (Exception e) {
            System.out.println("Error en modificar en el bean: "+e);
        }
    }

    public List<cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public cliente getClie() {
        return clie;
    }

    public void setClie(cliente clie) {
        this.clie = clie;
    }  
}
