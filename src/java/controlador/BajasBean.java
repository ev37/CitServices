package controlador;


import dao.BajasDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.ConsultaClientes;
@ManagedBean
@ViewScoped
public class BajasBean {
    int codigo;
    private ConsultaClientes consulta =  new ConsultaClientes();
    private ConsultaClientes consulta2 =  new ConsultaClientes();
    private List<ConsultaClientes> listConsultacable;
    private List<ConsultaClientes> listConsultaint;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    public ConsultaClientes getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaClientes consulta) {
        this.consulta = consulta;
    }

    public List<ConsultaClientes> getListConsultacable() {
        return listConsultacable;
    }

    public void setListConsultacable(List<ConsultaClientes> listConsultacable) {
        this.listConsultacable = listConsultacable;
    }

    public List<ConsultaClientes> getListConsultaint() {
        return listConsultaint;
    }

    public void setListConsultaint(List<ConsultaClientes> listConsultaint) {
        this.listConsultaint = listConsultaint;
    }

    public ConsultaClientes getConsulta2() {
        return consulta2;
    }

    public void setConsulta2(ConsultaClientes consulta2) {
        this.consulta2 = consulta2;
    }
    
    public void listarTodo() throws Exception {
        BajasDAO dao = new BajasDAO();

        try {
            listConsultacable = dao.listarcable(codigo);
            listConsultaint = dao.listarInternet(codigo);
            
            System.out.println(consulta.getId_cliente());
            System.out.println(consulta.getId_contratacion());
            
            
        } catch (Exception e) {
            System.out.println("Error En en Bean Bajas" +e);
            throw e;
        }
    }
    public void leerID(ConsultaClientes pac) throws Exception{
        BajasDAO dao;
        ConsultaClientes temp;
        try{
            
            dao = new BajasDAO();
            temp =dao.leerID(pac);
            
            if(temp != null){
                this.consulta = temp;
            }
            
        }catch(Exception e){
            throw e;
        }
      
    }
   
    public void eliminar(ConsultaClientes pac) throws Exception{
        BajasDAO dao;
        
        try{
            dao = new BajasDAO();
            dao.eliminar(pac);
   
            this.listarTodo();
        }catch(Exception e){
            throw e;
        }
    }
}
