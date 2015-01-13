/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.bean;

import ec.com.sisapus.modelo.ControlEjecutadoPresupuestado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.model.chart.CartesianChartModel;

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

 public void criaModeloBarras() {
     model= new CartesianChartModel();
     ControlEj
     
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
