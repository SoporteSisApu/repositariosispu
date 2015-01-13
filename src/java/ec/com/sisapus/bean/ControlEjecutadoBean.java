/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.bean;

import ec.com.sisapus.daoimpl.ControlEjecucionImpl;
import ec.com.sisapus.modelo.ControlEjecutadoPresupuestado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author kleber
 */
@Named(value = "ControlEjecutadoBean")
@ViewScoped
public class ControlEjecutadoBean implements Serializable {
     Session session;
    Transaction transaction;
 private ControlEjecutadoPresupuestado controlpresupues;
    private List<ControlEjecutadoPresupuestado> listaControl;
   private CartesianChartModel model;
      

   
 public    ControlEjecutadoBean()
         
 {
 this.controlpresupues=new ControlEjecutadoPresupuestado();
 this.listaControl=new ArrayList<>();
 }

 public void crearModeloBarrasControlProyecto() throws Exception {
     model= new CartesianChartModel();
     ControlEjecucionImpl daoeje=new ControlEjecucionImpl();
   List< ControlEjecutadoPresupuestado> listacontrol=daoeje.listaproyectosejecucion(session);
   ChartSeries seriegrafic;
   for (ControlEjecutadoPresupuestado control : listacontrol)           {
               seriegrafic=new ChartSeries();
               String Nombre=String.valueOf(control.getDescripcionEjec());
               String Id=String.valueOf(control.getCodigoEjec());
               seriegrafic.setLabel(Nombre);
               seriegrafic.set("Ejecutados", control.getPTotalEjec());
               model.addSeries(seriegrafic);
               //model.addSeries(seriegrafic);
           }
   
     
 }
 
 
 
 
 
 
 
 
 
 
    public CartesianChartModel getModel() {
  
      
        return model;
    }

    public void setModel(CartesianChartModel model) {
        this.model = model;
    }
    
 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public ControlEjecutadoPresupuestado getControlpresupues() {
        return controlpresupues;
    }

    public void setControlpresupues(ControlEjecutadoPresupuestado controlpresupues) {
        this.controlpresupues = controlpresupues;
    }

    public List<ControlEjecutadoPresupuestado> getListaControl() {
        return listaControl;
    }

    public void setListaControl(List<ControlEjecutadoPresupuestado> listaControl) {
        this.listaControl = listaControl;
    }


    
    
    
}
