package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleados;

public class EmpleadosDAO extends DAO{
     public void registrar(Empleados empleado)throws Exception{
        try{
            this.conectar();
            PreparedStatement st= this.getCn().prepareStatement("insert into empleados values(?,?,?,?,?,?,?)");            
            st.setInt(1, empleado.getId_empleado());
            st.setString(2, empleado.getNombre());
            st.setString(3, empleado.getApellido());
            st.setInt(4, empleado.getTelefono());
            st.setString(5, empleado.getDireccion());
            st.setInt(6, empleado.getId_puesto());
            st.setDouble(7, empleado.getSueldo());
            
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }
    public List<Empleados> listar() throws Exception{
        List<Empleados> lista;
        ResultSet result;
        
        try {
            this.conectar();
            PreparedStatement st =   this.getCn().prepareCall("SELECT id_empleado, nombre, apellido,telefono, direccion,id_puesto,sueldo FROM empleados");
            result = st.executeQuery();
            lista = new ArrayList();
            
            while(result.next()){
                Empleados emp = new Empleados();
                System.out.println("aqui1");
                emp.setId_empleado(Integer.parseInt(result.getString("id_empleado")));
                emp.setNombre(result.getString("nombre"));
                emp.setApellido(result.getString("apellido"));
                emp.setTelefono(result.getInt("telefono"));
                emp.setDireccion(result.getString("direccion"));
                emp.setId_puesto(Integer.parseInt(result.getString("id_puesto")));
                emp.setSueldo(Double.parseDouble(result.getString("sueldo")));
                lista.add(emp);
                System.out.println("aqui2");
            }
        } catch (Exception e)  {
            throw e;
        }finally{
            this.cerrar();            
        }
        return lista;   
    }
    public Empleados leerID(Empleados emple) throws Exception{
        Empleados empleados =null;
        ResultSet rs;
        try{
            this.conectar();
            PreparedStatement st= this.getCn().prepareStatement("SELECT id_empleado,nombre,apellido,telefono,direccion,id_puesto,sueldo FROM empleados where id_empleado=?");
            st.setInt(1, emple.getId_empleado());
            rs = st.executeQuery();
            while(rs.next()){
                empleados = new Empleados();
                empleados.setId_empleado(rs.getInt("id_empleado"));
                empleados.setNombre(rs.getString("nombre"));
                empleados.setApellido(rs.getString("apellido"));
                empleados.setTelefono(rs.getInt("telefono"));
                empleados.setDireccion(rs.getString("direccion"));
                empleados.setId_puesto(rs.getInt("id_puesto"));
                empleados.setSueldo(rs.getDouble("sueldo"));
            }
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
        return empleados;
    }

    public void modificar(Empleados empleados)throws Exception{
        try{
            this.conectar();
            PreparedStatement st= this.getCn().prepareStatement("UPDATE empleados SET nombre=?,apellido=?,telefono=?,direccion=?,id_puesto=?,sueldo=? where id_empleado =?");
            System.out.println("hola");
            st.setString(1, empleados.getNombre());
            st.setString(2, empleados.getApellido());
            st.setInt(3, empleados.getTelefono());
            st.setString(4, empleados.getDireccion());
            st.setInt(5, empleados.getId_puesto());
            st.setDouble(6, empleados.getSueldo());
            st.setInt(7, empleados.getId_empleado());
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally
        {
            this.cerrar();
        }
    }
    public void eliminar(Empleados empleados)throws Exception{
        try{
            this.conectar();
            PreparedStatement st= this.getCn().prepareStatement("DELETE FROM empelados WHERE id_empleado = ?");
            st.setInt(1, empleados.getId_empleado());
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally
        {
            this.cerrar();
        }
    }
}
