package controlador;

import dao.*;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import modelo.Clientes;
import modelo.ConsultaClientes;


@ViewScoped
@ManagedBean(name = "consultaClientesBean")
public class consultaClientesBean {

    @ManagedProperty("#{plantillaController}")
    private plantillaController plantBean;
    private int codigo2;
    private int codigo;
    private Clientes client = new Clientes();
    private List<Clientes> lstclient;
    private List<ConsultaClientes> lstclientes;
    private ConsultaClientes Cliente = new ConsultaClientes();
    private List<ConsultaClientes> lstClientes;

    public plantillaController getPlantBean() {
        return plantBean;
    }

    public void setPlantBean(plantillaController plantBean) {
        this.plantBean = plantBean;
    }
    
    

    public int getCodigo2() {
        return codigo2;
    }

    public void setCodigo2(int codigo2) {
        this.codigo2 = codigo2;
    }

    public Clientes getClient() {
        return client;
    }

    public void setClient(Clientes client) {
        this.client = client;
    }

    public List<Clientes> getLstclient() {
        return lstclient;
    }

    public void setLstclient(List<Clientes> lstclient) {
        this.lstclient = lstclient;
    }

    public ConsultaClientes getCliente() {
        return Cliente;
    }

    public void setCliente(ConsultaClientes Cliente) {
        this.Cliente = Cliente;
    }

    public List<ConsultaClientes> getLstClientes() {
        return lstClientes;
    }

    public void setLstClientes(List<ConsultaClientes> lstClientes) {
        this.lstClientes = lstClientes;
    }

    public List<ConsultaClientes> getLstclientes() {
        return lstclientes;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setLstclientes(List<ConsultaClientes> lstclientes) {
        this.lstclientes = lstclientes;
    }

    public void listarCable() throws Exception {
        consultaClientesDao dao = new consultaClientesDao();

        try {
            
            System.out.println("codigo recibido" + codigo);
            lstclientes = dao.listar(codigo);
            lstClientes = dao.listarInternet(codigo);

        } catch (Exception e) {
            System.out.println("Error al listar servicios" + e);
        }
    }

    public void listarDatosPersonales() throws Exception {
        consultaClientesDao dao = new consultaClientesDao();

        try {
            lstclient = dao.listarCliente(plantBean.getUsua().getId_usuario());
        } catch (Exception e) {
            System.out.println("Error al listar los datos personales" + e);
        }
    }

    public void listarPersonas() {
        consultaClientesDao dao = new consultaClientesDao();

        try {
            lstclient = dao.listarCliente(plantBean.getUsua().getId_usuario());
        } catch (Exception e) {
            System.out.println("Error al listar Personas" + e);
        }
    }
}
