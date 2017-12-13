package daoAdministrador;

import ModeloAdministrador.TipoServicio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import ModeloAdministrador.paquete;
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
    
    public void registrar(paquete paq) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into paquetes values(?,?,?,?,?,?)");
            st.setInt(1, paq.getIdPaquete());
            st.setString(2, paq.getNombre());
            st.setString(3, paq.getDescripcion());
            st.setInt(4, paq.getIdTipoServicio());
            st.setDouble(5, paq.getCosto());
            st.setDouble(6, paq.getPrecioVenta());
            

            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error en DAO al Registrar " + ex);
        } finally {
            this.cerrar();
        }
    }
    
    
    public List<TipoServicio> listarTipoServicio(){
        List<TipoServicio> lis = null;
        ResultSet res;
        
        try {
            this.conectar();
            query="select * from tipos_servicios ";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lis = new ArrayList();
            
            while(res.next()){
                TipoServicio tip = new TipoServicio();
                tip.setId_tiposervicio(res.getInt("id_tiposervicio"));
                tip.setNombre(res.getString("nombre"));
                lis.add(tip);
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
        } catch (Exception ex) {
        Logger.getLogger(paqueteDao.class.getName()).log(Level.SEVERE, null, ex);
      }
        
        return lis;
    }
    
    public List<paquete> listarPaque(){
        List<paquete> lis = null;
        ResultSet res;
        
        try {
            this.conectar();
            query="select * from paquetes";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lis = new ArrayList();
            
            while(res.next()){
                paquete paq = new paquete();
                paq.setIdPaquete(res.getInt("id_paquete"));
                paq.setNombre(res.getString("nombre"));
                paq.setDescripcion(res.getString("descripcion"));
                paq.setIdTipoServicio(res.getInt("id_tiposervicio"));
                paq.setCosto(res.getDouble("costo"));
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
