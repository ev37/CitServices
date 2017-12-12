package beanAdministrador;

import ModeloAdministrador.Personas;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import ModeloAdministrador.Usuarios;
import daoAdministrador.UsuarioDAOAdmon;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class UsuariosBeanAdmon implements Serializable {

    private Usuarios usuario = new Usuarios();
    private Usuarios usuarioSesion = new Usuarios();
    private List<Usuarios> lstUsuarios;
    private List<Personas> lstPersonas;

    public Usuarios getUsuarioSesion() {
        return usuarioSesion;
    }

    public void setUsuarioSesion(Usuarios usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
    }

    public List<Personas> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Personas> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }
    
    
    

    public UsuariosBeanAdmon() {

    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public List<Usuarios> getLstUsuarios() {
        return lstUsuarios;
    }

    
    public void listarPersona() throws Exception {

        UsuarioDAOAdmon dao = new UsuarioDAOAdmon();

        try {
            lstPersonas = dao.listarPersona();
            
        } catch (Exception e) {
            System.out.println("Error en el BEAN");
            throw e;
        }
    }

}
