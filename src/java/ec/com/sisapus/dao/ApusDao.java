/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.dao;

import org.hibernate.Session;
import ec.com.sisapus.modelo.EquipherrApu;
import ec.com.sisapus.modelo.ManoobraApu;
import ec.com.sisapus.modelo.MaterialApu;
import ec.com.sisapus.modelo.TransporteApu;
import ec.com.sisapus.modelo.Analisispreciounitario;
/**
 *
 * @author kleber
 */
public interface ApusDao {
    //insertar equiposapus
     public boolean insert(Session session, EquipherrApu equipherrapu) throws Exception;
    public EquipherrApu getByIdEquipoAPU(Session session, Integer idequipoapu) throws Exception;
       public EquipherrApu getUltimoRegistroEqApu(Session session) throws Exception;
     
     
    //insertar mano de obra apus
      public boolean insertarManobra(Session session,ManoobraApu manapu) throws Exception;
         //insertar material apus
      public boolean insertarMaterial(Session session,MaterialApu mateapu) throws Exception; 
      //insertar transporte
      public boolean insertarTransporte(Session session,TransporteApu transapu) throws Exception;
     public boolean insertarAPU(Session session,Analisispreciounitario apu) throws Exception; 
}
