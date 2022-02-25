package Ordenamiento;

public class algoritmosPelicula<T extends Comparable<T>> {
	//Selection sort 
	
	public void SelectionSort(Pelicula[] datos) {
		int min;
		Pelicula temp;
		
		for(int j=0; j<datos.length-1;j++) {
			min=j;
			for(int i=j+1; i<datos.length;i++) {
				if(datos[min].compareTo(datos[i].getID())>0) {
					min=i;
				}
			}
			temp=datos[min];
			datos[min]=datos[j];
			datos[j]=temp;
		}
	}
	
	//Insertion sort
	public void InsertionSort(Pelicula[] datos) {
		int j;
		Pelicula temp;
		for(int i=1; i<datos.length;i++) {
			j=i;
			while(j>=1 && datos[j].compareTo(datos[j-1].getID())<0) {
				temp=datos[j];
				datos[j]=datos[j-1];
				datos[j-1]=temp;
				j--;
				}
			}
		}
	
	
	
	//Quick Sort
	//Swap para emplear en QuickSort
	public void swap(Pelicula[] datos, int i, int j) {
		Pelicula temp=datos[i];
		datos[i]=datos[j];
		datos[j]=temp;
	}
	
	//Partición: método auxiliar para hacer la mitad en quickSort
	private int particion(Pelicula[] datos, int min, int max) {
		int i=min;
		int j=max;
		
		while(i<j) {
			if(datos[i+1].compareTo(datos[i].getID())<=0) {
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
	private void QuickSort(Pelicula[] datos, int min, int max) {
		if(max-min<=1) {
			return;
		}
		
		int pivote=particion(datos, min,max);
		QuickSort(datos,min,pivote-1);
		QuickSort(datos,pivote+1,max);
	}
	//Método recursivo publico
	public void QuickSort(Pelicula[] datos) {
		QuickSort(datos,0,datos.length-1);
	}
	
	
	
	//MERGE SORT
	
	public void MergeSort(Pelicula[] datos) {
		MergeSort(datos,0,datos.length);
	}
	
	private void MergeSort(Pelicula[] datos, int min, int max) {
		if(max-min<=1) {
			return;
		}
		
		int mitad=(max+min)/2;
		MergeSort(datos,min,mitad);
		MergeSort(datos,mitad,max);
		MergeSort(datos,min,max,mitad); //Método de mezcla
		
	}
	
	private void MergeSort(Pelicula[] datos, int min, int max, int mitad) {
		Pelicula[]aux;
		aux=new Pelicula[1+max-min];
		int i=min;
		int j=mitad;
		int k=0;
		
		while(i<mitad && j<max) {
			if(datos[i].compareTo(datos[j].getID())<0) {
				aux[k]=datos[i];
				i++;
			}else {
				aux[k]=datos[j];
				j++;
			}
			k++;
		}
		
		while(j<max) {
			aux[k]=datos[j];
			j++;
			k++;
		}
		
		while(i<mitad) {
			aux[k]=datos[i];
			i++;
			k++;
		}
		
		//Copiar al original
		k=0;
		for(i=min;i<max;i++)
			datos[i]=aux[k++];
	}
	
	
	
	
	
	
	}
