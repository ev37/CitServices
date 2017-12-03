
package daoCliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modeloCliente.nuevaTabla;

/**
 *
 * @author Walter
 */
public class nuevaTablaDao extends dao.DAO{
    private PreparedStatement sta;
    private String query;
    
    public List<nuevaTabla> lisatarNuevaTabla(int idUsuario) throws Exception{
        List<nuevaTabla> lista= null;
        ResultSet result;
            
        try {
           
            this.conectar();
            query = "select paquetes.costo as monto, paquetes.nombre as nombre_paquete, tipos_servicios.nombre as tipo_servicio\n" +
                    "from clientes\n" +
                    "inner join contrataciones on clientes.id_cliente = contrataciones.id_cliente\n" +
                    "inner join paquetes  on contrataciones.id_paquete = paquetes.id_paquete\n" +
                    "inner join tipos_servicios on paquetes.id_tiposervicio = tipos_servicios.id_tiposervicio \n" +
                    "where clientes.id_cliente=?";
            sta = this.getCn().prepareStatement(query);
            System.out.println("id usuario tabla dao "+idUsuario);
            sta.setInt(1, idUsuario);
            result = sta.executeQuery();
            lista = new ArrayList();
            
            while(result.next()){
                nuevaTabla tabla = new nuevaTabla();
                tabla.setMonto(result.getDouble("monto"));
                tabla.setNombrePaquete(result.getString("nombre_paquete"));
                tabla.setNombreTipoServicio(result.getString("tipo_servicio"));
                lista.add(tabla);
            }
            
        } catch (Exception ex) {
            System.out.println("Error al listar en nueva tabla Dao: "+ex);
        }finally{
            this.cerrar();
        }
        return lista;
    }
    
}
