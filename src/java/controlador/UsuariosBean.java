package controlador;

import dao.UsuarioDAO;
import java.io.Serializable;

import java.util.List;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import modelo.Usuarios;

@ManagedBean
@ViewScoped
public class UsuariosBean implements Serializable{

  private Usuarios usuario = new Usuarios();
  private Usuarios usuarioSesion = new Usuarios();
  private List<Usuarios> lstUsuarios;

  public UsuariosBean() {

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

  public void setLstUsuarios(List<Usuarios> lstUsuarios) {
    this.lstUsuarios = lstUsuarios;
  }

  public void listar() throws Exception {

    UsuarioDAO dao = new UsuarioDAO();

    try {
     usuarioSesion = dao.usuariolistar(usuario);

      //if (usuario.getContraseña().equals(usuarioSesion.getContraseña())) {
        if (usuarioSesion!=null){
        
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sesion", usuarioSesion);
        System.out.println(usuarioSesion.getNombre());
        context.getExternalContext().redirect("templates/MenuBusiness.xhtml");
        System.out.println("llega?");
        System.out.println("Se creo todo correctamente");
      }
    } catch (Exception e) {
      System.out.println("se encontro un error en el Usuario BEAN");
      System.out.println("Error en crear sesion UsuarioBean : " + e);
    }

  }

}
