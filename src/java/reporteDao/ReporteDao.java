/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteDao;

import com.mysql.jdbc.Connection;
import dao.DAO;
import java.io.File;
import javax.swing.JFileChooser;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Admin
 */
public class ReporteDao extends DAO{
//    public void generarReporte(String nombre) throws JRException, Exception {
//        this.conectar();
//        Connection conn = this.getCn();
//        File direccion = new File("src\\Reporte\\listaCliente.jasper");
//        JasperReport reporteCliente;//Variable de tipo JasperReport
//        reporteCliente = (JasperReport) JRLoader.loadObject(direccion);//se le asigna la direccion del archivo .jasper 
//        JasperPrint imprimirReporte = JasperFillManager.fillReport(reporteCliente, null, conn);//obtiene la direccion del reporte y la conexion a base de datos
//        JasperExportManager.exportReportToPdfFile(imprimirReporte,"C:\\Users\\Walter\\Documents\\NetBeansProjects\\aplicacionDesktop\\src\\Reporte"+nombre+".pdf");
//        JasperViewer vista = new JasperViewer(imprimirReporte, false);//se genera la vista del reporte
//        String file = "C:\\Users\\Walter\\Documents\\NetBeansProjects\\aplicacionDesktop\\src\\Reporte"+nombre+".pdf";
//        Runtime.getRuntime().exec("C:\\Program Files (x86)\\Adobe\\Acrobat Reader DC\\Reader\\AcroRd32 start "+file);
//        vista.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //para que se pueda cerrar el reporte al momento de pichar la X
//        
//    }
    public void generarReporteCliente() throws JRException, Exception {
        this.conectar();
        Connection conn = (Connection) this.getCn();
        
//        JFileChooser guardarComo =  new JFileChooser();
//        guardarComo.setApproveButtonText("Guardar");
//        guardarComo.showSaveDialog(null);
//        
        File direccion = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\CitServices\\web\\Reportes\\ReporteEmpleados\\empleados.jasper");
        JasperReport reporteCliente;//Var\iable de tipo JasperReport
        reporteCliente = (JasperReport) JRLoader.loadObject(direccion);//se le asigna la direccion del archivo .jasper 
        JasperPrint imprimirReporte = JasperFillManager.fillReport(reporteCliente, null, conn);//obtiene la direccion del reporte y la conexion a base de datos
        JasperExportManager.exportReportToPdfFile(imprimirReporte,"C:\\Users\\Admin\\Documents\\NetBeansProjects\\CitServices\\web\\Reportes\\ReporteEmpleados\\empleado.pdf");
        
    }
    
    public void generarReporteEmpleado() throws JRException, Exception {
        this.conectar();
        Connection conn = (Connection) this.getCn();
        
        JFileChooser guardarComo =  new JFileChooser();
        guardarComo.setApproveButtonText("Guardar");
        guardarComo.showSaveDialog(null);
        
        File direccion = new File("src\\Reporte\\listaEmpleado.jasper");
        JasperReport reporteCliente;//Variable de tipo JasperReport
        reporteCliente = (JasperReport) JRLoader.loadObject(direccion);//se le asigna la direccion del archivo .jasper 
        JasperPrint imprimirReporte = JasperFillManager.fillReport(reporteCliente, null, conn);//obtiene la direccion del reporte y la conexion a base de datos
        JasperExportManager.exportReportToPdfFile(imprimirReporte,guardarComo.getSelectedFile()+".pdf");
        
    }
}
