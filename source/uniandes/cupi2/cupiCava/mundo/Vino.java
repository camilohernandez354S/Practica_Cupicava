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
package uniandes.cupi2.cupiCava.mundo;

/**
 * Clase que representa un vino almacenado en la Cupi-Cava.<br>
 * <b>inv: </b><br>
 * - nombre != null && nombre != ""<br>
 * - presentacion != null && presentacion != "" && (presentacion == BOTELLA || presentacion == BARRIL)<br>
 * - anhoElaboracion > 0<br>
 * - contenidoAzucar >= 0<br>
 * - tipo != null && tipo != "" && (tipo == SECO || tipo == ABOCADO || tipo == SEMI_SECO || tipo == SEMI_DULCE || tipo == DULCE)<br>
 * - color != null && color != "" && (color == TINTO || color == ROSADO || color == BLANCO)<br>
 * - lugarOrigen != null && lugarOrigen != ""<br>
 * - imagen != null && imagen != ""<br>
 */

public class Vino
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa la presentaci�n barril.
     */
    public final static String BARRIL = "Barril";

    /**
     * Constante que representa la presentaci�n botella.
     */
    public final static String BOTELLA = "Botella";

    /**
     * Constante que representa el color tinto.
     */
    public final static String TINTO = "Tinto";

    /**
     * Constante que representa el color rosado.
     */
    public final static String ROSADO = "Rosado";

    /**
     * Constante que representa el color blanco.
     */
    public final static String BLANCO = "Blanco";

    /**
     * Constante que representa el tipo de vino seco.
     */
    public final static String SECO = "Seco";

    /**
     * Constante que representa el tipo de vino abocado.
     */
    public static final String ABOCADO = "Abocado";

    /**
     * Constante que representa el tipo de vino semi-seco.
     */
    public static final String SEMI_SECO = "Semi-seco";

    /**
     * Constante que representa el tipo de vino semi-dulce.
     */
    public static final String SEMI_DULCE = "Semi-dulce";

    /**
     * Constante que representa el tipo de vino dulce.
     */
    public static final String DULCE = "Dulce";

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Nombre del vino.
     */
    private String nombre;

    /**
     * Presentaci�n del vino.
     */
    private String presentacion;

    /**
     * A�o de elaboraci�n del vino.
     */
    private int anhoElaboracion;

    /**
     * Contenido en az�car del vino (gramos/litro).
     */
    private double contenidoAzucar;

    /**
     * Tipo del vino.
     */
    private String tipo;

    /**
     * Color del vino.
     */
    private String color;

    /**
     * Lugar de origen del vino.
     */
    private String lugarOrigen;

    /**
     * Ruta donde se encuentra la imagen del vino.
     */
    private String imagen;

    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------

    /**
     * Inicializa el vino con la informaci�n dada por par�metro. <br>
     * <b>post: </b> El vino se inicializ� con los valores de nombre, presentaci�n, a�o elaboraci�n, contenido en az�car, tipo, color, lugar de origen e imagen dados por
     * par�metro.
     * @param pNombre Nombre del vino. pNombre != null && pNombre != "".
     * @param pPresentacion Presentaci�n del vino. pPresentacion != null && pPresentacion != "" && (pPresentacion == BOTELLA || pPresentacion == BARRIL).
     * @param pAnhoElaboracion A�o de elaboraci�n del vino. pAnhoElaboracion > 0.
     * @param pContenidoAzucar Contenido en az�car del vino. pContenidoAzucar >= 0
     * @param pTipo Tipo de vino de acuerdo a su contenido en az�car. pTipo != null && pTipo != "" && (pTipo == SECO || pTipo == ABOCADO || pTipo == SEMI_SECO || pTipo ==
     *        SEMI_DULCE || pTipo == DULCE).
     * @param pColor Color del vino. pColor != null && pColor != "" && (pColor == TINTO || pColor == ROSADO || pColor == BLANCO).
     * @param pLugarOrigen Lugar de origen del vino. lugarElaboracion != null y lugarElaboracion != "".
     * @param pImagen Imagen del vino. pImagen != null && pImagen != "".
     */
    public Vino( String pNombre, String pPresentacion, int pAnhoElaboracion, double pContenidoAzucar, String pTipo, String pColor, String pLugarOrigen, String pImagen )
    {
        nombre = pNombre;
        presentacion = pPresentacion;
        anhoElaboracion = pAnhoElaboracion;
        contenidoAzucar = pContenidoAzucar;
        tipo = pTipo;
        color = pColor;
        lugarOrigen = pLugarOrigen;
        imagen = pImagen;
        verificarInvariante();

    }

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Retorna el nombre del vino.
     * @return Nombre del vino.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la presentaci�n del vino.
     * @return Presentaci�n del vino.
     */
    public String darPresentacion( )
    {
        return presentacion;
    }

    /**
     * Retorna el a�o de elaboraci�n del vino.
     * @return A�o de elaboraci�n del vino.
     */
    public int darAnhoElaboracion( )
    {
        return anhoElaboracion;
    }

    /**
     * Retorna el contenido en az�car del vino.
     * @return Contenido en az�car del vino.
     */
    public double darContenidoAzucar( )
    {
        return contenidoAzucar;
    }

    /**
     * Retorna el tipo del vino.
     * @return Tipo del vino.
     */
    public String darTipo( )
    {
        return tipo;
    }

    /**
     * Retorna el color del vino.
     * @return Color del vino.
     */
    public String darColor( )
    {
        return color;
    }

    /**
     * Retorna el lugar de origen del vino.
     * @return Lugar de origen del vino.
     */
    public String darLugarOrigen( )
    {
        return lugarOrigen;
    }

    /**
     * Retorna la imagen del vino.
     * @return Imagen del vino.
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Compara dos vinos seg�n el nombre. <br>
     * @param pVino Vino contra el cual se est� comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo nombre. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el nombre. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el nombre. <br>
     */
    public int compararPorNombre( Vino pVino ) throws Exception
    {
    	if (pVino == null) {
    		throw new Exception("El campo no puede estar vacio");
    	}
    	try {
    		if (pVino.darNombre().length() == nombre.length()) {
    			return 0;
    		} else if (pVino.darNombre().length() > nombre.length()){
    			return -1;
    		} else {
    			return 1;
    		}
    	} catch (Exception e) {
    		throw new Exception("Error al comparar los nombres");
    	}
    }

    /**
     * Compara dos vinos seg�n la presentaci�n. <br>
     * @param pVino Vino contra el cual se est� comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen la misma presentaci�n. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para la presentaci�n. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para la presentaci�n. <br>
     */
    public int compararPorPresentacion(Vino pVino) throws Exception 
    {
        try {
            if (pVino == null || this.presentacion == null || pVino.presentacion == null) {
                throw new Exception("La presentaci�n no puede ser null.");
            }

            int comparacion = this.presentacion.compareTo(pVino.presentacion);

            if (comparacion == 0) {
                return 0;
            } else if (comparacion < 0) {
                return 1;
            } else {
                return -1;
            }

        } catch (Exception e) {
            throw new Exception("Error al comparar las presentaciones: " + e.getMessage());
        }
    }

    /**
     * Compara dos vinos seg�n el a�o de elaboraci�n. <br>
     * @param pVino Vino contra el cual se est� comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo a�o de elaboraci�n. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el a�o de elaboraci�n. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el a�o de elaboraci�n. <br>
     */
    public int compararPorAnhoElaboracion(Vino pVino) throws Exception {
        if (pVino == null) {
            throw new Exception("El vino a comparar no puede ser null.");
        }
        if (this.anhoElaboracion == pVino.anhoElaboracion) {
            return 0;
        } else if (pVino.anhoElaboracion > this.anhoElaboracion) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * Compara dos vinos seg�n el contenido en az�car. <br>
     * @param pVino Vino contra el cual se est� comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo contenido en az�car. <br>
     *         Retorna -1 si el vino pVino tiene un mayor contenido en az�car. <br>
     *         Retorna 1 si el vino pVino tiene un menor contenido en az�car. <br>
     */
    public int compararPorContenidoAzucar(Vino pVino) throws Exception {
        if (pVino == null) {
            throw new Exception("El vino a comparar no puede ser null.");
        }
        if (this.contenidoAzucar == pVino.contenidoAzucar) {
            return 0;
        } else if (pVino.contenidoAzucar > this.contenidoAzucar) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * Compara dos vinos seg�n el tipo de vino. <br>
     * @param pVino Vino contra el cual se est� comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo tipo. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el tipo. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el tipo. <br>
     */
    public int compararPorTipo(Vino pVino) throws Exception {
        if (pVino == null || this.tipo == null || pVino.tipo == null) {
            throw new Exception("El tipo del vino no puede ser null.");
        }
        int comparacion = this.tipo.compareTo(pVino.tipo);
        if (comparacion == 0) {
            return 0;
        } else if (comparacion < 0) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Compara dos vinos seg�n el color. <br>
     * @param pVino Vino contra el cual se est� comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo color. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el color. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el color. <br>
     */
    public int compararPorColor(Vino pVino) throws Exception {
        if (pVino == null || this.color == null || pVino.color == null) {
            throw new Exception("El color del vino no puede ser null.");
        }
        int comparacion = this.color.compareTo(pVino.color);
        if (comparacion == 0) {
            return 0;
        } else if (comparacion < 0) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Compara dos vinos seg�n el lugar de origen. <br>
     * @param pVino Vino contra el cual se est� comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo lugar de origen. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el lugar de origen. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el lugar de origen. <br>
     */
    public int compararPorLugarOrigen(Vino pVino) throws Exception {
        if (pVino == null || this.lugarOrigen == null || pVino.lugarOrigen == null) {
            throw new Exception("El lugar de origen no puede ser null.");
        }
        int comparacion = this.lugarOrigen.compareTo(pVino.lugarOrigen);
        if (comparacion == 0) {
            return 0;
        } else if (comparacion < 0) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Retorna una cadena con el nombre del vino.
     * @return Representaci�n del vino en una cadena de caracteres.
     */
    public String toString( )
    {
        return nombre;
    }
    
    public int compareTo(String nombreVino) {
    	return this.nombre.compareTo(nombreVino);
    }
    
    public int compareToOrigen(String origen) {
    	return this.lugarOrigen.compareTo(origen);
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica que se cumplan todas las condiciones de la invariante de la clase.
     * Si alguna condici�n no se cumple, lanza una excepci�n AssertionError.
     */
    private void verificarInvariante() {
    	assert nombre != null && !nombre.isEmpty() : "Nombre inv�lido";
    	assert presentacion != null && (presentacion.equals(BOTELLA) || presentacion.equals(BARRIL)) : "Presentaci�n inv�lida";
    	assert anhoElaboracion > 0 : "A�o de elaboraci�n inv�lido";
    	assert contenidoAzucar >= 0 : "Contenido de az�car inv�lido";
    	assert tipo != null && (
    		tipo.equals(SECO) || tipo.equals(ABOCADO) || tipo.equals(SEMI_SECO) ||
    		tipo.equals(SEMI_DULCE) || tipo.equals(DULCE)
    	) : "Tipo de vino inv�lido";
    	assert color != null && (
    		color.equals(TINTO) || color.equals(ROSADO) || color.equals(BLANCO)
    	) : "Color de vino inv�lido";
    	assert lugarOrigen != null && !lugarOrigen.isEmpty() : "Lugar de origen inv�lido";
    	assert imagen != null && !imagen.isEmpty() : "Imagen inv�lida";
 }
}