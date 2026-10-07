/**
 * Clase Vertice - Representa un vértice (nodo) de un grafo.
 *
 * Conceptos reforzados:
 * - Vértice como elemento fundamental de un grafo V(G)
 * - Vértice aislado: no incide arista alguna
 * - Grado de un vértice: número de extremos de aristas que salen de él
 *
 * @author [Rodolfo]
 * @version 1.0
 * Periodo 202660
 */
public class Vertice {

    // ============================
    // ATRIBUTOS
    // ============================
    private String nombre;   // Nombre del vértice (ej: "v1", "v2")
    private int id;          // Identificador numérico único
    private int grado;       // Grado del vértice (se calcula desde Grafo)
    private boolean esAislado; // true si no incide arista alguna (grado == 0)

    // ============================
    // CONSTRUCTORES
    // ============================

    /**
     * Constructor vacío.
     * Inicializa el vértice con valores por defecto.
     */
    public Vertice() {
        // TODO: Inicializar todos los atributos con valores por defecto
         this.nombre = ""; this.id = 0; this.grado = 0; this.esAislado = true;
    }

    /**
     * Constructor parametrizado.
     * @param nombre Nombre del vértice (ej: "v1")
     * @param id Identificador numérico único
     */
    public Vertice(String nombre, int id) {
        // TODO: Asignar los parámetros a los atributos correspondientes
        // Inicializar grado en 0 y esAislado en true
        this.nombre = nombre;
        this.id = id;
        this.grado = 0;
        this.esAislado = true;
    }

    // ============================
    // GETTERS Y SETTERS
    // ============================

    public String getNombre() {
        // TODO: Retornar el nombre del vértice
        return this.nombre;
    }

    public void setNombre(String nombre) {
        // TODO: Asignar el nombre recibido al atributo
        this.nombre = nombre;
    }

    public int getId() {
        // TODO: Retornar el id del vértice
        return this.id;
    }

    public void setId(int id) {
        // TODO: Asignar el id recibido al atributo
        this.id = id;
    }

    public int getGrado() {
        // TODO: Retornar el grado del vértice
        return this.grado;
    }

    public void setGrado(int grado) {
        // TODO: Asignar el grado recibido al atributo
        this.grado = grado;
    }

    public boolean esAislado() {
        // TODO: Retornar si el vértice es aislado
        return this.esAislado;
    }

    public void setEsAislado(boolean esAislado) {
        // TODO: Asignar el valor recibido al atributo
        this.esAislado = esAislado;
    }

    // ============================
    // MÉTODOS AUXILIARES
    // ============================

    /**
     * Representación en texto del vértice.
     * Formato esperado: "v1 (grado: 3)" o "v4 (grado: 0) [AISLADO]"
     */
    @Override
    public String toString() {
        // TODO: Retornar una cadena con el formato indicado
        // Si el vértice es aislado, agregar "[AISLADO]" al final
        if (esAislado()){
            return this.nombre +": (grado: " + this.grado + ") [AISLADO]";
        } else {
            return this.nombre +": (grado: " + this.grado + ")";
        }
    }
}