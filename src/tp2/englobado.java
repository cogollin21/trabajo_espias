package tp2;

public class englobado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		espias Espias = new espias ();
		Espias.agregar_espia("fede");
		Espias.agregar_espia("larry");
		Espias.agregar_espia("kapinga");
		
		System.out.println(Espias.Espias.get("fede"));
		
		
		grafosnumero grafo = new grafosnumero(Espias.total_espias());
	
		String espia1 = "fede";
		String espia2 = "larry";
		Integer peso = 4;
		
		grafo.agregarArista(Espias.num_espia(espia1), Espias.num_espia(espia2), peso);
		grafo.caminominimo2(Espias.num_espia(espia1));
		
		
		
		
	
	
		
	}

}
