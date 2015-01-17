package ec.com.sisapus.bean;

import ec.com.sisapus.daoimpl.usuarioDaoImpl;
import ec.com.sisapus.modelo.Usuario;
import ec.com.sisapus.util.HibernateUtil;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;

@Named(value = "loginBean")
@SessionScoped
public class loginBean implements Serializable {

    private String sobrenombre;
    private String contrasenia;
    private Session session;
    private Transaction transaccion;
    private Usuario usuario;
    private String usuarioSesion;

    public loginBean() {
        HttpSession miSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        miSession.setMaxInactiveInterval(5000);
    }

    ///Getters y Setters de variables declaradas
    public String getSobrenombre() {
        return sobrenombre;
    }

    public void setSobrenombre(String sobrenombre) {
        this.sobrenombre = sobrenombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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

    public Usuario getUsuario() {
//        if (this.usuario == null) {
//            usuario = new Usuario();
//        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUsuarioSesion() {
        return usuarioSesion;
    }

    public void setUsuarioSesion(String usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
    }

    ////////////////////////////////////////////
    //Funcion para iniciar sesion en el sistema
    public String iniciarSesion() {
        this.session = null;
        this.transaccion = null;
        FacesMessage msg = null;
        boolean logeado = false;  
        try {
             RequestContext context = RequestContext.getCurrentInstance();
            usuarioDaoImpl daousuario = new usuarioDaoImpl();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            this.usuario = daousuario.getBySobrenombreusu(this.session, this.sobrenombre);

            if (usuario != null) {
                
                     if (usuario.getContraseniaUsu().equals(this.contrasenia)) {
                    HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    httpSession.setAttribute("sobre", this.sobrenombre);
                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", usuario.getSobrenombreUsu());
                    this.usuarioSesion = usuario.getSobrenombreUsu();
                    return "/Pantallas/menuTemplate.xhtml";
                }
                     else 
                         
                {
                  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de acceso:", "Usuario o contraseña incorrecto"));
                }

            }
            
            else
            
            {
                logeado=false;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de acceso:", "Usuario o contraseña incorrecto"));
            }

            this.transaccion.commit();

            this.sobrenombre = null;
            this.contrasenia = null;

            
            return "/login.xhtml";
            
        } catch (Exception ex) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));

            return null;
        }


    }

    //Funcion para cerrar sesion en el sistema
    public String cerrarSesion() {
        this.sobrenombre = null;
        this.contrasenia = null;

        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.invalidate();

        return "/login.xhtml";
    }
}
