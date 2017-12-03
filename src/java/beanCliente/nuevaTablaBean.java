
package beanCliente;



import controlador.plantillaController;
import daoCliente.nuevaTablaDao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import modeloCliente.nuevaTabla;

/**
 *
 * @author Walter
 */
@ViewScoped
@ManagedBean (name="nuevaTablaBean")
public class nuevaTablaBean {
    private List<nuevaTabla> lisTabla;
    
    @ManagedProperty("#{plantillaController}")
    private plantillaController plantBean;
    
    public void listarTabla(){
        nuevaTablaDao tablaDao = new nuevaTablaDao();
        try {
            lisTabla = tablaDao.lisatarNuevaTabla(plantBean.getUsua().getId_usuario());
            System.out.println("usuario id nueva tabla bean: "+plantBean.getUsua().getId_usuario());
        } catch (Exception ex) {
            Logger.getLogger(nuevaTablaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public plantillaController getPlantBean() {
        return plantBean;
    }

    public void setPlantBean(plantillaController plantBean) {
        this.plantBean = plantBean;
    }

    public List<nuevaTabla> getLisTabla() {
        return lisTabla;
    }

    public void setLisTabla(List<nuevaTabla> lisTabla) {
        this.lisTabla = lisTabla;
    }
    
}
