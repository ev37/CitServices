package daoAdministrador;

import ModeloAdministrador.Personas;
import ModeloAdministrador.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOAdmon extends DAO {

    public void registrar(Usuarios usuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into usuarios(id_usuario, nombre, contrasena ,id_tipoUsuario)\n"
                    + "values(?,?,?,?)");
            st.setInt(1, usuario.getId_usuario());
            st.setString(2, usuario.getNombre());
            st.setString(3, usuario.getContraseña());
            st.setLong(4, usuario.getTipo_usuario());

            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error en Registrar " + ex);
        } finally {
            this.cerrar();
        }
    }

    public List<Personas> listarPersona() {
        List<Personas> lista = new ArrayList();
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareCall("select id_persona, nombre  from persona where persona.id_persona not in(select usuarios.id_usuario from usuarios)");
            rs = st.executeQuery();

            while (rs.next()) {
                Personas persona = new Personas();
                persona.setId(rs.getInt("id_persona"));
                persona.setNombre(rs.getString("nombre"));
                lista.add(persona);
            }
        } catch (Exception ex) {
            System.out.println("Error en Lista Persona " + ex);
        }
        return lista;
    }

    public List<T> listarPersona() {
        List<Personas> lista = new ArrayList();
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareCall("select id_persona, nombre  from persona where persona.id_persona not in(select usuarios.id_usuario from usuarios)");
            rs = st.executeQuery();

            while (rs.next()) {
                Personas persona = new Personas();
                persona.setId(rs.getInt("id_persona"));
                persona.setNombre(rs.getString("nombre"));
                lista.add(persona);
            }
        } catch (Exception ex) {
            System.out.println("Error en Lista Persona " + ex);
        }
        return lista;
    }
}
