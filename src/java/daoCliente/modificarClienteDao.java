package daoCliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modeloCliente.cliente;
import modeloCliente.tablaCliente;

public class modificarClienteDao extends dao.DAO {

    private String sql;
    private PreparedStatement sta;

    public void modficar(cliente cle) throws Exception {
        try {
            this.conectar();
            sql = "update persona set telefono_movil=?, telefono_casa=?, direccion=? where id_persona=?";
            sta = this.getCn().prepareStatement(sql);
            sta.setInt(1, cle.getTelefono_movil());
            sta.setInt(2, cle.getTelefono_casa());
            sta.setString(3, cle.getDireccion());
            System.out.println("id: "+cle.getIdCliente());
            sta.setInt(4, cle.getIdCliente());
            sta.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al modificar al cliente: " + ex);
        }

    }

    public List<tablaCliente> listarCliente(int codigo) {
        List<tablaCliente> listad;
        listad = new ArrayList();
        try {

            ResultSet result;
            this.conectar();
            PreparedStatement st = this.getCn().prepareCall("select persona.nombre,persona.apellido,persona.direccion,persona.dpi,persona.telefono_movil,persona.nit,persona.fecha_nacimiento,persona.telefono_casa\n"
                    + "from clientes INNER JOIN persona ON persona.id_persona = clientes.id_cliente where clientes.id_cliente=?");

            st.setInt(1, codigo);
            result = st.executeQuery();

            while (result.next()) {
                tablaCliente cliente = new tablaCliente();
                
                cliente.setNombre(result.getString("nombre"));
                cliente.setApellido(result.getString("apellido"));
                cliente.setDireccion(result.getString("direccion"));
                cliente.setNit(result.getLong("nit"));
                cliente.setDpi(result.getLong("dpi"));
                cliente.setTel_casa(result.getInt("telefono_casa"));
                cliente.setTel_movil(result.getInt("telefono_movil"));
                cliente.setFecha_nac(result.getString("fecha_nacimiento"));
                listad.add(cliente);
            }
        } catch (Exception ex) {
            System.out.println("Error al Listar Cliente DAO" + ex);
        }
        return listad;
    }

}
