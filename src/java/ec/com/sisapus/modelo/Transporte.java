package ec.com.sisapus.modelo;
// Generated 18/01/2015 06:23:43 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Transporte generated by hbm2java
 */
public class Transporte  implements java.io.Serializable {


     private Integer codigoTransp;
     private Categoriatransporte categoriatransporte;
     private String nombreTransp;
     private Double tarifaTransp;
     private Set transporteApus = new HashSet(0);

    public Transporte() {
        this.codigoTransp = 0;
        this.categoriatransporte = new Categoriatransporte();
    }

    public Transporte(Categoriatransporte categoriatransporte, String nombreTransp, Double tarifaTransp, Set transporteApus) {
       this.categoriatransporte = categoriatransporte;
       this.nombreTransp = nombreTransp;
       this.tarifaTransp = tarifaTransp;
       this.transporteApus = transporteApus;
    }
   
    public Integer getCodigoTransp() {
        return this.codigoTransp;
    }
    
    public void setCodigoTransp(Integer codigoTransp) {
        this.codigoTransp = codigoTransp;
    }
    public Categoriatransporte getCategoriatransporte() {
        return this.categoriatransporte;
    }
    
    public void setCategoriatransporte(Categoriatransporte categoriatransporte) {
        this.categoriatransporte = categoriatransporte;
    }
    public String getNombreTransp() {
        return this.nombreTransp;
    }
    
    public void setNombreTransp(String nombreTransp) {
        this.nombreTransp = nombreTransp;
    }
    public Double getTarifaTransp() {
        return this.tarifaTransp;
    }
    
    public void setTarifaTransp(Double tarifaTransp) {
        this.tarifaTransp = tarifaTransp;
    }
    public Set getTransporteApus() {
        return this.transporteApus;
    }
    
    public void setTransporteApus(Set transporteApus) {
        this.transporteApus = transporteApus;
    }




}


