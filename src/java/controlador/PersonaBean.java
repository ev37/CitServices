package controlador;

import dao.PersonaDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Personas;

@ManagedBean
@ViewScoped

public class PersonaBean {
    private Personas per= new Personas();

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
}
