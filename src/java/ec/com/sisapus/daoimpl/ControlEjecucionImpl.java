/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.daoimpl;

import ec.com.sisapus.dao.ControlEjecucionDao;
import ec.com.sisapus.modelo.ControlEjecutadoPresupuestado;
import java.util.List;
import org.hibernate.Session;


public class ControlEjecucionImpl implements ControlEjecucionDao {

    @Override
    public List<ControlEjecutadoPresupuestado> listaproyectosejecucion(Session session) throws Exception {
           return session.createCriteria(ControlEjecucionDao.class).list(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
