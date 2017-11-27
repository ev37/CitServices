
package controlador;

import dao.contactenoDao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.contacteno;

@ManagedBean
@ViewScoped
public class contactenoBean {
    private contacteno con = new contacteno();
    private List<contacteno> ListCon = new ArrayList();
    
    public contactenoBean(){
        
    }

    public contacteno getCon() {
        return con;
    }

    public void setCon(contacteno con) {
        this.con = con;
    }

    public List<contacteno> getListCon() {
        return ListCon;
    }

    public void setListCon(List<contacteno> listCon) {
        this.ListCon = listCon;
    }
    
    public void registrarContacteno(){
        contactenoDao conDao = new contactenoDao();
        try {
            conDao.registrar(con);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        
    }
}
