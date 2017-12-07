package controlador;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.Serializable;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

import modelo.Usuarios;

@ManagedBean
@ViewScoped
public class UsuariosBean implements Serializable {

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

    public void cerrarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            
            ExternalContext externalContext = context.getExternalContext();
            
            Object session = externalContext.getSession(false);
            
            HttpSession httpSession = (HttpSession) session;
            
            httpSession.invalidate();
            context.getExternalContext().redirect("../index.xhtml");
        } catch (IOException ex) {
            System.out.println("Error al eliminar la Sesion");
        }
    }

    public void listar() throws Exception {

        UsuarioDAO dao = new UsuarioDAO();

        try {
            usuarioSesion = dao.usuariolistar(usuario);

            //if (usuario.getContraseña().equals(usuarioSesion.getContraseña())) {
            if (usuarioSesion != null) {

                FacesContext context = FacesContext.getCurrentInstance();

                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sesion", usuarioSesion);

                if (usuarioSesion.getTipo_usuario() == 1) {
                    System.out.println(usuarioSesion.getNombre());
                    context.getExternalContext().redirect("../Business/formRenovacionContratos.xhtml");
                } else if (usuarioSesion.getTipo_usuario() == 4) {
                    System.out.println(usuarioSesion.getNombre());
                    context.getExternalContext().redirect("../Business/formConsultaClientes.xhtml");
                } else if (usuarioSesion.getTipo_usuario() == 5) {
                    System.out.println(usuarioSesion.getNombre());
                    context.getExternalContext().redirect("../Cliente/formConsultaClientes.xhtml");
                }

            }
        } catch (Exception e) {
            System.out.println("se encontro un error en el Usuario BEAN");
            System.out.println("Error en crear sesion UsuarioBean : " + e);
        }

    }

}
