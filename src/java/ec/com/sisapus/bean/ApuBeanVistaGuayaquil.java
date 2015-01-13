/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sisapus.bean;
import ec.com.sisapus.modelo.Categoriamaterial;
import ec.com.sisapus.dao.usuarioDao;
import ec.com.sisapus.daoimpl.ApusDaoImpl;
import ec.com.sisapus.daoimpl.equipoherrDaoImpl;
import ec.com.sisapus.daoimpl.manoobraDaoImpl;
import ec.com.sisapus.daoimpl.materialDaoImpl;
import ec.com.sisapus.daoimpl.transporteDaoImpl;
import ec.com.sisapus.daoimpl.rubroDaoImpl;
import ec.com.sisapus.daoimpl.usuarioDaoImpl;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ec.com.sisapus.modelo.EquipherrApu;
import ec.com.sisapus.modelo.Equipoherramienta;
import ec.com.sisapus.modelo.Manoobra;
import ec.com.sisapus.modelo.ManoobraApu;
import ec.com.sisapus.modelo.Material;
import ec.com.sisapus.modelo.MaterialApu;
import ec.com.sisapus.modelo.Transporte;
import ec.com.sisapus.modelo.TransporteApu;
import ec.com.sisapus.modelo.Analisispreciounitario;
import ec.com.sisapus.modelo.Categoriarubro;
import ec.com.sisapus.modelo.Escenarioapu;
import ec.com.sisapus.modelo.Rubro;
import ec.com.sisapus.util.HibernateUtil;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.activation.DataSource;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.naming.spi.DirStateFactory;
import javax.persistence.EntityManager;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuter;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Settings;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.connection.DatasourceConnectionProvider;
import org.hibernate.ejb.EntityManagerFactoryImpl;
import org.hibernate.ejb.HibernateEntityManager;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.impl.SessionFactoryImpl;
import org.hibernate.mapping.Component;
import org.primefaces.component.tabview.TabView;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author kleber
 */
@Named(value = "ApuBeanVistaGuayaquil")
@ViewScoped
public class ApuBeanVistaGuayaquil {
    
    
     Session session;
    Transaction transaction;
    // equipos   
    private Equipoherramienta equipherramientas;
    private List<EquipherrApu> listaEquiposApus;
    private EquipherrApu equipapus;
    private Double precioTotalEquipo;
    private Double CostoHora;
    //mano de obra
    private Manoobra manoobras;
    private List<ManoobraApu> listaManoBra;
    private ManoobraApu manopapus;
    private Double precioTotalmanoobra;
    //material
    private Material materiales;
    private List<MaterialApu> listaMaterialApus;
    private MaterialApu materialapus;
    private Double precioTotalmaterial;
    //transporte
    private Transporte transportes;
    private List<TransporteApu> listaTransporteApus;
    private TransporteApu transportapus;
    private Double precioTotaltransporte;
    //precios unitarios
    private Analisispreciounitario analisisapus;
    private List<Analisispreciounitario> listapus;
    private List<Analisispreciounitario> listarapus;
    private Double auxiliarPorcenjate;
    private Double auxiliarotroscostos;
    private Double totaldirAPU;
    private Double costoinAPu;
    private Double costoaputotal;
    //rubros
    private Rubro rubro;
    private List<Rubro> listaRubro;
    private String auxdesrubro;
    private String auxunidrubro;
    private int auxocidigo;
    private String auxcategoria;
    ///para la categoria rubro
    private Categoriarubro catrubro;
    //
    private Escenarioapu escenariosapu;
    private Connection coneccion;
  //Escenarios
    private boolean escenarioact1;
    private boolean escenarioact2;
    private boolean escenarioact3;
   //     
    public ApuBeanVistaGuayaquil() {
        this.equipherramientas = new Equipoherramienta();
        this.listaEquiposApus = new ArrayList<>();
        this.manoobras = new Manoobra();
        this.listaManoBra = new ArrayList<>();
        this.materiales = new Material();
        this.listaMaterialApus = new ArrayList<>();
        this.transportes = new Transporte();
        this.listaTransporteApus = new ArrayList<>();
        this.rubro = new Rubro();
        this.analisisapus = new Analisispreciounitario();
        this.escenariosapu=new Escenarioapu();  
        this.auxdesrubro = "";
        this.auxunidrubro = "";
     this.escenarioact1=false;
    this.escenarioact2=true;
    this.escenarioact3=true;
    }

    public boolean isEscenarioact1() {
        return escenarioact1;
    }

    public void setEscenarioact1(boolean escenarioact1) {
        this.escenarioact1 = escenarioact1;
    }

    public boolean isEscenarioact2() {
        return escenarioact2;
    }

    public void setEscenarioact2(boolean escenarioact2) {
        this.escenarioact2 = escenarioact2;
    }

    public boolean isEscenarioact3() {
        return escenarioact3;
    }

    public void setEscenarioact3(boolean escenarioact3) {
        this.escenarioact3 = escenarioact3;
    }
    
    
    

    public Escenarioapu getEscenariosapu() {
        return escenariosapu;
    }

    public void setEscenariosapu(Escenarioapu escenariosapu) {
        this.escenariosapu = escenariosapu;
    }
    
    
    
    //// Listar los apus en el dialogo
    public List<Analisispreciounitario> getListarapus() throws Exception {
        this.session = null;
        this.transaction = null;

        try {
            ApusDaoImpl daoapu = new ApusDaoImpl();

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            //this.listarapus = daoapu.listarApus(this.session);
            this.transaction.commit();
            return this.listarapus;
        } catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
            return null;
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
        //)  ApusDaoImpl daoapu = new ApusDaoImpl();
        //listarapus = daoapu.listarApus(this.session);
        //return listarapus;
    }

    public void setListarapus(List<Analisispreciounitario> listarapus) {
        this.listarapus = listarapus;
    }
        
        

    ///funcion para agregar el rubro
    public void agregarRubroApus(Integer idRubros) {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            rubroDaoImpl daorubro = new rubroDaoImpl();


            this.transaction = this.session.beginTransaction();

            this.rubro = daorubro.getByIdRubro(session, idRubros);

            this.setAuxocidigo(this.rubro.getCodigoRubro());
            this.setAuxdesrubro(this.rubro.getDetalleRubro());
            this.setAuxunidrubro(this.rubro.getUnidadRubro());
            this.setAuxcategoria(this.rubro.getCategoriarubro().getDescripcionCatRubro());


            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Rubro agregado"));

            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:panelFinalVenta16");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:mensajeGeneral2");


        } catch (Exception ex) {
            if (this.transaction != null) {
                transaction.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    //  
    public void agregarListaEquiposApus(Integer idEquipos) {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            equipoherrDaoImpl daoequipo = new equipoherrDaoImpl();

            this.transaction = this.session.beginTransaction();
            this.equipherramientas = daoequipo.getByIdEquipo(session, idEquipos);
            //this.listaEquiposApus.add(new EquipherrApu( null,this.equipherramientas.getNombreEqherr(), null,this.equipherramientas.getCostohoraEqherr(),null, null, null, null));
            this.listaEquiposApus.add(new EquipherrApu(null,null, this.equipherramientas.getNombreEqherr(), null, this.equipherramientas.getCostohoraEqherr(), null, null, null));
            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Equipo/Herramienta agregado"));

            //el qu estaba
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:tablaListaProductosVenta17");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:mensajeGeneral2");


        } catch (Exception ex) {
            if (this.transaction != null) {
                transaction.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }
    //funcion para retirar

    public void EliminarListaEquipo(String nom) {
        try {
            int i = 0;

            for (EquipherrApu item : this.listaEquiposApus) {
                if (item.getDescEqherrApu().equals(nom)) {
                    this.listaEquiposApus.remove(i);

                    break;
                }

                i++;
            }

            Double totalVenta = new Double("0");

            for (EquipherrApu item : this.listaEquiposApus) {
                Double costohora = item.getCantEqherrApu() * (new Double(item.getTarifaEqherrApu()));

                Double totalVentaPorProducto = (costohora * (new Double(item.getRendimEqherrApu())));
                item.setCostohoraEqherrApu(costohora);
                item.setCostotEqherrApu(totalVentaPorProducto);

                totalVenta = totalVenta + totalVentaPorProducto;
            }

            this.setPrecioTotalEquipo(totalVenta);
            this.analisisapus.setAnalApuEqherr(totalVenta);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Equipos y Herramientas retirado de la lista"));

            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:tablaListaProductosVenta17");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:panelFinalVenta17");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:mensajeGeneral2");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        }
    }
    //calculo subtotal equipos

    public void calcularCostos() {

        try {
            Double totalVenta = new Double("0.00");

            for (EquipherrApu item : this.listaEquiposApus) {
                Double costohora = item.getCantEqherrApu() * (new Double(item.getTarifaEqherrApu()));
                Double totalVentaPorProducto = (costohora * (new Double(item.getRendimEqherrApu())));
                item.setCostohoraEqherrApu(costohora);
                item.setCostotEqherrApu(totalVentaPorProducto);

                totalVenta = totalVenta + totalVentaPorProducto;
            }

            this.setPrecioTotalEquipo(totalVenta);
              this.analisisapus.setAnalApuEqherr(totalVenta);
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:tablaListaProductosVenta17");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:panelFinalVenta17");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        }
    }

  
    //probar creacion de Escenarios
    private TabView tabView;

    public void setTabView(TabView tabView) {
        this.tabView = tabView;
    }

    /* public TabView getTabView() {
     FacesContext fc = FacesContext.getCurrentInstance();
     tabView = (TabView) fc.getApplication().createComponent("org.primefaces.component.TabView");

     // cargar la lista de objetos para tabview
     List liscaldimensional = new ArrayList();
     liscaldimensional =a//ejbFacadeCalidadDimensional.findAll();

     //Se crean dinamicamente las tabs y en su contenido, unas cajas de texto
     for (CalidadDimensional sub : liscaldimensional) {
     Tab tab = new Tab();
     tab.setTitle(sub.getCalidadDimensional());
     Random randomGenerator = new Random();
     int total = 4;
     for (int i = 0; i < total; i++) {
     InputText inputtext = new InputText();
     inputtext.setLabel("Label");
     inputtext.setValue("id:" + inputtext.getClientId());
     inputtext.setOnfocus("");
     tab.getChildren().add(inputtext);
     }
     tabView.getChildren().add(tab);
     }
     return tabView;
     }*/
    //probar a lo que se selecciona la fila
//material
    public void agregarListaManobraApu(Integer idmanobra) {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            manoobraDaoImpl daomano = new manoobraDaoImpl();


            this.transaction = this.session.beginTransaction();

            this.manoobras = daomano.getByIdManobra(session, idmanobra);

            this.listaManoBra.add(new ManoobraApu(null,null, this.manoobras.getNombreManob(), this.manoobras.getCategoriamanoobra().getNombCatManob(),null, this.manoobras.getCostojrhManob(), null, null, null));
            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Mano de Obra agregado"));


            //el qu estaba
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:tablaListaProductosVenta18");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:mensajeGeneral2");
            //

        } catch (Exception ex) {
            if (this.transaction != null) {
                transaction.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

//
    //funcion para retirar
    public void EliminarListaManObra(String nom) {
        try {
            int i = 0;

            for (ManoobraApu item : this.listaManoBra) {
                if (item.getDescMoApu().equals(nom)) {
                    this.listaManoBra.remove(i);

                    break;
                }

                i++;
            }

            Double totalVenta1 = new Double("0.00");

            for (ManoobraApu item : this.listaManoBra) {
                Double costohora1 = item.getCantMoApu() * (new Double(item.getCostojrhMoApu()));

                Double totalVentaPorProducto1 = (costohora1 * (new Double(item.getRendimMoApu())));
                item.setCostohoraMoApu(costohora1);
                item.setCostotMoApu(totalVentaPorProducto1);

                totalVenta1 = totalVenta1 + totalVentaPorProducto1;
            }

            this.setPrecioTotalmanoobra(totalVenta1);
               this.analisisapus.setAnalApuMob(totalVenta1);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Mano de Obra retirado de la lista"));

            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:tablaListaProductosVenta18");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:panelFinalVenta18");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:mensajeGeneral2");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        }
    }

    //calculo subtotal equipos
    public void calcularCostosManobra() {
        try {
            Double totalVenta1 = new Double("0.00");

            for (ManoobraApu item : this.listaManoBra) {
                Double costohora1 = item.getCantMoApu() * (new Double(item.getCostojrhMoApu()));

                Double totalVentaPorProducto1 = (costohora1 * (new Double(item.getRendimMoApu())));
                item.setCostohoraMoApu(costohora1);
                item.setCostotMoApu(totalVentaPorProducto1);

                totalVenta1 = totalVenta1 + totalVentaPorProducto1;
            }

            this.setPrecioTotalmanoobra(totalVenta1);
               this.analisisapus.setAnalApuMob(totalVenta1);
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:tablaListaProductosVenta18");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:panelFinalVenta18");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        }
    }

    //
   

    // 
   
//materiales    
    public void agregarListaMaterialApu(Integer idmaterial) {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            materialDaoImpl materialdao = new materialDaoImpl();



            this.transaction = this.session.beginTransaction();

            this.materiales = materialdao.getByIdMaterial(session, idmaterial);

            //this.listaManoBra.add(new ManoobraApu(null,this.manoobras.getNombreManob(),null,null,this.manoobras.getCostojrhManob(),null, null, null,null));
            this.listaMaterialApus.add(new MaterialApu(null,null, this.materiales.getNombreMat(), this.materiales.getUnidMat(), null, this.materiales.getPrecunitMat(), null));
            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Material agregado"));


            //el qu estaba
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:tablaListaProductosVenta19");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:mensajeGeneral2");
            //

        } catch (Exception ex) {
            if (this.transaction != null) {
                transaction.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

//
    //funcion para retirar
    public void EliminarListaMateriales(String nom) {
        try {
            int i = 0;

            for (MaterialApu item : this.listaMaterialApus) {
                if (item.getDescMatApu().equals(nom)) {
                    this.listaMaterialApus.remove(i);

                    break;
                }

                i++;
            }

            Double totalVenta1 = new Double("0.00");

            for (MaterialApu item : this.listaMaterialApus) {


                Double totalVentaPorProducto1 = (new Double(item.getCantMatApu())) * (new Double(item.getPreunitMatApu()));

                item.setCostotMatApu(totalVentaPorProducto1);

                totalVenta1 = totalVenta1 + totalVentaPorProducto1;
            }

            this.setPrecioTotalmaterial(totalVenta1);
   this.analisisapus.setAnalApuMat(totalVenta1);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Material retirado de la lista"));

            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:tablaListaProductosVenta19");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:panelFinalVenta19");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:mensajeGeneral2");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        }
    }

    //calculo subtotal equipos
    public void calcularCostosMateriales() {
        try {
            Double totalVenta1 = new Double("0.00");

            for (MaterialApu item : this.listaMaterialApus) {


                Double totalVentaPorProducto1 = (new Double(item.getCantMatApu())) * (new Double(item.getPreunitMatApu()));

                item.setCostotMatApu(totalVentaPorProducto1);

                totalVenta1 = totalVenta1 + totalVentaPorProducto1;
            }

            this.setPrecioTotalmaterial(totalVenta1);
               this.analisisapus.setAnalApuMat(totalVenta1);
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:tablaListaProductosVenta19");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:panelFinalVenta19");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        }
    }

    // 
  

//fin materiales
//transporte    
    public void agregarListaTransporteApu(Integer idtrans) {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
         
            transporteDaoImpl transpdao = new transporteDaoImpl();


            this.transaction = this.session.beginTransaction();

            this.transportes = transpdao.getByIdTransporte(session, idtrans);

            //this.listaManoBra.add(new ManoobraApu(null,this.manoobras.getNombreManob(),null,null,this.manoobras.getCostojrhManob(),null, null, null,null));
            this.listaTransporteApus.add(new TransporteApu(null,null, this.transportes.getNombreTransp(), "GLB", null, this.transportes.getTarifaTransp(), null));
            this.transaction.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Transporte agregado"));

            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:tablaListaProductosVenta20");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:mensajeGeneral2");
            //

        } catch (Exception ex) {
            if (this.transaction != null) {
                transaction.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

//
    //funcion para retirar
    public void EliminarListaTransporte(String nom) {
        try {
            int i = 0;

            for (TransporteApu item : this.listaTransporteApus) {
                if (item.getDescTranApu().equals(nom)) {
                    this.listaTransporteApus.remove(i);

                    break;
                }

                i++;
            }

            Double totalVenta1 = new Double("0.00");

            for (TransporteApu item : this.listaTransporteApus) {


                Double totalVentaPorProducto1 = (new Double(item.getCantTranApu())) * (new Double(item.getTarifaTranApu()));

                item.setCostotTranApu(totalVentaPorProducto1);

                totalVenta1 = totalVenta1 + totalVentaPorProducto1;
            }

            this.setPrecioTotaltransporte(totalVenta1);
               this.analisisapus.setAnalApuTran(totalVenta1);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Transporte retirado de la lista"));

            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:tablaListaProductosVenta20");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:panelFinalVenta20");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:mensajeGeneral2");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        }
    }

    //calculo subtotal transporte
    public void calcularCostosTransporte() {
        try {
            Double totalVenta1 = new Double("0.00");

            for (TransporteApu item : this.listaTransporteApus) {


                Double totalVentaPorProducto1 = (new Double(item.getCantTranApu())) * (new Double(item.getTarifaTranApu()));

                item.setCostotTranApu(totalVentaPorProducto1);

                totalVenta1 = totalVenta1 + totalVentaPorProducto1;
            }

            this.setPrecioTotaltransporte(totalVenta1);
            this.analisisapus.setAnalApuTran(totalVenta1);



            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:tablaListaProductosVenta20");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:panelFinalVenta20");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        }
    }

    // 
  /*  public void guardarTransporteApus() {
        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();

            transporteDaoImpl transpodao = new transporteDaoImpl();
            ApusDaoImpl apustraanporte = new ApusDaoImpl();


            this.transaction = this.session.beginTransaction();
            this.transportes = transpodao.getUltimoRegistro(session);

            for (TransporteApu item : this.listaTransporteApus) {
                this.transportes = transpodao.getByIdTransporte(session, this.transportes.getCodigoTransp());
                item.setTransporte(this.transportes);
                apustraanporte.insertarTransporte(this.session, item);
            }

            this.transaction.commit();
            //this.listaTransporteApus=new ArrayList<>();
            //this.transportes=new Transporte();
            //this.precioTotaltransporte=0.0;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Transporte guardado correctamente"));
        } catch (Exception ex) {
            if (this.transaction != null) {
                transaction.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }
*/
//fin transporte
//Analisis Precios Unitarios
    public void guardarAPU() {
         this.session=null;
        this.transaction=null;
        
        try
        {
            
        this.session=HibernateUtil.getSessionFactory().openSession();
        //enconntrar ide del tab segun eso setear el escenario
        
       // UIComponent componente1 = findComponent("tab1", FacesContext.getCurrentInstance().getViewRoot());
       // UIComponent componente2 = findComponent("tab2", FacesContext.getCurrentInstance().getViewRoot());
       // UIComponent componente3 = findComponent("tab3", FacesContext.getCurrentInstance().getViewRoot());
        /* if (componente1.equals("tab1")){
         this.escenariosapu.setCodigoEscenario(1);
         }*/
         
        // if (componente2.equals("tab2")){
         this.escenariosapu.setCodigoEscenario(3);
         //}
         /*if (componente3.equals("tab3")){
         this.escenariosapu.setCodigoEscenario(3);
         }*/
         
       //this.escenariosapu.setCodigoEscenario(1);
        this.analisisapus.setEscenarioapu(escenariosapu);
        this.analisisapus.setDescApu(getAuxdesrubro());
        this.analisisapus.setCategoriaApu(getAuxcategoria());
        this.analisisapus.setUnidadApu(getAuxunidrubro());
        this.analisisapus.setRubro(rubro);
          //los daos que necesito
          //daos para el analilsis ose la cabecera
         ApusDaoImpl apugenal=new ApusDaoImpl();
        equipoherrDaoImpl daoequipo=new equipoherrDaoImpl();
        manoobraDaoImpl manoobradao=new manoobraDaoImpl();
        materialDaoImpl materialdao=new materialDaoImpl();
       transporteDaoImpl transportedao=new transporteDaoImpl();
       
         this.transaction=this.session.beginTransaction();
         apugenal.insertarAPU(session, this.analisisapus);
         this.analisisapus=apugenal.getUltimoRegistroApu(session);
         this.equipherramientas=daoequipo.getUltimoRegistro(session);
         this.manoobras=manoobradao.getUltimoRegistro(session);
         this.materiales=materialdao.getUltimoRegistro(session);
         this.transportes=transportedao.getUltimoRegistro(session);
          for(EquipherrApu item : this.listaEquiposApus)
            {
                this.equipherramientas=daoequipo.getByIdEquipo(session,this.equipherramientas.getCodigoEqherr());
                item.setEquipoherramienta(this.equipherramientas);
               
                item.setAnalisispreciounitario(this.analisisapus);
                  apugenal.insert(this.session, item); }
           //detalle mano de obra
           for(ManoobraApu item : this.listaManoBra)
            {
                this.manoobras=manoobradao.getByIdManobra(session,this.manoobras.getCodigoManob());
                item.setManoobra(this.manoobras);
           
                 item.setAnalisispreciounitario(this.analisisapus);
                  apugenal.insertarManobra(this.session, item);
            }
         // detalle material
             for(MaterialApu item : this.listaMaterialApus)
            {
                this.materiales=materialdao.getByIdMaterial(session,this.materiales.getCodigoMat());
                item.setMaterial(this.materiales);
               
                 item.setAnalisispreciounitario(this.analisisapus);
                  apugenal.insertarMaterial(this.session, item);
            }
          //detalle transporte
            for(TransporteApu item : this.listaTransporteApus)
            {
                this.transportes=transportedao.getByIdTransporte(session,this.transportes.getCodigoTransp());
                item.setTransporte(this.transportes);
               item.setAnalisispreciounitario(this.analisisapus);
                apugenal.insertarTransporte(this.session, item);
                 
            }
          
          	
           
            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Precio Unitario guardado correctamente"));
       
         this.listaEquiposApus=new ArrayList<>();
         this.listaManoBra= new ArrayList<>();
         this.listaMaterialApus=new ArrayList<>();
         this.listaTransporteApus=new ArrayList<>();
         this.analisisapus=new Analisispreciounitario();
         this.auxdesrubro="";
         this.auxcategoria="";
         this.auxiliarPorcenjate=null;
         this.auxiliarotroscostos=null;
         this.auxocidigo=0;
         this.auxunidrubro="";
         this.precioTotalEquipo=0.00;
         this.precioTotalmanoobra=0.00;
         this.precioTotalmaterial=0.00;
         this.precioTotaltransporte=0.00;
         this.costoaputotal=0.00;
         this.costoinAPu=0.00;
         this.totaldirAPU=0.00;
         this.rubro=new Rubro();
         this.escenariosapu=new Escenarioapu();
      
        
         
        } catch (Exception ex) {
            if (this.transaction != null) {
                transaction.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error","NO se Guardo Apu"));
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }    
    //costos totales apus
    public void calcularCostosTotalesAPU() {
        try {
            Double costodir1APu = new Double("0.00");
            Double costoinAPu = new Double("0.00");
            Double costosotrosindAPu = new Double("0.00");
            Double costoaputotal = new Double("0.00");
            Analisispreciounitario apus = new Analisispreciounitario();

            costodir1APu = this.precioTotaltransporte + this.precioTotalEquipo + this.precioTotalmaterial + this.precioTotalmanoobra;
            costoinAPu = (costodir1APu * (this.auxiliarPorcenjate / 100));
            costosotrosindAPu = this.auxiliarotroscostos;
            costoaputotal = costodir1APu + costoinAPu + costosotrosindAPu;
            //setear los totales del apu     
            this.analisisapus.setCostDirApu(costodir1APu);
            this.analisisapus.setCostIndApu(costoinAPu);
            this.analisisapus.setCostOtrosIndApu(costosotrosindAPu);
            this.analisisapus.setCostotApu(costoaputotal);
            this.analisisapus.setPorcenIndApu(getAuxiliarPorcenjate());
            //setear los totales de la pantalla
            this.setTotaldirAPU(costodir1APu);
            this.setCostoinAPu(costoinAPu);
            this.setCostoaputotal(costoaputotal);

            RequestContext.getCurrentInstance().update("frmRealizarVentas:Escenarios:panelFinalVenta21");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));
        }
    }
    //fin de costos totales apus   

    public Equipoherramienta getEquipherramientas() {
        return equipherramientas;
    }

    public void setEquipherramientas(Equipoherramienta equipherramientas) {
        this.equipherramientas = equipherramientas;
    }

    public Double getPrecioTotalEquipo() {
        return precioTotalEquipo;
    }

    public void setPrecioTotalEquipo(Double precioTotalEquipo) {
        this.precioTotalEquipo = precioTotalEquipo;
    }

    public EquipherrApu getEquipapus() {
        return equipapus;
    }

    public void setEquipapus(EquipherrApu equipapus) {
        this.equipapus = equipapus;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public List<EquipherrApu> getListaEquiposApus() {
        return listaEquiposApus;
    }

    public void setListaEquiposApus(List<EquipherrApu> listaEquiposApus) {
        this.listaEquiposApus = listaEquiposApus;
    }

    public Manoobra getManoobras() {
        return manoobras;
    }

    public void setManoobras(Manoobra manoobras) {
        this.manoobras = manoobras;
    }

    public List<ManoobraApu> getListaManoBra() {
        return listaManoBra;
    }

    public void setListaManoBra(List<ManoobraApu> listaManoBra) {
        this.listaManoBra = listaManoBra;
    }

    public ManoobraApu getManopapus() {
        return manopapus;
    }

    public void setManopapus(ManoobraApu manopapus) {
        this.manopapus = manopapus;
    }

    public Double getPrecioTotalmanoobra() {
        return precioTotalmanoobra;
    }

    public void setPrecioTotalmanoobra(Double precioTotalmanoobra) {
        this.precioTotalmanoobra = precioTotalmanoobra;
    }

    public Double getCostoHora() {
        return CostoHora;
    }

    public void setCostoHora(Double CostoHora) {
        this.CostoHora = CostoHora;
    }

    //materiales
    public Material getMateriales() {
        return materiales;
    }

    public void setMateriales(Material materiales) {
        this.materiales = materiales;
    }

    public List<MaterialApu> getListaMaterialApus() {
        return listaMaterialApus;
    }

    public void setListaMaterialApus(List<MaterialApu> listaMaterialApus) {
        this.listaMaterialApus = listaMaterialApus;
    }

    public MaterialApu getMaterialapus() {
        return materialapus;
    }

    public void setMaterialapus(MaterialApu materialapus) {
        this.materialapus = materialapus;
    }

    public Double getPrecioTotalmaterial() {
        return precioTotalmaterial;
    }

    public void setPrecioTotalmaterial(Double precioTotalmaterial) {
        this.precioTotalmaterial = precioTotalmaterial;
    }

    //transporte
    public Transporte getTransportes() {
        return transportes;
    }

    public void setTransportes(Transporte transportes) {
        this.transportes = transportes;
    }

    public List<TransporteApu> getListaTransporteApus() {
        return listaTransporteApus;
    }

    public void setListaTransporteApus(List<TransporteApu> listaTransporteApus) {
        this.listaTransporteApus = listaTransporteApus;
    }

    public TransporteApu getTransportapus() {
        return transportapus;
    }

    public void setTransportapus(TransporteApu transportapus) {
        this.transportapus = transportapus;
    }

    public Double getPrecioTotaltransporte() {
        return precioTotaltransporte;
    }

    public void setPrecioTotaltransporte(Double precioTotaltransporte) {
        this.precioTotaltransporte = precioTotaltransporte;
    }

    public Analisispreciounitario getAnalisisapus() {
        return analisisapus;
    }

    public void setAnalisisapus(Analisispreciounitario analisisapus) {
        this.analisisapus = analisisapus;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public String getAuxdesrubro() {
        return auxdesrubro;
    }

    public void setAuxdesrubro(String auxdesrubro) {
        this.auxdesrubro = auxdesrubro;
    }

    public String getAuxunidrubro() {
        return auxunidrubro;
    }

    public void setAuxunidrubro(String auxunidrubro) {
        this.auxunidrubro = auxunidrubro;
    }

    public List<Rubro> getListaRubro() {
        return listaRubro;
    }

    public void setListaRubro(List<Rubro> listaRubro) {
        this.listaRubro = listaRubro;
    }

    public int getAuxocidigo() {
        return auxocidigo;
    }

    public void setAuxocidigo(int auxocidigo) {
        this.auxocidigo = auxocidigo;
    }

    public List<Analisispreciounitario> getListapus() {
        return listapus;
    }

    public void setListapus(List<Analisispreciounitario> listapus) {
        this.listapus = listapus;
    }

    public String getAuxcategoria() {
        return auxcategoria;
    }

    public void setAuxcategoria(String auxcategoria) {
        this.auxcategoria = auxcategoria;
    }

    public Categoriarubro getCatrubro() {
        return catrubro;
    }

    public void setCatrubro(Categoriarubro catrubro) {
        this.catrubro = catrubro;
    }

    public Double getTotaldirAPU() {
        return totaldirAPU;
    }

    public void setTotaldirAPU(Double totaldirAPU) {
        this.totaldirAPU = totaldirAPU;
    }

    public Double getAuxiliarPorcenjate() {
        return auxiliarPorcenjate;
    }

    public void setAuxiliarPorcenjate(Double auxiliarPorcenjate) {
        this.auxiliarPorcenjate = auxiliarPorcenjate;
    }

    public Double getCostoinAPu() {
        return costoinAPu;
    }

    public void setCostoinAPu(Double costoinAPu) {
        this.costoinAPu = costoinAPu;
    }

    public Double getCostoaputotal() {
        return costoaputotal;
    }

    public void setCostoaputotal(Double costoaputotal) {
        this.costoaputotal = costoaputotal;
    }

    public Double getAuxiliarotroscostos() {
        return auxiliarotroscostos;
    }

    public void setAuxiliarotroscostos(Double auxiliarotroscostos) {
        this.auxiliarotroscostos = auxiliarotroscostos;
    }

    ///probar cambio de datos
   
    //Reporte
    
 
 
public void imprimirpdfaapu(){
  
    this.session = null;
this.transaction = null;
 
          try{
              ApusDaoImpl apugenal=new ApusDaoImpl();
this.session=HibernateUtil.getSessionFactory().openSession();
this.transaction=this.session.beginTransaction();   
this.analisisapus=apugenal.getUltimoRegistroApu(session);
HashMap parametros = new HashMap();
parametros.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION,this.session);
parametros.put("Codigoapu",this.analisisapus.getCodigoApu());
         File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("Reportes/ReporteApu.jasper"));		
		//byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(),parametros,CONEXION);
         // JasperPrint imprimit = JasperFillManager.fillReport(jasper.getPath(),parametros);
          byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(),parametros,this.coneccion);
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream outStream = response.getOutputStream();
		outStream.write(bytes, 0 , bytes.length);
		outStream.flush();
		outStream.close();   
          this.transaction.commit();
            
           // this.analisisapus=new Analisispreciounitario();
            //this.contrasenia=null; 
         /*} catch (Exception ex) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error","NO se puede Generar Apu"));
        } */
                }   catch (Exception ex) {
            
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error","NO se Guardo Apu"));
                }

            
    }
         
	public void imprimirexcelapu(){
      
           this.session = null;
          this.transaction = null;
 
          try{
              ApusDaoImpl apugenal=new ApusDaoImpl();
this.session=HibernateUtil.getSessionFactory().openSession();
this.transaction=this.session.beginTransaction();   
this.analisisapus=apugenal.getUltimoRegistroApu(session);
HashMap parametros = new HashMap();
parametros.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION,this.session);
parametros.put("Codigoapu",this.analisisapus.getCodigoApu());
   
          
          File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("Reportes/ReporteApu.jasper"));		
		  
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(),parametros,this.coneccion);
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition","attachment; filename=APU"+this.analisisapus.getDescApu()+".xls");
		ServletOutputStream outStream = response.getOutputStream();
		
		JRXlsExporter exporter = new JRXlsExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);
		exporter.exportReport();
		
		outStream.flush();
		outStream.close();
		FacesContext.getCurrentInstance().responseComplete();		
          this.transaction.commit();
        }catch(Exception e){
            
  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error","NO se Guardo Apu"));
        }
    }


		public void exportarPDF(ActionEvent actionEvent) throws JRException, IOException{
		 
           this.session = null;
this.transaction = null;
 
          try{
              ApusDaoImpl apugenal=new ApusDaoImpl();
this.session=HibernateUtil.getSessionFactory().openSession();
this.transaction=this.session.beginTransaction();   
this.analisisapus=apugenal.getUltimoRegistroApu(session);
HashMap parametros = new HashMap();
parametros.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION,this.session);
parametros.put("Codigoapu",this.analisisapus.getCodigoApu());
   
		
		File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("Reportes/ReporteApu.jasper"));
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(),parametros, this.coneccion);
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition","attachment; filename=APU"+this.analisisapus.getDescApu()+".pdf");
		ServletOutputStream stream = response.getOutputStream();
		
		JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		
		stream.flush();
		stream.close();
		FacesContext.getCurrentInstance().getResponseStream();
                             this.transaction.commit();
        }catch(Exception e){
            
  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error","NO se Guardo Apu"));
        }
	}
	
//cambio de escenarios
  public void ActivarEscenarios(ValueChangeEvent vcEvent){

       // rendered = Boolean.valueOf(vcEvent.getNewValue().toString()).booleanValue();
       this.escenarioact1=false;
       this.escenarioact2=false;
       this.escenarioact3=false;
        

    }

 


public Connection getConeccion() {
         Session session = this.getSession();
    SessionFactoryImplementor sessionFactoryImplementor = null;
    ConnectionProvider connectionProvider = null;
    java.sql.Connection connection = null;
    try {
        sessionFactoryImplementor = (SessionFactoryImplementor) session.getSessionFactory();
        connectionProvider = (ConnectionProvider) sessionFactoryImplementor.getConnectionProvider().getConnection();
        connection = connectionProvider.getConnection();
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return connection;
    }





    public void setConeccion(Connection coneccion) {
        this.coneccion = coneccion;
    }

//buscar el id para setear los escenarios
  /*  private UIComponent findComponent(String id, UIComponent idcomp) {
if (idcomp == null) {
   return null;
}
else if (idcomp.getId().equals(id)) {
   return idcomp;
}
else {
    
    
   List<UIComponent> childrenList = idcomp.getChildren();
   if (childrenList == null || childrenList.isEmpty()) {
      return null;
   }
   for (UIComponent child : childrenList) {
      UIComponent result = null;
      result = findComponent(id, child);
      if(result != null) {
         return result;
   }
   return result;
}
   }
      
}*/
    
   



    }

