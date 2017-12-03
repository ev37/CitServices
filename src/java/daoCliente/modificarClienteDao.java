package daoCliente;


import java.sql.PreparedStatement;
import modeloCliente.cliente;

public class modificarClienteDao extends dao.DAO{
    private String sql;
    private PreparedStatement sta;
    
    public void modficar(cliente cle){
        try {
            this.conectar();
            sql = "update persona set telefono_movil=?, telefono_casa=? where id_persona=?";
            sta = this.getCn().prepareStatement(sql); 
            sta.setInt(1, cle.getTelefono_movil());
            sta.setInt(2, cle.getTelefono_casa());
            sta.setInt(3, cle.getIdCliente());
            sta.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error al modificar al cliente: "+ex);
        }
        
    }
    
//    public List<cliente> listarCliente(cliente cle){
//        List<cliente> lista = null;
//        ResultSet res;
//        
//        try {
//            this.conectar();
//            sql="select * from clientes where id_cliente=?";
//            sta = this.getCn().prepareStatement(sql);
//            sta.setInt(1, cle.getIdCliente());
//            res = sta.executeQuery();
//            lista = new ArrayList();
//            while(res.next()){
//                cliente clie = new cliente();
//                clie.setDireccion(res.getString("direccion"));
//                clie.setEmail(res.getString("email"));
//                clie.setTelefono(res.getInt("telefono")); 
//                sta.executeQuery();
//            }
//        } catch (Exception e) {
//            System.out.println("Error en listar cliente"+e);
//        }
//        
//        return lista;
//    }
}
