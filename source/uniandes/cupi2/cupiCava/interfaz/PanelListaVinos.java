/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiCava
 * Autor: Equipo Cupi2 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiCava.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Panel con la lista de vinos de la cava.
 */
public class PanelListaVinos extends JPanel implements ListSelectionListener, ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	
	private static final long serialVersionUID = 1L;

    /**
     * Constante que representa el comando de agregar un vino.
     */	
    private final static String AGREGAR = "Agregar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazCupiCava principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Lista de los vinos.
     */
    // TODO Parte3 PuntoA: Declare el atributo listaVinos de tipo JList.
    private JList<String> listaVinos;
    
    /**
     * Modelo para la lista de vinos, facilita la adici�n y eliminaci�n de elementos.
     */
    private DefaultListModel<String> modeloListaVinos; // Nuevo atributo para el modelo de la lista

    /**
     * Panel con un scroll que contiene a listaVinos.
     */
    private JScrollPane scroll;

    /**
     * Bot�n para agregar un nuevo vino.
     */
    private JButton botonAgregar;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public PanelListaVinos( InterfazCupiCava pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new BorderLayout( ) );
        setBorder( new CompoundBorder( new EmptyBorder( 0, 5, 0, 5 ), new TitledBorder( "Lista de vinos" ) ) );
        setPreferredSize( new Dimension( 250, 0 ) );

        // TODO Parte3 PuntoB: Inicializar la lista de vinos y agregarle un ListSelectionListener
        listaVinos = new JList<>();
        listaVinos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaVinos.addListSelectionListener(this);
        

     // TODO Parte3 PuntoC: Inicializar el scroll.
        scroll = new JScrollPane(listaVinos);
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );

        botonAgregar = new JButton( AGREGAR );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );

        add( scroll, BorderLayout.CENTER );
        add( botonAgregar, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista de vinos con la lista recibida por par�metro.
     * @param pListaVinos Lista de los vinos. pListaVinos != null.
     */
    public void refrescarLista( ArrayList<String> pListaVinos )
    {
        modeloListaVinos.clear();
        for (Object vino : pListaVinos) {
            modeloListaVinos.addElement(vino.toString()); 
        }
        
        if( !pListaVinos.isEmpty( ) )
        {
            listaVinos.setSelectedIndex( 0 );
        }
    }

    /**
     * Actualiza el vino seleccionado.
     * @param pNombreVino Nombre del vino seleccionado. pNombreVino != null && pNombreVino != "".
     */
    public void seleccionar( String nombreVino )
    {
        int indice = -1;
        for( int i = 0; i < modeloListaVinos.getSize( ); i++ )
        {
            String vinoActual = modeloListaVinos.getElementAt( i );
            if( vinoActual.equals( nombreVino ) )
            {
                indice = i;
                break;
            }
        }

        listaVinos.setSelectedIndex( indice );
        listaVinos.ensureIndexIsVisible( indice );
    }

    /**
     * Atiende el evento cuando el usuario selecciona un vino de la lista.
     * @param pEvento Evento de selecci�n de un elemento de la lista de vinos. pEvento != null.
     */
    public void valueChanged( ListSelectionEvent pEvento )
    {
        // Solo procesar el evento cuando la selecci�n ha terminado de ajustarse
        if ( !pEvento.getValueIsAdjusting() ) {
            if( listaVinos.getSelectedValue( ) != null )
            {
                String nombreVino = listaVinos.getSelectedValue( ); // No necesita casting si JList es de tipo <String>
                principal.actualizarInfoVino( nombreVino );
            }
        }
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( AGREGAR ) )
        {
            DialogoAgregarVino dialogoAgregar = new DialogoAgregarVino( principal );
            dialogoAgregar.setVisible( true );
        }
    }

}