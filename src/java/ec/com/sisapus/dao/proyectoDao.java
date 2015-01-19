/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.dao;

import ec.com.sisapus.modelo.Proyecto;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author kleber
 */
public interface proyectoDao {

    public boolean guardarproyecto(Session session, Proyecto proyecto) throws Exception;

    public List<Proyecto> getbyUsuarioProyecto(Session session, String sobre) throws Exception;

    public boolean actualizarproyecto(Session session, Proyecto proyecto) throws Exception;

    public boolean eliminarproyecto(Session session, Integer idproyecto) throws Exception;

    public Proyecto obtenerProyectoPorId(Session session, Integer idProyecto) throws Exception;
}
