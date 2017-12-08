package daoAdministrador;


import dao.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;
import ModeloAdministrador.Clientes;
import modelo.Estado;
import modelo.Personas;
import modelo.TipoCliente;

public class ClientesDAO extends DAO {

    public void registrar(Clientes client) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into clientes values(?,?,?,?,?)");
            st.setInt(1, client.getId_cliente());
            st.setInt(2, client.getId_categoria());
            st.setInt(3, client.getId_estado());
            st.setInt(4, client.getId_tipo_cliente());
            st.setString(5, client.getEmail());
            

            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error en DAO al Registrar " + ex);
        } finally {
            this.cerrar();
        }
    }

    public List<Categoria> listarCategoria() {
        List<Categoria> lista = new ArrayList();
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareCall("select * from  categoria");
            rs = st.executeQuery();

            while (rs.next()) {
                Categoria categorias = new Categoria();
                categorias.setId_categoria(rs.getInt("id_categoria"));
                categorias.setNombre(rs.getString("nombre"));
                lista.add(categorias);
            }
        } catch (Exception ex) {
            System.out.println("Error en Lista Categoria " + ex);
        }
        return lista;
    }

    public List<TipoCliente> listarTipoCliente() {
        List<TipoCliente> lista = new ArrayList();
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareCall("select * from tipo_cliente");
            rs = st.executeQuery();

            while (rs.next()) {
                TipoCliente tcliente = new TipoCliente();
                tcliente.setId_tipo_cliente(rs.getInt("id_tipo_cliente"));
                tcliente.setNombre(rs.getString("nombre"));
                lista.add(tcliente);
            }
        } catch (Exception ex) {
            System.out.println("Error en Lista Servicios " + ex);
        }
        return lista;
    }

    public List<Estado> listarEstado() {
        List<Estado> lista = new ArrayList();
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareCall("select * from estado");
            rs = st.executeQuery();

            while (rs.next()) {
                Estado estado = new Estado();
                estado.setCodestado(rs.getInt("codestado"));
                estado.setNombre(rs.getString("nombre"));
                lista.add(estado);
            }
        } catch (Exception ex) {
            System.out.println("Error en Listar estado " + ex);
        }
        return lista;
    }

    public List<Personas> listarPersona() throws Exception {
        List<Personas> lista3;
        lista3 = new ArrayList();
        ResultSet result;

        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareCall("select id_persona,nombre from persona");
            result = st.executeQuery();
            while (result.next()) {
                Personas con = new Personas();
                con.setId(Integer.parseInt(result.getString("id_persona")));
                con.setNombre(result.getString("nombre"));
                lista3.add(con);
            }
        } catch (Exception e) {
            System.out.println("Muestre error" + e);
        } finally {
            this.cerrar();
        }
        return lista3;
    }
    
     public List<Clientes> tablacliente() throws Exception {
        List<Clientes> lis;
        lis = new ArrayList();
        ResultSet result;

        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareCall("select id_cliente,id_categoria, id_estado, id_tipo_cliente, email from clientes");
            result = st.executeQuery();
            while (result.next()) {
                Clientes cli = new Clientes();
                cli.setId_cliente((result.getInt("id_cliente")));
                cli.setId_categoria((result.getInt("id_categoria")));
                cli.setId_estado((result.getInt("id_estado")));
                cli.setId_tipo_cliente((result.getInt("id_tipo_cliente")));
                cli.setEmail(result.getString("email"));
                lis.add(cli);
            }
        } catch (Exception e) {
            System.out.println("Muestre error" + e);
        } finally {
            this.cerrar();
        }
        return lis;
    }
}