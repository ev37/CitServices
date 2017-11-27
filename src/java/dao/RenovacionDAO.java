package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Municipios;

import modelo.RenovacionContratos;
import modelo.paquete;

public class RenovacionDAO extends DAO {

    public List<paquete> listarPaquetes() throws Exception {
        List<paquete> listapaquetes = new ArrayList();
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareCall("select id_paquete,nombre from  paquetes");

            rs = st.executeQuery();

            while (rs.next()) {
                paquete paquetes = new paquete();
                paquetes.setIdPaquete(rs.getInt("id_paquete"));
                paquetes.setNombre(rs.getString("nombre"));
                listapaquetes.add(paquetes);
            }
        } catch (Exception ex) {
            System.out.println("fsfsf");
        } finally {
            this.cerrar();
        }
        return listapaquetes;
    }

    public List<Municipios> listarMunicipios() throws Exception {
        List<Municipios> lista = new ArrayList();;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareCall("select id_municipio,nombre from  municipios");

            rs = st.executeQuery();

            while (rs.next()) {
                Municipios municipio = new Municipios();
                municipio.setId_municipio(rs.getInt("id_municipio"));
                municipio.setNombre(rs.getString("nombre"));
                lista.add(municipio);
            }
        } catch (Exception ex) {
            System.out.println("fsfsf");
        } finally {
            this.cerrar();
        }
        return lista;
    }

    public List<RenovacionContratos> listar(RenovacionContratos codigo) throws Exception {
        List<RenovacionContratos> lista;
        ResultSet rs;

        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareCall("select * from contrataciones where id_cliente=?");
            st.setInt(1, codigo.getId_cliente());
            System.out.println(codigo.getId_cliente());
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                RenovacionContratos renovacion = new RenovacionContratos();
                renovacion.setId_contracion(rs.getInt("id_contratacion"));
                renovacion.setFecha_contratacion(rs.getString("fecha_contratacion"));
                renovacion.setFecha_renovacion(rs.getString("fecha_renovacion"));
                renovacion.setFecha_culminacion(rs.getString("fecha_culminacion"));
                renovacion.setId_cliente(rs.getInt("id_cliente"));
                renovacion.setId_paquete(rs.getInt("id_paquete"));
                renovacion.setDireccion(rs.getString("direccion"));                
                renovacion.setId_municipio(rs.getInt("id_municipio"));
                renovacion.setId_empleado(rs.getInt("id_empleado"));
                lista.add(renovacion);
            }
        } catch (Exception e) {
            System.out.println("Error en el DAO ListaCable" + e);
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    public RenovacionContratos leerID(RenovacionContratos pac) throws Exception {
        RenovacionContratos renovacion = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("select * from contrataciones where id_cliente=? ;");
            st.setInt(1, pac.getId_cliente());
            rs = st.executeQuery();
            while (rs.next()) {
                renovacion = new RenovacionContratos();
                renovacion.setId_contracion(rs.getInt("id_contratacion"));
                renovacion.setFecha_contratacion(rs.getString("fecha_contratacion"));
                renovacion.setFecha_renovacion(rs.getString("fecha_renovacion"));
                renovacion.setFecha_culminacion(rs.getString("fecha_culminacion"));
                renovacion.setId_cliente(rs.getInt("id_cliente"));
                renovacion.setId_paquete(rs.getInt("id_paquete"));
                renovacion.setDireccion(rs.getString("direccion"));                
                renovacion.setId_municipio(rs.getInt("id_municipio"));
                renovacion.setId_empleado(rs.getInt("id_empleado"));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return renovacion;
    }

    public void modificar(RenovacionContratos nueva) throws Exception {
        try {
            System.out.println("direccion" + nueva.getDireccion());
            System.out.println("id " + nueva.getId_cliente());
            
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE contrataciones \n"
                    + "	SET fecha_contratacion=?,fecha_renovacion=?,fecha_culminacion=?,id_paquete=?,direccion=?,id_municipio=? \n"
                    + "	where id_cliente=?");            
            st.setString(1, nueva.getFecha_contratacion());
            st.setString(2, nueva.getFecha_renovacion());
            st.setString(3, nueva.getFecha_culminacion());
            st.setInt(4, nueva.getId_paquete());
            st.setString(5, nueva.getDireccion());
            st.setInt(6, nueva.getId_municipio());
            st.setInt(7, nueva.getId_cliente());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al modificar en el DAO Renovaciones"+e);
        } finally {
            this.cerrar();
        }
    }
}
