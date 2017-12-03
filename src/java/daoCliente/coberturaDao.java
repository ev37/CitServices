/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoCliente;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modeloCliente.tablaCobertura;

/**
 *
 * @author Walter
 */
public class coberturaDao extends dao.DAO {

    private String sql;
    private PreparedStatement sta;

    public List<tablaCobertura> listar(tablaCobertura tabCob) throws Exception {
        List<tablaCobertura> listDep = null;
        ResultSet res;

        try {
            this.conectar();
            sql = "select departamentos.nombre as departamento, departamentos.id_departamento as id_departamento, municipios.nombre as municipio, municipios.id_municipio as id_municipio, coberturas.nombre as cobertura, coberturas.id_cobertura as id_cobertura\n"
                    + "from departamentos\n"
                    + "inner join municipios on municipios.id_departamento = departamentos.id_departamento "
                    + "inner join coberturas on coberturas.id_cobertura = municipios.id_cobertura "
                    + "where departamentos.id_departamento=?";
            sta = this.getCn().prepareStatement(sql);
            sta.setInt(1, tabCob.getIdDepartamento());
            res = sta.executeQuery();
            listDep = new ArrayList();

            while (res.next()) {
                tablaCobertura de = new tablaCobertura();
                de.setMunicipio(res.getString("municipio"));
                de.setIdMunicipio(res.getInt("id_municipio"));
                listDep.add(de);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        } finally {
            this.cerrar();
        }

        return listDep;
    }
    
    public List<tablaCobertura> listarDepartamento() throws Exception {
        List<tablaCobertura> listDep = null;
        ResultSet res;

        try {
            this.conectar();
            sql = "select * from departamentos";
            sta = this.getCn().prepareStatement(sql);
            res = sta.executeQuery();
            listDep = new ArrayList();

            while (res.next()) {
                tablaCobertura de = new tablaCobertura();
                de.setIdDepartamento(res.getInt("id_departamento"));
                de.setDepartamento(res.getString("nombre"));
                listDep.add(de);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        } finally {
            this.cerrar();
        }

        return listDep;
    }
}
