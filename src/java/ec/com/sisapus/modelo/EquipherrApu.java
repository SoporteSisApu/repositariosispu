package ec.com.sisapus.modelo;
// Generated 18/12/2014 06:11:00 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * EquipherrApu generated by hbm2java
 */
public class EquipherrApu  implements java.io.Serializable {


     private Integer codEqherrApu;
     private Equipoherramienta equipoherramienta;
     private String descEqherrApu;
     private Integer cantEqherrApu;
     private Double tarifaEqherrApu;
     private Double costohoraEqherrApu;
     private Double rendimEqherrApu;
     private Double costotEqherrApu;
     private Set analisispreciounitarios = new HashSet(0);

    public EquipherrApu() {
        this.codEqherrApu=0;
        this.equipoherramienta = new Equipoherramienta();
    }

    public EquipherrApu(Equipoherramienta equipoherramienta, String descEqherrApu, Integer cantEqherrApu, Double tarifaEqherrApu, Double costohoraEqherrApu, Double rendimEqherrApu, Double costotEqherrApu, Set analisispreciounitarios) {
       this.equipoherramienta = equipoherramienta;
       this.descEqherrApu = descEqherrApu;
       this.cantEqherrApu = cantEqherrApu;
       this.tarifaEqherrApu = tarifaEqherrApu;
       this.costohoraEqherrApu = costohoraEqherrApu;
       this.rendimEqherrApu = rendimEqherrApu;
       this.costotEqherrApu = costotEqherrApu;
       this.analisispreciounitarios = analisispreciounitarios;
    }
   
    public Integer getCodEqherrApu() {
        return this.codEqherrApu;
    }
    
    public void setCodEqherrApu(Integer codEqherrApu) {
        this.codEqherrApu = codEqherrApu;
    }
    public Equipoherramienta getEquipoherramienta() {
        return this.equipoherramienta;
    }
    
    public void setEquipoherramienta(Equipoherramienta equipoherramienta) {
        this.equipoherramienta = equipoherramienta;
    }
    public String getDescEqherrApu() {
        return this.descEqherrApu;
    }
    
    public void setDescEqherrApu(String descEqherrApu) {
        this.descEqherrApu = descEqherrApu;
    }
    public Integer getCantEqherrApu() {
        return this.cantEqherrApu;
    }
    
    public void setCantEqherrApu(Integer cantEqherrApu) {
        this.cantEqherrApu = cantEqherrApu;
    }
    public Double getTarifaEqherrApu() {
        return this.tarifaEqherrApu;
    }
    
    public void setTarifaEqherrApu(Double tarifaEqherrApu) {
        this.tarifaEqherrApu = tarifaEqherrApu;
    }
    public Double getCostohoraEqherrApu() {
        return this.costohoraEqherrApu;
    }
    
    public void setCostohoraEqherrApu(Double costohoraEqherrApu) {
        this.costohoraEqherrApu = costohoraEqherrApu;
    }
    public Double getRendimEqherrApu() {
        return this.rendimEqherrApu;
    }
    
    public void setRendimEqherrApu(Double rendimEqherrApu) {
        this.rendimEqherrApu = rendimEqherrApu;
    }
    public Double getCostotEqherrApu() {
        return this.costotEqherrApu;
    }
    
    public void setCostotEqherrApu(Double costotEqherrApu) {
        this.costotEqherrApu = costotEqherrApu;
    }
    public Set getAnalisispreciounitarios() {
        return this.analisispreciounitarios;
    }
    
    public void setAnalisispreciounitarios(Set analisispreciounitarios) {
        this.analisispreciounitarios = analisispreciounitarios;
    }




}


