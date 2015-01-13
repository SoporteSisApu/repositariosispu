/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.dao;

import ec.com.sisapus.modelo.ControlEjecutadoPresupuestado;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author kleber
 */
public interface ControlEjecucion {
     public List<ControlEjecutadoPresupuestado> listaproyectosejecucion (Session session) throws  Exception;
    
}
