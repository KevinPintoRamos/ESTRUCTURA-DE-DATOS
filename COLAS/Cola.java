public class Cola {
    private final int MAX = 10;
    private int primero;
    private int ultimo;
    private String []info;

    public Cola() {
        primero = 0;
        ultimo = -1;
        info = new String[MAX];
    }

    public boolean vacia() {
        return (ultimo < primero);
    }
    public boolean llena() {
        return (ultimo == MAX - 1);
    }

    public void insertar(String x) {
        if (!llena())
            info[++ultimo] = x;
    }

    public String eliminar() {
        String x = " ";
        if (!vacia()) {
            x = info[primero];
            for (int i=primero; i<ultimo; i++)
                info[i] = info[i+1];
            ultimo--;
        }
        return x;
    }

    public void mostrar() {
        for (int i=primero; i<=ultimo; i++)
            System.out.print(info[i] + "\t");
        System.out.println();
    }
    // al no insertar ningun dato por defecto se llena con null
}
