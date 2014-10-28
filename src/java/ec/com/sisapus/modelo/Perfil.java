package ec.com.sisapus.modelo;
// Generated 24/03/2014 10:48:04 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Perfil generated by hbm2java
 */
public class Perfil  implements java.io.Serializable {


     private Integer codigoPerf;
     private String descripPerf;
     private Boolean modProyecto;
     private Boolean modProyectos;
     private Boolean modRecursos;
     private Boolean modRubro;
     private Boolean modMateriales;
     private Boolean modEquiherr;
     private Boolean modManoobra;
     private Boolean modTransporte;
     private Boolean modAnalcosto;
     private Boolean modApu;
     private Boolean modPresup;
     private Boolean modCronograma;
     private Boolean modReajprec;
     private Boolean modEjecpresup;
     private Boolean modReportes;
     private Boolean modRepestadist;
     private Boolean modRepapu;
     private Boolean modReppresup;
     private Boolean modRepcronog;
     private Boolean modReppartida;
     private Boolean modReprubro;
     private Boolean modRepejecpres;
     private Boolean modSeguridad;
     private Boolean modUsuario;
     private Boolean modPerfil;
     private Boolean modRegusu;
     private Set<Usuario> usuarios = new HashSet<Usuario>(0);

    public Perfil() {
        this.codigoPerf = 0;
    }

    public Perfil(String descripPerf, Boolean modProyecto, Boolean modProyectos, Boolean modRecursos, Boolean modRubro, Boolean modMateriales, Boolean modEquiherr, Boolean modManoobra, Boolean modTransporte, Boolean modAnalcosto, Boolean modApu, Boolean modPresup, Boolean modCronograma, Boolean modReajprec, Boolean modEjecpresup, Boolean modReportes, Boolean modRepestadist, Boolean modRepapu, Boolean modReppresup, Boolean modRepcronog, Boolean modReppartida, Boolean modReprubro, Boolean modRepejecpres, Boolean modSeguridad, Boolean modUsuario, Boolean modPerfil, Boolean modRegusu, Set<Usuario> usuarios) {
       this.descripPerf = descripPerf;
       this.modProyecto = modProyecto;
       this.modProyectos = modProyectos;
       this.modRecursos = modRecursos;
       this.modRubro = modRubro;
       this.modMateriales = modMateriales;
       this.modEquiherr = modEquiherr;
       this.modManoobra = modManoobra;
       this.modTransporte = modTransporte;
       this.modAnalcosto = modAnalcosto;
       this.modApu = modApu;
       this.modPresup = modPresup;
       this.modCronograma = modCronograma;
       this.modReajprec = modReajprec;
       this.modEjecpresup = modEjecpresup;
       this.modReportes = modReportes;
       this.modRepestadist = modRepestadist;
       this.modRepapu = modRepapu;
       this.modReppresup = modReppresup;
       this.modRepcronog = modRepcronog;
       this.modReppartida = modReppartida;
       this.modReprubro = modReprubro;
       this.modRepejecpres = modRepejecpres;
       this.modSeguridad = modSeguridad;
       this.modUsuario = modUsuario;
       this.modPerfil = modPerfil;
       this.modRegusu = modRegusu;
       this.usuarios = usuarios;
    }
   
    public Integer getCodigoPerf() {
        return this.codigoPerf;
    }
    
    public void setCodigoPerf(Integer codigoPerf) {
        this.codigoPerf = codigoPerf;
    }
    public String getDescripPerf() {
        return this.descripPerf;
    }
    
    public void setDescripPerf(String descripPerf) {
        this.descripPerf = descripPerf;
    }
    public Boolean getModProyecto() {
        return this.modProyecto;
    }
    
    public void setModProyecto(Boolean modProyecto) {
        this.modProyecto = modProyecto;
    }
    public Boolean getModProyectos() {
        return this.modProyectos;
    }
    
    public void setModProyectos(Boolean modProyectos) {
        this.modProyectos = modProyectos;
    }
    public Boolean getModRecursos() {
        return this.modRecursos;
    }
    
    public void setModRecursos(Boolean modRecursos) {
        this.modRecursos = modRecursos;
    }
    public Boolean getModRubro() {
        return this.modRubro;
    }
    
    public void setModRubro(Boolean modRubro) {
        this.modRubro = modRubro;
    }
    public Boolean getModMateriales() {
        return this.modMateriales;
    }
    
    public void setModMateriales(Boolean modMateriales) {
        this.modMateriales = modMateriales;
    }
    public Boolean getModEquiherr() {
        return this.modEquiherr;
    }
    
    public void setModEquiherr(Boolean modEquiherr) {
        this.modEquiherr = modEquiherr;
    }
    public Boolean getModManoobra() {
        return this.modManoobra;
    }
    
    public void setModManoobra(Boolean modManoobra) {
        this.modManoobra = modManoobra;
    }
    public Boolean getModTransporte() {
        return this.modTransporte;
    }
    
    public void setModTransporte(Boolean modTransporte) {
        this.modTransporte = modTransporte;
    }
    public Boolean getModAnalcosto() {
        return this.modAnalcosto;
    }
    
    public void setModAnalcosto(Boolean modAnalcosto) {
        this.modAnalcosto = modAnalcosto;
    }
    public Boolean getModApu() {
        return this.modApu;
    }
    
    public void setModApu(Boolean modApu) {
        this.modApu = modApu;
    }
    public Boolean getModPresup() {
        return this.modPresup;
    }
    
    public void setModPresup(Boolean modPresup) {
        this.modPresup = modPresup;
    }
    public Boolean getModCronograma() {
        return this.modCronograma;
    }
    
    public void setModCronograma(Boolean modCronograma) {
        this.modCronograma = modCronograma;
    }
    public Boolean getModReajprec() {
        return this.modReajprec;
    }
    
    public void setModReajprec(Boolean modReajprec) {
        this.modReajprec = modReajprec;
    }
    public Boolean getModEjecpresup() {
        return this.modEjecpresup;
    }
    
    public void setModEjecpresup(Boolean modEjecpresup) {
        this.modEjecpresup = modEjecpresup;
    }
    public Boolean getModReportes() {
        return this.modReportes;
    }
    
    public void setModReportes(Boolean modReportes) {
        this.modReportes = modReportes;
    }
    public Boolean getModRepestadist() {
        return this.modRepestadist;
    }
    
    public void setModRepestadist(Boolean modRepestadist) {
        this.modRepestadist = modRepestadist;
    }
    public Boolean getModRepapu() {
        return this.modRepapu;
    }
    
    public void setModRepapu(Boolean modRepapu) {
        this.modRepapu = modRepapu;
    }
    public Boolean getModReppresup() {
        return this.modReppresup;
    }
    
    public void setModReppresup(Boolean modReppresup) {
        this.modReppresup = modReppresup;
    }
    public Boolean getModRepcronog() {
        return this.modRepcronog;
    }
    
    public void setModRepcronog(Boolean modRepcronog) {
        this.modRepcronog = modRepcronog;
    }
    public Boolean getModReppartida() {
        return this.modReppartida;
    }
    
    public void setModReppartida(Boolean modReppartida) {
        this.modReppartida = modReppartida;
    }
    public Boolean getModReprubro() {
        return this.modReprubro;
    }
    
    public void setModReprubro(Boolean modReprubro) {
        this.modReprubro = modReprubro;
    }
    public Boolean getModRepejecpres() {
        return this.modRepejecpres;
    }
    
    public void setModRepejecpres(Boolean modRepejecpres) {
        this.modRepejecpres = modRepejecpres;
    }
    public Boolean getModSeguridad() {
        return this.modSeguridad;
    }
    
    public void setModSeguridad(Boolean modSeguridad) {
        this.modSeguridad = modSeguridad;
    }
    public Boolean getModUsuario() {
        return this.modUsuario;
    }
    
    public void setModUsuario(Boolean modUsuario) {
        this.modUsuario = modUsuario;
    }
    public Boolean getModPerfil() {
        return this.modPerfil;
    }
    
    public void setModPerfil(Boolean modPerfil) {
        this.modPerfil = modPerfil;
    }
    public Boolean getModRegusu() {
        return this.modRegusu;
    }
    
    public void setModRegusu(Boolean modRegusu) {
        this.modRegusu = modRegusu;
    }
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }




}


