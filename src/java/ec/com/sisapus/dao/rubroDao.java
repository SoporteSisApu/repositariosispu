/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.dao;

import ec.com.sisapus.modelo.Rubro;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author kleber
 */
public interface rubroDao {
        public boolean guardarrubro(Session session, Rubro rubro)throws Exception;
         public List<Rubro> getbyUsuarioRubro(Session session,String sobre)throws Exception;
         public boolean actualizarrubro(Session session, Rubro rubro)throws Exception;
         public boolean eliminarrubro(Session session, Integer idrubro)throws Exception;
           public Rubro obtenerrubroPorId(Session session, Integer idrubro) throws Exception;
            public List<Rubro> listartodosRubros(Session session)throws Exception;
              //agregado
    public Rubro getByIdRubro(Session session, Integer idrubro) throws Exception;
    public Rubro getUltimoRegistroRubro(Session session) throws Exception;
    
}
