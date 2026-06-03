import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        LSE lista = new LSE();
        LSE lista2 = new LSE();

        int opcion, dato, pos, origen, destino;

        do {

            System.out.println("\n===== MENU LISTA SIMPLE ENLAZADA =====");
            System.out.println("1.- Insertar al principio");
            System.out.println("2.- Insertar al final");
            System.out.println("3.- Mostrar lista");
            System.out.println("4.- Contar nodos");
            System.out.println("5.- Promedio");
            System.out.println("6.- Nodo mayor");
            System.out.println("7.- Nodo menor");
            System.out.println("8.- Eliminar primero");
            System.out.println("9.- Eliminar final");
            System.out.println("10.- Eliminar determinado");
            System.out.println("11.- Buscar");
            System.out.println("12.- Contar repetidos");
            System.out.println("13.- Insertar lado igual");
            System.out.println("14.- Mayor repetido");
            System.out.println("15.- Mover primero");
            System.out.println("16.- Insertar posición");
            System.out.println("17.- Eliminar iguales");
            System.out.println("18.- Eliminar repetidos");
            System.out.println("19.- Mover nodo");
            System.out.println("20.- Intercambiar primero último");
            System.out.println("21.- Eliminar posición");
            System.out.println("22.- Intercalar listas");
            System.out.println("23.- Eliminar consecutivos");
            System.out.println("24.- Insertar ordenado");
            System.out.println("25.- Invertir");
            System.out.println("0.- Salir");

            System.out.print("Seleccione opción: ");
            opcion = leer.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Dato: ");
                    dato = leer.nextInt();
                    lista.insertarPrincipio(dato);
                    break;
                case 2:
                    System.out.print("Dato: ");
                    dato = leer.nextInt();
                    lista.insertarFinal(dato);
                    break;
                case 3:
                    lista.mostrar();
                    break;
                case 4:
                    System.out.println(lista.contarNodos());
                    break;
                case 5:
                    System.out.println(lista.promedioLista());
                    break;
                case 6:
                    System.out.println(lista.nodoMayor());
                    break;
                case 7:
                    System.out.println(lista.nodoMenor());
                    break;
                case 8:
                    lista.eliminarPrimero();
                    break;
                case 9:
                    lista.eliminarFinal();
                    break;
                case 10:
                    System.out.print("Eliminar: ");
                    dato = leer.nextInt();
                    lista.eliminarDeterminado(dato);
                    break;
                case 11:
                    System.out.print("Buscar: ");
                    dato = leer.nextInt();
                    if (lista.buscar(dato) != null)
                        System.out.println("Encontrado");
                    else
                        System.out.println("No encontrado");
                    break;
                case 12:
                    System.out.print("Número: ");
                    dato = leer.nextInt();
                    System.out.println(lista.contarRepetidos(dato));
                    break;
                case 13:
                    System.out.print("Número: ");
                    dato = leer.nextInt();
                    lista.insertarLadoIgual(dato);
                    break;
                case 14:
                    System.out.println(lista.mayorRepetido());
                    break;
                case 15:
                    System.out.print("Mover: ");
                    dato = leer.nextInt();
                    lista.moverPrimero(dato);
                    break;
                case 16:
                    System.out.print("Dato: ");
                    dato = leer.nextInt();
                    System.out.print("Posición: ");
                    pos = leer.nextInt();
                    lista.insertar_posicion(dato, pos);
                    break;
                case 17:
                    System.out.print("Eliminar iguales: ");
                    dato = leer.nextInt();
                    lista.eliminar_iguales(dato);
                    break;
                case 18:
                    lista.eliminar_repetidos();
                    break;
                case 19:
                    System.out.print("Origen: ");
                    origen = leer.nextInt();
                    System.out.print("Destino: ");
                    destino = leer.nextInt();
                    lista.moverNodo(origen, destino);
                    break;
                case 20:
                    lista.intercambiar_primero_ultimo();
                    break;
                case 21:
                    System.out.print("Posición: ");
                    pos = leer.nextInt();
                    lista.eliminar_posicion(pos);
                    break;
                case 22:
                    System.out.print("Cantidad lista 2: ");
                    int n = leer.nextInt();
                    for (int i = 0; i < n; i++) {
                        dato = leer.nextInt();
                        lista2.insertarFinal(dato);
                    }
                    lista.intercalar(lista2);
                    break;
                case 23:
                    lista.eliminar_consecutivos();
                    break;
                case 24:
                    System.out.print("Dato: ");
                    dato = leer.nextInt();
                    lista.insertar_ordenado(dato);
                    break;
                case 25:
                    lista.invertir();
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        leer.close();
    }
}