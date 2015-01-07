package ec.com.sisapus.modelo;
// Generated 07/01/2015 01:13:46 PM by Hibernate Tools 3.2.1.GA



/**
 * Detallecronograma generated by hbm2java
 */
public class Detallecronograma  implements java.io.Serializable {


     private Integer codigoDetalleCronograma;
     private Cronograma cronograma;
     private String descripcionDetalleCrono;
     private Integer cantidadDetalleCrono;
     private Double costoUnitarioDetalleCrono;
     private Double costoTotalDetalleCrono;

    public Detallecronograma() {
    }

    public Detallecronograma(Cronograma cronograma, String descripcionDetalleCrono, Integer cantidadDetalleCrono, Double costoUnitarioDetalleCrono, Double costoTotalDetalleCrono) {
       this.cronograma = cronograma;
       this.descripcionDetalleCrono = descripcionDetalleCrono;
       this.cantidadDetalleCrono = cantidadDetalleCrono;
       this.costoUnitarioDetalleCrono = costoUnitarioDetalleCrono;
       this.costoTotalDetalleCrono = costoTotalDetalleCrono;
    }
   
    public Integer getCodigoDetalleCronograma() {
        return this.codigoDetalleCronograma;
    }
    
    public void setCodigoDetalleCronograma(Integer codigoDetalleCronograma) {
        this.codigoDetalleCronograma = codigoDetalleCronograma;
    }
    public Cronograma getCronograma() {
        return this.cronograma;
    }
    
    public void setCronograma(Cronograma cronograma) {
        this.cronograma = cronograma;
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




}


