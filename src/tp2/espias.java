package tp2;

import java.util.HashMap;
import java.util.Map;

public class espias {
	Map <String,Integer> Espias;
	int cant_espias;

	public espias () {
		this.Espias=new HashMap<String,Integer> ();
		this.cant_espias=0;
	}
	
	public void agregar_espia (String nombre) {
		
		this.Espias.put(nombre,cant_espias);
		this.cant_espias++;
		
	}
	
	public int total_espias() {
		return cant_espias;
	}
	
	public Integer num_espia (String nombre) {
		if (this.Espias.containsKey(nombre)) {
			return this.Espias.get(nombre);	
		}
		else {
			return null ;
		}
		
	}

}
