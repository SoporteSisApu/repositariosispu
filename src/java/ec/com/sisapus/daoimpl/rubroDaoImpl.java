/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.daoimpl;

import ec.com.sisapus.dao.rubroDao;
import ec.com.sisapus.modelo.Rubro;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author kleber
 */
public class rubroDaoImpl implements rubroDao{

    @Override
    public boolean guardarrubro(Session session, Rubro rubro) throws Exception {
        session.save(rubro);
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rubro> getbyUsuarioRubro(Session session, String sobre) throws Exception {
         String hql="select r from Rubro r where r.usuario.sobrenombreUsu=:sobre";
         Query query=session.createQuery(hql);
        query.setParameter("sobre",sobre);
        
        List<Rubro> listarubro=(List<Rubro>) query.list();
        
        return listarubro;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarrubro(Session session, Rubro rubro) throws Exception {
        session.update(rubro);
        
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarrubro(Session session, Integer idrubro) throws Exception {
        Rubro rubro = (Rubro) session.load(Rubro.class, idrubro);
            session.delete(rubro);
            return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rubro obtenerrubroPorId(Session session, Integer idrubro) throws Exception {
       return ( Rubro) session.load( Rubro.class, idrubro); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rubro getByIdRubro(Session session, Integer idrubro) throws Exception {
         return (Rubro) session.load(Rubro.class, idrubro); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rubro getUltimoRegistroRubro(Session session) throws Exception {
       String hql="FROM Rubro r left join fetch r.categoriarubro order by CODIGO_RUBRO desc";
        Query query=session.createQuery(hql).setMaxResults(1);
         return (Rubro) query.uniqueResult(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
