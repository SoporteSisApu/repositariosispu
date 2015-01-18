package ec.com.sisapus.bean;

import ec.com.sisapus.dao.proyectoDao;
import ec.com.sisapus.daoimpl.proyectoDaoImpl;
import ec.com.sisapus.daoimpl.usuarioDaoImpl;
import ec.com.sisapus.modelo.Proyecto;
import ec.com.sisapus.modelo.Usuario;
import ec.com.sisapus.util.HibernateUtil;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Edison
 */
@Named(value = "proyectoBean")
@ViewScoped
//@ManagedBean
//@ViewScoped
public class proyectoBean implements Serializable {

    private Proyecto proyecto;
    private Usuario usuario;
    private List<Proyecto> listaProyectos;
    private List<Proyecto> liscaldimensional;
    private List<Proyecto> listaporUsuario;
     //private Session session;
    //private Transaction transaccion;
    private List<SelectItem> cargarProyectos;
    
    private Integer codigoProy;
     org.hibernate.Session session;
     
      @ManagedProperty("#{loginBean}")
    private loginBean mbSLogin;
    Transaction transaccion;
    private SelectItem[] opciones = new SelectItem[]{
		new SelectItem("Quito", "Quito"),
		new SelectItem("Guayaquil", "Guayaquil"),
		new SelectItem("Cuenca", "Cuenca")};

    public SelectItem[] getOpciones() {
        return opciones;
    }

    public void setOpciones(SelectItem[] opciones) {
        this.opciones = opciones;
    }

    public proyectoBean() {
        this.proyecto = new Proyecto();
        this.usuario=new Usuario();
    }

    public Proyecto getProyecto() {
        //if (this.proyecto == null) {
          //  proyecto = new Proyecto();
        //}
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<Proyecto> getListaProyectos() {
        proyectoDao proyecDao = new proyectoDaoImpl();
        listaProyectos = proyecDao.listarProyectos();
        return listaProyectos;
    }
    
    
    
    

    public void setListaProyectos(List<Proyecto> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }

    ///////////
    public Integer getCodigoProy() {
        return codigoProy;
    }

    public void setCodigoProy(Integer codigoProy) {
        this.codigoProy = codigoProy;
    }

    ///////////
  /*  public Proyecto getListaporUsuario() throws Exception {
         
        
            proyectoDaoImpl daoproy=new proyectoDaoImpl();
            usuarioDaoImpl userdao=new usuarioDaoImpl();
        HttpSession sessionUsuario=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        this.usuario=userdao.getByUsuarioCodigo(this.session, sessionUsuario.getAttribute("sobre").toString());
            this.usuario=this.mbSLogin.getUsuario();
            this.usuario=userdao.getByUsuarioCodigo(this.session, sessionUsuario.getAttribute("sobre").toString());
        this.proyecto.setUsuario(this.usuario);
        
        return proyecto;
        
        
        
    }*/

public void setListaporUsuario(List<Proyecto> listaporUsuario) {
        this.listaporUsuario = listaporUsuario;
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

    public loginBean getMbSLogin() {
        return mbSLogin;
    }

    public void setMbSLogin(loginBean mbSLogin) {
        this.mbSLogin = mbSLogin;
    }

    

    //////////
    //////////////////////////
    ////Crear Proyecto
    public void crearProyecto(ActionEvent actionEvent)  {
        
        
        proyectoDao proyectDao = new proyectoDaoImpl();
        String msg;
       usuarioDaoImpl userdao= new usuarioDaoImpl();
       //HttpSession sessionUsuario=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
       //this.usuario=userdao.getByUsuarioCodigo(this.session, sessionUsuario.getAttribute("sobre").toString());
       
       // this.proyecto.setUsuario(this.usuario);
       //this.proyecto.setUsuario(usuarios);
       /*this.proyecto.setContratProy(this.proyecto.getContratProy());
        this.proyecto.setPropiepProy(this.proyecto.getPropiepProy());
        this.proyecto.setObraProy(this.proyecto.getObraProy());
        this.proyecto.setUbicProy(this.proyecto.getUbicProy());
        this.proyecto.setFechaProy(this.proyecto.getFechaProy());
        this.proyecto.setCostotProy(this.proyecto.getCostotProy());
        */
        if (proyectDao.crearProyecto(this.proyecto)) {
            msg = "Proyecto creado correctamente";
            FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message1);
        } else {
            msg = "No se creo el Proyecto";
            FacesMessage message2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message2);
        }

    }

    /*Actualizar Proyecto*/
    public void actualizarProyecto(ActionEvent actionEvent) {
        proyectoDao proyectDao = new proyectoDaoImpl();
        String msg;
        /*
        this.proyecto.setUsuario(this.proyecto.getUsuario());
        this.proyecto.setContratProy(this.proyecto.getContratProy());
        this.proyecto.setPropiepProy(this.proyecto.getPropiepProy());
        this.proyecto.setObraProy(this.proyecto.getObraProy());
        this.proyecto.setUbicProy(this.proyecto.getUbicProy());
        this.proyecto.setFechaProy(this.proyecto.getFechaProy());
        this.proyecto.setCostotProy(this.proyecto.getCostotProy());
        */
        if (proyectDao.actualizarProyecto(this.proyecto)) {
            msg = "Proyecto modificado correctamente";
            FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message1);
        } else {
            msg = "No se modifico el Proyecto";
            FacesMessage message2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message2);
        }
    }

    //Eliminar Proyecto
    public void eliminarProyecto(ActionEvent actionEvent) {
        proyectoDao proyectDao = new proyectoDaoImpl();
        String msg;
        if (proyectDao.eliminarProyecto(this.proyecto.getCodigoProy())) {
            msg = "Proyecto eliminado correctamente";
            FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message1);
        } else {
            msg = "No se elimino el Proyecto";
            FacesMessage message2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message2);
        }

    }

    

    //Cargar lista de proyectos en el combobox
    public List<SelectItem> getCargarProyectos() {
        this.cargarProyectos = new ArrayList<SelectItem>();
        proyectoDao proydao = new proyectoDaoImpl();
        List<Proyecto> proy = proydao.listarProyectos();
        for (Proyecto pro : proy) {
            SelectItem selectItem = new SelectItem(pro.getCodigoProy(), pro.getObraProy());
            this.cargarProyectos.add(selectItem);
        }
        return cargarProyectos;
    }

    
    public void GuardarProyecto()
    {
        this.session=null;
        this.transaccion=null;
        
        try
        {            
            

            usuarioDaoImpl daoTUsuario=new usuarioDaoImpl();
            proyectoDaoImpl daoproyecto=new proyectoDaoImpl();
            
            this.session=HibernateUtil.getSessionFactory().openSession();
            this.transaccion=session.beginTransaction();
           // HttpSession sessionUsuario=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            
          //  this.usuario=daoTUsuario.getByUsuarioCodigo(this.session, sessionUsuario.getAttribute("sobre").toString());
          //  this.proyecto.setUsuario(usuario);
            daoproyecto.guardarproyecto(this.session, this.proyecto);
            
            this.transaccion.commit();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "El ingreso fue realizado correctamente"));

            //this.usuario=new Usuario();
           
          
        }
        catch(Exception ex)
        {
            if(this.transaccion!=null)
            {
                this.transaccion.rollback();
            }
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador "+ex.getMessage()));
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
