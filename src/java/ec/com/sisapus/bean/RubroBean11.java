/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.bean;

import ec.com.sisapus.daoimpl.proyectoDaoImpl;
import ec.com.sisapus.daoimpl.rubroDaoImpl1;
import ec.com.sisapus.daoimpl.usuarioDaoImpl;
import ec.com.sisapus.modelo.Rubro;
import ec.com.sisapus.modelo.Usuario;
import ec.com.sisapus.util.HibernateUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author kleber
 */
@ManagedBean
@ViewScoped
public class RubroBean11 {
      private Session session;
    private Transaction transaccion;
    
    private Rubro rubro;
    private Usuario usuario;
    private List<Rubro> listarubroporUsurio;
     public  RubroBean11(){
        this.rubro=new Rubro();
        
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaction transaccion) {
        this.transaccion = transaccion;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Rubro> getListarubroporUsurio() {
     this.session=null;
        this.transaccion=null;
        
        try
        {
            rubroDaoImpl1 daorubro=new rubroDaoImpl1();
            usuarioDaoImpl usuariodao=new usuarioDaoImpl();
            
            this.session=HibernateUtil.getSessionFactory().openSession();
            this.transaccion=this.session.beginTransaction();
            
            HttpSession sessionUsuario=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            
           this.usuario=usuariodao.getBySobrenombreusu(this.session, sessionUsuario.getAttribute("sobre").toString());
           this.usuario.getCodigoUsu();
            this.rubro.setUsuario(this.usuario);
            this.listarubroporUsurio=daorubro.getbyUsuarioRubro(session,this.rubro.getUsuario().getSobrenombreUsu());
            this.transaccion.commit();
            
            return this.listarubroporUsurio;
        }
        catch(Exception ex)
        {
            if(this.transaccion!=null)
            {
                this.transaccion.rollback();
            }
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador "+ex.getMessage()));
            
            return null;
        }
        finally
        {
            if(this.session!=null)
            {
                this.session.close();
            }
        }
        
    }
    
     public void guardarrubro()
    {
        this.session=null;
        this.transaccion=null;
        String msg;
        try
        {            
           

           rubroDaoImpl1 daorubro=new rubroDaoImpl1();
            usuarioDaoImpl usuariodao=new usuarioDaoImpl();
            this.session=HibernateUtil.getSessionFactory().openSession();
            this.transaccion=session.beginTransaction();

           HttpSession sessionUsuario=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            
           this.usuario=usuariodao.getBySobrenombreusu(this.session, sessionUsuario.getAttribute("sobre").toString());
           this.usuario.getCodigoUsu();
            this.rubro.setUsuario(this.usuario);
            daorubro.guardarrubro(this.session, this.rubro);
            
            this.transaccion.commit();
            
           msg = "Rubro creado correctamente";
            FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message1);

           this.rubro=new Rubro();
                    }
        catch(Exception ex)
        {
            if(this.transaccion!=null)
            {
                this.transaccion.rollback();
            }
            
             msg = "No se puede crear rubro";
            FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message1);
        }
        finally
        {
            if(this.session!=null)
            {
                this.session.close();
            }
        }
    } 
    
       public void actulizarrubro()
    {
        this.session=null;
        this.transaccion=null;
        String msg;
        try
        {            
           

            rubroDaoImpl1 daorubro=new rubroDaoImpl1();
         
            this.session=HibernateUtil.getSessionFactory().openSession();
            this.transaccion=session.beginTransaction();
            daorubro.actualizarrubro(this.session, this.rubro);
            
            this.transaccion.commit();
            
            msg = "Rubro actualizado correctamente";
            FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message1);

           
                    }
        catch(Exception ex)
        {
            if(this.transaccion!=null)
            {
                this.transaccion.rollback();
            }
            
             msg = "No se puede actualizar rubro";
            FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message1);
        }
        finally
        {
            if(this.session!=null)
            {
                this.session.close();
            }
        }
    } 
 public void eliminarrubro()
    {
        this.session=null;
        this.transaccion=null;
        String msg;
        try
        {            
           

            rubroDaoImpl1 daorubro=new rubroDaoImpl1();
           
            this.session=HibernateUtil.getSessionFactory().openSession();
            this.transaccion=session.beginTransaction();

         
            daorubro.eliminarrubro(this.session, this.rubro.getCodigoRubro());
            
            this.transaccion.commit();
            
          msg = "Rubro eliminado correctamente";
            FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message1);

           
                    }
        catch(Exception ex)
        {
            if(this.transaccion!=null)
            {
                this.transaccion.rollback();
            }
            
            msg = "No se elimino Rubro";
            FacesMessage message2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message2);
        }
        finally
        {
            if(this.session!=null)
            {
                this.session.close();
            }
        }
    }     
      
    public void setListarubroporUsurio(List<Rubro> listarubroporUsurio) {
        this.listarubroporUsurio = listarubroporUsurio;
    }
    
     
     
}
