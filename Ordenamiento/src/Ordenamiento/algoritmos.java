package Ordenamiento;
import java.lang.reflect.Array;

public class algoritmos<T extends Comparable<T>> {
	
	//Selection sort 
		public void SelectionSort(T[] datos) {
			int min;
			T temp;
			
			for(int j=0; j<datos.length-1;j++) {
				min=j;
				for(int i=j+1; i<datos.length;i++) {
					if(datos[min].compareTo(datos[i])>0) {
						min=i;
					}
				}
				temp=datos[min];
				datos[min]=datos[j];
				datos[j]=temp;
			}
		}
		
		//Insertion sort
		public void InsertionSort(T[] datos) {
			int j;
			T temp;
			
			for(int i=1; i<datos.length;i++) {
				j=i;
				while(j>=1 && datos[j].compareTo(datos[j-1])<0) {
					temp=datos[j];
					datos[j]=datos[j-1];
					datos[j-1]=temp;
					j--;
				}
			}
		}
		
		//Quick Sort
		
		//Swap para emplear en QuickSort
		public void swap(T[] datos, int i, int j) {
			T temp=datos[i];
			datos[i]=datos[j];
			datos[j]=temp;
		}
		
		//Partición: método auxiliar para hacer la mitad en quickSort
		private int particion(T[] datos, int min, int max) {
			int i=min;
			int j=max;
			
			while(i<j) {
				if(datos[i+1].compareTo(datos[i])<=0) {
					swap(datos,i,i+1);
					i++;
				}
				else {
					swap(datos,i+1,j);
					j--;
				}
			}
			return i;
		}
		
		//Método recursivo privado
		
		private void QuickSort(T[] datos, int min, int max) {
			if(max-min<=1) {
				return;
			}
			
			int pivote=particion(datos, min,max);
			QuickSort(datos,min,pivote-1);
			QuickSort(datos,pivote+1,max);
		}
		
		//Método recursivo publico
		public void QuickSort(T[] datos) {
			QuickSort(datos,0,datos.length-1);
		}
		
		//MergeSort
		public void MergeSort(T[] datos) {
			MergeSort(datos,0,datos.length);
		}
		
		//Método privado recursivo
		private void MergeSort(T[] datos, int min, int max) {
			if(max-min<=1) {
				return;
			}
			
			int mitad=(max+min)/2;
			MergeSort(datos,min,mitad);
			MergeSort(datos,mitad,max);
			MergeSort(datos,min,max,mitad); //Método de mezcla
			
		}
		
		//Método auxiliar de mezcla privado
		private void MergeSort(T[] datos, int min, int max, int mitad) {
			T aux[];
			aux=(T[])new Comparable[1+max-min];
			int i=min;
			int j=mitad;
			int k=0;
			
			while(i<mitad && j<max) {
				if(datos[i].compareTo(datos[j])<0) {
					aux[k]=(T)datos[i];
					i++;
				}else {
					aux[k]=(T)datos[j];
					j++;
				}
				k++;
			}
			
			while(j<max) {
				aux[k]=(T)datos[j];
				j++;
				k++;
			}
			
			while(i<mitad) {
				aux[k]=(T)datos[i];
				i++;
				k++;
			}
			
			//Copiar al original
			k=0;
			for(i=min;i<max;i++)
				datos[i]=aux[k++];
		}
		
		
		//Método de prueba para comprobar ordenamiento
		public  void prueba(int size){
			T[] aux;
			Integer[] myStringArray = {1,2,3,4};
			aux =  (T[])new Comparable[myStringArray.length];
			for(int i=0;i<aux.length;i++){
				aux[i]=(T)myStringArray[i];
				}
			
			if(aux[0].compareTo(aux[1])<0){
				System.out.println("true");
				}
			} 
	

}
