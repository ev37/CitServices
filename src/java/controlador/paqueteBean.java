package controlador;

import dao.paqueteDao;
import java.util.ArrayList;
import java.util.List;
import modelo.paquete;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class paqueteBean{
    private paquete paq = new paquete();
    private List<paquete> lisPaq = new ArrayList();

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
}
