package ec.com.sisapus.modelo;
// Generated 06/01/2015 11:20:58 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Analisispreciounitario generated by hbm2java
 */
public class Analisispreciounitario  implements java.io.Serializable {


     private Integer codigoApu;
     private TransporteApu transporteApu;
     private Rubro rubro;
     private MaterialApu materialApu;
     private ManoobraApu manoobraApu;
     private EquipherrApu equipherrApu;
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
     private Set escenarioapus = new HashSet(0);

    public Analisispreciounitario() {
         this.codigoApu = 0;
        this.transporteApu = new TransporteApu();
      //  this.categoriapreciounitario=new Categoriapreciounitario();
        this.rubro=new Rubro();
         this.materialApu=new MaterialApu();
          this.manoobraApu=new ManoobraApu();
           this.equipherrApu=new EquipherrApu();
    }

    public Analisispreciounitario(TransporteApu transporteApu, Rubro rubro, MaterialApu materialApu, ManoobraApu manoobraApu, EquipherrApu equipherrApu, String descApu, String unidadApu, String categoriaApu, Double analApuMat, Double analApuEqherr, Double analApuMob, Double analApuTran, Double costDirApu, Double costIndApu, Double costOtrosIndApu, Double costotApu, Double rendApu, Double porcenIndApu, Set presupuestos, Set escenarioapus) {
       this.transporteApu = transporteApu;
       this.rubro = rubro;
       this.materialApu = materialApu;
       this.manoobraApu = manoobraApu;
       this.equipherrApu = equipherrApu;
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
       this.escenarioapus = escenarioapus;
    }
   
    public Integer getCodigoApu() {
        return this.codigoApu;
    }
    
    public void setCodigoApu(Integer codigoApu) {
        this.codigoApu = codigoApu;
    }
    public TransporteApu getTransporteApu() {
        return this.transporteApu;
    }
    
    public void setTransporteApu(TransporteApu transporteApu) {
        this.transporteApu = transporteApu;
    }
    public Rubro getRubro() {
        return this.rubro;
    }
    
    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }
    public MaterialApu getMaterialApu() {
        return this.materialApu;
    }
    
    public void setMaterialApu(MaterialApu materialApu) {
        this.materialApu = materialApu;
    }
    public ManoobraApu getManoobraApu() {
        return this.manoobraApu;
    }
    
    public void setManoobraApu(ManoobraApu manoobraApu) {
        this.manoobraApu = manoobraApu;
    }
    public EquipherrApu getEquipherrApu() {
        return this.equipherrApu;
    }
    
    public void setEquipherrApu(EquipherrApu equipherrApu) {
        this.equipherrApu = equipherrApu;
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
    public Set getEscenarioapus() {
        return this.escenarioapus;
    }
    
    public void setEscenarioapus(Set escenarioapus) {
        this.escenarioapus = escenarioapus;
    }




}


