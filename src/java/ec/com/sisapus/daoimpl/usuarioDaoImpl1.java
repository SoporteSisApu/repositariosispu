/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.daoimpl;

import ec.com.sisapus.dao.usuarioDao1;
import ec.com.sisapus.modelo.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author kleber
 */
public class usuarioDaoImpl1 implements usuarioDao1{

    @Override
    public boolean register(Session session, Usuario usuario) throws Exception {
        session.save(usuario);
        return true; 
    }

    @Override
    public List<Usuario> getAll(Session session) throws Exception {
        String hql="from Usuario";
        Query query=session.createQuery(hql);
        
        List<Usuario> listaTUsuario=(List<Usuario>) query.list();
        
        return listaTUsuario;
    }

    @Override
    public Usuario getByCodigoUsuario(Session session, int codigoUsuario) throws Exception {
        return (Usuario) session.get(Usuario.class, codigoUsuario);
    }

    @Override
    public Usuario getBySobrenombreusu(Session session, String sobre) throws Exception {
        String hql="from Usuario where sobrenombreUsu=:sobre and estadoUsu=1 ";
        Query query=session.createQuery(hql);
        query.setParameter("sobre", sobre);
        
        Usuario tUsuario=(Usuario) query.uniqueResult();
        
        return tUsuario; 
    }
    
}
