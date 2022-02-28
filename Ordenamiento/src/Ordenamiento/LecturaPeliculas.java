package Ordenamiento;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;
import java.util.Scanner;

public class LecturaPeliculas{
	private ArrayList<Pelicula> peliculas;
	
	public LecturaPeliculas(){
		peliculas=new ArrayList<Pelicula>();
	}
	public LecturaPeliculas(ArrayList<Pelicula> nuevoPeliculas) {
		peliculas=nuevoPeliculas;
	}
	
	public void loadPeliculasFromFile(String file) {
		try {
			FileReader fr =new FileReader(file);
			try {
				Scanner scan= new Scanner(fr);
				int lineNumber=0;
				while(scan.hasNextLine()) {
					lineNumber++;
					String line=scan.nextLine();
					
					String[] partes=line.split(",");
					int ID=Integer.parseInt(partes[0]);
					int year=Integer.parseInt(partes[1]);
					String title=partes[2];
					
					try {
						Pelicula peliculaNueva=new Pelicula(ID,year,title);
						addMovie(peliculaNueva);
					}catch(IllegalStateException e) {
						System.out.println("Error en la info de pelicula");
					}
				}
			}finally {
				fr.close();
			}
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch(IOException e) {
			System.out.println("Unexpected I/O exception");
		}
	}
	
	public ArrayList<Pelicula> getPeliculas(){
		return peliculas;
	}

    // Add a movie to the database, throws a NullPointerException if object in argument is not set
    public void addMovie(Pelicula newMovie)
    {
        if (newMovie == null)
        {
            throw new NullPointerException("Must provide a valid movie object\n");
        }
        
        peliculas.add(newMovie);
    }
    
    public Pelicula[] cambioTamaño(Pelicula[] datos, int n) {
    	Pelicula[] nuevo=new Pelicula[n];
    	for(int i=0; i<n;i++) {
    		nuevo[i]=datos[i];
    	}
    	return nuevo;
    }
    
    public Pelicula[] ordenInverso(Pelicula[] datos) {
    	Pelicula[]nuevo= new Pelicula[datos.length];
    	for(int i=0;i<datos.length;i++) {
    		nuevo[i]=datos[datos.length-1-i];
    	}
    	datos=nuevo;
    	return datos;
    }
    
    public Pelicula[] shuffle(Pelicula[] datos){
        Pelicula[] peliculaAux=new Pelicula[datos.length];
        
        for(int i=0; i<datos.length;i++){
            int shuffle=(int)Math.floor(Math.random()*(17700+1));
            peliculaAux[i]=datos[shuffle];    
        }
        
        datos=peliculaAux;
        return datos;
        }
    


    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		algoritmosPelicula ordenamiento=new algoritmosPelicula();
		String file="movieTitles.txt";
		LecturaPeliculas lp=new LecturaPeliculas();
		Pelicula[] inverso,shuffle;
		
		lp.loadPeliculasFromFile(file);
		//System.out.println(lp.getPeliculas());
		
		Pelicula[] arrayPeliculas=lp.peliculas.toArray(new Pelicula[0]);
		

		shuffle=lp.shuffle(arrayPeliculas);
		shuffle=lp.cambioTamaño(shuffle, 14000);

		
		long startTime= System.nanoTime();
		ordenamiento.MergeSort(shuffle);
		long endTime=System.nanoTime();
		long duration=(endTime-startTime);
		
		for(int i=0;i<shuffle.length;i++)
			System.out.println(shuffle[i]);
		
		System.out.println("Tiempo: "+duration);
		
		/*
		for(int i=0;i<inverso.length;i++)
			System.out.println(inverso[i]);
		
		long startTime= System.nanoTime();
		ordenamiento.InsertionSort(inverso);
		long endTime=System.nanoTime();
		long duration=(endTime-startTime);
		
		
		System.out.println("Array Ordenado por Selection Sort");
		for(int i=0;i<inverso.length;i++)
			System.out.println(inverso[i]);
		
		System.out.println("Tiempo: "+duration);
	
		long startTime= System.nanoTime();
		ordenamiento.QuickSort(inverso);
		long endTime=System.nanoTime();
		long duration=(endTime-startTime);
		
		
		System.out.println("Array Ordenado por Selection Sort");
		for(int i=0;i<inverso.length;i++)
			System.out.println(inverso[i]);
		
		System.out.println("Tiempo: "+duration);*/
		/*
		long startTime= System.nanoTime();
		ordenamiento.MergeSort(inverso);
		long endTime=System.nanoTime();
		long duration=(endTime-startTime);
		
		
		System.out.println("Array Ordenado por Selection Sort");
		for(int i=0;i<inverso.length;i++)
			System.out.println(inverso[i]);
		
		System.out.println("Tiempo: "+duration);*/
		
		//Orden aleatorio
		/*
		Pelicula[] aux=lp.cambioTamaño(arrayPeliculas, 17000);
		
		for(int i=0;i<aux.length;i++)
			System.out.println(aux[i]);
		
		long startTime= System.nanoTime();
		ordenamiento.SelectionSort(aux);
		long endTime=System.nanoTime();
		long duration=(endTime-startTime);
		
		
		System.out.println("Array Ordenado por Selection Sort");
		for(int i=0;i<aux.length;i++)
			System.out.println(aux[i]);
		
		System.out.println("Tiempo: "+duration);*/

	}

}
