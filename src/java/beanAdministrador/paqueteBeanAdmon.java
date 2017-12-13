package beanAdministrador;


import ModeloAdministrador.TipoServicio;
import daoAdministrador.paqueteDao;
import java.util.ArrayList;
import java.util.List;
import ModeloAdministrador.paquete;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class paqueteBeanAdmon{
    private paquete paq = new paquete();
    private List<paquete> lisPaq = new ArrayList();
    private List<TipoServicio> lstTipoServicio = new ArrayList();
    private List<paquete>lstPaquete = new ArrayList();

    public List<paquete> getLstPaquete() {
        return lstPaquete;
    }

    public void setLstPaquete(List<paquete> lstPaquete) {
        this.lstPaquete = lstPaquete;
    }
    
    

    public List<TipoServicio> getLstTipoServicio() {
        return lstTipoServicio;
    }

    public void setLstTipoServicio(List<TipoServicio> lstTipoServicio) {
        this.lstTipoServicio = lstTipoServicio;
    }
    
    

    public paquete getPaq() {
        return paq;
    }

    public void setPaq(paquete paq) {
        this.paq = paq;
    }

    public List<paquete> getLisPaq() {
        return lisPaq;
    }

    public void setLisPaq(List<paquete> lisPaq) {
        this.lisPaq = lisPaq;
    }
    
    public void listarPaqueteDuo(){
        paqueteDao paqDao;
        try {
            paqDao = new paqueteDao();
            lisPaq = paqDao.listarPaqueteDuo();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        } 
    }
    public void listarPaqueteInternet(){
        paqueteDao paqDao;
        try {
            paqDao = new paqueteDao();
            lisPaq = paqDao.listarPaqueteInternet();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
    public void listarPaqueteCable(){
        paqueteDao paqDao;
        try {
            paqDao = new paqueteDao();
            lisPaq = paqDao.listarPaqueteCable();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
    
    public void registrarPaquete() throws Exception {
        paqueteDao dao;

        try {
            dao = new paqueteDao();

            dao.registrar(paq);
        } catch (Exception e) {
            System.out.println("Error en el Bean" + e);
        }
    }
    
    public void listarTipoServicio(){
        paqueteDao paqDao;
        try {
            paqDao = new paqueteDao();
            lstTipoServicio = paqDao.listarTipoServicio();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
    
    public void listarPaquete(){
        paqueteDao paqDao;
        try {
            paqDao = new paqueteDao();
            lstPaquete = paqDao.listarPaque();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
}
