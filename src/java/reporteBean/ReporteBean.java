/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import reporteDao.ReporteDao;

/**
 *
 * @author Admin
 */
@ManagedBean
@RequestScoped
public class ReporteBean {
    
    public void Mostrar(){
       
      
        try {
             System.out.println("datos dao" );
           ReporteDao dao = new ReporteDao();
            dao.generarReporteCliente();
        } catch (Exception e) {
            System.out.println("Error en el dao: "+e);
        }
        
    }
    
}
