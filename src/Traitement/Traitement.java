package Traitement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;
import java.util.regex.Pattern;

public class Traitement {
	
	//Lecture du fichier et extraction des attribut et caracteristique

	public static DataSet RecupDonnees(String NomFichier){
		
		DataSet Data= new DataSet();
		try{
			InputStream ips=new FileInputStream(NomFichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne=br.readLine();
			int i;
			Pattern pattern = Pattern.compile("(([0-9])+,)+");
			while (((ligne=br.readLine())!=null)&&(!pattern.matcher(ligne).find())){				
			}// on recherche les lignes ou les attributs sont d�cris
			if(ligne != null)
			{
				while(ligne!=null)
				{  
					String[] TabL=ligne.split(",");
					row2 rowTemp= new row2();
					for(String s:TabL)
					{   if(s.equals("absent"))
						{rowTemp.set.add((Double) 1.0);}
						else 
							{if(s.equals("present"))
							{rowTemp.set.add((Double) 2.0);}
							else{
							rowTemp.set.add(Double.parseDouble((s.trim())));}}
					}
					Data.Contenu.add(rowTemp);
					ligne=br.readLine();
					
				}
			}
			 br.close(); 
		}		
	catch (Exception e){
		System.out.println(e.toString());
	}

		return Data;
	}
	




	
		
		
		
	
	

}
