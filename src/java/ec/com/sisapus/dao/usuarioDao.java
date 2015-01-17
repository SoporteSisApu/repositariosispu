package ec.com.sisapus.dao;

import ec.com.sisapus.modelo.Usuario;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Edison
 */
public interface usuarioDao {
///Metodo Validacion Usuario
    public Usuario buscarPorUsuario(Usuario usuario);
    public Usuario buscarPorcodigoUsuario(Usuario usuario);
       //buscar por sobrenombre
    public Usuario buscarPorsobreUsuario(String sobrenombre);   
       
///MetodosCrud Usuario
    public List<Usuario> buscarTodosUsu();
    public boolean crearUsu(Usuario usuario);
    public boolean actualizarUsu(Usuario usuario);
    public boolean eliminarUsu(Integer idUs);
    public boolean regisUsu(Usuario usuario);
   
    public void registrarUsuario(String nombre, String apellido, String sobrenom, String contrasenia, String correo );
  
    //nuev
    
      public boolean register(Session session, Usuario usuario)throws Exception;
    public List<Usuario> getAll(Session session)throws Exception;
    public Usuario getByCodigoUsuario(Session session, int codigoUsuario)throws Exception;
    public Usuario getBySobrenombreusu(Session session, String sobre)throws Exception;
    
}
