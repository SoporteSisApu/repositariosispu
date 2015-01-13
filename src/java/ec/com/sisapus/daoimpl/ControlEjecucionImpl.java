/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.daoimpl;

import ec.com.sisapus.dao.ControlEjecucion;
import ec.com.sisapus.modelo.ControlEjecutadoPresupuestado;
import java.util.List;
import org.hibernate.Session;


public class ControlEjecucionImpl implements ControlEjecucion {

    @Override
    public List<ControlEjecutadoPresupuestado> listaproyectosejecucion(Session session) throws Exception {
           return session.createCriteria(ControlEjecucion.class).list(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
