package Ordenamiento;

import java.util.Objects;

public class Pelicula <T extends Comparable<T>> {
	private int ID;
	private int year;
	private String title;

//Constructor
	
public Pelicula(){
	
}

public Pelicula(int ID, int year, String title) {
	this.ID=ID;
	this.year=year;
	this.title=title;
	}

public int getID() {
	return ID;
	}

public int getYear() {
	return year;
	}

public String getTitle(){
	return title;
	}	

public void setID(int iD) {
	ID = iD;
	}

public void setYear(int year) {
	this.year = year;
	}

public void setTitle(String title) {
	this.title = title;
	}

public String toString() {
	return ("ID: "+ID+"\n "+ "Título: "+title+"\n "+"Año de estreno: "+year+"\n\n");
	}

@Override
public int hashCode() {
	return Objects.hash(ID);
	}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Pelicula other = (Pelicula) obj;
	return ID == other.ID;
}

public int compareTo(int IDOtro) {
	int aux=0;
	if(this.ID==IDOtro) {
		aux=0;
	}
	if(this.ID<IDOtro) {
		aux=-11;
	}else
		aux=1;
	return aux;
}



}