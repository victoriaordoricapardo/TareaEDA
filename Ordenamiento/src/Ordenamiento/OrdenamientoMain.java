package Ordenamiento;

public class OrdenamientoMain {
	public static void main(String[] args) {
		algoritmos<Integer> algoritmos=new algoritmos<>();
		Integer[] datos={3,10,-8,2,40,-1,35,48,15,0};
		System.out.println("Datos originales"+datos);
		
		//Prueba de SelectionSort
		System.out.println("-------------------------------------------------");
		algoritmos.SelectionSort(datos);
		System.out.println("Prueba de SelectionSort");
		algoritmos.prueba(10);
		for(int i=0;i<datos.length;i++)
			System.out.println(datos[i]);
		
		
		
		//Prueba de insertionSort
		System.out.println("-------------------------------------------------");
		algoritmos.InsertionSort(datos);
		System.out.println("Prueba de insertionSort");
		algoritmos.prueba(10);
		for(int i=0;i<datos.length;i++)
			System.out.println(datos[i]);
		
		//Prueba de QuickSort
		System.out.println("-------------------------------------------------");
		algoritmos.QuickSort(datos);
		System.out.println("Prueba de QuickSort");
		algoritmos.prueba(10);
		for(int i=0;i<datos.length;i++)
			System.out.println(datos[i]);
		
		
		//Prueba de MergeSort
		System.out.println("-------------------------------------------------");
		algoritmos.MergeSort(datos);
		System.out.println("Prueba de MergeSort");
		algoritmos.prueba(10);
		for(int i=0;i<datos.length;i++)
			System.out.println(datos[i]);
	
	}


}
