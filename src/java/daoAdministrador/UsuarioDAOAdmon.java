package daoAdministrador;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ModeloAdministrador.Usuarios;

public class UsuarioDAOAdmon extends DAO {

  public Usuarios usuariolistar(Personas us) throws Exception {
    Usuarios usuarios = null;
    ResultSet result;

    try {
      this.conectar();
      PreparedStatement st = this.getCn().prepareCall("select id_persona, nombre  from persona where persona.id_persona not in(select usuarios.id_usuario from usuarios)");
      result = st.executeQuery();
      //lista = new ArrayList();

      while (result.next()) {
        usuarios = new Usuarios();        
        usuarios.setId_usuario(result.getInt("id_usuario"));
        usuarios.setNombre(result.getString("nombre"));
        
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
