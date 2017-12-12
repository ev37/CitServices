package daoAdministrador;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ModeloAdministrador.Personas;

public class PersonaDAOAdmon extends DAO {

    public void registrar(Personas personas) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into persona(nombre,apellido,direccion,dpi,telefono_movil,nit,fecha_nacimiento,telefono_casa)\n"
                    + "values(?,?,?,?,?,?,?,?)");
            st.setString(1, personas.getNombre());
            st.setString(2, personas.getApellido());
            st.setString(3, personas.getDireccion());
            st.setLong(4, personas.getDpi());
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
    
    public List<Personas> tablaPersona() throws Exception {
        List<Personas> lis;
        lis = new ArrayList();
        ResultSet result;

        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareCall("select * from persona");
            result = st.executeQuery();
            while (result.next()) {
                Personas per = new Personas();
                per.setId((result.getInt("id_persona")));
                per.setNombre((result.getString("nombre")));
                per.setApellido((result.getString("apellido")));
                per.setDireccion((result.getString("direccion")));
                per.setDpi(result.getLong("dpi")); 
                per.setTel_movil((result.getInt("telefono_movil")));
                per.setNit(result.getInt("nit"));
                per.setFecha_nac((result.getString("fecha_nacimiento")));
                per.setTel_casa((result.getInt("telefono_casa")));
                lis.add(per);
            }
        } catch (Exception e) {
            System.out.println("Muestre error" + e);
        } finally {
            this.cerrar();
        }
        return lis;
    }
}
