/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.daoimpl;

import ec.com.sisapus.dao.rubroInterfaceDao;
import ec.com.sisapus.modelo.Rubro;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Edison
 */
public class rubroDaoImplInterface implements rubroInterfaceDao{

    @Override
    public boolean crearRubro(Session session, Rubro tRubro) throws Exception {
        session.save(tRubro);
        return true;
    }

    @Override
    public boolean modificarRubro(Session session, Rubro tRubro) throws Exception {
        session.update(tRubro);
        return true;
    }

    @Override
    public List<Rubro> listarTodosRubros(Session session) throws Exception {
        String hql="from Rubro r";
        Query query=session.createQuery(hql);
        List<Rubro> listaTRubro=(List<Rubro>) query.list();
        return listaTRubro;
    }

    @Override
    public Rubro getByCodigoRubro(Session session, String codigoRubro) throws Exception {
        return (Rubro) session.get(Rubro.class,codigoRubro );
    }

    @Override
    public boolean eliminarRubro(Session session, Integer idRubro) throws Exception {
        Rubro rubro = (Rubro) session.load(Rubro.class, idRubro);
        session.delete(rubro);
        return true;
    }
    
}
