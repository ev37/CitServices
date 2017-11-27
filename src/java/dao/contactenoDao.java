package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.contacteno;

/**
 *
 * @author Walter
 */
public class contactenoDao extends DAO {

    private String query;
    private PreparedStatement sta;

    public contactenoDao() {

    }

    public void registrar(contacteno con) throws Exception {
        try {
            query = "insert into contacteno(id_contacteno,nombre, apellido, empresa, cargo_departamento, telefono, email, comentario) values(?,?,?,?,?,?,?,?)";
            sta = this.getCn().prepareStatement(query);
            sta.setInt(1, con.getId_contacteno());
            sta.setString(2, con.getNombre());
            sta.setString(3, con.getApellido());
            sta.setString(4, con.getEmpresa());
            sta.setString(5, con.getCargoDepartamento());
            sta.setInt(6, con.getTelefono());
            sta.setString(7, con.getEmail());
            sta.setString(8, con.getComentario());
            sta.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error en Registrar"+ex);
        } finally {
            this.cerrar();
        }
    }
}
