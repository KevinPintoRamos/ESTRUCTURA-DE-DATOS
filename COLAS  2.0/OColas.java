
public class OColas {
    private Cola c;

    public OColas() {
        c = new Cola();
    }
    public void agregar(String x) {
        if (!c.llena())
            c.insertar(x);
        else
            System.out.println("Error, cola llena");
    }

    public String quitar() {
        if (!c.vacia())
         return c.eliminar();

        System.out.println("Error, cola vacia");
        return "";
    }
    public void view() {
        c.mostrar();
    }

    public int contar() {
    int cont = 0;
        Cola aux = new Cola();

        while (!c.vacia()) {
            aux.insertar(c.eliminar());
            cont++;
        }

        c = aux;
        return cont;
    }

    public void insertar_delante(String x) {
        if (!c.llena()) {
            Cola aux = new Cola();
            aux.insertar(x);

            while (!c.vacia())
                aux.insertar(c.eliminar());

            c = aux;
        } else {
            System.out.println("Error, cola llena");
        }
    }

    public void eliminar_ultimo() {
        if (!c.vacia()) {
            Cola aux = new Cola();

            while (!c.vacia()) {
                String x = c.eliminar();

                if (!c.vacia())
                    aux.insertar(x);
            }

            c = aux;
        } else {
            System.out.println("Error, cola vacia");
        }
    }

    public void invertir() {
        int n = contar();
        String[] v = new String[n];

        for (int i = 0; i < n; i++)
            v[i] = c.eliminar();

        Cola aux = new Cola();

        for (int i = n - 1; i >= 0; i--)
            aux.insertar(v[i]);

        c = aux;
    }

    private String[] obtenerElementos() {
        int n = contar();
        String[] v = new String[n];

        for (int i = 0; i < n; i++)
            v[i] = c.eliminar();

        for (int i = 0; i < n; i++)
            c.insertar(v[i]);

        return v;
    }

    private void cargar(String[] v, int n) {
        c = new Cola();

        for (int i = 0; i < n; i++)
            c.insertar(v[i]);
    }
  // deste aqui es la practica 3
    // 1. Insertar en una posicion determinada

    public void insertar_posicion(String x, int pos) {
        int n = contar();

        if (n >= 200 || pos < 1 || pos > n + 1) {
            System.out.println("Posicion incorrecta o cola llena");
            return;
        }

        String[] v = new String[n + 1];

        for (int i = 0; i < pos - 1; i++)
            v[i] = c.eliminar();

        v[pos - 1] = x;

        for (int i = pos; i <= n; i++)
            v[i] = c.eliminar();

        cargar(v, n + 1);
    }

    // 2. Intercambiar primero y ultimo

    public void intercambiar_primero_ultimo() {
        int n = contar();

        if (n < 2)
            return;

        String[] v = obtenerElementos();

        String aux = v[0];
        v[0] = v[n - 1];
        v[n - 1] = aux;

        cargar(v, n);
    }

    // 3. Eliminar posiciones pares

    public void eliminar_posiciones_pares() {
        String[] v = obtenerElementos();
        Cola aux = new Cola();

        for (int i = 0; i < v.length; i++)
            if (i % 2 == 0)
                aux.insertar(v[i]);

        c = aux;
    }

    // 4. Segundo elemento mayor distinto

    public String segundo_mayor() {
        String[] v = obtenerElementos();

        boolean hayMayor = false;
        boolean haySegundo = false;
        int mayor = 0;
        int segundo = 0;

        for (int i = 0; i < v.length; i++) {
            int x = Integer.parseInt(v[i]);

            if (!hayMayor || x > mayor) {
                if (hayMayor) {
                    segundo = mayor;
                    haySegundo = true;
                }

                mayor = x;
                hayMayor = true;

            } else if (x < mayor &&
                      (!haySegundo || x > segundo)) {
                segundo = x;
                haySegundo = true;
            }
        }

        if (haySegundo)
            return String.valueOf(segundo);

        return "";
    }

    // 5. Eliminar elementos duplicados

    public void eliminar_duplicados() {
        String[] v = obtenerElementos();
        String[] vistos = new String[v.length];
        Cola aux = new Cola();
        int nv = 0;

        for (int i = 0; i < v.length; i++) {
            boolean repetido = false;

            for (int j = 0; j < nv; j++)
                if (v[i].equals(vistos[j]))
                    repetido = true;

            if (!repetido) {
                aux.insertar(v[i]);
                vistos[nv] = v[i];
                nv++;
            }
        }

        c = aux;
    }

    // 6. Agrupar pares primero e impares despues

    public void agrupar_pares_impares() {
        String[] v = obtenerElementos();
        Cola aux = new Cola();

        for (int i = 0; i < v.length; i++)
            if (Integer.parseInt(v[i]) % 2 == 0)
                aux.insertar(v[i]);

        for (int i = 0; i < v.length; i++)
            if (Integer.parseInt(v[i]) % 2 != 0)
                aux.insertar(v[i]);

        c = aux;
    }

    // 7. Intercambiar dos colas

    public void intercambiar_colas(OColas otra) {
        Cola aux = c;
        c = otra.c;
        otra.c = aux;
    }

    // 8. Dividir segun el promedio

    public void dividir_promedio(OColas mayores,
                                 OColas menores) {
        String[] v = obtenerElementos();

        mayores.c = new Cola();
        menores.c = new Cola();

        if (v.length == 0)
            return;

        double suma = 0;

        for (int i = 0; i < v.length; i++)
            suma += Integer.parseInt(v[i]);

        double promedio = suma / v.length;

        for (int i = 0; i < v.length; i++) {
            int x = Integer.parseInt(v[i]);

            if (x >= promedio)
                mayores.c.insertar(v[i]);
            else
                menores.c.insertar(v[i]);
        }
    }

    // 9. Rotar N posiciones a la izquierda

    public void rotar_izquierda(int N) {
        int n = contar();

        if (n == 0)
            return;

        N = ((N % n) + n) % n;

        for (int i = 0; i < N; i++)
            c.insertar(c.eliminar());
    }

    // 10. Comparar dos colas

    public boolean iguales(OColas otra) {
        String[] a = obtenerElementos();
        String[] b = otra.obtenerElementos();

        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i]))
                return false;

        return true;
    }

    // 11. Ordenar ascendentemente

    public void ordenar_ascendente() {
        String[] v = obtenerElementos();

        for (int i = 0; i < v.length - 1; i++)
            for (int j = 0; j < v.length - 1 - i; j++)
                if (Integer.parseInt(v[j]) >
                    Integer.parseInt(v[j + 1])) {
                    String aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                }

        cargar(v, v.length);
    }

    // 12. Secuencia creciente mas larga

    public void secuencia_creciente_mas_larga() {
        String[] v = obtenerElementos();
        int n = v.length;

        if (n == 0) {
            System.out.println("Secuencia vacia. Longitud = 0");
            return;
        }

        int inicio = 0;
        int mejorInicio = 0;
        int longitud = 1;
        int mejorLongitud = 1;

        for (int i = 1; i < n; i++) {
            if (Integer.parseInt(v[i]) >
                Integer.parseInt(v[i - 1])) {
                longitud++;
            } else {
                inicio = i;
                longitud = 1;
            }

            if (longitud > mejorLongitud) {
                mejorLongitud = longitud;
                mejorInicio = inicio;
            }
        }

        System.out.print("Secuencia: ");

        for (int i = mejorInicio;
             i < mejorInicio + mejorLongitud; i++)
            System.out.print(v[i] + "\t");

        System.out.println();
        System.out.println("Longitud = " + mejorLongitud);
    }

    // 13. Intercalar dos colas ordenadas

    public OColas mezclar_ordenadas(OColas otra) {
        String[] a = obtenerElementos();
        String[] b = otra.obtenerElementos();

        OColas resultado = new OColas();
        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            if (Integer.parseInt(a[i]) <=
                Integer.parseInt(b[j])) {
                resultado.agregar(a[i]);
                i++;
            } else {
                resultado.agregar(b[j]);
                j++;
            }
        }

        while (i < a.length)
            resultado.agregar(a[i++]);

        while (j < b.length)
            resultado.agregar(b[j++]);

        return resultado;
    }

    // 14. Invertir entre dos posiciones

    public void invertir_entre_posiciones(int pos1, int pos2) {
        int n = contar();

        if (pos1 < 1 || pos2 > n || pos1 > pos2) {
            System.out.println("Posiciones incorrectas");
            return;
        }

        String[] v = obtenerElementos();
        int i = pos1 - 1;
        int j = pos2 - 1;

        while (i < j) {
            String aux = v[i];
            v[i] = v[j];
            v[j] = aux;
            i++;
            j--;
        }

        cargar(v, n);
    }

    // 15. Verificar si las dos mitades son identicas

    public boolean dos_mitades_identicas() {
        String[] v = obtenerElementos();
        int n = v.length;

        if (n % 2 != 0)
            return false;

        int mitad = n / 2;

        for (int i = 0; i < mitad; i++)
            if (!v[i].equals(v[i + mitad]))
                return false;

        return true;
    }
}
