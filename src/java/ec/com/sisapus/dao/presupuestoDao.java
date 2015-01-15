/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.dao;

import ec.com.sisapus.modelo.CabeceraPresupuesto;
import ec.com.sisapus.modelo.DetallePresupuesto;
import org.hibernate.Session;

/**
 *
 * @author Edison
 */
public interface presupuestoDao {
    
    public boolean insertaCabeceraPres(Session session, CabeceraPresupuesto cabpres) throws Exception;
    public boolean insertaDetallePres(Session session, DetallePresupuesto detpres) throws Exception;
    public CabeceraPresupuesto obtenerCabPres(Session session, Integer idcabpres) throws Exception;
    public CabeceraPresupuesto obtenerUltimoRegistroCabPres(Session session) throws Exception;
    public DetallePresupuesto obtenerDetPres(Session session, Integer iddetpres) throws Exception;
    public DetallePresupuesto obtenerUltimoRegistroDetPres(Session session) throws Exception;
}
