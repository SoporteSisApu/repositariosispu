/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.bean;

import ec.com.sisapus.daoimpl.proyectoDaoImpl;
import ec.com.sisapus.daoimpl.usuarioDaoImpl;
import ec.com.sisapus.modelo.Proyecto;
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
public class proyectoBean {
      private Session session;
    private Transaction transaccion;
    
    private Proyecto proyecto;
    private Usuario usuario;
    private List<Proyecto> listaproyectoporUsurio;
    public  proyectoBean(){
        this.proyecto=new Proyecto();
        
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

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Proyecto> getListaproyectoporUsurio() {
        
        this.session=null;
        this.transaccion=null;
        
        try
        {
            proyectoDaoImpl daoproyecto=new proyectoDaoImpl();
            usuarioDaoImpl usuariodao=new usuarioDaoImpl();
            
            this.session=HibernateUtil.getSessionFactory().openSession();
            this.transaccion=this.session.beginTransaction();
            
            HttpSession sessionUsuario=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            
           this.usuario=usuariodao.getBySobrenombreusu(this.session, sessionUsuario.getAttribute("sobre").toString());
           this.usuario.getCodigoUsu();
           this.proyecto.setUsuario(this.usuario);
           this.listaproyectoporUsurio=daoproyecto.getbyUsuarioProyecto(session,this.proyecto.getUsuario().getSobrenombreUsu());
           this.transaccion.commit();
            
            return this.listaproyectoporUsurio;
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

    public void setListaproyectoporUsurio(List<Proyecto> listaproyectoporUsurio) {
        this.listaproyectoporUsurio = listaproyectoporUsurio;
    }
    
    
   
    
    
    
    public void guardarproyecto()
    {
        this.session=null;
        this.transaccion=null;
        String msg;
        try
        {            
           

            proyectoDaoImpl daoproyecto=new proyectoDaoImpl();
            usuarioDaoImpl usuariodao=new usuarioDaoImpl();
            this.session=HibernateUtil.getSessionFactory().openSession();
            this.transaccion=session.beginTransaction();

           HttpSession sessionUsuario=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            
           this.usuario=usuariodao.getBySobrenombreusu(this.session, sessionUsuario.getAttribute("sobre").toString());
           this.usuario.getCodigoUsu();
           this.proyecto.setUsuario(this.usuario);
           daoproyecto.guardarproyecto(this.session, this.proyecto);
            
            this.transaccion.commit();
            
           msg = "Proyecto creado correctamente";
            FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message1);

           this.proyecto=new Proyecto();
                    }
        catch(Exception ex)
        {
            if(this.transaccion!=null)
            {
                this.transaccion.rollback();
            }
            
             msg = "No se puede crear proyecto";
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
    
      public void actulizarproyecto()
    {
        this.session=null;
        this.transaccion=null;
        String msg;
        try
        {            
           

            proyectoDaoImpl daoproyecto=new proyectoDaoImpl();
            usuarioDaoImpl usuariodao=new usuarioDaoImpl();
            this.session=HibernateUtil.getSessionFactory().openSession();
            this.transaccion=session.beginTransaction();

         //  HttpSession sessionUsuario=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            
          // this.usuario=usuariodao.getBySobrenombreusu(this.session, sessionUsuario.getAttribute("sobre").toString());
          // this.usuario.getCodigoUsu();
          //  this.proyecto.setUsuario(this.usuario);
            daoproyecto.actualizarproyecto(this.session, this.proyecto);
            
            this.transaccion.commit();
            
            msg = "Proyecto actualizado correctamente";
            FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message1);

           
                    }
        catch(Exception ex)
        {
            if(this.transaccion!=null)
            {
                this.transaccion.rollback();
            }
            
             msg = "No se puede actualizar proyecto";
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
    
   public void eliminarproyecto()
    {
        this.session=null;
        this.transaccion=null;
        String msg;
        try
        {            
           

            proyectoDaoImpl daoproyecto=new proyectoDaoImpl();
           
            this.session=HibernateUtil.getSessionFactory().openSession();
            this.transaccion=session.beginTransaction();

         
            daoproyecto.eliminarproyecto(this.session, this.proyecto.getCodigoProy());
            
            this.transaccion.commit();
            
          msg = "Proyecto eliminado correctamente";
            FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message1);

           
                    }
        catch(Exception ex)
        {
            if(this.transaccion!=null)
            {
                this.transaccion.rollback();
            }
            
            msg = "No se elimino el Proyecto";
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
      
      
}
