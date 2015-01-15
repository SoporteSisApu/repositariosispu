/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.bean;

import ec.com.sisapus.daoimpl.ControlEjecucionImpl;
import ec.com.sisapus.modelo.ControlEjecutadoPresupuestado;
import ec.com.sisapus.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.component.chart.bar.BarChart;
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
private static final long serialVersionUID = 6401166601481931346L;
private CartesianChartModel GrafControl;
   

   
 public    ControlEjecutadoBean()
         
 {
 this.controlpresupues=new ControlEjecutadoPresupuestado();


 }

 /*public void crearModeloBarrasControlProyecto() {
      ControlEjecucionImpl daoeje=new ControlEjecucionImpl();
   List< ControlEjecutadoPresupuestado> listacontrol=daoeje.listaproyectosejecucion();
        GrafControl = new CartesianChartModel();
         
  for (ControlEjecutadoPresupuestado control :listacontrol)           {
              final  ChartSeries ejec= new ChartSeries("Ejecucion");
              // String Nombre=String.valueOf(control.getDescripcionEjec());
              // String Id=String.valueOf(control.getCodigoEjec());
              //.setLabel(Nombre);
               ejec.set("Ejecutados", control.getPTotalEjec());
               GrafControl.addSeries(ejec);
               //model.addSeries(seriegrafic);
           }      
     
         
        final ChartSeries alquiler  = new ChartSeries("Alquiler");
        alquiler.set("2008", 1200);
        alquiler.set("2009", 1100);
        alquiler.set("2010", 1700);
        alquiler.set("2011", 1900);
         
        //GrafControl.addSeries(ejec);
        GrafControl.addSeries(alquiler);
 }*/
 
 
@PostConstruct
    public void init(){
    
     ControlEjecucionImpl daoeje=new ControlEjecucionImpl();
   List< ControlEjecutadoPresupuestado> listacontrol=daoeje.listaproyectosejecucion();
        GrafControl = new CartesianChartModel();
         
  for (ControlEjecutadoPresupuestado control :listacontrol)           {
              final  ChartSeries ejec= new ChartSeries("Proyectos en Ejecucion");
              // String Nombre=String.valueOf(control.getDescripcionEjec());
              // String Id=String.valueOf(control.getCodigoEjec());
              //.setLabel(Nombre);
               ejec.set("Precio Total", 1/*control.getPTotalEjec()*/);
               ejec.set("Precio Unitario",1/* control.getPUnitEjec()*/);
               GrafControl.addSeries(ejec);
           }      
        
         
        final ChartSeries alquiler  = new ChartSeries("Proyecto Presupuestados");
        alquiler.set("Precio Total",1);
        alquiler.set("Precio Unitario",1);
        

        GrafControl.addSeries(alquiler);
  
 }

   
    public CartesianChartModel getGrafControl() {
        return GrafControl;
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
        if (this.controlpresupues == null) {
            controlpresupues = new ControlEjecutadoPresupuestado();
        }
        
        return controlpresupues;
    }

    public void setControlpresupues(ControlEjecutadoPresupuestado controlpresupues) {
        this.controlpresupues = controlpresupues;
    }

    public List<ControlEjecutadoPresupuestado> getListaControl() throws Exception {
       ControlEjecucionImpl ejedao=new ControlEjecucionImpl();
        listaControl = ejedao.listaproyectosejecucion();
        return listaControl;
   
    }

    public void setListaControl(List<ControlEjecutadoPresupuestado> listaControl) {
        this.listaControl = listaControl;
    }


    
    
    
}
