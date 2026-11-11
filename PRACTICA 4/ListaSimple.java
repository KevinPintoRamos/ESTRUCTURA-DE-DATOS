
public class ListaSimple {

    private Nodo cabeza;

    public ListaSimple() {
        cabeza = null;
    }

    // INSERTAR AL INICIO
    public void insertarInicio(int x) {
        Nodo nuevo = new Nodo(x);
        nuevo.setEnlace(cabeza);
        cabeza = nuevo;
    }

    // INSERTAR AL FINAL
    public void insertarFinal(int x) {
        Nodo nuevo = new Nodo(x);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        Nodo actual = cabeza;

        while (actual.getEnlace() != null) {
            actual = actual.getEnlace();
        }

        actual.setEnlace(nuevo);
    }

    // MOSTRAR LISTA
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("Lista vacia");
            return;
        }

        Nodo actual = cabeza;

        while (actual != null) {
            System.out.print(actual.getInfo() + " -> ");
            actual = actual.getEnlace();
        }

        System.out.println("NULL");
    }

    // 1. BUSCAR ELEMENTO
    public Nodo buscar(int x) {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.getInfo() == x) {
                return actual;
            }

            actual = actual.getEnlace();
        }

        return null;
    }

    // 2. CONTAR REPETICIONES
    public int contarRepeticiones(int x) {
        int contador = 0;
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.getInfo() == x) {
                contador++;
            }

            actual = actual.getEnlace();
        }

        return contador;
    }

    // 3. ELEMENTO CON MAYOR FRECUENCIA
    public Integer mayorFrecuencia() {
        if (cabeza == null) {
            return null;
        }

        int mayor = 0;
        Integer resultado = null;

        Nodo actual = cabeza;

        while (actual != null) {
            int frecuencia = contarRepeticiones(actual.getInfo());

            if (frecuencia > mayor) {
                mayor = frecuencia;
                resultado = actual.getInfo();
            }

            actual = actual.getEnlace();
        }

        return resultado;
    }

    // 4. INSERTAR DESPUES DEL PRIMER ELEMENTO IGUAL
    public void insertarDespues(int referencia, int x) {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.getInfo() == referencia) {
                Nodo nuevo = new Nodo(x);

                nuevo.setEnlace(actual.getEnlace());
                actual.setEnlace(nuevo);

                return;
            }

            actual = actual.getEnlace();
        }

        insertarInicio(x);
    }

    // 5. INSERTAR EN UNA POSICION
    public void insertarPosicion(int x, int posicion) {
        if (posicion <= 1 || cabeza == null) {
            insertarInicio(x);
            return;
        }

        Nodo nuevo = new Nodo(x);
        Nodo actual = cabeza;
        int contador = 1;

        while (actual.getEnlace() != null &&
               contador < posicion - 1) {

            actual = actual.getEnlace();
            contador++;
        }

        nuevo.setEnlace(actual.getEnlace());
        actual.setEnlace(nuevo);
    }

    // 6. ELIMINAR POR POSICION
    public void eliminarPosicion(int posicion) {
        if (cabeza == null || posicion < 1) {
            return;
        }

        if (posicion == 1) {
            cabeza = cabeza.getEnlace();
            return;
        }

        Nodo actual = cabeza;
        int contador = 1;

        while (actual.getEnlace() != null &&
               contador < posicion - 1) {

            actual = actual.getEnlace();
            contador++;
        }

        if (actual.getEnlace() != null) {
            actual.setEnlace(
                actual.getEnlace().getEnlace()
            );
        }
    }

    // 7. INSERTAR EN LISTA ORDENADA
    public void insertarOrdenado(int x) {
        Nodo nuevo = new Nodo(x);

        if (cabeza == null || x < cabeza.getInfo()) {
            nuevo.setEnlace(cabeza);
            cabeza = nuevo;
            return;
        }

        Nodo actual = cabeza;

        while (actual.getEnlace() != null &&
               actual.getEnlace().getInfo() <= x) {

            actual = actual.getEnlace();
        }

        nuevo.setEnlace(actual.getEnlace());
        actual.setEnlace(nuevo);
    }

    // 8. ELIMINAR REPETIDOS CONSERVANDO LA PRIMERA APARICION
    public void eliminarRepetidos() {
        Nodo actual = cabeza;

        while (actual != null) {
            Nodo anterior = actual;
            Nodo siguiente = actual.getEnlace();

            while (siguiente != null) {
                if (siguiente.getInfo() == actual.getInfo()) {

                    anterior.setEnlace(siguiente.getEnlace());
                    siguiente = anterior.getEnlace();

                } else {
                    anterior = siguiente;
                    siguiente = siguiente.getEnlace();
                }
            }

            actual = actual.getEnlace();
        }
    }

    // 9. ELIMINAR REPETIDOS CONSECUTIVOS
    public void eliminarConsecutivos() {
        Nodo actual = cabeza;

        while (actual != null && actual.getEnlace() != null) {

            if (actual.getInfo() ==
                actual.getEnlace().getInfo()) {

                actual.setEnlace(
                    actual.getEnlace().getEnlace()
                );

            } else {
                actual = actual.getEnlace();
            }
        }
    }

    // 10. INVERTIR LA LISTA
    public void invertir() {
        Nodo anterior = null;
        Nodo actual = cabeza;

        while (actual != null) {
            Nodo siguiente = actual.getEnlace();

            actual.setEnlace(anterior);

            anterior = actual;
            actual = siguiente;
        }

        cabeza = anterior;
    }

    // METODO AUXILIAR: EXTRAER PRIMER NODO
    private Nodo extraerPrimero() {
        if (cabeza == null) {
            return null;
        }

        Nodo nodo = cabeza;
        cabeza = cabeza.getEnlace();
        nodo.setEnlace(null);

        return nodo;
    }

    // METODO AUXILIAR: AGREGAR NODO EXISTENTE
    private void agregarNodo(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        nodo.setEnlace(null);

        if (cabeza == null) {
            cabeza = nodo;
            return;
        }

        Nodo actual = cabeza;

        while (actual.getEnlace() != null) {
            actual = actual.getEnlace();
        }

        actual.setEnlace(nodo);
    }

    // 11. INTERCALAR DOS LISTAS
    public static ListaSimple intercalar(
            ListaSimple lista1, ListaSimple lista2) {

        ListaSimple resultado = new ListaSimple();

        while (lista1.cabeza != null ||
               lista2.cabeza != null) {

            if (lista1.cabeza != null) {
                resultado.agregarNodo(
                    lista1.extraerPrimero()
                );
            }

            if (lista2.cabeza != null) {
                resultado.agregarNodo(
                    lista2.extraerPrimero()
                );
            }
        }

        return resultado;
    }

    // 12. INTERCAMBIAR PRIMER Y ULTIMO NODO
    public void intercambiarExtremos() {
        if (cabeza == null ||
            cabeza.getEnlace() == null) {
            return;
        }

        Nodo anteriorUltimo = null;
        Nodo ultimo = cabeza;

        while (ultimo.getEnlace() != null) {
            anteriorUltimo = ultimo;
            ultimo = ultimo.getEnlace();
        }

        if (anteriorUltimo == cabeza) {
            ultimo.setEnlace(cabeza);
            cabeza.setEnlace(null);
            cabeza = ultimo;
            return;
        }

        ultimo.setEnlace(cabeza.getEnlace());
        anteriorUltimo.setEnlace(cabeza);
        cabeza.setEnlace(null);
        cabeza = ultimo;
    }

    // CLASE AUXILIAR PARA LA DIVISION
    public static class Division {

        public ListaSimple pares;
        public ListaSimple impares;

        public Division(ListaSimple pares, ListaSimple impares) {
            this.pares = pares;
            this.impares = impares;
        }
    }

    // 13. DIVIDIR PARES E IMPARES
    public Division dividirParesImpares() {
        ListaSimple pares = new ListaSimple();
        ListaSimple impares = new ListaSimple();

        while (cabeza != null) {
            Nodo nodo = extraerPrimero();

            if (nodo.getInfo() % 2 == 0) {
                pares.agregarNodo(nodo);
            } else {
                impares.agregarNodo(nodo);
            }
        }

        return new Division(pares, impares);
    }

    // 14. INTERCAMBIAR DOS NODOS POR POSICION
    public void intercambiarPosiciones(int pos1, int pos2) {

        if (pos1 < 1 || pos2 < 1 || pos1 == pos2) {
            return;
        }

        if (pos1 > pos2) {
            int temporal = pos1;
            pos1 = pos2;
            pos2 = temporal;
        }

        Nodo anterior1 = null;
        Nodo nodo1 = cabeza;

        for (int i = 1; i < pos1 && nodo1 != null; i++) {
            anterior1 = nodo1;
            nodo1 = nodo1.getEnlace();
        }

        Nodo anterior2 = null;
        Nodo nodo2 = cabeza;

        for (int i = 1; i < pos2 && nodo2 != null; i++) {
            anterior2 = nodo2;
            nodo2 = nodo2.getEnlace();
        }

        if (nodo1 == null || nodo2 == null) {
            return;
        }

        // NODOS CONSECUTIVOS
        if (nodo1.getEnlace() == nodo2) {

            if (anterior1 != null) {
                anterior1.setEnlace(nodo2);
            } else {
                cabeza = nodo2;
            }

            nodo1.setEnlace(nodo2.getEnlace());
            nodo2.setEnlace(nodo1);

        } else {

            if (anterior1 != null) {
                anterior1.setEnlace(nodo2);
            } else {
                cabeza = nodo2;
            }

            anterior2.setEnlace(nodo1);

            Nodo temporal = nodo1.getEnlace();

            nodo1.setEnlace(nodo2.getEnlace());
            nodo2.setEnlace(temporal);
        }
    }

    // 15. ORDENAR ASCENDENTEMENTE
    public void ordenar() {
        Nodo ordenada = null;
        Nodo actual = cabeza;

        while (actual != null) {
            Nodo siguiente = actual.getEnlace();

            if (ordenada == null ||
                actual.getInfo() < ordenada.getInfo()) {

                actual.setEnlace(ordenada);
                ordenada = actual;

            } else {

                Nodo auxiliar = ordenada;

                while (auxiliar.getEnlace() != null &&
                       auxiliar.getEnlace().getInfo()
                       <= actual.getInfo()) {

                    auxiliar = auxiliar.getEnlace();
                }

                actual.setEnlace(auxiliar.getEnlace());
                auxiliar.setEnlace(actual);
            }

            actual = siguiente;
        }

        cabeza = ordenada;
    }
}
