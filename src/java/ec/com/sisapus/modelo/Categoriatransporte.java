package ec.com.sisapus.modelo;
// Generated 06/01/2015 02:17:13 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Categoriatransporte generated by hbm2java
 */
public class Categoriatransporte  implements java.io.Serializable {


     private Integer codCatTrans;
     private String nombCatTrans;
     private Set transportes = new HashSet(0);

    public Categoriatransporte() {
    }

    public Categoriatransporte(String nombCatTrans, Set transportes) {
       this.nombCatTrans = nombCatTrans;
       this.transportes = transportes;
    }
   
    public Integer getCodCatTrans() {
        return this.codCatTrans;
    }
    
    public void setCodCatTrans(Integer codCatTrans) {
        this.codCatTrans = codCatTrans;
    }
    public String getNombCatTrans() {
        return this.nombCatTrans;
    }
    
    public void setNombCatTrans(String nombCatTrans) {
        this.nombCatTrans = nombCatTrans;
    }
    public Set getTransportes() {
        return this.transportes;
    }
    
    public void setTransportes(Set transportes) {
        this.transportes = transportes;
    }




}


