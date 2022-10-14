package Traitement;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class K_Means {

    public static void K_MEANS_ALgorithme(int k, double [] min,double [] max,
                                          ArrayList<Instance> all_instances, JFXTextArea textArea, JFXTextField textField,JFXTextField cout){
        ArrayList<Instance> centroids = new ArrayList<Instance>();
        ArrayList<Cluster2> clusters = new ArrayList<Cluster2>();
        ArrayList<Integer> instances_numbers=new ArrayList<>();

        double starttime = System.currentTimeMillis();

            Random rand = new Random();
            for (int md = 0; md < k; md++) {
                int r = rand.nextInt(all_instances.size());
                Instance inst = all_instances.get(r);
                centroids.add(inst);
                clusters.add(new Cluster2(md, inst));
            }

        double cost=0;
        cost = fill_clusters(all_instances, centroids, k, cost, clusters, true);

        boolean change = true;
        int cp=1;
        while(change){
            change = false;

            for (int i = 0; i < k; i++) {
                double [] mean = clusters.get(i).calcul_mean(min.length);
                clusters.get(i).elements.clear();
                clusters.set(i, new Cluster2(i, new Instance(mean)));
                if(!centroids.get(i).eq(mean))
                    change =true;
                centroids.set(i, new Instance(mean));
            }

            double cost2=0;
            cost2 = fill_clusters(all_instances, centroids, k, cost2, clusters, true);
            if(cost <= cost2) {
                change = false;
            }
            if(cost > cost2){
                cost = cost2;
            }
            textArea.appendText("==================== Iteration: "+cp+" ====================");
            textArea.appendText("\n");
            for (int j = 0; j < clusters.size(); j++) {
                textArea.appendText("Cluster "+ (j+1) + ": " );
                ArrayList<Double> d=new ArrayList<>();
                for(int f=0;f<clusters.get(j).medoid.size;f++){d.add(clusters.get(j).medoid.getAtt(f));}
                textArea.appendText("\n");
                textArea.appendText(("Instance K-means:"+" ===> "+ d+ "\n"));
                textArea.appendText("\n");
                textArea.appendText("Nombre d'instances :"+String.valueOf(clusters.get(j).elements.size()));
                textArea.appendText("\n");
                textArea.appendText("Liste d'instance : \n");

                for (int l = 0; l < clusters.get(j).elements.size() ; l++) {
                    instances_numbers.add(all_instances.indexOf(clusters.get(j).elements.get(l)));

                }
                textArea.appendText(String.valueOf(instances_numbers));
                textArea.appendText("\n");
                textArea.appendText("\n");
                instances_numbers.clear();

            }
            cp++;
        }

        textField.setText(" " + (System.currentTimeMillis()-starttime) + "ms");


        cout.setText(" "+ cost);

    }

    public static double fill_clusters(ArrayList<Instance> all_instances, ArrayList<Instance> bestnodes,
                                       int k, double cost, ArrayList<Cluster2> clusters, boolean p){
        for (int i = 0; i < all_instances.size() ; i++) {
            int m;
            double distance = all_instances.get(i).distanceEuc(bestnodes.get(0));
            int Cnum =0;
            for (m = 1; m < k; m++) {
                double dst = all_instances.get(i).distanceEuc(bestnodes.get(m));
                if(dst<distance){
                    distance = dst; Cnum = m;
                }
            }
            if (p) clusters.get(Cnum).elements.add(all_instances.get(i));
            cost = cost + distance;
        }
        return cost;
    }
}
