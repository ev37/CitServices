package controlador;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;

import modelo.Usuarios;

@ManagedBean(name="plantillaController")
@SessionScoped
public class plantillaController implements Serializable  {
  Usuarios usua=new Usuarios();

  public Usuarios getUsua() {
    return usua;
  }

  public void setUsua(Usuarios usua) {
    this.usua = usua;
  }
  public void verificarSesion() throws Exception{
    System.out.println("holaaa");
    try{
      
      FacesContext context = FacesContext.getCurrentInstance();
      Usuarios us =(Usuarios) context.getExternalContext().getSessionMap().get("sesion");
      if(us ==null){
        context.getExternalContext().redirect("permisos.xhtml");
      }else{
        usua=us;
       
      }
    }catch(Exception e){
      System.out.println("error en plantilla controler"+e);
      throw e;
    }
  }
}
