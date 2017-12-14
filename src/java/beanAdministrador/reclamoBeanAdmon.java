package beanAdministrador;

import ModeloAdministrador.Reclamo2;
import ModeloAdministrador.Reclamos;
import daoAdministrador.reclamoDaoAdmon;
import daoCliente.reclamoDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modeloCliente.Reclamo;

@ManagedBean
@ViewScoped
public class reclamoBeanAdmon {

    private List<Reclamo> listReclamo = new ArrayList();
    private List<Reclamos> listRecla = new ArrayList();
    private Reclamo rec = new Reclamo();
    private Reclamos recla = new Reclamos();
    private Reclamo2 tipo = new Reclamo2();
    private List<Reclamo2> lsttipo = new ArrayList();
    private List<Reclamo2> lstcliente = new ArrayList();
    private List<Reclamo2> lstEstado = new ArrayList();
    private List<Reclamos> lstreclamofinal = new ArrayList();

    public reclamoBeanAdmon() {

    }

    public List<Reclamos> getLstreclamofinal() {
        return lstreclamofinal;
    }

    public void setLstreclamofinal(List<Reclamos> lstreclamofinal) {
        this.lstreclamofinal = lstreclamofinal;
    }

    public List<Reclamo2> getLstEstado() {
        return lstEstado;
    }

    public void setLstEstado(List<Reclamo2> lstEstado) {
        this.lstEstado = lstEstado;
    }

    public List<Reclamo2> getLstcliente() {
        return lstcliente;
    }

    public void setLstcliente(List<Reclamo2> lstcliente) {
        this.lstcliente = lstcliente;
    }

    public Reclamo2 getTipo() {
        return tipo;
    }

    public void setTipo(Reclamo2 tipo) {
        this.tipo = tipo;
    }

    public List<Reclamo2> getLsttipo() {
        return lsttipo;
    }

    public void setLsttipo(List<Reclamo2> lsttipo) {
        this.lsttipo = lsttipo;
    }

    public List<Reclamos> getListRecla() {
        return listRecla;
    }

    public void setListRecla(List<Reclamos> listRecla) {
        this.listRecla = listRecla;
    }

    public Reclamos getRecla() {
        return recla;
    }

    public void setRecla(Reclamos recla) {
        this.recla = recla;
    }

    public List<Reclamo> getListReclamo() {
        return listReclamo;
    }

    public void setListReclamo(List<Reclamo> listReclamo) {
        this.listReclamo = listReclamo;
    }

    public Reclamo getRec() {
        return rec;
    }

    public void setRec(Reclamo rec) {
        this.rec = rec;
    }

    public void ingresarReclamo() {
        reclamoDao recDao;
        try {
            recDao = new reclamoDao();

            recDao.insertar(rec);
        } catch (Exception e) {
            System.out.println("Error al ingresar reclamo: " + e);
        }
    }

    public void listarTipoReclamo() {
        reclamoDao recDao;
        try {
            recDao = new reclamoDao();
            listReclamo = recDao.listarTipoReclamo();

        } catch (Exception e) {
            System.out.println("Error al listar tipo reclamo: " + e);
        }
    }

    public void listarTipoReclamos() {
        reclamoDaoAdmon recDaoAdmon;
        try {
            recDaoAdmon = new reclamoDaoAdmon();
            listRecla = recDaoAdmon.listarRECLAMOS();

        } catch (Exception e) {
            System.out.println("Error al listar tipo reclamo: " + e);
        }
    }

    public void listarTip() {
        reclamoDaoAdmon recDaoAdmo;
        try {
            recDaoAdmo = new reclamoDaoAdmon();
            lsttipo = recDaoAdmo.listarTipoRecl();

        } catch (Exception e) {
            System.out.println("Error al listar tipo Tipo: " + e);
        }
    }

    public void listarCliente() {
        reclamoDaoAdmon recDaoAdmo;
        try {
            recDaoAdmo = new reclamoDaoAdmon();
            lstcliente = recDaoAdmo.listarcliente();

        } catch (Exception e) {
            System.out.println("Error al listar tipo Cliente: " + e);
        }
    }

    public void listarEstado() {
        reclamoDaoAdmon recDaoAdmo;
        try {
            recDaoAdmo = new reclamoDaoAdmon();
            lstEstado = recDaoAdmo.listarEstado();

        } catch (Exception e) {
            System.out.println("Error al listar tipo Cliente: " + e);
        }
    }
    
    public void listarReclamos() {
        reclamoDaoAdmon recDaoAd;
        try {
            recDaoAd = new reclamoDaoAdmon();
            lstreclamofinal = recDaoAd.listarRECLAMOS();

        } catch (Exception e) {
            System.out.println("Error al listar Reclamo: " + e);
        }
    }
}
