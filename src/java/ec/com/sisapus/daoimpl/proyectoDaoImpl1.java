/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.daoimpl;

import ec.com.sisapus.dao.proyecto1Dao;
import ec.com.sisapus.modelo.Proyecto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author kleber
 */
public class proyectoDaoImpl1 implements proyecto1Dao {

    @Override
    public boolean guardarproyecto(Session session, Proyecto proyecto) throws Exception {
         session.save(proyecto);
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Proyecto> getbyUsuarioProyecto(Session session,String sobre) throws Exception {
          String hql="select p from Proyecto p where p.usuario.sobrenombreUsu=:sobre";
         Query query=session.createQuery(hql);
        query.setParameter("sobre",sobre);
        
        List<Proyecto> listaproyecto=(List<Proyecto>) query.list();
        
        return listaproyecto; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarproyecto(Session session, Proyecto proyecto) throws Exception {
         session.update(proyecto);
        
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarproyecto(Session session, Integer idproyecto) throws Exception {
       Proyecto proyecto = (Proyecto) session.load(Proyecto.class, idproyecto);
            session.delete(proyecto);
            return true;//To change body of generated methods, choose Tools | Templates.
    }
    
    
}
