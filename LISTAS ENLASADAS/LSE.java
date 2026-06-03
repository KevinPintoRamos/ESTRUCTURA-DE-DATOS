public class LSE {

    private Nodo lista;

    public LSE() {
        lista = null;
    }

    // Insertar al principio
    public void insertarPrincipio(int x) {

        Nodo p = new Nodo(x);

        if (lista == null) {

            lista = p;

        } else {

            p.setEnlace(lista);

            lista = p;
        }
    }

    // Mostrar
    public void mostrar() {

        Nodo p = lista;

        while (p != null) {

            System.out.print(p.getInfo() + "\t");

            p = p.getEnlace();
        }

        System.out.println();
    }

    // Insertar al final
    public void insertarFinal(int x) {

        Nodo p = new Nodo(x);

        if (lista == null) {

            lista = p;

        } else {

            Nodo q = lista;

            while (q.getEnlace() != null) {
                q = q.getEnlace();
            }

            q.setEnlace(p);
        }
    }

    // Contar nodos
    public int contarNodos() {

        Nodo p = lista;

        int c = 0;

        while (p != null) {

            c++;

            p = p.getEnlace();
        }

        return c;
    }

    // Promedio
    public double promedioLista() {

        Nodo p = lista;

        int suma = 0;

        int n = 0;

        while (p != null) {

            suma += p.getInfo();

            n++;

            p = p.getEnlace();
        }

        if (n == 0)
            return 0;

        return (double) suma / n;
    }

    // Mayor
    public int nodoMayor() {

        if (lista == null)
            return 0;

        Nodo p = lista;

        int mayor = lista.getInfo();

        while (p != null) {

            if (p.getInfo() > mayor)
                mayor = p.getInfo();

            p = p.getEnlace();
        }

        return mayor;
    }

    // Menor
    public int nodoMenor() {

        if (lista == null)
            return 0;

        Nodo p = lista;

        int menor = lista.getInfo();

        while (p != null) {

            if (p.getInfo() < menor)
                menor = p.getInfo();

            p = p.getEnlace();
        }

        return menor;
    }

    // Eliminar primero
    public void eliminarPrimero() {

        if (lista != null)
            lista = lista.getEnlace();
    }

    // Eliminar final
    public void eliminarFinal() {

        if (lista == null)
            return;

        if (lista.getEnlace() == null) {

            lista = null;

        } else {

            Nodo p = lista;

            Nodo q = null;

            while (p.getEnlace() != null) {

                q = p;

                p = p.getEnlace();
            }

            q.setEnlace(null);
        }
    }

    // Eliminar determinado
    public void eliminarDeterminado(int x) {

        if (lista == null)
            return;

        Nodo p = lista;

        Nodo q = null;

        while (p != null && p.getInfo() != x) {

            q = p;

            p = p.getEnlace();
        }

        if (p != null) {

            if (p == lista) {

                lista = lista.getEnlace();

            } else {

                q.setEnlace(p.getEnlace());
            }
        }
    }
    // deste aqui es la tarea del licenciado auxiliar 

    // Buscar
    public Nodo buscar(int x) {

        Nodo p = lista;

        while (p != null) {

            if (p.getInfo() == x)
                return p;

            p = p.getEnlace();
        }

        return null;
    }

    // Contar repetidos
    public int contarRepetidos(int x) {

        Nodo p = lista;

        int contador = 0;

        while (p != null) {

            if (p.getInfo() == x)
                contador++;

            p = p.getEnlace();
        }

        return contador;
    }

    // Insertar igual al lado
    public void insertarLadoIgual(int x) {

        Nodo p = lista;

        while (p != null) {

            if (p.getInfo() == x) {

                Nodo q = new Nodo(x);

                q.setEnlace(p.getEnlace());

                p.setEnlace(q);

                p = q.getEnlace();

            } else {

                p = p.getEnlace();
            }
        }
    }

    // Mayor repetido
    public int mayorRepetido() {

        if (lista == null)
            return 0;

        Nodo p = lista;

        int mayor = 0;

        int dato = lista.getInfo();

        while (p != null) {

            int contador = contarRepetidos(p.getInfo());

            if (contador > mayor) {

                mayor = contador;

                dato = p.getInfo();
            }

            p = p.getEnlace();
        }

        return dato;
    }

    // Mover primero
    public void moverPrimero(int x) {

        if (lista == null || lista.getInfo() == x)
            return;

        Nodo p = lista;

        Nodo q = null;

        while (p != null && p.getInfo() != x) {

            q = p;

            p = p.getEnlace();
        }

        if (p == null)
            return;

        q.setEnlace(p.getEnlace());

        p.setEnlace(lista);

        lista = p;
    }

    // Insertar posición
    public void insertar_posicion(int x, int pos) {

        Nodo p = new Nodo(x);

        if (pos == 1) {

            p.setEnlace(lista);

            lista = p;

        } else {

            Nodo q = lista;

            int i = 1;

            while (q != null && i < pos - 1) {

                q = q.getEnlace();

                i++;
            }

            if (q != null) {

                p.setEnlace(q.getEnlace());

                q.setEnlace(p);
            }
        }
    }

    // Eliminar iguales
    public void eliminar_iguales(int x) {

        Nodo p = lista;

        Nodo q = null;

        boolean primero = false;

        while (p != null) {

            if (p.getInfo() == x) {

                if (!primero) {

                    primero = true;

                    q = p;

                    p = p.getEnlace();

                } else {

                    q.setEnlace(p.getEnlace());

                    p = p.getEnlace();
                }

            } else {

                q = p;

                p = p.getEnlace();
            }
        }
    }

    // Eliminar repetidos
    public void eliminar_repetidos() {

        Nodo p = lista;

        while (p != null) {

            Nodo q = p;

            Nodo r = p.getEnlace();

            while (r != null) {

                if (p.getInfo() == r.getInfo()) {

                    q.setEnlace(r.getEnlace());

                    r = r.getEnlace();

                } else {

                    q = r;

                    r = r.getEnlace();
                }
            }

            p = p.getEnlace();
        }
    }

    // Mover nodo
    public void moverNodo(int orgin, int destino) {

        if (lista == null)
            return;

        Nodo p = lista;

        Nodo q = null;

        int i = 1;

        while (p != null && i < orgin) {

            q = p;

            p = p.getEnlace();

            i++;
        }

        if (p == null)
            return;

        if (q == null) {

            lista = p.getEnlace();

        } else {

            q.setEnlace(p.getEnlace());
        }

        if (destino <= 0) {

            p.setEnlace(lista);

            lista = p;

            return;
        }

        Nodo r = lista;

        i = 1;

        while (r != null && i < destino - 1) {

            r = r.getEnlace();

            i++;
        }

        if (r != null) {

            p.setEnlace(r.getEnlace());

            r.setEnlace(p);
        }
    }

    // Intercambiar primero último
    public void intercambiar_primero_ultimo() {

        if (lista == null || lista.getEnlace() == null)
            return;

        Nodo p = lista;

        Nodo q = null;

        Nodo r = lista;

        while (r.getEnlace() != null) {

            q = r;

            r = r.getEnlace();
        }

        q.setEnlace(p);

        lista = r;

        r.setEnlace(p.getEnlace());

        p.setEnlace(null);
    }

    // Eliminar posición
    public void eliminar_posicion(int pos) {

        if (lista == null)
            return;

        if (pos == 0) {

            lista = lista.getEnlace();

            return;
        }

        Nodo p = lista;

        int i = 0;

        while (p != null && i < pos - 1) {

            p = p.getEnlace();

            i++;
        }

        if (p != null && p.getEnlace() != null)
            p.setEnlace(p.getEnlace().getEnlace());
    }

    // Intercalar
    public void intercalar(LSE l2) {

        Nodo p = lista;

        Nodo q = l2.lista;

        Nodo r;

        Nodo s;

        while (p != null && q != null) {

            r = p.getEnlace();

            s = q.getEnlace();

            p.setEnlace(q);

            q.setEnlace(r);

            p = r;

            q = s;
        }
    }

    // Eliminar consecutivos
    public void eliminar_consecutivos() {

        Nodo p = lista;

        while (p != null && p.getEnlace() != null) {

            if (p.getInfo() == p.getEnlace().getInfo()) {

                p.setEnlace(
                        p.getEnlace().getEnlace());

            } else {

                p = p.getEnlace();
            }
        }
    }

    // Insertar ordenado
    public void insertar_ordenado(int x) {

        Nodo p = new Nodo(x);

        if (lista == null || x <= lista.getInfo()) {

            p.setEnlace(lista);

            lista = p;

            return;
        }

        Nodo q = lista;

        while (q.getEnlace() != null &&
                q.getEnlace().getInfo() < x) {

            q = q.getEnlace();
        }

        p.setEnlace(q.getEnlace());

        q.setEnlace(p);
    }

    // Invertir
    public void invertir() {

        Nodo p = lista;

        Nodo q = null;

        Nodo r;

        while (p != null) {

            r = p.getEnlace();

            p.setEnlace(q);

            q = p;

            p = r;
        }

        lista = q;
    }
}