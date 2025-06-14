/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiCava
 * Autor: Equipo Cupi2 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiCava.mundo;

import java.util.ArrayList;

/**
 * Clase que representa la Cupi-Cava. <br>
 * <b>inv: </b> <br>
 * - La lista de vinos (vinos) no es null.<br>
 * - Ningún elemento de la lista de vinos es null.<br>
 */

public class CupiCava
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Lista de vinos en la cava.
     */
    private ArrayList<Vino> vinos;

    // -------------------------------------------------------------
    // Método Constructor
    // -------------------------------------------------------------

    /**
     * Construye una nueva cava sin vinos. <br>
     * <b>post:</b> La lista de vinos ha sido inicializada.
     */
    public CupiCava( )
    {
        vinos = new ArrayList<Vino>( );
        verificarInvariante();
    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Retorna la lista de vinos.
     * @return Lista de vinos.
     */
    public ArrayList<Vino> darVinos( )
    {
        return vinos;
    }

    /**
     * Busca un vino con el nombre dado por parámetro. <br>
     * <b>pre:</b> La lista de vinos está inicializada.
     * @param pNombre Nombre del vino. pNombre != null && pNombre != ""
     * @return Vino con el nombre dado, null en caso de no encontrarlo.
     */
    public Vino buscarVino( String pNombre )
    {
        Vino buscado = null;
        boolean encontre = false;

        for( int i = 0; i < vinos.size( ) && !encontre; i++ )
        {
            Vino vinoActual = ( Vino )vinos.get( i );
            if( vinoActual.darNombre( ).equalsIgnoreCase( pNombre ) )
            {
                buscado = vinoActual;
                encontre = true;
            }
        }

        return buscado;
    }

    /**
     * Busca un vino utilizando una búsqueda binaria. <br>
     * <b>pre: </b> La lista de vinos está inicializada y se encuentra ordenada por nombre.
     * @param pNombre Nombre del vino que se va a buscar. pNombre != null && pNombre != "".
     * @return Vino con el nombre dado, null en caso de no encontrarlo.
     */
    public Vino buscarBinarioPorNombre( String pNombre ) throws Exception
    {
    	if (pNombre == null) {
    		throw new Exception("No se ingreso el nombre");
    	}
    	try {
    		int izquierda = 0;
    		int derecha = vinos.size() - 1;
    		while(izquierda <= derecha) {
    			int valorMedio = izquierda + (derecha -izquierda) / 2;
    			
    			Vino vino = vinos.get(valorMedio);
    			
    			int comparacion = pNombre.compareTo(vino.darNombre());
    			
    			if (comparacion == 0) {
    				return vino;
    			} else if (comparacion < 0) {
    				derecha = valorMedio - 1;
    			} else {
    				izquierda = valorMedio + 1;
    			}
    		}
    		return null;
    		
    	} catch (Exception e) {
    		throw new Exception("Error al buscar binario por nombre");
    	}
    }

    /**
     * Busca el vino más dulce (con mayor contenido en azúcar) de la cava. <br>
     * <b>pre:</b> La lista de vinos está inicializada.
     * @return Vino más dulce de la cava. Si la cava no tiene vinos se retorna null. Si existen varios vinos con el contenido en azúcar más alto, se retorna el primer vino
     *         encontrado.
     */
    public Vino buscarVinoMasDulce( ) throws Exception
    {
    	if (vinos.size() == 0) {
    		return null;
    	}
    	try {
    		Vino vinoMasDulce = vinos.get(0);
    		for (Vino vino : vinos) {
    			if (vino.darContenidoAzucar() > vinoMasDulce.darContenidoAzucar()) {
    				vinoMasDulce = vino;
    			}
    		}
    		return vinoMasDulce;
    	} catch (Exception e) {
    		throw new Exception("Error al buscar el vino mas dulce");
    	}
    }

    /**
     * Busca el vino más seco (con menor contenido en azúcar) de la cava. <br>
     * <b>pre:</b> La lista de vinos está inicializada.
     * @return Vino más seco de la cava. Si la cava no tiene vinos se retorna null. Si existen varios vinos con el contenido en azúcar más bajo, se retorna el primer vino
     *         encontrado.
     */
    public Vino buscarVinoMasSeco( ) throws Exception
    {
    	if (vinos.size() == 0) {
    		return null;
    	}
    	try {
    		Vino vinoMasSeco = vinos.get(0);
    		for (Vino vino : vinos) {
    			if (vino.darContenidoAzucar() < vinoMasSeco.darContenidoAzucar()) {
    				vinoMasSeco = vino;
    			}
    		}
    		return vinoMasSeco;
    	} catch (Exception e) {
    		throw new Exception("Error al buscar el vino mas seco");
    	}
   }

    /**
     * Busca los vinos del tipo dado por parámetro. <br>
     * <b>pre:</b> La lista de vinos está inicializada.
     * @param pTipo Tipo de vino de acuerdo a su contenido en azúcar.pTipo != null && pTipo != "" && (pTipo == SECO || pTipo == ABOCADO || pTipo == SEMI_SECO || pTipo ==
     *        SEMI_DULCE || pTipo == DULCE).
     * @return Lista de vinos del tipo dado.
     */
    public ArrayList<Vino> buscarVinosDeTipo(String pTipo) throws Exception 
	{
	    if (pTipo == null) {
	        throw new Exception("El tipo de vino no puede ser nulo o vacío");
	    }

	    ArrayList<Vino> vinosTipo = new ArrayList<>();

	    for (Vino vino : vinos) {
	        if (vino.darTipo().equals(pTipo)) {
	            vinosTipo.add(vino);
	        }
	    }

	    return vinosTipo;
	}

    /**
     * Agrega un nuevo vino a la cava si no existe actualmente un vino en la cava con el mismo nombre.<br>
     * <b>pre:</b> La lista de vinos está inicializada.<br>
     * <b>post:</b> Se agregó un nuevo vino a la lista de vinos.<br>
     * @param pNombre Nombre del vino. pNombre != null && pNombre != "".
     * @param pPresentacion Presentación del vino. pPresentacion != null && pPresentacion != "" && (pPresentacion == BOTELLA || pPresentacion == BARRIL).
     * @param pAnhoElaboracion Año de elaboración del vino. pAnhoElaboracion > 0.
     * @param pContenidoAzucar Contenido en azúcar del vino. pContenidoAzucar >= 0
     * @param pTipo Tipo de vino de acuerdo a su contenido en azúcar. pTipo != null && pTipo != "" && (pTipo == SECO || pTipo == ABOCADO || pTipo == SEMI_SECO || pTipo ==
     *        SEMI_DULCE || pTipo == DULCE).
     * @param pColor Color del vino. pColor != null && pColor != "" && (pColor == TINTO || pColor == ROSADO || pColor == BLANCO).
     * @param pLugarOrigen Lugar de origen del vino. lugarElaboracion != null y lugarElaboracion != "".
     * @param pImagen Imagen del vino. pImagen != null && pImagen != "".
     * @return True si el vino es agregado, false de lo contrario.
     */
    public boolean agregarVino( String pNombre, String pPresentacion, int pAnhoElaboracion, double pContenidoAzucar, String pTipo, String pColor, String pLugarOrigen, String pImagen )
    {
        Vino buscado = buscarVino( pNombre );
        boolean agregada = false;

        if( buscado == null )
        {
            Vino vino = new Vino( pNombre, pPresentacion, pAnhoElaboracion, pContenidoAzucar, pTipo, pColor, pLugarOrigen, pImagen );
            vinos.add( vino );
            agregada = true;
        }

        return agregada;
    }

    /**
     * Ordena ascendentemente la lista de vinos por nombre usando el algoritmo de burbuja. <br>
     * <b>pre:</b> La lista de vinos está inicializada. <br>
     * <b>post:</b> La lista de vinos está ordenada por nombre (orden ascendente).
     */
    public void ordenarVinosPorNombre() throws Exception {
        if (vinos == null) {
            throw new Exception("La lista de vinos no ha sido inicializada.");
        }

        int tamanoListaVinos = vinos.size();
        boolean intercambio;

        for (int i = 0; i < tamanoListaVinos - 1; i++) {
            intercambio = false;
            for (int j = 0; j < tamanoListaVinos - 1 - i; j++) {
                String nombreActual = vinos.get(j).darNombre();
                String nombreSiguiente = vinos.get(j + 1).darNombre();

                if (nombreActual.compareTo(nombreSiguiente) > 0) {
                    Vino vinoTemporal = vinos.get(j);
                    vinos.set(j, vinos.get(j + 1));
                    vinos.set(j + 1, vinoTemporal);
                    intercambio = true;
                }
            }
            if (!intercambio) {
                break;
            }
        }
    }

    /**
     * Ordena descendentemente la lista de vinos por año de elaboración usando el algoritmo de selección. <br>
     * <b>pre:</b> La lista de vinos está inicializada. <br>
     * <b>post:</b> La lista de vinos está ordenada por año de elaboración (orden descendente).
     */
    public void ordenarVinosPorAnhoElaboracion( )
    {
    	int longList = vinos.size();
    	
    	for (int i = 0; i < longList - 1; i++ ) {
    		int indiceMaximo = i;
    		for (int j = i + 1; j < longList; j++) {
    			if(vinos.get(j).darAnhoElaboracion() > vinos.get(indiceMaximo).darAnhoElaboracion()) {
    				indiceMaximo = j;
    			}
    		}
    		if (indiceMaximo != i) {
    			Vino vinoAux = vinos.get(i);
    			
    			vinos.set(i, vinos.get(indiceMaximo));
    			
    			vinos.set(indiceMaximo, vinoAux);
    		}
    	}
   }

    /**
     * Ordena ascendentemente la lista de vinos por lugar de origen usando el algoritmo de inserción. <br>
     * <b>pre:</b> La lista de vinos está inicializada.<br>
     * <b> post: </b>La lista de vinos está ordenada por lugar de origen (orden ascendente).
     */
    public void ordenarVinosPorLugarOrigen( )
    {
    	int longVinos = vinos.size();
    	
    	for ( int i = 1; i < longVinos; i++) {
    		Vino vinoKey = vinos.get(i);
    		
    		int j = i - 1;
    		
    		while (j >= 0 && vinos.get(j).darLugarOrigen().compareTo(vinoKey.darLugarOrigen()) > 0) {
    			vinos.set(j + 1, vinos.get(j));
    			j = j - 1;
    		}
    		vinos.set(j + 1, vinoKey);
    	}
    	
   }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    private void verificarInvariante() {
        assert vinos != null : "La lista de vinos no puede ser null";
        for (Vino v : vinos) {
            assert v != null : "La lista de vinos contiene un vino null";
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1.";
    }

    /**
     * Método para la extensión 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }
}