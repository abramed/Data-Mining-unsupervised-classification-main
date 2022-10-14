package Traitement;

import java.util.ArrayList;

public class DataSet {
	
	ArrayList<ArrayList<String>> Attributs= new ArrayList<ArrayList<String>>();
	
	public ArrayList<ArrayList<String>> getAttributs() {
		return Attributs;
	}

	public void setAttributs(ArrayList<ArrayList<String>> attributs) {
		Attributs = attributs;
	}
	


	ArrayList<row2> Contenu= new ArrayList<row2>();

	public ArrayList<row2> getContenu() {
		int i=0;
		while(i<Contenu.size())
		{
			i++;
		}
		return Contenu;
	}

	public void setContenu(ArrayList<row2> contenu) {
		Contenu = contenu;
	}
	

}
