/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.daoimpl;

import ec.com.sisapus.dao.presupuestoDao;
import ec.com.sisapus.modelo.CabeceraPresupuesto;
import ec.com.sisapus.modelo.DetallePresupuesto;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Edison
 */
public class presupuestoDaoImpl implements presupuestoDao{

    @Override
    public boolean insertaCabeceraPres(Session session, CabeceraPresupuesto cabpres) throws Exception {
        session.save(cabpres);
        return true;
    }

    @Override
    public boolean insertaDetallePres(Session session, DetallePresupuesto detpres) throws Exception {
        session.save(detpres);
        return true;
    }

    @Override
    public CabeceraPresupuesto obtenerCabPres(Session session, Integer idcabpres) throws Exception {
        return (CabeceraPresupuesto) session.load(CabeceraPresupuesto.class, idcabpres);
    }

    @Override
    public CabeceraPresupuesto obtenerUltimoRegistroCabPres(Session session) throws Exception {
        String hql="from CabeceraPresupuesto order by codigoPres desc";
        Query query=session.createQuery(hql).setMaxResults(1);
        return (CabeceraPresupuesto) query.uniqueResult();
    }

    @Override
    public DetallePresupuesto obtenerDetPres(Session session, Integer iddetpres) throws Exception {
        return (DetallePresupuesto) session.load(DetallePresupuesto.class, iddetpres);
    }

    @Override
    public DetallePresupuesto obtenerUltimoRegistroDetPres(Session session) throws Exception {
        String hql="from DetallePresupuesto order by codigoDetPres desc";
        Query query=session.createQuery(hql).setMaxResults(1);
        return (DetallePresupuesto) query.uniqueResult();
    }

    
    
}
