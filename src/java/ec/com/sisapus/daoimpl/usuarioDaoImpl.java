/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.daoimpl;

import ec.com.sisapus.dao.usuarioDao;
import ec.com.sisapus.modelo.Usuario;
import ec.com.sisapus.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Edison
 */
public class usuarioDaoImpl implements usuarioDao{

    @Override
    public Usuario buscarPorUsuario(Usuario usuario) {
     Session session = HibernateUtil.getSessionFactory().openSession();
     String sql="select  u  from Usuario u where SOBRENOMBRE_USU=:usuario and CONTRASENIA_USU=:clave and ESTADO_USU=1";
     Query query=session.createQuery(sql);
     query.setString("usuario", usuario.getSobrenombreUsu());
     query.setString("clave", usuario.getContraseniaUsu());
     return (Usuario) query.uniqueResult(); 
    }

    @Override
    public List<Usuario> buscarTodosUsu() {
        List<Usuario> listado = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "FROM Usuario u left join fetch u.perfil";
        try {
            sesion.beginTransaction();
            listado = sesion.createQuery(sql).list();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }

        return listado;
    }

    @Override
    public boolean crearUsu(Usuario usuario) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.save(usuario);
            sesion.beginTransaction().commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean actualizarUsu(Usuario usuario) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            Usuario usuariodb = (Usuario) sesion.load(Usuario.class, usuario.getCodigoUsu());
            usuariodb.setNombreUsu(usuario.getNombreUsu());
            usuariodb.setApellidoUsu(usuario.getApellidoUsu());
            usuariodb.setSobrenombreUsu(usuario.getSobrenombreUsu());
            usuariodb.setContraseniaUsu(usuario.getContraseniaUsu());
            usuariodb.setCorreoUsu(usuario.getCorreoUsu());
            usuariodb.setFechmodUsu(usuario.getFechmodUsu());
            usuariodb.setEstadoUsu(usuario.getEstadoUsu());
            usuariodb.setPerfil(usuario.getPerfil());
            
            sesion.merge(usuariodb);
            sesion.beginTransaction().commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean eliminarUsu(Integer idUs) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            Usuario usuario = (Usuario) sesion.load(Usuario.class, idUs);
            sesion.delete(usuario);
            sesion.beginTransaction().commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean regisUsu(Usuario usuario) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.save(usuario);
            sesion.beginTransaction().commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public void registrarUsuario(String nombre, String apellido, String sobrenom, String contrasenia, String correo) {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createSQLQuery("call registrar_usuario(:nombre,:apellido,:sobrenom,:contrasenia,:correo) ");
            q.setParameter("nombre", nombre);
            q.setParameter("apellido", apellido);
            q.setParameter("sobrenom", sobrenom);
            q.setParameter("contrasenia", contrasenia);
            q.setParameter("correo", correo);
            
            q.executeUpdate();
            
            session.beginTransaction().commit();
            session.close();

        } catch (Exception e) {
            //System.out.println("Error en el registro del usuario" +e.getMessage());
            //session.beginTransaction().rollback();
        }
        
    }

    @Override
    public Usuario getByCodigoUsuario(Session session, String codigoUsuario) throws Exception {
        return (Usuario) session.get(Usuario.class, codigoUsuario); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario getByCorreoElectronico( String correoElectronico)  {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
         String hql="select u from Usuario u where correoUsu=:correoElectronico";
        Query query=sesion.createQuery(hql);
        query.setParameter("correoElectronico", correoElectronico);
        
        Usuario usuarios=(Usuario) query.uniqueResult();
        return usuarios; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario getByCorreoElectronicoDiferent(Session session, String codigoUsuario, String correoElectronico) throws Exception {
        String hql="from Usuario where codigoUsu!=:codigoUsuario and correoUsu=:correoElectronico";
        Query query=session.createQuery(hql);
        query.setParameter("codigoUsuario", codigoUsuario);
        query.setParameter("correoElectronico", correoElectronico);
        
        Usuario tUsuario=(Usuario) query.uniqueResult();
        
        return tUsuario; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscarPorcodigoUsuario(Usuario usuario) {
     Session session = HibernateUtil.getSessionFactory().openSession();
     String sql="select  u.SOBRENOMBRE_USU from Usuario u where SOBRENOMBRE_USU=:usuario and CONTRASENIA_USU=:clave and ESTADO_USU=1";
     Query query=session.createQuery(sql);
     query.setString("usuario", usuario.getSobrenombreUsu());
     query.setString("clave", usuario.getContraseniaUsu());
     return (Usuario) query.uniqueResult(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscarPorsobreUsuario(String sobrenombre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
     String sql="select  u from Usuario u where SOBRENOMBRE_USU=:usuario and ESTADO_USU=1";
     Query query=session.createQuery(sql);
     query.setString("usuario",sobrenombre); 
     return (Usuario) query.uniqueResult(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
