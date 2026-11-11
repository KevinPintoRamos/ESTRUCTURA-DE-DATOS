
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ListaSimple lista = new ListaSimple();

        int opcion;

        do {
            System.out.println("\n==================================");
            System.out.println("LISTAS SIMPLEMENTE ENLAZADAS");
            System.out.println("==================================");
            System.out.println("1. Buscar elemento");
            System.out.println("2. Contar repeticiones");
            System.out.println("3. Mayor frecuencia");
            System.out.println("4. Insertar despues de un elemento");
            System.out.println("5. Insertar en una posicion");
            System.out.println("6. Eliminar por posicion");
            System.out.println("7. Insertar ordenadamente");
            System.out.println("8. Eliminar todas las repeticiones");
            System.out.println("9. Eliminar repetidos consecutivos");
            System.out.println("10. Invertir lista");
            System.out.println("11. Intercalar dos listas");
            System.out.println("12. Intercambiar primer y ultimo nodo");
            System.out.println("13. Dividir pares e impares");
            System.out.println("14. Intercambiar dos posiciones");
            System.out.println("15. Ordenar ascendentemente");
            System.out.println("16. Insertar al inicio");
            System.out.println("17. Insertar al final");
            System.out.println("18. Mostrar lista");
            System.out.println("19. Crear lista nueva");
            System.out.println("0. Salir");
            System.out.println("==================================");

            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            int valor, posicion;

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese elemento: ");
                    valor = sc.nextInt();

                    if (lista.buscar(valor) != null) {
                        System.out.println("Elemento encontrado.");
                    } else {
                        System.out.println("Elemento no encontrado.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese elemento: ");
                    valor = sc.nextInt();

                    System.out.println("Cantidad de repeticiones: "
                            + lista.contarRepeticiones(valor));
                    break;

                case 3:
                    Integer mayor = lista.mayorFrecuencia();

                    if (mayor == null) {
                        System.out.println("Lista vacia.");
                    } else {
                        System.out.println("Mayor frecuencia: " + mayor);
                    }
                    break;

                case 4:
                    System.out.print("Elemento de referencia: ");
                    int referencia = sc.nextInt();

                    System.out.print("Nuevo elemento: ");
                    valor = sc.nextInt();

                    lista.insertarDespues(referencia, valor);
                    lista.mostrar();
                    break;

                case 5:
                    System.out.print("Elemento: ");
                    valor = sc.nextInt();

                    System.out.print("Posicion: ");
                    posicion = sc.nextInt();

                    lista.insertarPosicion(valor, posicion);
                    lista.mostrar();
                    break;

                case 6:
                    System.out.print("Posicion a eliminar: ");
                    posicion = sc.nextInt();

                    lista.eliminarPosicion(posicion);
                    lista.mostrar();
                    break;

                case 7:
                    System.out.print("Elemento: ");
                    valor = sc.nextInt();

                    lista.insertarOrdenado(valor);
                    lista.mostrar();
                    break;

                case 8:
                    lista.eliminarRepetidos();
                    lista.mostrar();
                    break;

                case 9:
                    lista.eliminarConsecutivos();
                    lista.mostrar();
                    break;

                case 10:
                    lista.invertir();
                    lista.mostrar();
                    break;

                case 11:
                    ListaSimple segunda = new ListaSimple();

                    System.out.print("Cantidad de elementos de la segunda lista: ");
                    int cantidad = sc.nextInt();

                    for (int i = 1; i <= cantidad; i++) {
                        System.out.print("Dato " + i + ": ");
                        segunda.insertarFinal(sc.nextInt());
                    }

                    lista = ListaSimple.intercalar(lista, segunda);

                    System.out.println("Lista intercalada:");
                    lista.mostrar();
                    break;

                case 12:
                    lista.intercambiarExtremos();
                    lista.mostrar();
                    break;

                case 13:
                    ListaSimple.Division division =
                            lista.dividirParesImpares();

                    System.out.println("LISTA DE PARES:");
                    division.pares.mostrar();

                    System.out.println("LISTA DE IMPARES:");
                    division.impares.mostrar();

                    lista = new ListaSimple();
                    break;

                case 14:
                    System.out.print("Primera posicion: ");
                    int p1 = sc.nextInt();

                    System.out.print("Segunda posicion: ");
                    int p2 = sc.nextInt();

                    lista.intercambiarPosiciones(p1, p2);
                    lista.mostrar();
                    break;

                case 15:
                    lista.ordenar();
                    lista.mostrar();
                    break;

                case 16:
                    System.out.print("Elemento: ");
                    valor = sc.nextInt();

                    lista.insertarInicio(valor);
                    lista.mostrar();
                    break;

                case 17:
                    System.out.print("Elemento: ");
                    valor = sc.nextInt();

                    lista.insertarFinal(valor);
                    lista.mostrar();
                    break;

                case 18:
                    lista.mostrar();
                    break;

                case 19:
                    lista = new ListaSimple();
                    System.out.println("Nueva lista creada.");
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
