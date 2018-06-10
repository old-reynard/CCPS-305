
/**
 * class Vertex.
 * 
 * @author Nikita Gerasimov
 * @version 2018-06-10
 */

public class Vertex
{
    public int v; // the vertex's unique identifier
    
    public Vertex(int v) {
        this.v = v;
    }
    
    public int getVertex() {
        return v;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vertex)) return false;

        Vertex _obj = (Vertex) obj;
        return _obj.v == v;
    }
}
