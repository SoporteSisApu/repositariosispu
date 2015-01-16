
package ec.com.sisapus.dao;

import ec.com.sisapus.modelo.Usuario;
import java.util.List;
import org.hibernate.Session;

public interface usuarioDao1 {
     /**
     *
     * @param session
     * @param usuario
     * @return
     * @throws Exception
     */
    public boolean register(Session session, Usuario usuario)throws Exception;
    public List<Usuario> getAll(Session session)throws Exception;
    public Usuario getByCodigoUsuario(Session session, int codigoUsuario)throws Exception;
    public Usuario getBySobrenombreusu(Session session, String sobre)throws Exception;
    
}
