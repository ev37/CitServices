package beanCliente;

import controlador.plantillaController;
import daoCliente.modificarClienteDao;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import modeloCliente.cliente;
import modeloCliente.tablaCliente;

@ManagedBean
@ViewScoped
public class modificarClienteBean {

    private List<cliente> listaCliente = new ArrayList();
    private cliente clie = new cliente();
    private List<tablaCliente> listTabCliente = new ArrayList();
    private tablaCliente clie1 = new tablaCliente();
    
    @ManagedProperty("#{plantillaController}")
    private plantillaController plantBean;
    
    public void modificar() {
       
        try {
            clie.setIdCliente(plantBean.getUsua().getId_usuario());
            modificarClienteDao clienBean = new modificarClienteDao();
            clienBean.modficar(clie);

        } catch (Exception e) {
            System.out.println("Error en modificar en el bean: " + e);
        }
    }

    public plantillaController getPlantBean() {
        return plantBean;
    }

    public void setPlantBean(plantillaController plantBean) {
        this.plantBean = plantBean;
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

    public List<tablaCliente> getListTabCliente() {
        return listTabCliente;
    }

    public void setListTabCliente(List<tablaCliente> listTabCliente) {
        this.listTabCliente = listTabCliente;
    }

    public tablaCliente getClie1() {
        return clie1;
    }

    public void setClie1(tablaCliente clie1) {
        this.clie1 = clie1;
    }

    public void listarCliente() {

        try {
            
            modificarClienteDao ClieDao = new modificarClienteDao();
            listTabCliente = ClieDao.listarCliente(plantBean.getUsua().getId_usuario());
        } catch (Exception e) {
            System.out.println("Error en Listar tabla Clientes bean: " + e);
        }

    }

}
