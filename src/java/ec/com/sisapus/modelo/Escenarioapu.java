package ec.com.sisapus.modelo;
// Generated 18/12/2014 06:11:00 PM by Hibernate Tools 3.2.1.GA



/**
 * Escenarioapu generated by hbm2java
 */
public class Escenarioapu  implements java.io.Serializable {


     private Integer codigoEscenario;
     private Analisispreciounitario analisispreciounitario;
     private String nombreEscenario;

    public Escenarioapu() {
        this.codigoEscenario=0;
    }

    public Escenarioapu(Analisispreciounitario analisispreciounitario, String nombreEscenario) {
       this.analisispreciounitario = analisispreciounitario;
       this.nombreEscenario = nombreEscenario;
    }
   
    public Integer getCodigoEscenario() {
        return this.codigoEscenario;
    }
    
    public void setCodigoEscenario(Integer codigoEscenario) {
        this.codigoEscenario = codigoEscenario;
    }
    public Analisispreciounitario getAnalisispreciounitario() {
        return this.analisispreciounitario;
    }
    
    public void setAnalisispreciounitario(Analisispreciounitario analisispreciounitario) {
        this.analisispreciounitario = analisispreciounitario;
    }
    public String getNombreEscenario() {
        return this.nombreEscenario;
    }
    
    public void setNombreEscenario(String nombreEscenario) {
        this.nombreEscenario = nombreEscenario;
    }




}

