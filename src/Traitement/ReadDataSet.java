package Traitement;

import java.io.*;
import java.nio.file.Files;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.Scanner; // Import the Scanner class to read text files
public class ReadDataSet {
    private String Thyroid_Dataset;
    private String Line;
    static public int nbr_col;


    public static String[][] ReadAllFile(String path) throws IOException {
        //String[][] liste=null;
        BufferedReader reader = new BufferedReader(new FileReader(path));
        int cpt=0;
        while (reader.readLine()!=null)
            cpt++;
        nbr_col=cpt;
        int [ ][ ] table = new int [3][ ];
        String liste[][]=new String[cpt][];
        String line;
        int k=0,j=0;
        reader = new BufferedReader(new FileReader(path));
        while (k<cpt)
        {
            line=reader.readLine();
            liste[k]=line.split(",");
            k++;
        }
        /*System.out.println(cpt);
        for (int i=0;i<liste.length;i++) {
            for (j = 0; j < liste[i].length; j++) {
                System.out.print(liste[i][j]+" ");
            }
               System.out.print("\n");
        }*/

        return liste;
    }



}

