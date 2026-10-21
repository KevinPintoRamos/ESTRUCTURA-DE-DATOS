
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OColas op = new OColas();
        int opcion;
        String x;

        do {
            System.out.println("\n===== MENU DE COLAS =====");
            System.out.println("1. Agregar elemento");
            System.out.println("2. Quitar primer elemento");
            System.out.println("3. Mostrar cola");
            System.out.println("4. Contar elementos");
            System.out.println("5. Insertar delante");
            System.out.println("6. Eliminar ultimo elemento");
            System.out.println("7. Invertir cola");
            System.out.println("8. Salir");
            System.out.println("9. Insertar en posicion determinada");
            System.out.println("10. Intercambiar primero y ultimo");
            System.out.println("11. Eliminar posiciones pares");
            System.out.println("12. Encontrar segundo mayor distinto");
            System.out.println("13. Eliminar elementos duplicados");
            System.out.println("14. Agrupar pares e impares");
            System.out.println("15. Intercambiar dos colas");
            System.out.println("16. Dividir cola segun promedio");
            System.out.println("17. Rotar cola N posiciones a la izquierda");
            System.out.println("18. Verificar si dos colas son iguales");
            System.out.println("19. Ordenar cola ascendentemente");
            System.out.println("20. Secuencia creciente mas larga");
            System.out.println("21. Intercalar dos colas ordenadas");
            System.out.println("22. Invertir entre dos posiciones");
            System.out.println("23. Verificar dos mitades identicas");

            System.out.print("\nElija una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento: ");
                    x = sc.nextLine();
                    op.agregar(x);
                    break;

                case 2:
                    x = op.quitar();
                    if (!x.equals(""))
                        System.out.println("Elemento eliminado: " + x);
                    break;

                case 3:
                    System.out.println("Contenido de la cola:");
                    op.view();
                    break;

                case 4:
                    System.out.println("Cantidad de elementos: " + op.contar());
                    break;

                case 5:
                    System.out.print("Ingrese el elemento: ");
                    x = sc.nextLine();
                    op.insertar_delante(x);
                    break;

                case 6:
                    op.eliminar_ultimo();
                    System.out.println("Ultimo elemento eliminado.");
                    break;

                case 7:
                    op.invertir();
                    System.out.println("Cola invertida.");
                    break;

                case 8:
                    System.out.println("Saliendo del programa...");
                    break;

                case 9:
                    System.out.print("Ingrese el elemento: ");
                    x = sc.nextLine();
                    System.out.print("Ingrese la posicion: ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    op.insertar_posicion(x, pos);
                    break;

                case 10:
                    op.intercambiar_primero_ultimo();
                    System.out.println("Primer y ultimo elemento intercambiados.");
                    break;

                case 11:
                    op.eliminar_posiciones_pares();
                    System.out.println("Elementos de posiciones pares eliminados.");
                    break;

                case 12:
                    x = op.segundo_mayor();
                    if (!x.equals(""))
                        System.out.println("Segundo mayor distinto: " + x);
                    else
                        System.out.println("No existe un segundo mayor distinto.");
                    break;

                case 13:
                    op.eliminar_duplicados();
                    System.out.println("Elementos duplicados eliminados.");
                    break;

                case 14:
                    op.agrupar_pares_impares();
                    System.out.println("Cola agrupada:");
                    op.view();
                    break;

                case 15: {
                    OColas otra = new OColas();

                    System.out.println("Ingrese los elementos de la segunda cola.");
                    System.out.println("Escriba FIN para terminar.");

                    while (true) {
                        System.out.print("Elemento: ");
                        x = sc.nextLine();

                        if (x.equalsIgnoreCase("FIN"))
                            break;

                        otra.agregar(x);
                    }

                    op.intercambiar_colas(otra);

                    System.out.println("Primera cola despues del intercambio:");
                    op.view();

                    System.out.println("Segunda cola despues del intercambio:");
                    otra.view();
                    break;
                }

                case 16: {
                    OColas mayores = new OColas();
                    OColas menores = new OColas();

                    op.dividir_promedio(mayores, menores);

                    System.out.println("Elementos mayores o iguales al promedio:");
                    mayores.view();

                    System.out.println("Elementos menores al promedio:");
                    menores.view();
                    break;
                }

                case 17:
                    System.out.print("Ingrese N: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    op.rotar_izquierda(n);
                    System.out.println("Cola rotada:");
                    op.view();
                    break;

                case 18: {
                    OColas otra = new OColas();

                    System.out.println("Ingrese los elementos de la segunda cola.");
                    System.out.println("Escriba FIN para terminar.");

                    while (true) {
                        System.out.print("Elemento: ");
                        x = sc.nextLine();

                        if (x.equalsIgnoreCase("FIN"))
                            break;

                        otra.agregar(x);
                    }

                    if (op.iguales(otra))
                        System.out.println("Las colas son iguales.");
                    else
                        System.out.println("Las colas son diferentes.");
                    break;
                }

                case 19:
                    op.ordenar_ascendente();
                    System.out.println("Cola ordenada:");
                    op.view();
                    break;

                case 20:
                    op.secuencia_creciente_mas_larga();
                    break;

                case 21: {
                    OColas otra = new OColas();

                    System.out.println("Ingrese los elementos de la segunda cola ordenada.");
                    System.out.println("Escriba FIN para terminar.");

                    while (true) {
                        System.out.print("Elemento: ");
                        x = sc.nextLine();

                        if (x.equalsIgnoreCase("FIN"))
                            break;

                        otra.agregar(x);
                    }

                    OColas resultado = op.mezclar_ordenadas(otra);

                    System.out.println("Cola resultante ordenada:");
                    resultado.view();
                    break;
                }

                case 22:
                    System.out.print("Ingrese la primera posicion: ");
                    int p1 = sc.nextInt();

                    System.out.print("Ingrese la segunda posicion: ");
                    int p2 = sc.nextInt();
                    sc.nextLine();

                    op.invertir_entre_posiciones(p1, p2);
                    System.out.println("Cola resultante:");
                    op.view();
                    break;

                case 23:
                    if (op.dos_mitades_identicas())
                        System.out.println("Verdadero: las dos mitades son identicas.");
                    else
                        System.out.println("Falso: las dos mitades no son identicas.");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 8);

        sc.close();
    }
}
