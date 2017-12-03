package daoCliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloCliente.Reclamo;

public class reclamoDao extends dao.DAO {

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

    public List<Reclamo> listarTipoReclamo() throws Exception {
        List<Reclamo> lista = null;
        ResultSet res;

        try {
            this.conectar();
            query = "select nombre_tipo_reclamo, id_tipo_reclamo from tipo_reclamo";
            sta = this.getCn().prepareStatement(query);
            res = sta.executeQuery();
            lista = new ArrayList();
            
            while(res.next()){
                Reclamo re = new Reclamo();
                re.setTipoReclamo(res.getString("nombre_tipo_reclamo"));
                re.setIdTipoReclamo(res.getInt("id_tipo_reclamo"));
                lista.add(re);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(reclamoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.cerrar();
        }

        return lista;
    }

}
