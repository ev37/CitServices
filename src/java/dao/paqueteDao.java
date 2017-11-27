package dao;

import dao.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import modelo.paquete;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class paqueteDao extends DAO{    
    //variables
    private String query;
    private PreparedStatement sta;
    
    //constructor
    public paqueteDao(){
        
    }
    
    //metodos
    public List<paquete> listarPaqueteDuo() throws Exception{
        List<paquete> lis = null;
        ResultSet res;
        try {
            this.conectar(); 
            query="select descripcion, precioventa from paquetes where id_tiposervicio=3";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lis = new ArrayList();
            
            while (res.next()) {          
                paquete paq = new paquete();
                paq.setDescripcion(res.getString("descripcion"));
                paq.setPrecioVenta(res.getDouble("precioventa"));
                lis.add(paq);
            }
            
        }catch (SQLException ex){
            System.out.println("Erro en el query: "+ex);
        }finally{
            this.cerrar();
        }
        
        return lis;
    }
    
    public List<paquete> listarPaqueteInternet(){
        List<paquete> lis = null;
        ResultSet res;
        try {
            
            this.conectar();
            query="select descripcion, precioventa from paquetes where id_tiposervicio=2";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lis = new ArrayList();
            
            while(res.next()){
                paquete paq = new paquete();
                paq.setDescripcion(res.getString("descripcion"));
                paq.setPrecioVenta(res.getDouble("precioventa"));
                lis.add(paq);
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
        } catch (Exception ex) {
        Logger.getLogger(paqueteDao.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          try {
            this.cerrar();
          } catch (Exception ex) {
            Logger.getLogger(paqueteDao.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        return lis;
    }
    public List<paquete> listarPaqueteCable(){
        List<paquete> lis = null;
        ResultSet res;
        
        try {
            this.conectar();
            query="select descripcion, precioventa from paquetes where id_tiposervicio=1";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lis = new ArrayList();
            
            while(res.next()){
                paquete paq = new paquete();
                paq.setDescripcion(res.getString("descripcion"));
                paq.setPrecioVenta(res.getDouble("precioventa"));
                lis.add(paq);
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
        } catch (Exception ex) {
        Logger.getLogger(paqueteDao.class.getName()).log(Level.SEVERE, null, ex);
      }
        
        return lis;
    }
}
