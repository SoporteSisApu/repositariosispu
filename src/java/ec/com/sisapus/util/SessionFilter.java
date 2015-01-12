/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.util;




import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kleber
 */
public class SessionFilter implements Filter {
 FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
          this.filterConfig=filterConfig; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;
        HttpSession session=req.getSession(true);
        
        String requestUrl=req.getRequestURI().toString();
        
        String[] urlPermitidaSinSesion=new String[]
        {
            "/login.xhtml",
            "Pantallas/usuarios/registroUsuarios.xhtml"
        };
        
        boolean redireccionarPeticion;
        
        if(session.getAttribute("correoElectronico")==null)
        {            
            redireccionarPeticion=true;
            
            for(String item : urlPermitidaSinSesion)
            {
                if(requestUrl.contains(item))
                {
                    redireccionarPeticion=false;
                    
                    break;
                }
            }
        }
        else
        {
            redireccionarPeticion=false;
        }
        
        if(redireccionarPeticion)
        {
            res.sendRedirect(req.getContextPath()+"/login.xhtml");
        }
        else
        {
            chain.doFilter(request, response);
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
       this.filterConfig=null; //To change body of generated methods, choose Tools | Templates.
    }
    
}
