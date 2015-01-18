package ec.com.sisapus.modelo;
// Generated 18/01/2015 05:06:35 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Proyecto generated by hbm2java
 */
public class Proyecto  implements java.io.Serializable {


     private Integer codigoProy;
     private Usuario usuario;
     private String propiepProy;
     private String contratProy;
     private String obraProy;
     private String ubicProy;
     private Date fechaProy;
     private Double costotProy;
     private Set cronogramas = new HashSet(0);
     private Set controlEjecutadoPresupuestados = new HashSet(0);
     private Set cabeceraPresupuestos = new HashSet(0);

    public Proyecto() {
          this.codigoProy = 0;
        this.usuario = new Usuario();
    }

    public Proyecto(Usuario usuario, String propiepProy, String contratProy, String obraProy, String ubicProy, Date fechaProy, Double costotProy, Set cronogramas, Set controlEjecutadoPresupuestados, Set cabeceraPresupuestos) {
       this.usuario = usuario;
       this.propiepProy = propiepProy;
       this.contratProy = contratProy;
       this.obraProy = obraProy;
       this.ubicProy = ubicProy;
       this.fechaProy = fechaProy;
       this.costotProy = costotProy;
       this.cronogramas = cronogramas;
       this.controlEjecutadoPresupuestados = controlEjecutadoPresupuestados;
       this.cabeceraPresupuestos = cabeceraPresupuestos;
    }
   
    public Integer getCodigoProy() {
        return this.codigoProy;
    }
    
    public void setCodigoProy(Integer codigoProy) {
        this.codigoProy = codigoProy;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getPropiepProy() {
        return this.propiepProy;
    }
    
    public void setPropiepProy(String propiepProy) {
        this.propiepProy = propiepProy;
    }
    public String getContratProy() {
        return this.contratProy;
    }
    
    public void setContratProy(String contratProy) {
        this.contratProy = contratProy;
    }
    public String getObraProy() {
        return this.obraProy;
    }
    
    public void setObraProy(String obraProy) {
        this.obraProy = obraProy;
    }
    public String getUbicProy() {
        return this.ubicProy;
    }
    
    public void setUbicProy(String ubicProy) {
        this.ubicProy = ubicProy;
    }
    public Date getFechaProy() {
        return this.fechaProy;
    }
    
    public void setFechaProy(Date fechaProy) {
        this.fechaProy = fechaProy;
    }
    public Double getCostotProy() {
        return this.costotProy;
    }
    
    public void setCostotProy(Double costotProy) {
        this.costotProy = costotProy;
    }
    public Set getCronogramas() {
        return this.cronogramas;
    }
    
    public void setCronogramas(Set cronogramas) {
        this.cronogramas = cronogramas;
    }
    public Set getControlEjecutadoPresupuestados() {
        return this.controlEjecutadoPresupuestados;
    }
    
    public void setControlEjecutadoPresupuestados(Set controlEjecutadoPresupuestados) {
        this.controlEjecutadoPresupuestados = controlEjecutadoPresupuestados;
    }
    public Set getCabeceraPresupuestos() {
        return this.cabeceraPresupuestos;
    }
    
    public void setCabeceraPresupuestos(Set cabeceraPresupuestos) {
        this.cabeceraPresupuestos = cabeceraPresupuestos;
    }




}


