package tp2;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo {
	private int [][] A;



	// La cantidad de vertices esta predeterminada desde el constructor
	public Grafo(int vertices)
	{
		A = new int[vertices][vertices];

	}
	private void verificarVertice(int i)
	{
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);

		if( i >= A.length )
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
	}

	// Verifica que i y j sean distintos
	private void verificarDistintos(int i, int j)
	{
		if( i == j )
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}
	// Agregado de aristas i=origen j= destino k = peso                    
	public void agregarArista(int i, int j, int k)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = k;
		A[j][i] = k;
	}



	public int pesoDeArista(int i , int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		return this.A [i][j];


	}

	public void eliminarArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = 0;
		A[j][i] = 0;
	}
	public boolean existeArista(int i, int j) // las aristas existen si son 0 o mayor a 0
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		if (A[i][j]!=0) {
			return true;
		}
		else {
			return false;
		}
	}

	// Cantidad de vertices
	public int tamano()
	{
		return A.length;
	}


	// Vecinos de un vertice
	public Set<Integer> vecinos(int i)
	{
		verificarVertice(i);

		Set<Integer> ret = new HashSet<Integer>();
		for(int j = 0; j < this.tamano(); ++j) if( i != j )
		{
			if( this.existeArista(i,j) )
				ret.add(j);
		}

		return ret;		
	}






	public ArrayList<Integer>caminoMinimo (int vertice){
		ArrayList<Integer> caminoMinimo = new ArrayList<Integer> ();
		Set <Integer> verticesSinusar = new HashSet<Integer> ();
		Set <Integer> verticesUsados = new HashSet<Integer> (); //camino minimo
		Set <Integer> vecinos = new HashSet<Integer> (); //auxiliar
		for (int i = 0 ; i<this.tamano();i++){
			verticesSinusar.add (i);
		}
		Integer verticeaux=0;
		caminoMinimo.add (vertice);
		verticesUsados.add(vertice);
		verticesSinusar.remove(vertice);
		Integer vertice1 = null;
		Integer vertice2 = null;
		while (verticesUsados.size()!= this.tamano()){
			//vecinos=vecinos(vertice);
			//vecinos=unir_set(vecinos,vertices_usados);
			Integer menor_peso=999999;
			//for (Integer ver : vecinos ) {
			//	if (A[vertice][ver]< menor_peso) {    //arista entre vertico y el vecino
			//		verticeaux=ver; //guardo el vertice con el que tiene menor peso
			//		menor_peso=A[vertice][ver];  //guardo el peos del  vertice con el que el peso es menor
			//	}
			//}
			for (Integer num1 : verticesUsados){
				for (Integer num2 : verticesSinusar){
					if(existeArista(num1,num2)) {
						if(this.A[num1][num2]<menor_peso){
							menor_peso=this.A[num1][num2];
							vertice1=num1;
							vertice2=num2;
						} 


					}
				}
			}
			caminoMinimo.add (vertice1);
			caminoMinimo.add(vertice2);
			verticesUsados.add(vertice2);
			verticesSinusar.remove(vertice2);


		}


		caminoMinimo.remove (0);  
		return caminoMinimo;

	}









}
