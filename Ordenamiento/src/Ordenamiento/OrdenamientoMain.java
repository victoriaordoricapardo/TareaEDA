package Ordenamiento;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OrdenamientoMain {

public static void main(String[] args){
	algoritmos<Integer> algoritmos=new algoritmos<>();
	Integer[] datos={3,10,-8,2,40,-1,35,48,15,0};
	System.out.println("Datos originales"+datos);

//Prueba de SelectionSort
	long startTime= System.nanoTime();
	System.out.println("-------------------------------------------------");
	algoritmos.SelectionSort(datos);
	System.out.println("Prueba de SelectionSort");
	algoritmos.prueba(10);
	for(int i=0;i<datos.length;i++)
		System.out.println(datos[i]);
	long endTime=System.nanoTime();
	long duration=(endTime-startTime);
	System.out.println("Tiempo ejecución: "+duration);



//Prueba de insertionSort
	long startTime1= System.nanoTime();
	System.out.println("-------------------------------------------------");
	algoritmos.InsertionSort(datos);
	System.out.println("Prueba de insertionSort");
	algoritmos.prueba(10);
	for(int i=0;i<datos.length;i++)
		System.out.println(datos[i]);
	long endTime1=System.nanoTime();
	long duration1=(endTime1-startTime1);
	System.out.println("Tiempo ejecución: "+duration1);

//Prueba de QuickSort
	long startTime2= System.nanoTime();
	System.out.println("-------------------------------------------------");
	algoritmos.QuickSort(datos);
	System.out.println("Prueba de QuickSort");
	algoritmos.prueba(10);
	for(int i=0;i<datos.length;i++)
		System.out.println(datos[i]);
	long endTime2=System.nanoTime();
	long duration2=(endTime2-startTime2);
	System.out.println("Tiempo ejecución: "+duration2);

//Prueba de MergeSort
	long startTime3= System.nanoTime();
	System.out.println("-------------------------------------------------");
	algoritmos.MergeSort(datos);
	System.out.println("Prueba de MergeSort");
	algoritmos.prueba(10);
	for(int i=0;i<datos.length;i++)
		System.out.println(datos[i]);
	long endTime3=System.nanoTime();
	long duration3=(endTime3-startTime3);
	System.out.println("Tiempo ejecución: "+duration3);

	Pelicula p1= new Pelicula(8986784,1967,"A new movie");

	System.out.println(p1.toString());

}
}



