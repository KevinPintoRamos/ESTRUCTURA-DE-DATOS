public class LSEC {
	private Nodo lista;
	public LSEC() {
		lista = null;
	}
	public Nodo ultimo_nodo() {
		Nodo p = lista;
		if (lista != null)
			while(p.getEnlace() != lista) {
				p = p.getEnlace();
		}
		return p;
	}
	public void insertar_delante(int x) {
		Nodo p = new Nodo(x), q = null;
		if(lista == null)
			p.setEnlace(p);
		else {
			q = ultimo_nodo();
			q.setEnlace(p);
			p.setEnlace(lista);
		}
		lista = p;
	}
	public void insertar_final(int x) {
		Nodo p= new Nodo(x), q = null;
		if (lista == null) {
			p.setEnlace(p);
			lista = p;
		}else {
			q = ultimo_nodo();
			q.setEnlace(p);
			p.setEnlace(lista);
		}
		lista = p;
	}
	public void mostrar() {
		Nodo p = lista;
		if(lista != null)
			do {
				System.out.print(p.getInfo() + "\t");
				p = p.getEnlace();
			}while(p != lista); 
				
			
	}
	
}
