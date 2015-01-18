package ec.com.sisapus.modelo;
// Generated 18/01/2015 06:23:43 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Rubro generated by hbm2java
 */
public class Rubro  implements java.io.Serializable {


     private Integer codigoRubro;
     private Categoriarubro categoriarubro;
     private String nombreRubro;
     private String detalleRubro;
     private String unidadRubro;
     private Set analisispreciounitarios = new HashSet(0);

    public Rubro() {
    }

    public Rubro(Categoriarubro categoriarubro, String nombreRubro, String detalleRubro, String unidadRubro, Set analisispreciounitarios) {
       this.categoriarubro = categoriarubro;
       this.nombreRubro = nombreRubro;
       this.detalleRubro = detalleRubro;
       this.unidadRubro = unidadRubro;
       this.analisispreciounitarios = analisispreciounitarios;
    }
   
    public Integer getCodigoRubro() {
        return this.codigoRubro;
    }
    
    public void setCodigoRubro(Integer codigoRubro) {
        this.codigoRubro = codigoRubro;
    }
    public Categoriarubro getCategoriarubro() {
        return this.categoriarubro;
    }
    
    public void setCategoriarubro(Categoriarubro categoriarubro) {
        this.categoriarubro = categoriarubro;
    }
    public String getNombreRubro() {
        return this.nombreRubro;
    }
    
    public void setNombreRubro(String nombreRubro) {
        this.nombreRubro = nombreRubro;
    }
    public String getDetalleRubro() {
        return this.detalleRubro;
    }
    
    public void setDetalleRubro(String detalleRubro) {
        this.detalleRubro = detalleRubro;
    }
    public String getUnidadRubro() {
        return this.unidadRubro;
    }
    
    public void setUnidadRubro(String unidadRubro) {
        this.unidadRubro = unidadRubro;
    }
    public Set getAnalisispreciounitarios() {
        return this.analisispreciounitarios;
    }
    
    public void setAnalisispreciounitarios(Set analisispreciounitarios) {
        this.analisispreciounitarios = analisispreciounitarios;
    }




}


