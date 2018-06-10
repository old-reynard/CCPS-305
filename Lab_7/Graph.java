import java.util.Arrays;
/**
 * class Graphs.
 *
 * @author Nikita Gerasimov
 * @version 2018-06-10
 */
public class Graph
{

    static private Edge[] edges;
    static private Vertex[] vertices;


    public Graph(Vertex[] vs, Edge[] es) {
        vertices = vs;
        edges = es;
    }

    /**
     * Create the Edge Endpoint function of the graph
     */
    public static void createEdgeEndpoint(Graph graph) {
        int i = 1;
        for(Edge e: graph.edges) {
            System.out.println("Edge " + i++ + ": {" + e.v1.v + ", " + e.v2.v + "}");
        }
    }

    /**
     * Create the Adjacency Matrix of the graph
     */
    public static int[][] createAdjacencyMatrix(Graph graph) {
        int matrixSize = graph.vertices.length;
        int[][] matrix = new int[matrixSize][matrixSize];
        Edge[] es = graph.edges;
        Vertex[] vs = graph.vertices;
        int[] vertexValues = new int[vs.length];
        for (int i = 0; i < vs.length; i++) {
            vertexValues[i] = vs[i].v;
        }

        for (Edge e: es) {
            int firstVertexPosition = e.v1.v / 10 - 1;
            int secondVertexPosition = e.v2.v / 10 - 1;
            matrix[firstVertexPosition][secondVertexPosition] += 1;
            matrix[secondVertexPosition][firstVertexPosition] += 1;
        }

        return matrix;
    }

    /**
     * Calculate and print the degree of all the vertices.
     */
    public static int[] getVertexDegrees(int[][] adjacencyMatrix) {
        int[] vertexDegrees = new int[vertices.length];
        for (int row = 0; row < adjacencyMatrix.length; row++) {
            int degree = 0;
            for (int col = 0; col < adjacencyMatrix[0].length; col++) {
                degree += adjacencyMatrix[row][col];
            }
            vertexDegrees[row] = degree;
        }
        return vertexDegrees;
    }

    /**
     * Calculate the total degree of the graph
     */
    public static int getGraphDegree() {
        return edges.length * 2;
    }

    /**
     * Determine if the graph has any isolated vertex
     */
    public static boolean hasIsolatedVertices(int[] vertexDegrees) {
        for (int vertex: vertexDegrees) {
            if (vertex == 0) return true;
        }
        return false;
    }

    /**
     * Determine if the graph is a simple graph or not
     */
    public static boolean isSimple(Graph graph) {
        Edge[] edges = graph.edges;

        for (int i = 0; i < edges.length; i++) {
            if (edges[i].v1.equals(edges[i].v2)) {
                return false;
            }
            int coincidencies = 0;
            for (int j = 0; j < edges.length; j++) {
                if (edges[i].equals(edges[j])) coincidencies++;
            }
            if (coincidencies > 1) return false;
        }
        return true;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row: matrix)
        System.out.println(Arrays.toString(row));
    }


    public static void test() {
        // this graph is taken from the presentation on graphs, slide 40
        Vertex v1 = new Vertex(10); 
        Vertex v2 = new Vertex(20); 
        Vertex v3 = new Vertex(30); 
        Vertex v4 = new Vertex(40); 
        Vertex v5 = new Vertex(50); 
        Vertex v6 = new Vertex(60); 
        Vertex v7 = new Vertex(70);                                     // this vertex is not connected to any edges, so it's isolated

        Vertex[] testVertices = {v1, v2, v3, v4, v5, v6, v7};

        Edge e1 = new Edge(v1, v2);                                     // this edge and the next one are the same so the graph is not simple
        Edge e2 = new Edge(v1, v2);
        Edge e3 = new Edge(v2, v3);
        Edge e4 = new Edge(v3, v3);
        Edge e5 = new Edge(v3, v4);
        Edge e6 = new Edge(v3, v5);
        Edge e7 = new Edge(v3, v6);
        Edge e8 = new Edge(v2, v6);
        Edge e9 = new Edge(v5, v6);
        Edge e10 = new Edge(v4, v5);                                        

        Edge[] testEdges = {e1, e2, e3, e4, e5, e6, e7, e8, e9, e10};
        System.out.println("Here is the Edge Endpoint table for this graph.");
        Graph g = new Graph(testVertices, testEdges);

        createEdgeEndpoint(g);

        int[][] aMatrix = createAdjacencyMatrix(g);
        System.out.println("Here is the adjacency matrix for this graph.");
        printMatrix(aMatrix);

        int[] vertexDegrees = getVertexDegrees(aMatrix);
        System.out.println("This graph's vertex degrees are: " + Arrays.toString(vertexDegrees));
        System.out.println("The total degree of the graph is: " + getGraphDegree());
        System.out.println("Does this graph have any isolated vertices? " + (hasIsolatedVertices(vertexDegrees) ? "Yes" : "No"));
        System.out.println("Is this a simple graph? " + (isSimple(g) ? "Yes":"No"));
    }
}
