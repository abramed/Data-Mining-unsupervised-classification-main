package outils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;



public class TraitementData {


    public static ArrayList<ArrayList<Float>> RecupDonnees(String NomFichier) {

        ArrayList<ArrayList<Float>> data = new ArrayList<ArrayList<Float>>();

        try {
            InputStream inputStream = new FileInputStream(NomFichier);
            InputStreamReader inputReader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(inputReader);
            String ligne;
            while ((ligne = br.readLine()) != null) {

                String[] TabL = ligne.split(",");
                ArrayList<Float> list = new ArrayList<Float>();
                for (String number : TabL) {
                    list.add(Float.parseFloat(number));
                }
                data.add(list);

            }// on recherche les lignes ou les attributs sont décri


            br.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }


        return data;
    }


    public static float CalculMoyenne(ArrayList<ArrayList<Float>> Data, String nameAttr) {

        Float s;
        s = Float.valueOf(0);
        for (ArrayList<Float> line : Data) {
            Row i = new Row(line);
            if (nameAttr.equals("T3_resin")) {
                s = s + i.getT3_resin();
            } else if (nameAttr.equals("thyroxin")) {
                s = s + i.getThyroxin();
            } else if (nameAttr.equals("triodothyronine")) {
                s = s + i.getTriodothyronine();
            } else if (nameAttr.equals("thyroid-stimulating hormone")) {
                s = s + i.getTSH();
            } else if (nameAttr.equals("Maximal absolute difference of TSH")) {
                s = s + i.getMax_TSH();
            }
        }
        return s / Data.size();


    }


    public static float CalculMediane(ArrayList<ArrayList<Float>> Data, String nameAttr) {
        int s;

        ArrayList<Float> temp = new ArrayList<>();
        for (ArrayList line : Data) {
            Row i = new Row(line);
            if (nameAttr.equals("T3_resin")) {
                temp.add(i.getT3_resin());
            } else if (nameAttr.equals("thyroxin")) {
                temp.add(i.getThyroxin());
            } else if (nameAttr.equals("triodothyronine")) {
                temp.add(i.getTriodothyronine());
            } else if (nameAttr.equals("thyroid-stimulating hormone")) {
                temp.add(i.getTSH());
            } else if (nameAttr.equals("Maximal absolute difference of TSH")) {
                temp.add(i.getMax_TSH());
            }
        }

        Collections.sort(temp);


        if (Data.size() % 2 != 0) {
            s = (Data.size() / 2) + 1;
            return temp.get(s);
        } else {
            s = Data.size() / 2;
            return (temp.get(s) + temp.get(s)) / 2;

        }


    }

    public static ArrayList<Float> CalculMod(ArrayList<ArrayList<Float>> Data, String nameAttr) {

        ArrayList<Float> temp = new ArrayList<>();
        ArrayList<Integer> frequenceaa = new ArrayList();
        ArrayList<Float>values = new ArrayList();

        calcFrequenceaa(Data,nameAttr,temp,values,frequenceaa);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < frequenceaa.size(); i++) {
            if (frequenceaa.get(i) > max) {
                max = frequenceaa.get(i);
            }
        }
        ArrayList<Float> maxs = new ArrayList<>();
        for (int i = 0; i < frequenceaa.size(); i++){
            if (frequenceaa.get(i)==max){
                maxs.add(values.get(i));
            }
        }

        return maxs;

    }


    public static void calcFrequenceaa(ArrayList<ArrayList<Float>> Data, String nameAttr, ArrayList<Float> temp ,ArrayList<Float> values ,ArrayList<Integer> frequenceaa ){
        for (ArrayList line : Data) {
            Row i = new Row(line);
            if (nameAttr.equals("T3_resin")) {
                temp.add(i.getT3_resin());
            } else if (nameAttr.equals("thyroxin")) {
                temp.add(i.getThyroxin());
            } else if (nameAttr.equals("triodothyronine")) {
                temp.add(i.getTriodothyronine());
            } else if (nameAttr.equals("thyroid-stimulating hormone")) {
                temp.add(i.getTSH());
            } else if (nameAttr.equals("Maximal absolute difference of TSH")) {
                temp.add(i.getMax_TSH());
            }
        }


        Collections.sort(temp);
        int j = 0;
        while (j < temp.size() - 1) {
            if (!temp.get(j).equals(temp.get(j + 1))) {


                frequenceaa.add(Collections.frequency(temp, temp.get(j)));
                values.add(temp.get(j));

            }
            j++;
        }

        if (!temp.get(j-1).equals(temp.get(j))) {
            frequenceaa.add(Collections.frequency(temp, temp.get(j)));
            values.add(temp.get(j));
        }

    }



    public static float ecartQuadratique(ArrayList<ArrayList<Float>> Data,String att, float m) {
        float v;
        v = (float) 0.0;
        for (ArrayList<Float> line : Data) {
            Row i = new Row(line);
            v = (float) (v + (i.getValueOfAttr(att)-m)*(i.getValueOfAttr(att)-m));
        }
        v = (float) Math.sqrt(v);
        return v;
    }

    public static float coefficientCorrelation(ArrayList<ArrayList<Float>> Data,String att1, String att2)
    {
        float cc;
        float mx;
        float my;
        float eqmx;
        float eqmy;
        mx =(float) CalculMoyenne(Data,att1);
        my =(float) CalculMoyenne(Data,att2);
        cc = (float) 0.0;
        for ( ArrayList<Float> line : Data )
        {
            Row i = new Row(line);
            cc = (float) (cc + (i.getValueOfAttr(att1)-mx)*(i.getValueOfAttr(att2)-my));
        }
        eqmx = ecartQuadratique(Data,att1,mx);
        eqmy = ecartQuadratique(Data,att2,my);
        cc = cc / (eqmx*eqmy);
        return cc;
    }

}





