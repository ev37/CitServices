package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="prueba")
@ViewScoped
public class prueba {
  
  @ManagedProperty("#{plantillaController}")
  private plantillaController bean1;

  public void prueba(){
    System.out.println("esta es una pŕueba:"+bean1.getUsua().getNombre());
  }
  public plantillaController getBean1() {
    return bean1;
  }

  public void setBean1(plantillaController bean1) {
    this.bean1 = bean1;
  }
  
 
}
