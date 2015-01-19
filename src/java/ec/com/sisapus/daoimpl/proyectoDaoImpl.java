/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.daoimpl;

import ec.com.sisapus.dao.proyectoDao;
import ec.com.sisapus.modelo.Proyecto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author kleber
 */
public class proyectoDaoImpl implements proyectoDao {

    @Override
    public boolean guardarproyecto(Session session, Proyecto proyecto) throws Exception {
        session.save(proyecto);
        return true; 
    }

    @Override
    public List<Proyecto> getbyUsuarioProyecto(Session session, String sobre) throws Exception {
        String hql = "select p from Proyecto p where p.usuario.sobrenombreUsu=:sobre";
        Query query = session.createQuery(hql);
        query.setParameter("sobre", sobre);

        List<Proyecto> listaproyecto = (List<Proyecto>) query.list();

        return listaproyecto; 
    }

    @Override
    public boolean actualizarproyecto(Session session, Proyecto proyecto) throws Exception {
        session.update(proyecto);

        return true; 
    }

    @Override
    public boolean eliminarproyecto(Session session, Integer idproyecto) throws Exception {
        Proyecto proyecto = (Proyecto) session.load(Proyecto.class, idproyecto);
        session.delete(proyecto);
        return true;
    }

    @Override
    public Proyecto obtenerProyectoPorId(Session session, Integer idProyecto) throws Exception {
        return (Proyecto) session.load(Proyecto.class, idProyecto);
    }
}
