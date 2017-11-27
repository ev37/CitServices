package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Usuarios;

public class UsuarioDAO extends DAO {

  public Usuarios usuariolistar(Usuarios us) throws Exception {
    Usuarios usuarios = null;
    ResultSet result;

    try {
      this.conectar();
      PreparedStatement st = this.getCn().prepareCall("select * from usuarios where nombre=? and contrasena=?");
       
      st.setString(1,us.getNombre());
      st.setString(2,us.getContraseña());

      result = st.executeQuery();
      //lista = new ArrayList();

      while (result.next()) {
        usuarios = new Usuarios();        
        usuarios.setId_usuario(result.getInt("id_usuario"));
        usuarios.setNombre(result.getString("nombre"));
        usuarios.setContraseña(result.getString("contrasena"));        
        usuarios.setTipo_usuario(result.getInt("id_tipoUsuario"));
        //lista.add(usuarios);               
        
       
      }
    } catch (Exception e) {
      System.out.println("Error no se encontro usuario "+e);
      throw e;
    } finally {
      this.cerrar();
    }
    return usuarios;
  }
}
