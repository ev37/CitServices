
package beanCliente;


import Modelo.*;
import daoCliente.reclamoDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modeloCliente.Reclamo;

@ManagedBean
@ViewScoped
public class reclamoBean {
    private List<Reclamo> listReclamo = new ArrayList();
    private Reclamo rec =  new Reclamo();

    public reclamoBean() {
        
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
    
    public void ingresarReclamo(){
        reclamoDao recDao;
        try {
            recDao = new reclamoDao();
           
            recDao.insertar(rec);
        } catch (Exception e) {
            System.out.println("Error al ingresar reclamo: "+e);
        }
    }
    public void listarTipoReclamo(){
        reclamoDao recDao;
        try {
            recDao = new reclamoDao();
            listReclamo=recDao.listarTipoReclamo();
            
        } catch (Exception e) {
            System.out.println("Error al listar tipo reclamo: "+e);
        }
    }
}
