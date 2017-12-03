
package beanCliente;



import daoCliente.coberturaDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modeloCliente.tablaCobertura;

@ManagedBean
@ViewScoped
public class coberturaBean {
    private List<tablaCobertura> lisTabCob = new ArrayList();
    private List<tablaCobertura> lisTabCob2 = new ArrayList();
    private tablaCobertura tabCob = new tablaCobertura();
    private tablaCobertura tabCob2 = new tablaCobertura();
    
    

    public List<tablaCobertura> getLisTabCob() {
        return lisTabCob;
    }

    public void setLisTabCob(List<tablaCobertura> lisTabCob) {
        this.lisTabCob = lisTabCob;
    }

    public tablaCobertura getTabCob() {
        return tabCob;
    }

    public void setTabCob(tablaCobertura tabCob) {
        this.tabCob = tabCob;
    }

    public List<tablaCobertura> getLisTabCob2() {
        return lisTabCob2;
    }

    public void setLisTabCob2(List<tablaCobertura> lisTabCob2) {
        this.lisTabCob2 = lisTabCob2;
    }

    public tablaCobertura getTabCob2() {
        return tabCob2;
    }

    public void setTabCob2(tablaCobertura tabCob2) {
        this.tabCob2 = tabCob2;
    }
    
    public void listar(){
        coberturaDao cobDao;
        try {
            System.out.println("valor de: "+tabCob2.getIdDepartamento());
            cobDao = new coberturaDao();
            lisTabCob = cobDao.listar(tabCob2);
        } catch (Exception e) {
            System.out.println("Error en Listar tabla cobertura: "+e);
        }
        
    }
    
    public void listarDepartamento(){
        coberturaDao cobDao;
        try {
            cobDao = new coberturaDao();
            lisTabCob2 = cobDao.listarDepartamento();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        
    }
}
