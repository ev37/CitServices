package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.ConsultaClientes;

public class BajasDAO extends DAO {

    public List<ConsultaClientes> listarcable(int codigo) throws Exception {
        List<ConsultaClientes> lista;
        lista = new ArrayList();
        ResultSet result;

        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareCall("select contrataciones.id_contratacion,contrataciones.id_cliente, persona.nombre,paquetes.id_paquete,paquetes.nombre as \"NomPaquete\", tipos_servicios.nombre as \"TipodeServicio\"\n"
                    + "from contrataciones inner join clientes on contrataciones.id_cliente = clientes.id_cliente \n"
                    + "inner join paquetes on contrataciones.id_paquete = paquetes.id_paquete\n"
                    + "inner join persona on clientes.id_cliente = persona.id_persona "
                    + "inner join tipos_servicios on paquetes.id_tiposervicio = tipos_servicios.id_tiposervicio\n"
                    + "where clientes.id_cliente=? and tipos_servicios.nombre='cable'");

            st.setInt(1 ,codigo);

            result = st.executeQuery();
            

            while (result.next()) {
                ConsultaClientes con = new ConsultaClientes();
                con.setId_contratacion(Integer.parseInt(result.getString("id_contratacion")));
                con.setId_cliente(Integer.parseInt(result.getString("id_cliente")));
                con.setNombre(result.getString("nombre"));
                con.setId_paquete(Integer.parseInt(result.getString("id_paquete")));
                con.setNom_paquete(result.getString("NomPaquete"));
                con.setTipo_servicio(result.getString("TipodeServicio"));
                lista.add(con);
            }
        } catch (Exception e) {
            System.out.println("Error en el DAO ListaCable" + e);

        } finally {
            this.cerrar();
        }
        return lista;
    }

    public List<ConsultaClientes> listarInternet(int codigo) throws Exception {
        List<ConsultaClientes> lista2;
        lista2 = new ArrayList();
        ResultSet result;

        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareCall("select contrataciones.id_contratacion,contrataciones.id_cliente, persona.nombre,paquetes.id_paquete,paquetes.nombre as \"NomPaquete\", tipos_servicios.nombre as \"TipodeServicio\"\n"
                    + "from contrataciones inner join clientes on contrataciones.id_cliente = clientes.id_cliente \n"
                    + "inner join paquetes on contrataciones.id_paquete = paquetes.id_paquete\n"
                    + "inner join persona on clientes.id_cliente = persona.id_persona "
                    + "inner join tipos_servicios on paquetes.id_tiposervicio = tipos_servicios.id_tiposervicio\n"
                    + "where clientes.id_cliente=? and tipos_servicios.nombre='internet'");

            st.setInt(1, codigo);

            result = st.executeQuery();
            

            while (result.next()) {
                ConsultaClientes con = new ConsultaClientes();
                con.setId_contratacion(Integer.parseInt(result.getString("id_contratacion")));
                con.setId_cliente(Integer.parseInt(result.getString("id_cliente")));
                con.setNombre(result.getString("nombre"));
                con.setId_paquete(Integer.parseInt(result.getString("id_paquete")));
                con.setNom_paquete(result.getString("NomPaquete"));
                con.setTipo_servicio(result.getString("TipodeServicio"));
                lista2.add(con);
            }
        } catch (Exception e) {
            System.out.println("Error en el Dao Lista Internet" + e);
            
        } finally {
            this.cerrar();
        }
        return lista2;
    }

    public ConsultaClientes leerID(ConsultaClientes pac) throws Exception {
        ConsultaClientes leer = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("select contrataciones.id_contratacion,contrataciones.id_cliente, clientes.nombre,paquetes.id_paquete,paquetes.nombre as \"NomPaquete\", tipos_servicios.nombre as \"TipodeServicio\"\n"
                    + "from contrataciones inner join clientes on contrataciones.id_cliente = clientes.id_cliente \n"
                    + "inner join paquetes on contrataciones.id_paquete = paquetes.id_paquete\n"
                    + "inner join tipos_servicios on paquetes.id_tiposervicio = tipos_servicios.id_tiposervicio\n"
                    + "where clientes.id_cliente=? and tipos_servicios.nombre='internet'");
            st.setInt(1, pac.getId_cliente());
            rs = st.executeQuery();
            while (rs.next()) {
                leer = new ConsultaClientes();
                leer.setId_contratacion(Integer.parseInt(rs.getString("id_contratacion")));
                leer.setId_cliente(Integer.parseInt(rs.getString("id_cliente")));
                leer.setNombre(rs.getString("nombre"));
                leer.setId_paquete(Integer.parseInt(rs.getString("id_paquete")));
                leer.setNom_paquete(rs.getString("NomPaquete"));
                leer.setTipo_servicio(rs.getString("TipodeServicio"));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return leer;
    }

    

    public void eliminar(ConsultaClientes consulta) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM contrataciones WHERE id_contratacion = ?");
            st.setInt(1, consulta.getId_contratacion());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
}
