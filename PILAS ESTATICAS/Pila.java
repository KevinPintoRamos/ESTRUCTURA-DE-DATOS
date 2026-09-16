public class Pila {
    private final static int TAM = 10;
    private int tope;
    private int []info;

    public Pila () {
        tope = -1;
        info = new int[TAM];
    }
    public boolean vacio () {
        return (tope == -1);
    }
    public boolean lleno () {
        return (tope == TAM-1);
    }
    public void insertar (int x) {
        if (!lleno())
            info[++tope] = x;
    }
    public int eliminar () {
        if (!vacio())
            return info[tope--];
        return 0;
    }
    public void mostrar () {
        for (int i = tope; i>-1; i--) {
            System.out.println(info[i]);
        }
    }
    
}
