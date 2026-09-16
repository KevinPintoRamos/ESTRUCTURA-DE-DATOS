public class OPilas {
    private  Pila p;

    public  OPilas() {
        p = new Pila();
    }

    public void agregar(int x) {
        if (!p.lleno()) {
            p.insertar(x);
        }else{
            System.out.println("Error, Pila llena!");
        }
    }

    public int eliminar() {
        if (!p.vacio()) {
            return p.eliminar();
        }else{
            System.err.println("Error, Pila vacia");
            return 0;    
        }
    }

    public void mostrar() {
        p.mostrar();
    } 
    private Pila invertir_own(Pila p){
        Pila p_aux = new Pila();
        while (!p.vacio()) {
            p_aux.insertar(p.eliminar());
        }
        return p_aux;
    }
    public void invertir(){
        p = invertir_own(p);
    }
    // metodos hecho en clases
    public void insertarFondo(int x) {
        if (!p.lleno()){
            Pila aux = new Pila();
            aux = invertir_own(p);
            aux.insertar(x);
            p = invertir_own(aux);
        }
    }
    public void eliminarFondo(){
        if(!p.vacio()){
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
        public void eliminar_determinado(int x){
            if(!p.vacio()){
                Pila aux = new Pila();
                int y;
                while (!p.vacio()) {
                    y = p.eliminar();
                    if(x == y)
                        break;
                    aux.insertar(y);
            }
            while (!aux.vacio()) {
                p.insertar(aux.eliminar());
            }
        }
     }
    }

