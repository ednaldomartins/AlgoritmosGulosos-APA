
package model;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 22.09.2018                                                           *
 ******************************************************************************/
public class Aresta {
    private long v1;            //vertice 1
    private long v2;            //vertice 2
    private long peso;          //peso da aresta
    private int floresta;       //grupo que a aresta se encontra

    public Aresta(long v1, long v2, long peso, int floresta) {
        this(peso, floresta);
        this.v1 = v1;
        this.v2 = v2;
    }
    
    public Aresta(long peso, int floresta) {
        this.peso = peso;
        this.floresta = floresta;
    }

    public Aresta() { }

    public long getV1() {
        return v1;
    }

    public long getV2() {
        return v2;
    }

    public long getPeso() {
        return peso;
    }

    public int getFloresta() {
        return floresta;
    }

    
    public void setV1(long v1) {
        this.v1 = v1;
    }

    public void setV2(long v2) {
        this.v2 = v2;
    }

    public void setPeso(long peso) {
        this.peso = peso;
    }

    public void setFloresta(int floresta) {
        this.floresta = floresta;
    }
    
}
