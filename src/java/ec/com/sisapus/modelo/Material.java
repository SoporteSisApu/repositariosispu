package ec.com.sisapus.modelo;
// Generated 14/01/2015 12:31:40 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Material generated by hbm2java
 */
public class Material  implements java.io.Serializable {


     private Integer codigoMat;
     private Categoriamaterial categoriamaterial;
     private String nombreMat;
     private String unidMat;
     private Double precunitMat;
     private Set materialApus = new HashSet(0);

    public Material() {
         this.codigoMat = 0;
        this.categoriamaterial = new Categoriamaterial();

    }

    public Material(Categoriamaterial categoriamaterial, String nombreMat, String unidMat, Double precunitMat, Set materialApus) {
       this.categoriamaterial = categoriamaterial;
       this.nombreMat = nombreMat;
       this.unidMat = unidMat;
       this.precunitMat = precunitMat;
       this.materialApus = materialApus;
    }
   
    public Integer getCodigoMat() {
        return this.codigoMat;
    }
    
    public void setCodigoMat(Integer codigoMat) {
        this.codigoMat = codigoMat;
    }
    public Categoriamaterial getCategoriamaterial() {
        return this.categoriamaterial;
    }
    
    public void setCategoriamaterial(Categoriamaterial categoriamaterial) {
        this.categoriamaterial = categoriamaterial;
    }
    public String getNombreMat() {
        return this.nombreMat;
    }
    
    public void setNombreMat(String nombreMat) {
        this.nombreMat = nombreMat;
    }
    public String getUnidMat() {
        return this.unidMat;
    }
    
    public void setUnidMat(String unidMat) {
        this.unidMat = unidMat;
    }
    public Double getPrecunitMat() {
        return this.precunitMat;
    }
    
    public void setPrecunitMat(Double precunitMat) {
        this.precunitMat = precunitMat;
    }
    public Set getMaterialApus() {
        return this.materialApus;
    }
    
    public void setMaterialApus(Set materialApus) {
        this.materialApus = materialApus;
    }




}


