import java.util.ArrayList;

/**
 * Clase Grafo - Representa un grafo no dirigido G = (V, E).
 *
 * Conceptos reforzados:
 * - Grafo G con conjuntos V(G) de vértices y E(G) de aristas
 * - Función punto extremo-arista
 * - Grado de vértice (bucle cuenta doble)
 * - Teorema del Saludo de Mano: gradoTotal = 2 × |E|
 * - Corolario 10.1.2: El grado total de un grafo siempre es par
 *
 * @author [Rodolfo]
 * @version 1.0
 * Periodo 202660
 */
public class Grafo {

    // ============================
    // ATRIBUTOS
    // ============================
    private String nombre;                  // Nombre del grafo
    private ArrayList<Vertice> vertices;    // Conjunto V(G)
    private ArrayList<Arista> aristas;      // Conjunto E(G)
    private int gradoTotal;                 // Suma de todos los grados

    // ============================
    // CONSTRUCTORES
    // ============================

    /**
     * Constructor vacío.
     */
    public Grafo() {
        // TODO: Inicializar nombre = "", las listas vacías y gradoTotal = 0
        this.nombre = ""; this.gradoTotal = 0;
        this.aristas = new ArrayList<Arista>(); this.vertices = new ArrayList<Vertice>();
    }

    /**
     * Constructor parametrizado.
     * @param nombre Nombre del grafo
     */
    public Grafo(String nombre) {
        // TODO: Asignar el nombre y crear las listas vacías
        // Inicializar gradoTotal en 0
        this.nombre = nombre; this.gradoTotal = 0;
        this.aristas = new ArrayList<Arista>(); this.vertices = new ArrayList<Vertice>();
    }

    // ============================
    // MÉTODOS DE CONSTRUCCIÓN
    // ============================

    /**
     * Agrega un vértice al conjunto V(G) del grafo.
     * @param v Vértice a agregar
     */
    public void agregarVertice(Vertice v) {
        // TODO: Agregar el vértice a la lista de vértices
        this.vertices.add(v);
    }

    /**
     * Agrega una arista al conjunto E(G) del grafo.
     * @param a Arista a agregar
     */
    public void agregarArista(Arista a) {
        // TODO: Agregar la arista a la lista de aristas
        this.aristas.add(a);
    }

    // ============================
    // MÉTODOS DE GRADO
    // ============================

    /**
     * Calcula el GRADO de un vértice.
     *
     * REGLA CLAVE: Un bucle contribuye con 2 al grado del vértice.
     * Una arista normal que incide en v contribuye con 1.
     *
     * Ejemplo del documento:
     * - v3 tiene aristas e1, e2 incidentes + e3 (bucle) → deg(v3) = 2 + 2 = 4
     *
     * @param v Vértice al que se le calculará el grado
     * @return El grado del vértice
     */
    public int calcularGrado(Vertice v) {
        int grado = 0;
        // TODO: Recorrer todas las aristas del grafo
        // Para cada arista:
        //   - Si la arista es un BUCLE y su extremo es v → sumar 2
        //   - Si la arista NO es bucle y incide en v → sumar 1
        //
        // Actualizar el grado del vértice con v.setGrado(grado)
        // Actualizar si es aislado con v.setEsAislado(grado == 0)
        // Retornar el grado calculado
        for (Arista a : aristas) {
            if (a == null) {
                v.setEsAislado(grado == 0);
            } else {
                if (a.esBucle() && (a.getExtremo1() == v || a.getExtremo2() == v)) {
                    grado += 2;
                    v.setGrado(grado);

                }
                if (!a.esBucle() && (a.incideEn(v))) {
                    grado += 1;
                    v.setGrado(grado);
                }
            }
        }
        return grado;
    }

    /**
     * Calcula el GRADO TOTAL del grafo.
     * Es la suma de los grados de todos los vértices.
     *
     * @return El grado total del grafo
     */
    public int calcularGradoTotal() {
        gradoTotal = 0;
        // TODO: Recorrer todos los vértices
        // Para cada vértice, llamar a calcularGrado(v) y sumar al gradoTotal
        // Retornar gradoTotal
        for (Vertice v : vertices){
           gradoTotal =  calcularGrado(v) + gradoTotal;
        }
        return gradoTotal;
    }

    // ============================
    // MÉTODOS DE TERMINOLOGÍA
    // ============================

    /**
     * Obtiene todos los vértices ADYACENTES a un vértice dado.
     * Dos vértices son adyacentes si están conectados por una arista.
     * Si v tiene un bucle, v es adyacente a sí mismo.
     *
     * @param v Vértice de referencia
     * @return Lista de vértices adyacentes a v
     */
    public ArrayList<Vertice> obtenerAdyacentes(Vertice v) {
        ArrayList<Vertice> adyacentes = new ArrayList<>();
        // TODO: Recorrer todas las aristas
        // Para cada arista que incida en v:
        //   - Si es bucle → agregar v a la lista (adyacente a sí mismo)
        //   - Si no es bucle:
        //       * Si extremo1 es v → agregar extremo2 (si no está ya en la lista)
        //       * Si extremo2 es v → agregar extremo1 (si no está ya en la lista)
        // Pista: Usar !adyacentes.contains(vertice) para evitar duplicados
        for (Arista a : aristas) {
            if (!adyacentes.contains(v)){
                if (a.esBucle()){
                    adyacentes.add(v);
                } else {
                    if (a.getExtremo1() == v){
                        adyacentes.add(a.getExtremo1());
                    } else if (a.getExtremo2() == v){
                        adyacentes.add(a.getExtremo2());
                    }
                }
            }
        }
        return adyacentes;
    }

    /**
     * Obtiene todas las aristas que INCIDEN en un vértice dado.
     * Una arista incide sobre cada uno de sus puntos extremos.
     *
     * @param v Vértice de referencia
     * @return Lista de aristas incidentes en v
     */
    public ArrayList<Arista> obtenerAristasIncidentes(Vertice v) {
        ArrayList<Arista> incidentes = new ArrayList<>();
        // TODO: Recorrer todas las aristas
        // Si la arista incide en v (usar método incideEn), agregarla a la lista
        for (Arista a : aristas){
            if (a.incideEn(v)){
                incidentes.add(a);
            }
        }
        return incidentes;
    }

    /**
     * Obtiene todas las aristas ADYACENTES a una arista dada.
     * Dos aristas son adyacentes si comparten al menos un punto extremo.
     *
     * @param a Arista de referencia
     * @return Lista de aristas adyacentes a la arista a
     */
    public ArrayList<Arista> obtenerAristasAdyacentes(Arista a) {
        ArrayList<Arista> adyacentes = new ArrayList<>();
        // TODO: Recorrer todas las aristas
        // Para cada arista diferente de 'a':
        //   - Si comparte al menos un punto extremo con 'a' → agregarla
        // Pista: Una arista 'b' es adyacente a 'a' si:
        //   b.incideEn(a.getExtremo1()) || b.incideEn(a.getExtremo2())
        for (Arista b : aristas){
            if (b.incideEn(a.getExtremo1()) || b.incideEn(a.getExtremo2())){
                adyacentes.add(b);
            }
        }
        return adyacentes;
    }

    /**
     * Obtiene todos los BUCLES del grafo.
     * Un bucle es una arista con un solo punto extremo.
     *
     * @return Lista de aristas que son bucles
     */
    public ArrayList<Arista> obtenerBucles() {
        ArrayList<Arista> bucles = new ArrayList<>();
        // TODO: Recorrer todas las aristas
        // Si la arista es un bucle (usar método esBucle), agregarla a la lista
        for (Arista a : aristas){
            if (a.esBucle()){
                bucles.add(a);
            }
        }

        return bucles;
    }

    /**
     * Obtiene los pares de aristas PARALELAS del grafo.
     * Dos aristas son paralelas si tienen el mismo conjunto de puntos extremos.
     *
     * @return Lista de cadenas describiendo los pares paralelos
     */
    public ArrayList<String> obtenerParalelas() {
        ArrayList<String> paralelas = new ArrayList<>();
        // TODO: Comparar cada par de aristas (doble ciclo for)
        // Para evitar duplicados, el segundo ciclo inicia en i+1
        // Si arista_i es paralela a arista_j → agregar descripción al resultado
        // Formato: "{e2, e3}"
        for (Arista a : aristas){
            for (Arista b : aristas) {
                if(a.esParalela(b)){
                    paralelas.add("{"+a+", "+b+"}");
                }
            }
        }
        return paralelas;
    }

    /**
     * Obtiene todos los vértices AISLADOS del grafo.
     * Un vértice aislado es aquel en el que no incide arista alguna (grado = 0).
     *
     * @return Lista de vértices aislados
     */
    public ArrayList<Vertice> obtenerVerticesAislados() {
        ArrayList<Vertice> aislados = new ArrayList<>();
        // TODO: Recorrer todos los vértices
        // Si el vértice es aislado (grado == 0), agregarlo a la lista
        // Nota: Asegurarse de que calcularGradoTotal() se haya ejecutado antes
        for (Vertice v : vertices){
            if (v.esAislado()){
                aislados.add(v);
            }
        }
        return aislados;
    }

    // ============================
    // MÉTODOS DE PRESENTACIÓN
    // ============================

    /**
     * Muestra la TABLA DE FUNCIÓN PUNTO EXTREMO-ARISTA.
     *
     * Formato esperado:
     * | Arista | Punto(s) Extremo(s) |
     * |--------|---------------------|
     * | e1     | {v1, v2}            |
     * | e6     | {v5} [BUCLE]        |
     */
    public void mostrarTablaExtremos() {
        System.out.println("\n--- Tabla Punto Extremo - Arista ---");
        System.out.printf("| %-8s | %-22s |%n", "Arista", "Punto(s) Extremo(s)");
        System.out.println("|----------|------------------------|");

        // TODO: Recorrer todas las aristas
        // Para cada arista:
        //   - Si es bucle → imprimir: | e6     | {v5} [BUCLE]        |
        //   - Si no es bucle → imprimir: | e1     | {v1, v2}            |
        // Usar System.out.printf para alinear columnas
        for (Arista a : aristas){
            System.out.println(a);
            System.out.println();
        }
    }


    // ============================
    // MÉTODOS AUXILIARES
    // ============================

    /**
     * Representación en texto del grafo.
     * Muestra: nombre, cantidad de vértices y aristas.
     */
    @Override
    public String toString() {
        // TODO: Retornar "Grafo [nombre]: |V| = X, |E| = Y"
        return "Grafo ["+this.nombre+"]: [V] = "+this.vertices.size()+"[E] + " + this.aristas.size();
    }
}