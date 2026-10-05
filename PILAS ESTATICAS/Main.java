import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        OPilas op = new OPilas();

        op.agregar(6);
        op.agregar(9);
        op.agregar(3);
        op.agregar(8);

        int opcion;

        do {

            System.out.println("\n==============================");
            System.out.println("        MENU DE PILAS");
            System.out.println("==============================");
            System.out.println("1. Eliminar primera ocurrencia");
            System.out.println("2. Eliminar y reinsertar");
            System.out.println("3. Eliminar todas las ocurrencias");
            System.out.println("4. Eliminar repetidos no consecutivos");
            System.out.println("5. Eliminar repetidos consecutivos");
            System.out.println("6. Elemento menos frecuente");
            System.out.println("7. Elemento mas frecuente");
            System.out.println("8. Insertar elemento menos frecuente");
            System.out.println("9. Insertar despues de una ocurrencia");
            System.out.println("10. Insertar en una posicion");
            System.out.println("11. Eliminar una posicion");
            System.out.println("12. Unir dos pilas");
            System.out.println("13. Intercalar dos pilas");
            System.out.println("14. Ordenar pila");
            System.out.println("15. Intercambiar dos posiciones");
            System.out.println("16. Mostrar pila");
            System.out.println("17. Agregar elemento");
            System.out.println("18. Eliminar cima");
            System.out.println("19. Insertar al fondo");
            System.out.println("20. Eliminar fondo");
            System.out.println("21. Cantidad de elementos");
            System.out.println("22. Invertir pila");
            System.out.println("0. Salir");
            System.out.println("==============================");

            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese el elemento a eliminar: ");
                    int x1 = sc.nextInt();

                    op.eliminar_determinado(x1);

                    System.out.println("Pila despues de eliminar:");
                    op.mostrar();
                    break;

                case 2:
                    System.out.print("Ingrese el elemento: ");
                    int x2 = sc.nextInt();

                    op.eliminar_y_reinsertar(x2);

                    System.out.println("Pila despues de eliminar y reinsertar:");
                    op.mostrar();
                    break;

                case 3:
                    System.out.print("Ingrese el elemento: ");
                    int x3 = sc.nextInt();

                    op.eliminar_todos(x3);

                    System.out.println("Pila despues de eliminar todas las ocurrencias:");
                    op.mostrar();
                    break;

                case 4:
                    op.eliminar_repetidos_no_consecutivos();

                    System.out.println("Pila sin repetidos no consecutivos:");
                    op.mostrar();
                    break;

                case 5:
                    op.eliminar_repetidos_consecutivos();

                    System.out.println("Pila sin repetidos consecutivos:");
                    op.mostrar();
                    break;

                case 6:
                    if (op.cantidad_elementos() > 0) {
                        System.out.println(
                            "Elemento menos frecuente: "
                            + op.elemento_menos_frecuente()
                        );
                    } else {
                        System.out.println("La pila esta vacia");
                    }
                    break;

                case 7:
                    if (op.cantidad_elementos() > 0) {
                        System.out.println(
                            "Elemento mas frecuente: "
                            + op.elemento_mas_frecuente()
                        );
                    } else {
                        System.out.println("La pila esta vacia");
                    }
                    break;

                case 8:
                    op.insertar_menos_frecuente();

                    System.out.println("Pila despues de insertar:");
                    op.mostrar();
                    break;

                case 9:
                    System.out.print("Ingrese el elemento x: ");
                    int x9 = sc.nextInt();

                    System.out.print("Ingrese el elemento y: ");
                    int y9 = sc.nextInt();

                    op.insertar_despues_de_una_ocurrencia(x9, y9);

                    System.out.println("Pila despues de insertar:");
                    op.mostrar();
                    break;

                case 10:
                    System.out.print("Ingrese el elemento: ");
                    int x10 = sc.nextInt();

                    System.out.print("Ingrese la posicion: ");
                    int pos10 = sc.nextInt();

                    op.insertar_posicion(x10, pos10);

                    System.out.println("Pila despues de insertar:");
                    op.mostrar();
                    break;

                case 11:
                    System.out.print("Ingrese la posicion a eliminar: ");
                    int pos11 = sc.nextInt();

                    op.eliminar_posicion(pos11);

                    System.out.println("Pila despues de eliminar:");
                    op.mostrar();
                    break;

                case 12:

                    OPilas p1 = new OPilas();
                    OPilas p2 = new OPilas();

                    p1.agregar(1);
                    p1.agregar(3);
                    p1.agregar(5);

                    p2.agregar(2);
                    p2.agregar(4);
                    p2.agregar(6);

                    System.out.println("Pila P1:");
                    p1.mostrar();

                    System.out.println("Pila P2:");
                    p2.mostrar();

                    op = op.unir(p1, p2);

                    System.out.println("Pila unida:");
                    op.mostrar();

                    break;

                case 13:

                    OPilas p3 = new OPilas();
                    OPilas p4 = new OPilas();

                    p3.agregar(1);
                    p3.agregar(3);
                    p3.agregar(5);

                    p4.agregar(2);
                    p4.agregar(4);
                    p4.agregar(6);

                    System.out.println("Pila P1:");
                    p3.mostrar();

                    System.out.println("Pila P2:");
                    p4.mostrar();

                    op = op.intercalar(p3, p4);

                    System.out.println("Pila intercalada:");
                    op.mostrar();

                    break;

                case 14:

                    System.out.println("Pila original:");
                    op.mostrar();

                    op.ordenar();

                    System.out.println("Pila ordenada de menor a mayor:");
                    op.mostrar();

                    break;

                case 15:

                    System.out.print("Ingrese la primera posicion: ");
                    int pos1 = sc.nextInt();

                    System.out.print("Ingrese la segunda posicion: ");
                    int pos2 = sc.nextInt();

                    op.intercambiar_posiciones(pos1, pos2);

                    System.out.println("Pila despues del intercambio:");
                    op.mostrar();

                    break;

                case 16:

                    System.out.println("Pila actual:");
                    op.mostrar();

                    break;

                case 17:

                    System.out.print("Ingrese el elemento: ");
                    int x17 = sc.nextInt();

                    op.agregar(x17);

                    System.out.println("Pila:");
                    op.mostrar();

                    break;

                case 18:

                    System.out.println(
                        "Se elimino el elemento: "
                        + op.eliminar()
                    );

                    System.out.println("Pila:");
                    op.mostrar();

                    break;

                case 19:

                    System.out.print("Ingrese el elemento: ");
                    int x19 = sc.nextInt();

                    op.insertarFondo(x19);

                    System.out.println("Pila:");
                    op.mostrar();

                    break;

                case 20:

                    op.eliminarFondo();

                    System.out.println("Pila:");
                    op.mostrar();

                    break;

                case 21:

                    System.out.println(
                        "Cantidad de elementos: "
                        + op.cantidad_elementos()
                    );

                    break;

                case 22:

                    op.invertir();

                    System.out.println("Pila invertida:");
                    op.mostrar();

                    break;

                case 0:

                    System.out.println("Programa terminado.");

                    break;

                default:

                    System.out.println("Opcion invalida.");

                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}
