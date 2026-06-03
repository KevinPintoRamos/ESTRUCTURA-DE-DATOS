public class Nodo {

    private int info;
    private Nodo enlace;

    public Nodo(int x) {
        info = x;
        enlace = null;
    }
    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
    public int getInfo() {
        return info;
    }
    public Nodo getEnlace() {
        return enlace;
    }
}