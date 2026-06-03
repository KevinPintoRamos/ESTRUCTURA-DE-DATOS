import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        LSEC p = new LSEC();

        int dato;
        int option;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Ultimo Nodo");
            System.out.println("2. Insertar por delante");
            System.out.println("3. Insertar al final");
            System.out.println("4. Mostrar nodos");
            System.out.println("0. Salir");

            System.out.print("Opcion: ");
            option = teclado.nextInt();

            switch (option) {

                case 1:
                    Nodo ultimo = p.ultimo_nodo();

                    if (ultimo != null)
                        System.out.println("El ultimo Nodo es: " + ultimo.getInfo());
                    else
                        System.out.println("La lista esta vacia.");
                    break;

                case 2:
                    System.out.print("Introduzca Nodo: ");
                    dato = teclado.nextInt();

                    p.insertar_delante(dato);

                    System.out.println("Nodo insertado por delante");
                    p.mostrar();
                    break;

                case 3:
                    System.out.print("Introduzca Nodo: ");
                    dato = teclado.nextInt();

                    p.insertar_final(dato);

                    System.out.println("Nodo insertado al final");
                    p.mostrar();
                    break;

                case 4:
                    System.out.println("Lista de nodos:");
                    p.mostrar();
                    break;

                case 0:
                    System.out.println("Fin del programa.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (option != 0);

        teclado.close();
    }
}