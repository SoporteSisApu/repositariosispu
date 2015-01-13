/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.daoimpl;

import ec.com.sisapus.dao.ControlEjecucionDao;
import ec.com.sisapus.modelo.ControlEjecutadoPresupuestado;
import ec.com.sisapus.modelo.Proyecto;
import ec.com.sisapus.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;


public class ControlEjecucionImpl implements ControlEjecucionDao {

    @Override
    public List<ControlEjecutadoPresupuestado> listaproyectosejecucion()  {
   List<ControlEjecutadoPresupuestado> listado = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "from ControlEjecutadoPresupuestado";
        //String sql = "from Proyecto p inner join p.usuario u WHERE u.sobrenombreUsu=";
     
        //Query query=sesion.createQuery(sql);
        try {
            sesion.beginTransaction();
          //  query.setString("sobre",sobre);
            listado = sesion.createQuery(sql).list();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }

        return listado;
    }

   
    
    
}
