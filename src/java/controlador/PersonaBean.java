package controlador;

import dao.PersonaDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Personas;

@ManagedBean
@ViewScoped

public class PersonaBean {
    private Personas per= new Personas();
    private List<ModeloAdministrador.Personas> lstPersonas;

    public List<ModeloAdministrador.Personas> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<ModeloAdministrador.Personas> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }
    

    public Personas getPer() {
        return per;
    }

    public void setPer(Personas per) {
        this.per = per;
    }
    
     public void registrarEmpleados() throws Exception {
        PersonaDAO dao;

        try {
            dao = new PersonaDAO();
            System.out.println(per.getNombre());
            System.out.println(per.getApellido());
            dao.registrar(per);
        } catch (Exception e) {
            System.out.println("Error en el Bean"+e);
        }
    }
     
      public void listarPersonas() throws Exception {
        PersonaDAO dao = new PersonaDAO();
        try {
            lstPersonas = dao.tablaPersona();
        } catch (Exception e) {
            System.out.println("Error en el BEAN listar Personas");
        }
    }
}
