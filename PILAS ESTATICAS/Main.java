public class Main {
    public static void main(String[] args) {
        OPilas op = new OPilas();

        op.agregar(6);
        op.agregar(9);
        op.agregar(3);
        op.agregar(8);

        System.out.println("Pila original");
        op.mostrar();

        System.out.println("Se elimino el elemento: " + op.eliminar());
        System.out.println("Pila");
        op.mostrar();

        op.invertir();
        System.out.println("Invertido");
        op.mostrar();

        System.out.println("Insertar 10 al fondo");
        op.insertarFondo(10);
        op.mostrar();

        System.out.println("Eliminar elemento del fondo");
        op.eliminarFondo();
        op.mostrar();

        System.out.println("Cantidad de elementos: " + op.cantidad_elementos());

        System.out.println("Eliminar determinado 9");
        op.eliminar_determinado(9);
        op.mostrar();
    }
}

