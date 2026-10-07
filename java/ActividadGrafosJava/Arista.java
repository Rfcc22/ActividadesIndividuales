/**
 * Clase Arista - Representa una arista (conexión) de un grafo.
 *
 * Conceptos reforzados:
 * - Arista como elemento de E(G) que conecta puntos extremos
 * - Bucle: arista con un solo punto extremo (extremo1 == extremo2)
 * - Aristas paralelas: dos aristas distintas con los mismos extremos
 * - Incidencia: una arista incide sobre cada uno de sus puntos extremos
 *
 * @author [Rodolfo]
 * @version 1.0
 * Periodo 202660
 */
public class Arista {

    // ============================
    // ATRIBUTOS
    // ============================
    private String nombre;     // Nombre de la arista (ej: "e1", "e2")
    private int id;            // Identificador numérico único
    private Vertice extremo1;  // Primer punto extremo
    private Vertice extremo2;  // Segundo punto extremo
    private boolean esBucle;   // true si extremo1 == extremo2

    // ============================
    // CONSTRUCTORES
    // ============================

    /**
     * Constructor vacío.
     * Inicializa la arista con valores por defecto.
     */
    public Arista() {
        // TODO: Inicializar todos los atributos con valores por defecto
         this.nombre = ""; this.id = 0; this.extremo1 = null; this.extremo2 = null; this.esBucle = false;
    }

    /**
     * Constructor parametrizado.
     * Determina automáticamente si la arista es un bucle.
     *
     * @param nombre   Nombre de la arista (ej: "e1")
     * @param id       Identificador numérico único
     * @param extremo1 Primer vértice (punto extremo)
     * @param extremo2 Segundo vértice (punto extremo)
     */
    public Arista(String nombre, int id, Vertice extremo1, Vertice extremo2) {
        this.nombre = nombre;
        this.id = id;
        this.extremo1 = extremo1;
        this.extremo2 = extremo2;

        if (extremo1 == extremo2){
            this.esBucle = true;
        }



        // TODO: Asignar los parámetros a los atributos correspondientes
        // TODO: Determinar automáticamente si es bucle:
        //       esBucle = (extremo1 == extremo2)  o comparar por id
    }

    // ============================
    // GETTERS
    // ============================

    public String getNombre() {
        // TODO: Retornar el nombre de la arista
        return this.nombre;
    }

    public int getId() {
        // TODO: Retornar el id de la arista
        return this.id;
    }

    public Vertice getExtremo1() {
        // TODO: Retornar el primer punto extremo
        return this.extremo1;
    }

    public Vertice getExtremo2() {
        // TODO: Retornar el segundo punto extremo
        return this.extremo2;
    }

    public boolean esBucle() {
        // TODO: Retornar si la arista es un bucle
        return this.esBucle;
    }

    // ============================
    // MÉTODOS DE LÓGICA
    // ============================

    /**
     * Determina si esta arista es PARALELA a otra arista.
     * Dos aristas son paralelas si tienen el mismo conjunto de puntos extremos.
     *
     * Ejemplo: e2{v1,v3} y e3{v1,v3} son paralelas.
     *
     * @param otra La otra arista a comparar
     * @return true si ambas aristas comparten los mismos puntos extremos
     */
    public boolean esParalela(Arista otra) {
        // TODO: Implementar la comparación de puntos extremos
        // Considerar que {v1, v3} es igual a {v3, v1}
        // Verificar que no sea la misma arista (this.id != otra.id)
        //
        // Pista: Comparar si (this.extremo1 == otra.extremo1 && this.extremo2 == otra.extremo2)
        //        O si (this.extremo1 == otra.extremo2 && this.extremo2 == otra.extremo1)

        if (this.id != otra.id) {
            if ((this.extremo1 == otra.extremo1 && this.extremo2 == otra.extremo2) || (this.extremo1 == otra.extremo2 && this.extremo2 == otra.extremo1)) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("Es la misma arista");
            return false;
        }
    }

    /**
     * Determina si esta arista INCIDE en un vértice dado.
     * Una arista incide sobre cada uno de sus puntos extremos.
     *
     * @param v El vértice a verificar
     * @return true si el vértice es uno de los puntos extremos de esta arista
     */
    public boolean incideEn(Vertice v) {
        // TODO: Verificar si v es extremo1 o extremo2 de esta arista
        // Pista: Comparar por id o por referencia
        if (this.extremo1 == v || this.extremo2 == v){
            return true;
        } else {
            return false;
        }
    }

    // ============================
    // MÉTODOS AUXILIARES
    // ============================

    /**
     * Representación en texto de la arista.
     * Formato: "e1: {v1, v2}" o "e6: {v5} [BUCLE]"
     */
    @Override
    public String toString() {
        // TODO: Retornar una cadena con el formato indicado
        // Si es bucle, mostrar solo un extremo y agregar "[BUCLE]"
        // Si no es bucle, mostrar ambos extremos
        if (this.esBucle()){
            return  this.nombre + ":  {"+ this.extremo1 + "} [BUCLE] ";
        } else {
            return this.nombre + ":  {"+ this.extremo1 + ", " +this.extremo2+"}";
        }
    }
}