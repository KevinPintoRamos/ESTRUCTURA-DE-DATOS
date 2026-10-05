public class OPilas {

    private Pila p;

    public OPilas() {
        p = new Pila();
    }

    public void agregar(int x) {
        if (!p.lleno()) {
            p.insertar(x);
        } else {
            System.out.println("Error, Pila llena!");
        }
    }

    public int eliminar() {
        if (!p.vacio()) {
            return p.eliminar();
        } else {
            System.err.println("Error, Pila vacia");
            return 0;
        }
    }

    public void mostrar() {
        p.mostrar();
    }

    private Pila invertir_own(Pila p) {
        Pila p_aux = new Pila();

        while (!p.vacio()) {
            p_aux.insertar(p.eliminar());
        }

        return p_aux;
    }

    public void invertir() {
        p = invertir_own(p);
    }

    public void insertarFondo(int x) {
        if (!p.lleno()) {
            Pila aux = new Pila();
            aux = invertir_own(p);
            aux.insertar(x);
            p = invertir_own(aux);
        }
    }

    public void eliminarFondo() {
        if (!p.vacio()) {
            Pila aux = new Pila();
            aux = invertir_own(p);
            aux.eliminar();
            p = invertir_own(aux);
        }
    }

    public int cantidad_elementos() {
        int cont = 0;

        if (!p.vacio()) {
            Pila aux = new Pila();

            while (!p.vacio()) {
                cont++;
                aux.insertar(p.eliminar());
            }

            p = invertir_own(aux);
        }

        return cont;
    }

    private Pila copiar(Pila original) {
        Pila aux = new Pila();
        Pila copia = new Pila();

        while (!original.vacio()) {
            aux.insertar(original.eliminar());
        }

        while (!aux.vacio()) {
            int x = aux.eliminar();
            original.insertar(x);
            copia.insertar(x);
        }

        return copia;
    }

    private boolean contiene(Pila pila, int x) {
        Pila aux = new Pila();
        boolean encontrado = false;

        while (!pila.vacio()) {
            int y = pila.eliminar();

            if (x == y) {
                encontrado = true;
            }

            aux.insertar(y);
        }

        while (!aux.vacio()) {
            pila.insertar(aux.eliminar());
        }

        return encontrado;
    }

    private int frecuencia(int x) {
        Pila aux = new Pila();
        int cont = 0;

        while (!p.vacio()) {
            int y = p.eliminar();

            if (x == y) {
                cont++;
            }

            aux.insertar(y);
        }

        while (!aux.vacio()) {
            p.insertar(aux.eliminar());
        }

        return cont;
    }

    public void eliminar_determinado(int x) {
        if (!p.vacio()) {
            Pila aux = new Pila();
            int y;

            while (!p.vacio()) {
                y = p.eliminar();

                if (x == y) {
                    break;
                }

                aux.insertar(y);
            }

            while (!aux.vacio()) {
                p.insertar(aux.eliminar());
            }
        }
    }

    public void eliminar_y_reinsertar(int x) {
        if (!p.vacio()) {
            Pila aux = new Pila();
            int y;
            boolean encontrado = false;

            while (!p.vacio()) {
                y = p.eliminar();

                if (x == y) {
                    encontrado = true;
                    break;
                }

                aux.insertar(y);
            }

            while (!aux.vacio()) {
                p.insertar(aux.eliminar());
            }

            if (encontrado && !p.lleno()) {
                p.insertar(x);
            }
        }
    }

    public void eliminar_todos(int x) {
        if (!p.vacio()) {
            Pila aux = new Pila();

            while (!p.vacio()) {
                int y = p.eliminar();

                if (x != y) {
                    aux.insertar(y);
                }
            }

            p = invertir_own(aux);
        }
    }

    public void eliminar_repetidos_no_consecutivos() {
        if (!p.vacio()) {
            Pila trabajo = copiar(p);
            Pila vistos = new Pila();
            Pila resultado = new Pila();

            while (!trabajo.vacio()) {
                int x = trabajo.eliminar();

                if (!contiene(vistos, x)) {
                    resultado.insertar(x);
                    vistos.insertar(x);
                }
            }

            p = invertir_own(resultado);
        }
    }

    public void eliminar_repetidos_consecutivos() {
        if (!p.vacio()) {
            Pila aux = new Pila();

            int anterior = 0;
            boolean primero = true;

            while (!p.vacio()) {
                int x = p.eliminar();

                if (primero) {
                    aux.insertar(x);
                    anterior = x;
                    primero = false;
                } else {
                    if (x != anterior) {
                        aux.insertar(x);
                    }

                    anterior = x;
                }
            }

            p = invertir_own(aux);
        }
    }

    public int elemento_menos_frecuente() {
        if (p.vacio()) {
            return 0;
        }

        Pila trabajo = copiar(p);
        Pila vistos = new Pila();

        int menor = 0;
        int frecuenciaMenor = 0;
        boolean primero = true;

        while (!trabajo.vacio()) {
            int x = trabajo.eliminar();

            if (!contiene(vistos, x)) {
                int frecuenciaActual = frecuencia(x);

                if (primero || frecuenciaActual < frecuenciaMenor) {
                    menor = x;
                    frecuenciaMenor = frecuenciaActual;
                    primero = false;
                }

                vistos.insertar(x);
            }
        }

        return menor;
    }

    public int elemento_mas_frecuente() {
        if (p.vacio()) {
            return 0;
        }

        Pila trabajo = copiar(p);
        Pila vistos = new Pila();

        int mayor = 0;
        int frecuenciaMayor = 0;
        boolean primero = true;

        while (!trabajo.vacio()) {
            int x = trabajo.eliminar();

            if (!contiene(vistos, x)) {
                int frecuenciaActual = frecuencia(x);

                if (primero || frecuenciaActual > frecuenciaMayor) {
                    mayor = x;
                    frecuenciaMayor = frecuenciaActual;
                    primero = false;
                }

                vistos.insertar(x);
            }
        }

        return mayor;
    }

    public void insertar_menos_frecuente() {
        if (!p.lleno() && !p.vacio()) {
            int x = elemento_menos_frecuente();
            p.insertar(x);
        } else if (p.lleno()) {
            System.out.println("Error, Pila llena!");
        }
    }

    public void insertar_despues_de_una_ocurrencia(int x, int y) {
        if (p.lleno()) {
            System.out.println("Error, Pila llena!");
            return;
        }

        Pila aux = new Pila();
        boolean encontrado = false;

        while (!p.vacio()) {
            int z = p.eliminar();

            if (z == y && !encontrado) {
                p.insertar(y);
                p.insertar(x);
                encontrado = true;

                while (!aux.vacio()) {
                    p.insertar(aux.eliminar());
                }

                return;
            }

            aux.insertar(z);
        }

        while (!aux.vacio()) {
            p.insertar(aux.eliminar());
        }
    }

    public void insertar_posicion(int x, int posicion) {
        int cantidad = cantidad_elementos();

        if (posicion < 1 || posicion > cantidad + 1) {
            System.out.println("Posicion invalida");
            return;
        }

        if (p.lleno()) {
            System.out.println("Error, Pila llena!");
            return;
        }

        Pila aux = new Pila();

        for (int i = 1; i < posicion; i++) {
            aux.insertar(p.eliminar());
        }

        p.insertar(x);

        while (!aux.vacio()) {
            p.insertar(aux.eliminar());
        }
    }

    public void eliminar_posicion(int posicion) {
        int cantidad = cantidad_elementos();

        if (posicion < 1 || posicion > cantidad) {
            System.out.println("Posicion invalida");
            return;
        }

        Pila aux = new Pila();

        for (int i = 1; i < posicion; i++) {
            aux.insertar(p.eliminar());
        }

        p.eliminar();

        while (!aux.vacio()) {
            p.insertar(aux.eliminar());
        }
    }

    private void insertar_fondo_own(Pila pila, int x) {
        Pila aux = new Pila();

        while (!pila.vacio()) {
            aux.insertar(pila.eliminar());
        }

        pila.insertar(x);

        while (!aux.vacio()) {
            pila.insertar(aux.eliminar());
        }
    }

    public OPilas unir(OPilas p1, OPilas p2) {
        OPilas resultado = new OPilas();

        Pila aux1 = copiar(p1.p);
        Pila aux2 = copiar(p2.p);

        while (!aux1.vacio()) {
            resultado.insertar_fondo_own(resultado.p, aux1.eliminar());
        }

        while (!aux2.vacio()) {
            resultado.insertar_fondo_own(resultado.p, aux2.eliminar());
        }

        return resultado;
    }

    public OPilas intercalar(OPilas p1, OPilas p2) {
        OPilas resultado = new OPilas();

        Pila aux1 = copiar(p1.p);
        Pila aux2 = copiar(p2.p);

        while (!aux1.vacio() || !aux2.vacio()) {

            if (!aux1.vacio()) {
                resultado.insertar_fondo_own(
                    resultado.p,
                    aux1.eliminar()
                );
            }

            if (!aux2.vacio()) {
                resultado.insertar_fondo_own(
                    resultado.p,
                    aux2.eliminar()
                );
            }
        }

        return resultado;
    }

    public void ordenar() {
        if (!p.vacio()) {
            Pila aux = new Pila();

            while (!p.vacio()) {
                int x = p.eliminar();
                Pila temp = new Pila();

                while (!aux.vacio() && auxTope(aux) < x) {
                    temp.insertar(aux.eliminar());
                }

                aux.insertar(x);

                while (!temp.vacio()) {
                    aux.insertar(temp.eliminar());
                }
            }

            p = aux;
        }
    }

    private int auxTope(Pila aux) {
        Pila temp = new Pila();
        int x = aux.eliminar();

        temp.insertar(x);

        while (!aux.vacio()) {
            temp.insertar(aux.eliminar());
        }

        while (!temp.vacio()) {
            int y = temp.eliminar();

            if (temp.vacio()) {
                aux.insertar(y);
                return y;
            }

            aux.insertar(y);
        }

        return x;
    }

    public void intercambiar_posiciones(int p1, int p2) {
        int cantidad = cantidad_elementos();

        if (p1 < 1 || p1 > cantidad ||
            p2 < 1 || p2 > cantidad) {

            System.out.println("Posicion invalida");
            return;
        }

        if (p1 == p2) {
            return;
        }

        int valor1 = obtener_posicion(p1);
        int valor2 = obtener_posicion(p2);

        Pila aux = new Pila();
        int posicion = 1;

        while (!p.vacio()) {
            int x = p.eliminar();

            if (posicion == p1) {
                x = valor2;
            }

            if (posicion == p2) {
                x = valor1;
            }

            aux.insertar(x);
            posicion++;
        }

        p = invertir_own(aux);
    }

    private int obtener_posicion(int posicion) {
        Pila aux = new Pila();
        int x = 0;

        for (int i = 1; i <= posicion; i++) {
            x = p.eliminar();
            aux.insertar(x);
        }

        while (!aux.vacio()) {
            p.insertar(aux.eliminar());
        }

        return x;
    }
}
