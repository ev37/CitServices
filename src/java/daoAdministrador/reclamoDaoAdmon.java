package daoAdministrador;


import ModeloAdministrador.Reclamo2;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ModeloAdministrador.Reclamos;
import modeloCliente.Reclamo;

public class reclamoDaoAdmon extends dao.DAO {

    private String query;
    private PreparedStatement sta;

    public void insertar(Reclamo rec) throws Exception {
        try {
            this.conectar();
            query = "insert into reclamo(id_estado, id_cliente, id_tipo_reclamo, descripcion) values(?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, rec.getIdEstado());
            sta.setInt(2, rec.getIdCliente());
            sta.setInt(3, rec.getIdTipoReclamo());
            sta.setString(4, rec.getDescripcion());
            sta.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        } finally {
            this.cerrar();
        }
    }

    public List<Reclamos> listarRECLAMOS() throws Exception {
        List<Reclamos> lista = null;
        ResultSet res;

        try {
            this.conectar();
            query = "select * from vwreclamo";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lista = new ArrayList();
            
            while(res.next()){
                Reclamos re = new Reclamos();
                re.setId_reclamo(res.getInt("id_reclamo"));
                re.setEstado(res.getString("estado_nombre"));
                re.setSolucion(res.getString("nombre_solucion"));
                re.setId_cliente(res.getInt("id_cliente"));
                re.setCliente(res.getString("cliente"));
                re.setTiporeclamo(res.getString("nombre_tipo_reclamo"));
                re.setDescripcion(res.getString("descripcion"));
                lista.add(re);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(reclamoDaoAdmon.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }

        return lista;
    }

    
    
    public List<Reclamo2> listarTipoRecl() throws Exception {
        List<Reclamo2> lista = null;
        ResultSet res;

        try {
            this.conectar();
            query = "select nombre_tipo_reclamo, id_tipo_reclamo from tipo_reclamo";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lista = new ArrayList();
            
            while(res.next()){
                Reclamo2 reclamo = new Reclamo2();
                reclamo.setTipoReclamo(res.getString("nombre_tipo_reclamo"));
                reclamo.setIdTipoReclamo(res.getInt("id_tipo_reclamo"));
                lista.add(reclamo);
            }
            
        } catch (Exception ex) {
            
        }finally{
            this.cerrar();
        }

        return lista;
    }
    
    public List<Reclamo2> listarcliente() throws Exception {
        List<Reclamo2> lista = null;
        ResultSet res;

        try {
            this.conectar();
            query = "select id_cliente, cliente from vwdatocliente";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lista = new ArrayList();
            
            while(res.next()){
                Reclamo2 cliente = new Reclamo2();
                cliente.setIdCliente(res.getInt("id_cliente"));
                cliente.setCliente(res.getString("cliente"));
                lista.add(cliente);
            }
            
        } catch (Exception ex) {
            
        }finally{
            this.cerrar();
        }

        return lista;
    }
    
    
    public List<Reclamo2> listarEstado() throws Exception {
        List<Reclamo2> lista = null;
        ResultSet res;

        try {
            this.conectar();
            query = "select id_estado, nombre from estados";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lista = new ArrayList();
            
            while(res.next()){
                Reclamo2 estado = new Reclamo2();
                estado.setIdEstado(res.getInt("id_estado"));
                estado.setEstado(res.getString("nombre"));
                lista.add(estado);
            }
            
        } catch (Exception ex) {
            
        }finally{
            this.cerrar();
        }

        return lista;
    }
}
