package ec.com.sisapus.modelo;
// Generated 18/12/2014 06:11:00 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * MaterialApu generated by hbm2java
 */
public class MaterialApu  implements java.io.Serializable {


     private Integer codMatApu;
     private Material material;
     private String descMatApu;
     private String unidMatApu;
     private Integer cantMatApu;
     private Double preunitMatApu;
     private Double costotMatApu;
     private Set analisispreciounitarios = new HashSet(0);

    public MaterialApu() {
        this.codMatApu = 0;
        this.material = new Material();
    }

    public MaterialApu(Material material, String descMatApu, String unidMatApu, Integer cantMatApu, Double preunitMatApu, Double costotMatApu, Set analisispreciounitarios) {
       this.material = material;
       this.descMatApu = descMatApu;
       this.unidMatApu = unidMatApu;
       this.cantMatApu = cantMatApu;
       this.preunitMatApu = preunitMatApu;
       this.costotMatApu = costotMatApu;
       this.analisispreciounitarios = analisispreciounitarios;
    }
   
    public Integer getCodMatApu() {
        return this.codMatApu;
    }
    
    public void setCodMatApu(Integer codMatApu) {
        this.codMatApu = codMatApu;
    }
    public Material getMaterial() {
        return this.material;
    }
    
    public void setMaterial(Material material) {
        this.material = material;
    }
    public String getDescMatApu() {
        return this.descMatApu;
    }
    
    public void setDescMatApu(String descMatApu) {
        this.descMatApu = descMatApu;
    }
    public String getUnidMatApu() {
        return this.unidMatApu;
    }
    
    public void setUnidMatApu(String unidMatApu) {
        this.unidMatApu = unidMatApu;
    }
    public Integer getCantMatApu() {
        return this.cantMatApu;
    }
    
    public void setCantMatApu(Integer cantMatApu) {
        this.cantMatApu = cantMatApu;
    }
    public Double getPreunitMatApu() {
        return this.preunitMatApu;
    }
    
    public void setPreunitMatApu(Double preunitMatApu) {
        this.preunitMatApu = preunitMatApu;
    }
    public Double getCostotMatApu() {
        return this.costotMatApu;
    }
    
    public void setCostotMatApu(Double costotMatApu) {
        this.costotMatApu = costotMatApu;
    }
    public Set getAnalisispreciounitarios() {
        return this.analisispreciounitarios;
    }
    
    public void setAnalisispreciounitarios(Set analisispreciounitarios) {
        this.analisispreciounitarios = analisispreciounitarios;
    }




}


