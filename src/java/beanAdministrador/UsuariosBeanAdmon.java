package beanAdministrador;

import ModeloAdministrador.Personas;
import ModeloAdministrador.TipoUsuario;

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
    private TipoUsuario tipo = new TipoUsuario();
    private List<TipoUsuario> lstTipoUsuario;
    

   

    public UsuariosBeanAdmon() {

    }
     public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }
    
    
    public List<TipoUsuario> getLstTipoUsuario() {
        return lstTipoUsuario;
    }

    public void setLstTipoUsuario(List<TipoUsuario> lstTipoUsuario) {
        this.lstTipoUsuario = lstTipoUsuario;
    }
    
    

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
    
    public void listarTipoUsuario() throws Exception {

        UsuarioDAOAdmon dao = new UsuarioDAOAdmon();

        try {
            lstTipoUsuario = dao.listarTipoUsuario();
            
        } catch (Exception e) {
            System.out.println("Error en el BEAN");
            throw e;
        }
    }

}
