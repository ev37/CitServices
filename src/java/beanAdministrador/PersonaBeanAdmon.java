package beanAdministrador;


import daoAdministrador.PersonaDAOAdmon;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import ModeloAdministrador.Personas;

@ManagedBean
@ViewScoped

public class PersonaBeanAdmon {
    private Personas per= new Personas();
     
     private List<Personas> lstPersonas;


    public List<Personas> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Personas> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }

     
    public Personas getPer() {
        return per;
    }

    public void setPer(Personas per) {
        this.per = per;
    }
    
     public void registrarEmpleados() throws Exception {
        PersonaDAOAdmon dao;

        try {
            dao = new PersonaDAOAdmon();
            System.out.println(per.getNombre());
            System.out.println(per.getApellido());
            dao.registrar(per);
        } catch (Exception e) {
            System.out.println("Error en el Bean"+e);
        }
    }
     
     public void listarPersonas() throws Exception {
        PersonaDAOAdmon dao = new PersonaDAOAdmon();
        try {
            lstPersonas = dao.tablaPersona();
        } catch (Exception e) {
            System.out.println("Error en el BEAN listar Personas");
        }
    }
}
