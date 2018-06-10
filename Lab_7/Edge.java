
/**
 * class Edge.
 *
 * @author Nikita Gerasimov
 * @version 2018-06-10
 */
public class Edge
{
    Vertex v1, v2;

    /**
     * Constructor for objects of class Edge
     */
    public Edge(Vertex v1, Vertex v2) {
        if (v1 == null || v2 == null) 
            throw new IllegalArgumentException("There is no such vertex");
        this.v1 = v1;
        this.v2 = v2;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Edge)) return false;

        Edge _obj = (Edge)obj;
        return _obj.v1.equals(v1) && _obj.v2.equals(v2);
    }
}
