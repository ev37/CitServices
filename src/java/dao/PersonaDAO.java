package dao;

import java.sql.PreparedStatement;
import modelo.Personas;

public class PersonaDAO extends DAO {

    public void registrar(Personas personas) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into persona(nombre,apellido,direccion,dpi,telefono_movil,nit,fecha_nacimiento,telefono_casa)\n"
                    + "values(?,?,?,?,?,?,?,?)");
            st.setString(1, personas.getNombre());
            st.setString(2, personas.getApellido());
            st.setString(3, personas.getDireccion());
            st.setInt(4, personas.getDpi());
            st.setInt(5, personas.getTel_movil());
            st.setInt(6, personas.getNit());
            st.setString(7, personas.getFecha_nac());
            st.setInt(8, personas.getTel_casa());

            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error en Registrar " + ex);
        } finally {
            this.cerrar();
        }
    }
}
