package ec.com.sisapus.modelo;
// Generated 06/01/2015 02:17:13 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Analisispreciounitario generated by hbm2java
 */
public class Analisispreciounitario  implements java.io.Serializable {


     private Integer codigoApu;
     private Escenarioapu escenarioapu;
     private Rubro rubro;
     private String descApu;
     private String unidadApu;
     private String categoriaApu;
     private Double analApuMat;
     private Double analApuEqherr;
     private Double analApuMob;
     private Double analApuTran;
     private Double costDirApu;
     private Double costIndApu;
     private Double costOtrosIndApu;
     private Double costotApu;
     private Double rendApu;
     private Double porcenIndApu;
     private Set presupuestos = new HashSet(0);

    public Analisispreciounitario() {
        this.codigoApu = 0;
      this.escenarioapu=new Escenarioapu();
        this.rubro=new Rubro();
        
    }

    public Analisispreciounitario(Escenarioapu escenarioapu, Rubro rubro, String descApu, String unidadApu, String categoriaApu, Double analApuMat, Double analApuEqherr, Double analApuMob, Double analApuTran, Double costDirApu, Double costIndApu, Double costOtrosIndApu, Double costotApu, Double rendApu, Double porcenIndApu, Set presupuestos) {
       this.escenarioapu = escenarioapu;
       this.rubro = rubro;
       this.descApu = descApu;
       this.unidadApu = unidadApu;
       this.categoriaApu = categoriaApu;
       this.analApuMat = analApuMat;
       this.analApuEqherr = analApuEqherr;
       this.analApuMob = analApuMob;
       this.analApuTran = analApuTran;
       this.costDirApu = costDirApu;
       this.costIndApu = costIndApu;
       this.costOtrosIndApu = costOtrosIndApu;
       this.costotApu = costotApu;
       this.rendApu = rendApu;
       this.porcenIndApu = porcenIndApu;
       this.presupuestos = presupuestos;
    }
   
    public Integer getCodigoApu() {
        return this.codigoApu;
    }
    
    public void setCodigoApu(Integer codigoApu) {
        this.codigoApu = codigoApu;
    }
    public Escenarioapu getEscenarioapu() {
        return this.escenarioapu;
    }
    
    public void setEscenarioapu(Escenarioapu escenarioapu) {
        this.escenarioapu = escenarioapu;
    }
    public Rubro getRubro() {
        return this.rubro;
    }
    
    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }
    public String getDescApu() {
        return this.descApu;
    }
    
    public void setDescApu(String descApu) {
        this.descApu = descApu;
    }
    public String getUnidadApu() {
        return this.unidadApu;
    }
    
    public void setUnidadApu(String unidadApu) {
        this.unidadApu = unidadApu;
    }
    public String getCategoriaApu() {
        return this.categoriaApu;
    }
    
    public void setCategoriaApu(String categoriaApu) {
        this.categoriaApu = categoriaApu;
    }
    public Double getAnalApuMat() {
        return this.analApuMat;
    }
    
    public void setAnalApuMat(Double analApuMat) {
        this.analApuMat = analApuMat;
    }
    public Double getAnalApuEqherr() {
        return this.analApuEqherr;
    }
    
    public void setAnalApuEqherr(Double analApuEqherr) {
        this.analApuEqherr = analApuEqherr;
    }
    public Double getAnalApuMob() {
        return this.analApuMob;
    }
    
    public void setAnalApuMob(Double analApuMob) {
        this.analApuMob = analApuMob;
    }
    public Double getAnalApuTran() {
        return this.analApuTran;
    }
    
    public void setAnalApuTran(Double analApuTran) {
        this.analApuTran = analApuTran;
    }
    public Double getCostDirApu() {
        return this.costDirApu;
    }
    
    public void setCostDirApu(Double costDirApu) {
        this.costDirApu = costDirApu;
    }
    public Double getCostIndApu() {
        return this.costIndApu;
    }
    
    public void setCostIndApu(Double costIndApu) {
        this.costIndApu = costIndApu;
    }
    public Double getCostOtrosIndApu() {
        return this.costOtrosIndApu;
    }
    
    public void setCostOtrosIndApu(Double costOtrosIndApu) {
        this.costOtrosIndApu = costOtrosIndApu;
    }
    public Double getCostotApu() {
        return this.costotApu;
    }
    
    public void setCostotApu(Double costotApu) {
        this.costotApu = costotApu;
    }
    public Double getRendApu() {
        return this.rendApu;
    }
    
    public void setRendApu(Double rendApu) {
        this.rendApu = rendApu;
    }
    public Double getPorcenIndApu() {
        return this.porcenIndApu;
    }
    
    public void setPorcenIndApu(Double porcenIndApu) {
        this.porcenIndApu = porcenIndApu;
    }
    public Set getPresupuestos() {
        return this.presupuestos;
    }
    
    public void setPresupuestos(Set presupuestos) {
        this.presupuestos = presupuestos;
    }




}


