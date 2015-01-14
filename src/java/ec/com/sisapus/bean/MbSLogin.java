/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.sisapus.bean;

import ec.com.sisapus.validadores.Encrypt;
import ec.com.sisapus.daoimpl.usuarioDaoImpl;
import ec.com.sisapus.util.HibernateUtil;
import ec.com.sisapus.modelo.Usuario;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author KevinArnold
 */
@Named(value = "MbSLogin")
@SessionScoped
public class MbSLogin implements Serializable {

    /**
     * Creates a new instance of MbSLogin
     */
    private String correoElectronico;
    private String contrasenia;
    
    private Session session;
    private Transaction transaccion;
    
    public MbSLogin() 
    {
        HttpSession miSession=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        miSession.setMaxInactiveInterval(5000);
    }
    
 /*   public String login()
    {
        this.session=null;
        this.transaccion=null;
        
        try
        {
            usuarioDaoImpl daousu=new usuarioDaoImpl();
           
            
            this.session=HibernateUtil.getSessionFactory().openSession();
            this.transaccion=this.session.beginTransaction();
            
        //    Usuario tUsuario=daousu.getByCorreoElectronico(this.session, this.correoElectronico);
            
            if(tUsuario!=null)
            {
                if(tUsuario.getContraseniaUsu().equals((this.contrasenia)))
                {
                    HttpSession httpSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    httpSession.setAttribute("correoElectronico", this.correoElectronico);
                    
                    return "/Pantallas/menuTemplate.xhtml";
                }
            }
            
            this.transaccion.commit();
            
            this.correoElectronico=null;
            this.contrasenia=null;
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de acceso:", "Usuario o contraseña incorrecto"));
            
            return "/login.xhtml";
            
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
    */
    public String cerrarSesion()
    {
        this.correoElectronico=null;
        this.contrasenia=null;
        
        HttpSession httpSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.invalidate();
        
        return "/login.xhtml";
    }
    
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
 
    public String IrusuarioRegistro(ActionEvent actionEvent) {
       return "/Pantallas/usuarios/registroUsuarios.xhtml";
    }
}
