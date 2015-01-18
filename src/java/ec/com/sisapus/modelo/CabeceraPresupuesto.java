package ec.com.sisapus.modelo;
// Generated 18/01/2015 06:23:43 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * CabeceraPresupuesto generated by hbm2java
 */
public class CabeceraPresupuesto  implements java.io.Serializable {


     private Integer codigoPres;
     private Proyecto proyecto;
     private String descripPres;
     private Double subtPres;
     private Double ivaPres;
     private Double gastotPres;
     private Set detallePresupuestos = new HashSet(0);

    public CabeceraPresupuesto() {
        this.codigoPres=0;
        this.proyecto=new Proyecto();
    }

    public CabeceraPresupuesto(Proyecto proyecto, String descripPres, Double subtPres, Double ivaPres, Double gastotPres, Set detallePresupuestos) {
       this.proyecto = proyecto;
       this.descripPres = descripPres;
       this.subtPres = subtPres;
       this.ivaPres = ivaPres;
       this.gastotPres = gastotPres;
       this.detallePresupuestos = detallePresupuestos;
    }
   
    public Integer getCodigoPres() {
        return this.codigoPres;
    }
    
    public void setCodigoPres(Integer codigoPres) {
        this.codigoPres = codigoPres;
    }
    public Proyecto getProyecto() {
        return this.proyecto;
    }
    
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    public String getDescripPres() {
        return this.descripPres;
    }
    
    public void setDescripPres(String descripPres) {
        this.descripPres = descripPres;
    }
    public Double getSubtPres() {
        return this.subtPres;
    }
    
    public void setSubtPres(Double subtPres) {
        this.subtPres = subtPres;
    }
    public Double getIvaPres() {
        return this.ivaPres;
    }
    
    public void setIvaPres(Double ivaPres) {
        this.ivaPres = ivaPres;
    }
    public Double getGastotPres() {
        return this.gastotPres;
    }
    
    public void setGastotPres(Double gastotPres) {
        this.gastotPres = gastotPres;
    }
    public Set getDetallePresupuestos() {
        return this.detallePresupuestos;
    }
    
    public void setDetallePresupuestos(Set detallePresupuestos) {
        this.detallePresupuestos = detallePresupuestos;
    }




}


