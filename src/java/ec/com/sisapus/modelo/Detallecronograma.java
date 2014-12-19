package ec.com.sisapus.modelo;
// Generated 18/12/2014 06:11:00 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Detallecronograma generated by hbm2java
 */
public class Detallecronograma  implements java.io.Serializable {


     private Integer codigoDetalleCronograma;
     private String descripcionDetalleCrono;
     private Integer cantidadDetalleCrono;
     private Double costoUnitarioDetalleCrono;
     private Double costoTotalDetalleCrono;
     private Set cronogramas = new HashSet(0);

    public Detallecronograma() {
        this.codigoDetalleCronograma=0;
    }

    public Detallecronograma(String descripcionDetalleCrono, Integer cantidadDetalleCrono, Double costoUnitarioDetalleCrono, Double costoTotalDetalleCrono, Set cronogramas) {
       this.descripcionDetalleCrono = descripcionDetalleCrono;
       this.cantidadDetalleCrono = cantidadDetalleCrono;
       this.costoUnitarioDetalleCrono = costoUnitarioDetalleCrono;
       this.costoTotalDetalleCrono = costoTotalDetalleCrono;
       this.cronogramas = cronogramas;
    }
   
    public Integer getCodigoDetalleCronograma() {
        return this.codigoDetalleCronograma;
    }
    
    public void setCodigoDetalleCronograma(Integer codigoDetalleCronograma) {
        this.codigoDetalleCronograma = codigoDetalleCronograma;
    }
    public String getDescripcionDetalleCrono() {
        return this.descripcionDetalleCrono;
    }
    
    public void setDescripcionDetalleCrono(String descripcionDetalleCrono) {
        this.descripcionDetalleCrono = descripcionDetalleCrono;
    }
    public Integer getCantidadDetalleCrono() {
        return this.cantidadDetalleCrono;
    }
    
    public void setCantidadDetalleCrono(Integer cantidadDetalleCrono) {
        this.cantidadDetalleCrono = cantidadDetalleCrono;
    }
    public Double getCostoUnitarioDetalleCrono() {
        return this.costoUnitarioDetalleCrono;
    }
    
    public void setCostoUnitarioDetalleCrono(Double costoUnitarioDetalleCrono) {
        this.costoUnitarioDetalleCrono = costoUnitarioDetalleCrono;
    }
    public Double getCostoTotalDetalleCrono() {
        return this.costoTotalDetalleCrono;
    }
    
    public void setCostoTotalDetalleCrono(Double costoTotalDetalleCrono) {
        this.costoTotalDetalleCrono = costoTotalDetalleCrono;
    }
    public Set getCronogramas() {
        return this.cronogramas;
    }
    
    public void setCronogramas(Set cronogramas) {
        this.cronogramas = cronogramas;
    }




}


