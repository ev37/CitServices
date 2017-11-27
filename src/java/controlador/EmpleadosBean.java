package controlador;

import dao.EmpleadosDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Empleados;

@ManagedBean
@ViewScoped
public class EmpleadosBean {

    private Empleados empleado = new Empleados();
    private List<Empleados> lstEmpleados;

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public List<Empleados> getLstEmpleados() {
        return lstEmpleados;
    }

    public void setLstEmpleados(List<Empleados> lstEmpleados) {
        this.lstEmpleados = lstEmpleados;
    }

    public void registrarEmpleados() throws Exception {
        EmpleadosDAO dao;

        try {
            dao = new EmpleadosDAO();
            dao.registrar(empleado);
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarEmpleados() throws Exception {
        EmpleadosDAO dao = new EmpleadosDAO();

        try {
            lstEmpleados = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerIDEmpleados(Empleados pac) throws Exception {
        EmpleadosDAO dao;
        Empleados temp;
        try {

            dao = new EmpleadosDAO();
            temp = dao.leerID(pac);

            if (temp != null) {
                this.empleado = temp;
            }

        } catch (Exception e) {
            throw e;
        }

    }

    public void modificarEmpleados() throws Exception {
        EmpleadosDAO dao;

        try {
            dao = new EmpleadosDAO();
            dao.modificar(empleado);
            this.listarEmpleados();
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Empleados pac) throws Exception {
        EmpleadosDAO dao;

        try {
            dao = new EmpleadosDAO();
            dao.eliminar(pac);

            this.listarEmpleados();
        } catch (Exception e) {
            throw e;
        }
    }
}
