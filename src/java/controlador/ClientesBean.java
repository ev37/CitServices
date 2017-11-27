package controlador;

import dao.ClientesDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Categoria;
import modelo.Clientes;
import modelo.Estado;
import modelo.Personas;
import modelo.TipoCliente;

@ManagedBean
@ViewScoped
public class ClientesBean {

    private List<Personas> lstPersona;
    private List<Categoria> lstCategoria;
    private List<TipoCliente> lstTipoCliente;
    private List<Estado> lstEstado;
    private Clientes cliente = new Clientes();
    

    public List<Categoria> getLstCategoria() {
        return lstCategoria;
    }

    public void setLstCategoria(List<Categoria> lstCategoria) {
        this.lstCategoria = lstCategoria;
    }

    public List<Estado> getLstEstado() {
        return lstEstado;
    }

    public void setLstEstado(List<Estado> lstEstado) {
        this.lstEstado = lstEstado;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public List<Personas> getLstPersona() {
        return lstPersona;
    }

    public void setLstPersona(List<Personas> lstPersona) {
        this.lstPersona = lstPersona;
    }

    public List<TipoCliente> getLstTipoCliente() {
        return lstTipoCliente;
    }

    public void setLstTipoCliente(List<TipoCliente> lstTipoCliente) {
        this.lstTipoCliente = lstTipoCliente;
    }

    public void registrarClientes() throws Exception {
        ClientesDAO dao;

        try {
            dao = new ClientesDAO();

            dao.registrar(cliente);
        } catch (Exception e) {
            System.out.println("Error en el Bean" + e);
        }
    }

    public void listarPersona() throws Exception {

        ClientesDAO dao = new ClientesDAO();

        try {
            lstPersona = dao.listarPersona();
            
        } catch (Exception e) {
            System.out.println("Error en el BEAN");
            throw e;
        }
    }

    public void listartodosId() throws Exception {
        ClientesDAO dao = new ClientesDAO();
        try {
            lstCategoria = dao.listarCategoria();
            lstEstado = dao.listarEstado();
            lstTipoCliente = dao.listarTipoCliente();
        } catch (Exception e) {
            System.out.println("Error en el BEAN listartodos los id");
        }
    }
}
