package controlador;

import dao.RenovacionDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Municipios;
import modelo.RenovacionContratos;
import modelo.paquete;



@ManagedBean
@ViewScoped
public class RenovacionBean {

    private RenovacionContratos contratos = new RenovacionContratos();
    private RenovacionContratos prueba = new RenovacionContratos();
    private List<RenovacionContratos> lstContratos;
    private List<Municipios> lstMunicipios;
    private List<paquete> lstPaquetes;

    public RenovacionContratos getPrueba() {
        return prueba;
    }

    public void setPrueba(RenovacionContratos prueba) {
        this.prueba = prueba;
    }

    public RenovacionContratos getContratos() {
        return contratos;
    }

    public void setContratos(RenovacionContratos contratos) {
        this.contratos = contratos;
    }

    public List<RenovacionContratos> getLstContratos() {
        return lstContratos;
    }

    public void setLstContratos(List<RenovacionContratos> lstContratos) {
        this.lstContratos = lstContratos;
    }

    public List<Municipios> getLstMunicipios() {
        return lstMunicipios;
    }

    public void setLstMunicipios(List<Municipios> lstMunicipios) {
        this.lstMunicipios = lstMunicipios;
    }

    public List<paquete> getLstPaquetes() {
        return lstPaquetes;
    }

    public void setLstPaquetes(List<paquete> lstPaquetes) {
        this.lstPaquetes = lstPaquetes;
    }

    public void listarMunicipios() throws Exception {

        RenovacionDAO dao = new RenovacionDAO();

        try {
            lstMunicipios = dao.listarMunicipios();
        } catch (Exception e) {
            System.out.println("Error en el BEAN");
            throw e;
        }
    }

    public void listarPaquetes() throws Exception {

        RenovacionDAO dao = new RenovacionDAO();

        try {
            lstPaquetes = dao.listarPaquetes();
        } catch (Exception e) {
            System.out.println("Error en el BEAN");
            throw e;
        }
    }

    public void listar() throws Exception {
        System.out.println("llega aqui");
        RenovacionDAO dao = new RenovacionDAO();

        try {
            lstContratos = dao.listar(contratos);
        } catch (Exception e) {
            System.out.println("Error en el BEAN");
            throw e;
        }
    }

    public void leerID(RenovacionContratos pac) throws Exception {
        RenovacionDAO dao;
        RenovacionContratos temp;

        try {

            dao = new RenovacionDAO();
            temp = dao.leerID(pac);

            if (temp != null) {
                this.contratos = temp;
                System.out.println(contratos.getId_cliente());
                System.out.println(contratos.getId_contracion());
            }

        } catch (Exception e) {
            throw e;
        }

    }

    public void modificar(RenovacionContratos nuevo ) throws Exception {
        RenovacionDAO dao;
        try {
            dao = new RenovacionDAO();
            nuevo.setId_cliente(contratos.getId_cliente());
            System.out.println("Id"+nuevo.getId_cliente());
            System.out.println("Fecha renovacion"+nuevo.getFecha_renovacion());
            System.out.println("Fecha culminacion"+nuevo.getFecha_culminacion());
            System.out.println("Fecha Contratacion "+nuevo.getFecha_contratacion());
            System.out.println("Paquete"+nuevo.getId_paquete());
            System.out.println("Id Municioio "+nuevo.getId_municipio());
            System.out.println("Direccion"+nuevo.getDireccion());
            dao.modificar(nuevo);
            this.listar();
        } catch (Exception e) {
            System.out.println("Error en el bean a modificar");
        }
    }
}
